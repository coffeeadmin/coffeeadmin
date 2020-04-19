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
import org.hibernate.criterion.*;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * Documentation for  class <code>WorkerDaoHibImp</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class WorkerDaoHibImp extends HibernateDaoSupport implements WorkerDao {


	/**
	 * Creates a new <code>WorkerDaoHibImp</code> instance.
	 */
	public WorkerDaoHibImp() {
		super();
	}


	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());



	/**
	 * Describe <code>getWorkers</code> method here.
	 *
	 * @return    a <code>List</code> value
	 */
	public List getWorkers() {
		List list = new ArrayList();
		DetachedCriteria crit = DetachedCriteria.forClass(CaWorker.class);
		crit.setFetchMode("idworker", FetchMode.JOIN);
		list = getHibernateTemplate().findByCriteria(crit);

		return list;
	}



	/**
	 * Describe <code>getWorkersbyId</code> method here.
	 *
	 * @param  caWorker  a <code>CaWorker</code> value
	 * @return           a <code>List</code> value
	 */
	public List getWorkersbyId(CaWorker caWorker) {
		List list = new ArrayList();
		DetachedCriteria crit = DetachedCriteria.forClass(CaWorker.class)
				.add(Restrictions.eq("idworker", caWorker.getIdworker()));

		list = getHibernateTemplate().findByCriteria(crit);
		logger.debug(" >>> list contains : " + list.size());
		return list;
	}



	/**
	 * Describe <code>updateWorkers</code> method here.
	 *
	 * @param  command  an <code>Object</code> value
	 */
	public void updateWorkers(Object command) {
		CaWorker caWorker = (CaWorker) command;
		getHibernateTemplate().initialize(caWorker);

		getHibernateTemplate().saveOrUpdate(caWorker);

	}



	/**
	 * Describe <code>removeWorkers</code> method here.
	 *
	 * @param  caWorker  a <code>CaWorker</code> value
	 */
	public void removeWorkers(CaWorker caWorker) {
		getHibernateTemplate().initialize(caWorker);
		getHibernateTemplate().refresh(caWorker);
		getHibernateTemplate().delete(caWorker);
		getHibernateTemplate().flush();

	}

}

