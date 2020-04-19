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
package mx.org.cadmin.persist;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * Documentation for  class <code>UsersDaoHibImp</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class UsersDaoHibImp extends HibernateDaoSupport implements UsersDao {


	/**
	 * Creates a new <code>UsersDaoHibImp</code> instance.
	 */
	public UsersDaoHibImp() {
		super();
	}


	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());


	/**
	 * Describe <code>getUsers</code> method here.
	 *
	 * @return    a <code>List</code> value
	 */
	public List getUsers() {
		List list = new ArrayList();

		list = getHibernateTemplate().find("from CaUsers u order by u.iduser");

		return list;
	}


	/**
	 * Describe <code>getUsersbyId</code> method here.
	 *
	 * @param  caUser  a <code>CaUsers</code> value
	 * @return         a <code>List</code> value
	 */
	public List getUsersbyId(CaUsers caUser) {
		List list = new ArrayList();

		list = getHibernateTemplate().find("from CaUsers u where u.iduser = ?", caUser.getIduser());
		logger.debug(" >>> list contains : " + list.size());
		return list;
	}


	/**
	 * Describe <code>updateUsers</code> method here.
	 *
	 * @param  command  an <code>Object</code> value
	 */
	public void updateUsers(Object command) {

		getHibernateTemplate().saveOrUpdate(command);

	}


	/**
	 * Describe <code>removeUsers</code> method here.
	 *
	 * @param  caUsers  a <code>CaUsers</code> value
	 */
	public void removeUsers(CaUsers caUsers) {
		getHibernateTemplate().initialize(caUsers);

		getHibernateTemplate().refresh(caUsers);
		getHibernateTemplate().delete(caUsers);
		getHibernateTemplate().flush();
	}


	/**
	 * Describe <code>getUsersbyEmail</code> method here.
	 *
	 * @param  caUser  a <code>CaUsers</code> value
	 * @return         a <code>List</code> value
	 */
	public List getUsersbyEmail(CaUsers caUser) {
		List list = new ArrayList();

		list = getHibernateTemplate().find("from CaUsers u where u.email = ?", caUser.getEmail());
		logger.debug(" >>> list contains : " + list.size());
		return list;
	}

}

