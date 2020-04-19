/****************************************************************************
*
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

import mx.org.cadmin.persist.CaGroups;
import mx.org.cadmin.persist.GroupsDao;

import org.springframework.web.servlet.ModelAndView;

/**
 * Documentation for  class <code>GroupsController</code> .
 *
 * @author <a href="www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @version 0.6
 */
public class GroupsController extends CoffeeController {


	private int objectsPerPage;

	/**
	 * Describe <code>groupsShow</code> method here.
	 *
	 * @param  request               a <code>HttpServletRequest</code> value
	 * @param  response              a <code>HttpServletResponse</code> value
	 * @return                       a <code>ModelAndView</code> value
	 * @exception  ServletException  if an error occurs
	 */
	public ModelAndView groupsShow(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException {

			CaGroups caGroups = new CaGroups();
			this.init(request, response);
			GroupsDao dao = (GroupsDao) ctx.getBean("groupsDao");

			if (request.getParameter("del") != null) {

				String[] delItems = request.getParameterValues("delItem");
				for (int i = 0; i < delItems.length; i++) {
					logger.debug("---> deleting Group : " + delItems[i]);
					caGroups.setIdgroup(new Integer(delItems[i]));
					dao.removeGroups(caGroups);
				}

				return new ModelAndView("redirect:viewGroups.htm");
			}
			list = dao.getGroups();
			map.put("groups", list);
			return new ModelAndView("groupsView", map);
	}

  /**
   * Describe <code>getObjectsPerPage</code> method here.
   *
   * @return
   */
  public int getObjectsPerPage() {
		return objectsPerPage;
	}

	public void setObjectsPerPage(int i) {
		objectsPerPage = i;
	}

}
