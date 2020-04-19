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
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.cadmin.persist.CaFiles;
import mx.org.cadmin.persist.CaWorker;
import mx.org.cadmin.persist.CaWorks;
import mx.org.cadmin.persist.WorkerDao;
import mx.org.cadmin.persist.WorksDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springframework.web.util.WebUtils;

/**
 * Documentation for  class <code>MainWizForm</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class MainWizForm extends AbstractWizardFormController {

	/**
	 * Describe variable <code>ctx</code> here.
	 */
	public WebApplicationContext ctx = null;

	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());


	/**
	 * Describe <code>init</code> method here.
	 *
	 * @param  request                            a <code>HttpServletRequest</code> value
	 * @exception  ModelAndViewDefiningException  if an error occurs
	 */
	public void init(HttpServletRequest request) throws ModelAndViewDefiningException {
		ServletContext context = this.getServletContext();
		ctx = WebApplicationContextUtils.getWebApplicationContext(context);
		if (WebUtils.getSessionAttribute(request, "iduser") == null) {
			logger.debug("iduser on session doesnt exists");

			throw new ModelAndViewDefiningException(new ModelAndView("redirect:viewLogin.htm"));
		}
	}


	/**
	 * Describe <code>initBinder</code> method here.
	 *
	 * @param  request        a <code>HttpServletRequest</code> value
	 * @param  binder         a <code>ServletRequestDataBinder</code> value
	 * @exception  Exception  if an error occurs
	 */
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {

		logger.debug("------- performing binding on caWorks");
		
		binder.registerCustomEditor(Integer.class, null, new CustomNumberEditor(Integer.class, true));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(List.class, "works_workers",
			new CustomCollectionEditor(List.class) {
				protected Object convertElement(Object element) {
					if (element != null) {
						Integer idworker = new Integer((String) element);
						List list = new ArrayList();
						CaWorker caWorker = new CaWorker();
						caWorker.setIdworker(idworker);

						WorkerDao wdao = (WorkerDao) ctx.getBean("workerDao");
						list = wdao.getWorkersbyId(caWorker);
						caWorker = (CaWorker) list.get(0);
						return caWorker;
					}
					return null;
				}
			});

		if (request.getParameter("idwork") != null && request.getParameter("idwork").length() != 0) {
			final Integer idwork = new Integer(request.getParameter("idwork"));
			binder.registerCustomEditor(List.class, "work_files",
				new CustomCollectionEditor(List.class) {
					protected Object convertElement(Object element) {
						if (element != null) {

							String filename = (String) element;
							CaFiles caFiles = new CaFiles();
							CaWorks caWorks = new CaWorks();
							caWorks.setIdwork(idwork);
							caFiles.setWork(caWorks);
							caFiles.setName(filename);

							return caFiles;
						}
						return null;
					}
				});

		}

	}


	/**
	 * Describe <code>processFinish</code> method here.
	 *
	 * @param  request        a <code>HttpServletRequest</code> value
	 * @param  response       a <code>HttpServletResponse</code> value
	 * @param  command        an <code>Object</code> value
	 * @param  errors         a <code>BindException</code> value
	 * @return                a <code>ModelAndView</code> value
	 * @exception  Exception  if an error occurs
	 */
	protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		logger.debug("----- processing finish on caWorks");

		WorksDao wdao = (WorksDao) ctx.getBean("worksDao");
		wdao.updateWorks(command);

		return new ModelAndView("worksFormRedirect");
	}



}

