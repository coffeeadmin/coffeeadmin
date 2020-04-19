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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.cadmin.persist.CaContacts;
import mx.org.cadmin.persist.CaGroups;
import mx.org.cadmin.persist.CaUsers;
import mx.org.cadmin.persist.CaWorker;
import mx.org.cadmin.persist.CaWorks;
import mx.org.cadmin.persist.ContactsDao;
import mx.org.cadmin.persist.GroupsDao;
import mx.org.cadmin.persist.UsersDao;
import mx.org.cadmin.persist.WorkerDao;
import mx.org.cadmin.persist.WorksDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

/**
 * Documentation for  class <code>AddReportForm</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class AddReportForm extends MainForm {

	/**
	 * Creates a new <code>AddReportForm</code> instance.
	 */
	public AddReportForm() { }


	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());
	Map map = new HashMap();
	List list = new ArrayList();
	CaWorks caWorks = null;
    private String template = "";

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

		if (request.getParameter("rname").equals("date")) {

			map.put("rname", "date");
		} else if (request.getParameter("rname").equals("user")) {
			logger.debug("----> referenceData user");
			UsersDao dao = (UsersDao) ctx.getBean("usersDao");
			list = dao.getUsers();
			map.put("users", list);
			map.put("rname", "user");
		} else if (request.getParameter("rname").equals("contact")) {
			ContactsDao dao = (ContactsDao) ctx.getBean("contactsDao");
			list = dao.getContacts();
			map.put("contacts", list);
			map.put("rname", "contact");
		} else if (request.getParameter("rname").equals("worker")) {
			WorkerDao dao = (WorkerDao) ctx.getBean("workerDao");
			list = dao.getWorkers();
			map.put("workers", list);
			map.put("rname", "worker");
		} else if (request.getParameter("rname").equals("group")) {
		GroupsDao gdao = (GroupsDao) ctx.getBean("groupsDao");
		list = gdao.getGroups();
		map.put("groups", list);
		map.put("rname", "group");
	}
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
		this.init(request);
		CaUsers caUsers = new CaUsers();
		CaContacts caContacts = new CaContacts();
		caWorks = new CaWorks();
		caWorks.setIduser(caUsers);
		caWorks.setIdcontact(caContacts);
		return caWorks;
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
		caWorks = (CaWorks) command;
		WorksDao wdao = (WorksDao) ctx.getBean("worksDao");
        template = request.getParameter("template");
		if (request.getParameter("rname").equals("date")) {
			logger.debug("-- -> gettin date report");

			list = wdao.getDateReport(caWorks);
			SimpleDateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");
			return new ModelAndView(template, getReportModel("Date", dformat.format(caWorks.getInit()) + " to " + dformat.format(caWorks.getEnd())));
		} else if (request.getParameter("rname").equals("user")) {
			list.clear();
			logger.debug("--> user to report : " + caWorks.getIduser().getIduser());
			logger.debug("-- -> gettin user report...");
			CaUsers caUsers = new CaUsers();
			UsersDao udao = (UsersDao) ctx.getBean("usersDao");
			caUsers = (CaUsers) udao.getUsersbyId(caWorks.getIduser()).get(0);
			caWorks.setIduser(caUsers);
			list = wdao.getUserReport(caWorks);
			return new ModelAndView(template, getReportModel("Manager", caWorks.getIduser().getFname() + " " + caWorks.getIduser().getLname()));
		} else if (request.getParameter("rname").equals("contact")) {
			list.clear();
			logger.debug("--> contact to report : " + caWorks.getIdcontact().getIdcontact());
			logger.debug("-- -> gettin contact report...");
			CaContacts caContacts = new CaContacts();
			ContactsDao cdao = (ContactsDao) ctx.getBean("contactsDao");
			caContacts = (CaContacts) cdao.getContactsbyId(caWorks.getIdcontact()).get(0);
			caWorks.setIdcontact(caContacts);
			list = wdao.getContactReport(caWorks);
			return new ModelAndView(template, getReportModel("Contact", caWorks.getIdcontact().getFname() + " " + caWorks.getIdcontact().getLname()));
		} else if (request.getParameter("rname").equals("worker")) {
			list.clear();
			logger.debug("--> worker to report : " + caWorks.getWorks_workers().size());
			logger.debug("-- -> gettin worker report...");
			list = wdao.getWorkerReport(caWorks);
			return new ModelAndView(template, getReportModel("Worker", ((CaWorker) caWorks.getWorks_workers().get(0)).getFname() + " " + ((CaWorker) caWorks.getWorks_workers().get(0)).getLname()));
		}else if (request.getParameter("rname").equals("group")) {
		list.clear();
		logger.debug("-- -> gettin user report...");
       CaWorker caWorker = new CaWorker();
		CaGroups caGroups = new CaGroups();
		GroupsDao gdao = (GroupsDao) ctx.getBean("groupsDao");
		caGroups = (CaGroups)gdao.getGroupsbyId((CaGroups)caWorks.getIduser().getUsers_groups().get(0)).get(0);
		logger.debug("--> group to report : " + caGroups.getDescription());
		caWorker.setIdgroup(caGroups);
		list.add(0, caWorker);
		caWorks.setWorks_workers(list);
		
		list = wdao.getGroupReport(caWorks);
		return new ModelAndView(template, getReportModel("Group", caGroups.getDescription()));
	   }
		return new ModelAndView(template, getReportModel("", ""));
	}


	/**
	 *  Gets the reportModel attribute of the AddReportForm object
	 *
	 * @param  type    Description of the Parameter
	 * @param  byItem  Description of the Parameter
	 * @return         The reportModel value
	 */
	private Map getReportModel(String type, String byItem) {
		
		map.clear();
		map.put("ReportTitle", getMessageSourceAccessor().getMessage("report.title"));
		map.put("ReportHead", getMessageSourceAccessor().getMessage("report.head"));
		map.put("byItem", byItem);
		
		map.put("ReportType", getMessageSourceAccessor().getMessage(type.toLowerCase()));
		map.put("credit", "Generated by CoffeeAdmin");
		map.put("dataSource", list);
		return map;
	}


}

