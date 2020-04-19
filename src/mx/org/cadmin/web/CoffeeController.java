/**
 *                       CoffeeAdmin Project
 *
 *  ========================================================================
 *
 *   Copyright (C) 2007 CoffeeAdmin Project. All rights reserved.
 *
 *   This file may be distributed and/or modified under the terms of the
 *   GNU Lesser General Public License version 2.1 as published by the Free
 *   Software Foundation and appearing in the file LICENSE.txt included
 *   in the packaging of this software.
 *
 *
 *   This software is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING
 *   THE WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 *   PURPOSE. See the GNU Lesser General Public License for more details.
 *
 *   appserver1 (at) yahoo.com
 *   http://www.mexgrp.com/coffee
 *
 *
 *  ========================================================================
 */
package mx.org.cadmin.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.cadmin.persist.CaUsers;
import mx.org.cadmin.persist.UsersDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.util.WebUtils;
/**
 * Documentation for  class <code>CoffeeController</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @version    0.6
 * @since 0.5
 */
public class CoffeeController extends MultiActionController implements InitializingBean{

	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());

  /**
   * Describe variable <code>ctx</code> here.
   *
   */
  public static WebApplicationContext ctx;

	List list = new ArrayList();
  /**
   * Describe variable <code>map</code> here.
   *
   */
  public Map map = new HashMap();
	private int objectsPerPage;

	/**
	 * Describe <code>afterPropertiesSet</code> method here.
	 *
	 * @exception  Exception  if an error occurs
	 */
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}


	/**
	 * Describe <code>init</code> method here.
	 *
	 * @param  request   a <code>HttpServletRequest</code> value
	 * @param  response  a <code>HttpServletResponse</code> value
	 */
	public void init(HttpServletRequest request, HttpServletResponse response) {
		ServletContext context = getServletContext();
		ctx = WebApplicationContextUtils.getWebApplicationContext(context);
		if (WebUtils.getSessionAttribute(request, "iduser") == null) {
			logger.debug("iduser on session doesnt exists");
			try {
				response.sendRedirect("viewLogin.htm");
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
	}






	/**
	 * Describe <code>homeShow</code> method here.
	 *
	 * @param  request               a <code>HttpServletRequest</code> value
	 * @param  response              a <code>HttpServletResponse</code> value
	 * @return                       a <code>ModelAndView</code> value
	 * @exception  ServletException  if an error occurs
	 */
	public ModelAndView homeShow(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		return new ModelAndView("homeView");
	}





	/**
	 * Describe <code>reportShow</code> method here.
	 *
	 * @param  request               a <code>HttpServletRequest</code> value
	 * @param  response              a <code>HttpServletResponse</code> value
	 * @return                       a <code>ModelAndView</code> value
	 * @exception  ServletException  if an error occurs
	 */
	public ModelAndView reportShow(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		return new ModelAndView("reportView");
	}


	/**
	 * Describe <code>loginShow</code> method here.
	 *
	 * @param  request               a <code>HttpServletRequest</code> value
	 * @param  response              a <code>HttpServletResponse</code> value
	 * @return                       a <code>ModelAndView</code> value
	 * @exception  ServletException  if an error occurs
	 */
	public ModelAndView loginShow(
			HttpServletRequest request,
			HttpServletResponse response)
			 throws ServletException {

		if (request.getParameter("email") == null
				 || request.getParameter("pass") == null) {

			if (request.getParameter("logout") != null) {
				logger.debug("....signing out user");
				request.getSession().removeAttribute("iduser");
				request.getSession().invalidate();
			}
			return new ModelAndView("loginView");
		} else {
			logger.debug("...validating login data");
			CaUsers caUser = new CaUsers();
			ServletContext context = this.getServletContext();
			ctx = WebApplicationContextUtils.getWebApplicationContext(context);
			UsersDao dao = (UsersDao) ctx.getBean("usersDao");

			caUser.setEmail(request.getParameter("email").trim());
			caUser.setPassword(request.getParameter("pass").trim());
			list.clear();

			try {
				list = dao.getUsersbyEmail(caUser);
			} catch (Exception e) {

				map.clear();
				map.put("failConn", "true");
				map.put("message", e.getCause());
				return new ModelAndView("loginView", map);
			}

			if (list.size() != 0) {
				caUser = (CaUsers) list.get(0);
				if (request.getParameter("email").equals(caUser.getEmail())
						 && request.getParameter("pass").equals(
						caUser.getPassword())) {
					WebUtils.setSessionAttribute(
							request,
							"iduser",
							caUser.getIduser());

					request.getSession(true).setMaxInactiveInterval(60 * 60);
					return new ModelAndView("redirect:viewWorks.htm");
				}
			}

			List allUsers = new ArrayList();
			String defaultUser =
					getMessageSourceAccessor().getMessage("firstrun.user");
			String defaultPass =
					getMessageSourceAccessor().getMessage(
					"firstrun.password");

			allUsers = dao.getUsers();
			logger.debug(
					"----- default user on context is : "
					 + defaultUser
					 + " allusers : "
					 + allUsers.isEmpty());
			if (allUsers.isEmpty()
					 && caUser.getEmail().equals(defaultUser)
					 && caUser.getPassword().equals(defaultPass)) {
				logger.debug("...loggin with default user : ");
				WebUtils.setSessionAttribute(request, "iduser", "0");

				request.getSession(true).setMaxInactiveInterval(
						60 * 60);

				return new ModelAndView("redirect:viewWorks.htm");
			} else if (allUsers.isEmpty()) {
				logger.debug("...no users defined try default user");
				map.clear();
				map.put("default", "true");

				return new ModelAndView("loginView", map);
			} else {
				logger.debug("...invalid login data");
				map.clear();
				map.put("invalid", "true");

				return new ModelAndView("loginView", map);
			}

		}
	}
  /**
   * Describe <code>getObjectsPerPage</code> method here.
   *
   * @return
   */
  public int getObjectsPerPage() {
		return objectsPerPage;
	}

  /**
   * Describe <code>setObjectsPerPage</code> method here.
   *
   * @param i
   */
  public void setObjectsPerPage(int i) {
		objectsPerPage = i;
	}

}

