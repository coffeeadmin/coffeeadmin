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
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * Documentation for  class <code>GroupsDaoHibImp</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class GroupsDaoHibImp extends HibernateDaoSupport implements GroupsDao {


	/**
	 * Creates a new <code>GroupsDaoHibImp</code> instance.
	 */
	public GroupsDaoHibImp() {
		super();
	}


	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());


	/**
	 * Describe <code>getGroups</code> method here.
	 *
	 * @return    a <code>List</code> value
	 */
	public List getGroups() {
		List list = new ArrayList();
		DetachedCriteria crit = DetachedCriteria.forClass(CaGroups.class);
		crit.setFetchMode("iduser", FetchMode.JOIN);
		list = getHibernateTemplate().findByCriteria(crit);

		return list;
	}





	/**
	 * Describe <code>getGroupsbyId</code> method here.
	 *
	 * @param  caGroups  a <code>CaGroups</code> value
	 * @return           a <code>List</code> value
	 */
	public List getGroupsbyId(CaGroups caGroups) {
		List list = new ArrayList();
		DetachedCriteria crit = DetachedCriteria.forClass(CaGroups.class)
				.add(Restrictions.eq("idgroup", caGroups.getIdgroup()));

		list = getHibernateTemplate().findByCriteria(crit);
		logger.debug(" >>> list contains : " + list.size());
		return list;
	}


	/**
	 * Describe <code>updateGroups</code> method here.
	 *
	 * @param  command  an <code>Object</code> value
	 */
	public void updateGroups(Object command) {

		CaGroups caGroups = (CaGroups) command;
		getHibernateTemplate().initialize(caGroups);

		getHibernateTemplate().saveOrUpdate(caGroups);
	}


	/**
	 * Describe <code>removeGroups</code> method here.
	 *
	 * @param  caGroups  a <code>CaGroups</code> value
	 */
	public void removeGroups(CaGroups caGroups) {

		getHibernateTemplate().initialize(caGroups);
		getHibernateTemplate().refresh(caGroups);
		getHibernateTemplate().delete(caGroups);
		getHibernateTemplate().flush();
	}



}

