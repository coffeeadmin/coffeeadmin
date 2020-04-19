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

import mx.org.cadmin.persist.CaContacts;
import mx.org.cadmin.persist.ContactsDao;

import org.springframework.web.servlet.ModelAndView;


/**
 * Documentation for  class <code>ContactsController</code> .
 *
 * @author <a href="www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @version 0.6
 */
public class ContactsController extends CoffeeController {

	private int objectsPerPage;
	/**
	 * Describe <code>contactsShow</code> method here.
	 *
	 * @param  request               a <code>HttpServletRequest</code> value
	 * @param  response              a <code>HttpServletResponse</code> value
	 * @return                       a <code>ModelAndView</code> value
	 * @exception  ServletException  if an error occurs
	 */
	public ModelAndView contactsShow(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		CaContacts caContacts = new CaContacts();
		this.init(request, response);
		ContactsDao dao = (ContactsDao) ctx.getBean("contactsDao");

		if (request.getParameter("del") != null) {
			if (request.getParameter("idcontact") != null) {
				caContacts.setIdcontact(new Integer(request.getParameter("idcontact")));
				dao.removeContacts(caContacts);
			} else {
				String[] delItems = request.getParameterValues("delItem");
				for (int i = 0; i < delItems.length; i++) {
					logger.debug("---> deleting Contact : " + delItems[i]);
					caContacts.setIdcontact(new Integer(delItems[i]));
					dao.removeContacts(caContacts);
				}
			}

			return new ModelAndView("redirect:viewContacts.htm");
		}

		if (request.getParameter("idcontact") != null) {

			caContacts.setIdcontact(new Integer(request.getParameter("idcontact")));
			list = dao.getContactsbyId(caContacts);
			logger.debug(" >>> idcontact  detailed to view : " + request.getParameter("idcontact"));
			map.put("contact", list);
			return new ModelAndView("contactsDetailView", map);
		}

		list = dao.getContacts();
		logger.debug(" >>> returning usersView context has dao :  " + ctx.containsBean("contactsDao"));

		map.put("contacts", list);

		return new ModelAndView("contactsView", map);
	}
  /**
   * Describe <code>getObjectsPerPage</code> method here.
   *
   * @return
   */
  public int getObjectsPerPage() {
		return objectsPerPage;
	}

  /**
   * Describe <code>setObjectsPerPage</code> method here.
   *
   * @param i
   */
  public void setObjectsPerPage(int i) {
		objectsPerPage = i;
	}

}
