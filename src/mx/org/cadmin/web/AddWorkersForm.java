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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import mx.org.cadmin.persist.CaWorker;
import mx.org.cadmin.persist.WorkerDao;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * Documentation for  class <code>AddWorkersForm</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class AddWorkersForm extends MainForm {

	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	private WorkerDao workerDao;


	/**
	 * Creates a new <code>AddWorkersForm</code> instance.
	 */
	public AddWorkersForm() {
		setSessionForm(true);
		setBindOnNewForm(true);
	}


	/**
	 * Describe <code>formBackingObject</code> method here.
	 *
	 * @param  r                     a <code>HttpServletRequest</code> value
	 * @return                       an <code>Object</code> value
	 * @exception  ServletException  if an error occurs
	 */
	protected Object formBackingObject(HttpServletRequest r)
			 throws ServletException {
		CaWorker caWorker = new CaWorker();
		return caWorker;
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

