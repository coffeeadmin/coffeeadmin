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

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.cadmin.persist.CaPagedAdapter;
import mx.org.cadmin.persist.CaWorks;
import mx.org.cadmin.persist.WorksDao;

import org.springframework.web.servlet.ModelAndView;


/**
 * Documentation for  class <code>WorksController</code> .
 *
 * @author <a href="www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @version 0.6
 */
public class WorksController extends CoffeeController {

	private int objectsPerPage;
	CaWorks caWorks = new CaWorks();
	private String sortField = new String();
	private boolean order;
	/**
	 * Describe <code>worksShow</code> method here.
	 *
	 * @param  request               a <code>HttpServletRequest</code> value
	 * @param  response              a <code>HttpServletResponse</code> value
	 * @return                       a <code>ModelAndView</code> value
	 * @exception  ServletException  if an error occurs
	 */
	public ModelAndView worksShow(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException {
		CaWorks caWorks = new CaWorks();
		this.init(request, response);
		WorksDao wdao = (WorksDao) ctx.getBean("worksDao");
		CaPagedAdapter pa = new CaPagedAdapter(objectsPerPage);
		list.clear();
		map.clear();
		if (request.getParameter("del") != null) {

             delWorks(caWorks, request, wdao);
			return new ModelAndView("redirect:viewWorks.htm");
		}
		if (request.getParameter("idwork") != null) {
			caWorks.setIdwork(new Integer(request.getParameter("idwork")));
			list = wdao.getWorksbyId(caWorks);
			map.put("work", list);
			return new ModelAndView("worksDetailView", map);
		}
		// perform sorting and paging

		if (request.getParameter("page") != null
			&& request.getParameter("page").trim().length() == 0) {
			pa.setPageNumber(1);
			pa.setList(doPaging(pa.getPageNumber(), objectsPerPage, wdao));
		}else if (request.getParameter("page") != null
		&& request.getParameter("page").trim().length() != 0 && request.getParameter("sort") == null) {
			pa.setPageNumber(
				Integer.parseInt(request.getParameter("page")));
		pa.setList(doPaging(pa.getPageNumber(), objectsPerPage, wdao));
       logger.debug("--> going to page without sorting : " + pa.getPageNumber());
     	} else if (request.getParameter("pageSort") != null) {
          pa = fillPagedAdapter(request, wdao, pa);

		} else {
			pa.setList(doPaging(pa.getPageNumber(), objectsPerPage, wdao));
		}
		if (request.getParameter("sort") != null
			&& request.getParameter("sort").trim().length() == 0) {
			map.put("defSort", "true");
			
		} else {
			pa.setSortCriterion(request.getParameter("sort"));
			
		}
		pa.setSortDirection(request.getParameter("dir"));
		pa.setFullListSize(wdao.countWorks());
		pa.setObjectsPerPage(this.objectsPerPage);
		map.put("works", pa);
		map.put("pageSortNum", new Integer(pa.getPageNumber()).toString());
		request.setAttribute("size", new Integer(pa.getFullListSize()));
		logger.debug(
			"--> processing model and view paging by : "
				+ this.objectsPerPage
				+ " on page : "
				+ new Integer(pa.getPageNumber()).toString());
		return new ModelAndView("worksView", map);
	}

	private void deleteItems(String[] delItems, WorksDao wdao) {
		for (int i = 0; i < delItems.length; i++) {
			logger.debug("---> deleting work : " + delItems[i]);
			caWorks.setIdwork(new Integer(delItems[i]));
			wdao.removeWorks(caWorks);
		}
	}


	private  List doSorting(int number, int objects, WorksDao wdao, String sortField, boolean order) {
		list.clear();
	
		list = wdao.getSortedWorks(number, objects, sortField, order);
		return list;
	
	}

	private  List doPaging(int number, int objects, WorksDao wdao) {
		list.clear();
		list = wdao.getPagedWorks(number, objects);
		return list;
		}

private void  delWorks(CaWorks caWorks, HttpServletRequest request, WorksDao wdao ) {
	if (request.getParameter("idwork") != null) {
		caWorks.setIdwork(new Integer(request.getParameter("idwork")));
		wdao.removeWorks(caWorks);
	} else {
		logger.debug(
			"----> deleting works : "
				+ request.getParameterValues("delItem"));
		String[] delWorks = request.getParameterValues("delItem");
		deleteItems(delWorks, wdao);
	}
}


private CaPagedAdapter fillPagedAdapter(HttpServletRequest request, WorksDao wdao, CaPagedAdapter pa) {
	if (request.getParameter("page") != null) {

		pa.setPageNumber(
			Integer.parseInt(request.getParameter("page")));
	} else {
		pa.setPageNumber(
			Integer.parseInt(request.getParameter("pageSort")));
	}

	if (request.getParameter("sort") != null
		&& request.getParameter("sort").trim().length() == 0) {
		sortField = "init";

	} else if (
		request.getParameter("sort") != null
			&& request.getParameter("sort").equals("status")) {
		sortField = "status";

	} else {
		sortField = "iduser";

	}
	if (request.getParameter("dir") != null
		&& request.getParameter("dir").equals("desc")) {
		order = false;
	} else {
		order = true;
	}

    logger.debug("--> going to a sorted page" + pa.getPageNumber());
	pa.setList(
		doSorting(
			pa.getPageNumber(),
			objectsPerPage,
			wdao,
			sortField,
			order));
			return pa;
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
