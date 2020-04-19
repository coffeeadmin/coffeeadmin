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

import mx.org.cadmin.persist.CaWorker;
import mx.org.cadmin.persist.WorkerDao;

import org.springframework.web.servlet.ModelAndView;


/**
 * Documentation for  class <code>WorkerController</code> .
 *
 * @author <a href="www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @version 0.6
 */
public class WorkerController extends CoffeeController {

	private int objectsPerPage;
	/**
	 * Describe <code>workerShow</code> method here.
	 *
	 * @param  request               a <code>HttpServletRequest</code> value
	 * @param  response              a <code>HttpServletResponse</code> value
	 * @return                       a <code>ModelAndView</code> value
	 * @exception  ServletException  if an error occurs
	 */
	public ModelAndView workerShow(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		CaWorker caWorker = new CaWorker();
		this.init(request, response);
		WorkerDao dao = (WorkerDao) ctx.getBean("workerDao");

		if (request.getParameter("del") != null) {

			String[] delItems = request.getParameterValues("delItem");
			for (int i = 0; i < delItems.length; i++) {
				logger.debug("---> deleting Worker : " + delItems[i]);
				caWorker.setIdworker(new Integer(delItems[i]));
				dao.removeWorkers(caWorker);
			}
			return new ModelAndView("redirect:viewWorker.htm");
		}

		list = dao.getWorkers();
		map.put("workers", list);
		return new ModelAndView("workerView", map);
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
