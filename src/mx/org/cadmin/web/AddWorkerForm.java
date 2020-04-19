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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import mx.org.cadmin.persist.CaGroups;
import mx.org.cadmin.persist.CaWorker;
import mx.org.cadmin.persist.GroupsDao;
import mx.org.cadmin.persist.WorkerDao;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Documentation for  class <code>AddWorkerForm</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class AddWorkerForm extends MainForm {

	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	private WorkerDao workerDao;


	/**
	 * Creates a new <code>AddWorkerForm</code> instance.
	 */
	public AddWorkerForm() {
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

		GroupsDao gdao = (GroupsDao) ctx.getBean("groupsDao");
		map.put("groups", gdao.getGroups());
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
		CaWorker caWorker = new CaWorker();
		CaGroups caGroup = new CaGroups();
		this.init(request);
		if (request.getParameter("idworker") != null && request.getParameter("idworker").length() > 0) {
			WorkerDao wdao = (WorkerDao) ctx.getBean("workerDao");
			caWorker.setIdworker(new Integer(request.getParameter("idworker")));
			list = wdao.getWorkersbyId(caWorker);
			caWorker = (CaWorker) list.get(0);

		} else {
			caWorker.setIdgroup(caGroup);
			caWorker.getIdgroup().setIdgroup(new Integer(0));
		}

		return caWorker;
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
		WorkerDao wdao = (WorkerDao) ctx.getBean("workerDao");
		wdao.updateWorkers(command);
		return new ModelAndView("workerFormRedirect");
	}


	/**
	 * Describe <code>getWorkerDao</code> method here.
	 *
	 * @return    a <code>WorkerDao</code> value
	 */
	public WorkerDao getWorkerDao() {
		return workerDao;
	}


	/**
	 * Describe <code>setWorkerDao</code> method here.
	 *
	 * @param  workerDao  a <code>WorkerDao</code> value
	 */
	public void setWorkerDao(WorkerDao workerDao) {
		this.workerDao = workerDao;
	}

}

