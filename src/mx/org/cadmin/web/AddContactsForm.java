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
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import mx.org.cadmin.persist.CaContacts;
import mx.org.cadmin.persist.ContactsDao;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Documentation for  class <code>AddContactsForm</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class AddContactsForm extends MainForm {

	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	private ContactsDao contactsDao;



	/**
	 * Creates a new <code>AddContactsForm</code> instance.
	 */
	public AddContactsForm() {
		setSessionForm(true);
		setBindOnNewForm(true);
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
		CaContacts caContacts = new CaContacts();
		List list = new ArrayList();
		this.init(request);
		ContactsDao dao = (ContactsDao) ctx.getBean("contactsDao");
		if (request.getParameter("idcontact") != null && request.getParameter("idcontact").length() > 0) {

			caContacts.setIdcontact(new Integer(request.getParameter("idcontact")));
			list = dao.getContactsbyId(caContacts);
			caContacts = (CaContacts) list.get(0);
		}
		return caContacts;
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
		ContactsDao dao = (ContactsDao) ctx.getBean("contactsDao");
		dao.updateContacts(command);
		logger.debug(" >>> redirecting view ");
		return new ModelAndView("contactsFormRedirect");
	}


	/**
	 * Describe <code>getContactsDao</code> method here.
	 *
	 * @return    a <code>ContactsDao</code> value
	 */
	public ContactsDao getContactsDao() {
		return contactsDao;
	}



	/**
	 * Describe <code>setContactsDao</code> method here.
	 *
	 * @param  contactsDao  a <code>ContactsDao</code> value
	 */
	public void setContactsDao(ContactsDao contactsDao) {
		this.contactsDao = contactsDao;
	}
}

