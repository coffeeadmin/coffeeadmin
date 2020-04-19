/**
 *                       CoffeeAdmin Project
 *
 *  ========================================================================
 *
 *   Copyright (C) 20067CoffeeAdmin Project. All rights reserved.
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
package mx.org.cadmin.persist;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * Documentation for  class <code>ContactsDaoHibImp</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class ContactsDaoHibImp extends HibernateDaoSupport implements ContactsDao {


	/**
	 * Creates a new <code>ContactsDaoHibImp</code> instance.
	 */
	public ContactsDaoHibImp() {
		super();
	}


	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());


	/**
	 * Describe <code>getContacts</code> method here.
	 *
	 * @return    a <code>List</code> value
	 */
	public List getContacts() {
		List list = new ArrayList();

		list = getHibernateTemplate().find("from CaContacts c order by c.idcontact");
		logger.debug(" >>> list contains : " + list.size());
		return list;
	}


	/**
	 * Describe <code>getContactsbyId</code> method here.
	 *
	 * @param  caContacts  a <code>CaContacts</code> value
	 * @return             a <code>List</code> value
	 */
	public List getContactsbyId(CaContacts caContacts) {
		List list = new ArrayList();

		list = getHibernateTemplate().find("from CaContacts c where c.idcontact = ?", caContacts.getIdcontact());
		logger.debug(" >>> list contains : " + list.size());
		return list;
	}


	/**
	 * Describe <code>updateContacts</code> method here.
	 *
	 * @param  command  an <code>Object</code> value
	 */
	public void updateContacts(Object command) {
		CaContacts caContacts = (CaContacts) command;
		getHibernateTemplate().initialize(caContacts);
		getHibernateTemplate().saveOrUpdate(command);
	}


	/**
	 * Describe <code>removeContacts</code> method here.
	 *
	 * @param  caContacts  a <code>CaContacts</code> value
	 */
	public void removeContacts(CaContacts caContacts) {

		getHibernateTemplate().initialize(caContacts);
		getHibernateTemplate().refresh(caContacts);
		getHibernateTemplate().delete(caContacts);
		getHibernateTemplate().flush();
	}

}

