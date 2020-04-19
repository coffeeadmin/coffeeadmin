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
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import mx.org.cadmin.persist.CaGroups;
import mx.org.cadmin.persist.CaUsers;
import mx.org.cadmin.persist.GroupsDao;
import mx.org.cadmin.persist.UsersDao;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.validation.Errors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Documentation for  class <code>AddGroupsForm</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class AddGroupsForm extends MainForm {

	/**
	 * Creates a new <code>AddGroupsForm</code> instance.
	 */
	public AddGroupsForm() {
		setSessionForm(true);
		setBindOnNewForm(true);
	}


	Map map = new HashMap();
	List list = new ArrayList();


	/**
	 * Describe <code>referenceData</code> method here.
	 *
	 * @param  request  a <code>HttpServletRequest</code> value
	 * @param  command  an <code>Object</code> value
	 * @param  errors   an <code>Errors</code> value
	 * @return          a <code>Map</code> value
	 */
	protected Map referenceData(HttpServletRequest request,
			Object command,
			Errors errors) {

		UsersDao udao = (UsersDao) ctx.getBean("usersDao");

		map.put("users", udao.getUsers());
		return map;
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
		CaGroups caGroups = new CaGroups();
		this.init(request);
		if (request.getParameter("idgroup") != null && request.getParameter("idgroup").length() > 0) {
			GroupsDao gdao = (GroupsDao) ctx.getBean("groupsDao");
			caGroups.setIdgroup(new Integer(request.getParameter("idgroup")));
			list = gdao.getGroupsbyId(caGroups);
			caGroups = (CaGroups) list.get(0);
		} else {
			caGroups.getIduser().setIduser(new Integer(0));
		}

		return caGroups;
	}


	/**
	 * Describe <code>onBind</code> method here.
	 *
	 * @param  request  a <code>HttpServletRequest</code> value
	 * @param  command  an <code>Object</code> value
	 */
	protected void onBind(HttpServletRequest request,
			Object command) {


	}


	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	private GroupsDao groupsDao;



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
		CaUsers caUsers = new CaUsers();
		GroupsDao dao = (GroupsDao) ctx.getBean("groupsDao");

		dao.updateGroups(command);
		logger.debug(" >>> redirecting view ");
		return new ModelAndView("groupsFormRedirect");
	}


	/**
	 * Describe <code>getGroupsDao</code> method here.
	 *
	 * @return    a <code>GroupsDao</code> value
	 */
	public GroupsDao getGroupsDao() {
		return groupsDao;
	}


	/**
	 * Describe <code>setGroupsDao</code> method here.
	 *
	 * @param  groupsDao  a <code>GroupsDao</code> value
	 */
	public void setGroupsDao(GroupsDao groupsDao) {
		this.groupsDao = groupsDao;
	}

}

