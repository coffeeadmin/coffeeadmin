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

import mx.org.cadmin.persist.CaGroups;
import mx.org.cadmin.persist.CaWorker;
import mx.org.cadmin.persist.GroupsDao;
import mx.org.cadmin.persist.WorkerDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.util.WebUtils;
/**
 * Documentation for  class <code>MainForm</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class MainForm extends SimpleFormController {

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
		
		binder.registerCustomEditor(Integer.class, null, new CustomNumberEditor(Integer.class, true));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));

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



		binder.registerCustomEditor(List.class, "iduser.users_groups",
			new CustomCollectionEditor(List.class) {
				protected Object convertElement(Object element) {
					if (element != null) {
						Integer idgroup = new Integer((String) element);
						List list = new ArrayList();
						CaGroups caGroups = new CaGroups();
						caGroups.setIdgroup(idgroup);
logger.debug("--> filling users.groups element is : " + element);
						GroupsDao gdao = (GroupsDao) ctx.getBean("groupsDao");
						list = gdao.getGroupsbyId(caGroups);
						caGroups = (CaGroups) list.get(0);
						return caGroups;
					}
					return null;
				}
			});

	}

}

