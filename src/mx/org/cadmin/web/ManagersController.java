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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.cadmin.persist.CaUsers;
import mx.org.cadmin.persist.UsersDao;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;


/**
 * Documentation for  class <code>ManagersController</code> .
 *
 * @author <a href="www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @version 0.6
 */
public class ManagersController extends CoffeeController{

	private int objectsPerPage;
	/**
	 * Describe <code>usersShow</code> method here.
	 *
	 * @param  request               a <code>HttpServletRequest</code> value
	 * @param  response              a <code>HttpServletResponse</code> value
	 * @return                       a <code>ModelAndView</code> value
	 * @exception  ServletException  if an error occurs
	 */
	public ModelAndView usersShow(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		CaUsers caUsers = new CaUsers();
		this.init(request, response);
		UsersDao dao = (UsersDao) ctx.getBean("usersDao");
		logger.debug(" --> the context is named : " + WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		if (request.getParameter("del") != null) {
			if (request.getParameter("iduser") != null) {
				caUsers.setIduser(new Integer(request.getParameter("iduser")));
				dao.removeUsers(caUsers);
			} else {
				String[] delItems = request.getParameterValues("delItem");
				for (int i = 0; i < delItems.length; i++) {
					logger.debug("---> deleting User : " + delItems[i]);
					caUsers.setIduser(new Integer(delItems[i]));
					dao.removeUsers(caUsers);
				}
			}

			return new ModelAndView("redirect:viewUsers.htm");
		}
		if (request.getParameter("iduser") != null) {

			caUsers.setIduser(new Integer(request.getParameter("iduser")));
			list = dao.getUsersbyId(caUsers);
			logger.debug(" >>> iduser  detailed to view : " + request.getParameter("iduser"));
			map.put("user", list);
			return new ModelAndView("usersDetailView", map);
		}

		list = dao.getUsers();
		logger.debug(" >>> returning usersView context has dao :  " + ctx.containsBean("usersDao"));

		map.put("users", list);

		return new ModelAndView("usersView", map);
	}

	/**
	 * @return
	 */
	public int getObjectsPerPage() {
		return objectsPerPage;
	}

	/**
	 * @param i
	 */
	public void setObjectsPerPage(int i) {
		objectsPerPage = i;
	}

}
