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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.cadmin.persist.CaUsers;
import mx.org.cadmin.persist.UsersDao;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;


/**
 * Documentation for  class <code>AddUsersForm</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class AddUsersForm extends MainForm {

	/**
	 * Creates a new <code>AddUsersForm</code> instance.
	 */
	public AddUsersForm() {
		setSessionForm(true);
		setBindOnNewForm(true);
	}



	/**
	 * Describe <code>formBackingObject</code> method here.
	 *
	 * @param  request               a <code>HttpServletRequest</code> value
	 * @return                       an <code>Object</code> value
	 * @exception  ServletException  if an error occurs
	 */
	protected Object formBackingObject(HttpServletRequest request)
			 throws ServletException {

		List list = new ArrayList();
		CaUsers caUsers = new CaUsers();
		this.init(request);
		UsersDao dao = (UsersDao) ctx.getBean("usersDao");
		if (request.getParameter("iduser") != null && request.getParameter("iduser").length() > 0) {

			caUsers.setIduser(new Integer(request.getParameter("iduser")));
			list = dao.getUsersbyId(caUsers);
			caUsers = (CaUsers) list.get(0);

		}
		return caUsers;
	}


	/**
	 * Describe <code>onSubmit</code> method here.
	 *
	 * @param  request                  a <code>HttpServletRequest</code> value
	 * @param  response                 a <code>HttpServletResponse</code> value
	 * @param  command                  an <code>Object</code> value
	 * @param  errors                   a <code>BindException</code> value
	 * @return                          a <code>ModelAndView</code> value
	 * @exception  java.lang.Exception  if an error occurs
	 */
	protected ModelAndView onSubmit(
			HttpServletRequest request,
			HttpServletResponse response,
			Object command,
			BindException errors)
			 throws java.lang.Exception {

		this.init(request);
		UsersDao dao = (UsersDao) ctx.getBean("usersDao");
		dao.updateUsers(command);
		logger.debug(" >>> redirecting view ");
		return new ModelAndView("usersFormRedirect");
	}


	private UsersDao usersDao;


	/**
	 * Describe <code>getUsersDao</code> method here.
	 *
	 * @return    an <code>UsersDao</code> value
	 */
	public UsersDao getUsersDao() {
		return usersDao;
	}


	/**
	 * Describe <code>setUsersDao</code> method here.
	 *
	 * @param  usersDao  an <code>UsersDao</code> value
	 */
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}


}

