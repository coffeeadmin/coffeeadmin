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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Documentation for  class <code>WorksDaoHibImp</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @version    0.6
 * @since 0.5
 */
public class WorksDaoHibImp extends HibernateDaoSupport implements WorksDao {

	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());




	/**
	 * Creates a new <code>WorksDaoHibImp</code> instance.
	 */
	public WorksDaoHibImp() {
		super();
//	setDataSource(dataSource);
	}


	/**
	 * Describe <code>getWorks</code> method here.
	 *
	 * @return    a <code>List</code> value
	 */
	public List getWorks() {
		List list = new ArrayList();
		DetachedCriteria crit = DetachedCriteria.forClass(CaWorks.class);
		crit.setFetchMode("iduser", FetchMode.JOIN);
		crit.setFetchMode("idcontact", FetchMode.JOIN);

		list = getHibernateTemplate().findByCriteria(crit);
		return list;
	}


	/**
	 * Describe <code>getWorksbyId</code> method here.
	 *
	 * @param  caWorks  a <code>CaWorks</code> value
	 * @return          a <code>List</code> value
	 */
	public List getWorksbyId(CaWorks caWorks) {

		List list = new ArrayList();
		DetachedCriteria crit = DetachedCriteria.forClass(CaWorks.class)
				.add(Restrictions.eq("idwork", caWorks.getIdwork()));
		list = getHibernateTemplate().findByCriteria(crit);
		logger.debug(">> elements in first list " + list.size());
		caWorks = (CaWorks) list.get(0);
		getHibernateTemplate().initialize(caWorks.getWorks_workers());

		list.clear();
		list.add(caWorks);
		return list;
	}


	/**
	 * Describe <code>updateWorks</code> method here.
	 *
	 * @param  command  an <code>Object</code> value
	 */
	public void updateWorks(Object command) {
		CaWorks caWorks = (CaWorks) command;

		getHibernateTemplate().saveOrUpdate(caWorks);
		getHibernateTemplate().flush();
	}



	/**
	 * Describe <code>removeWorks</code> method here.
	 *
	 * @param  caWorks  a <code>CaWorks</code> value
	 */
	public void removeWorks(CaWorks caWorks) {
		getHibernateTemplate().initialize(caWorks);
		getHibernateTemplate().refresh(caWorks);
		getHibernateTemplate().delete(caWorks);
		getHibernateTemplate().flush();

	}


	/**
	 * Describe <code>getDateReport</code> method here.
	 *
	 * @param  caWorks  a <code>CaWorks</code> value
	 * @return          a <code>List</code> value
	 */
	public List getDateReport(CaWorks caWorks) {
		List list = new ArrayList();
		DetachedCriteria crit =
				DetachedCriteria.forClass(CaWorks.class).createAlias("iduser", "user").add(
				Restrictions.between("init", caWorks.getInit(), caWorks.getEnd())).addOrder(Order.asc("init"));

		list = getHibernateTemplate().findByCriteria(crit);
		logger.debug("-- -> report date list : " + list.size());
		return list;
	}


	/**
	 * Describe <code>getUserReport</code> method here.
	 *
	 * @param  caWorks  a <code>CaWorks</code> value
	 * @return          a <code>List</code> value
	 */
	public List getUserReport(CaWorks caWorks) {
		List list = new ArrayList();

		DetachedCriteria crit =
				DetachedCriteria.forClass(CaWorks.class).createAlias("iduser", "user").
				add(Restrictions.eq("user.iduser", caWorks.getIduser().getIduser())).
				add(Restrictions.between("init", caWorks.getInit(), caWorks.getEnd())).
				addOrder(Order.asc("init"));

		list = getHibernateTemplate().findByCriteria(crit);
		logger.debug("-- -> user report list : " + list.size());
		return list;
	}


	/**
	 * Describe <code>getContactReport</code> method here.
	 *
	 * @param  caWorks  a <code>CaWorks</code> value
	 * @return          a <code>List</code> value
	 */
	public List getContactReport(CaWorks caWorks) {
		List list = new ArrayList();
		DetachedCriteria crit =
				DetachedCriteria.forClass(CaWorks.class).
				createAlias("idcontact", "contact").
				add(Restrictions.eq("contact.idcontact", caWorks.getIdcontact().getIdcontact())).
				add(Restrictions.between("init", caWorks.getInit(), caWorks.getEnd())).
				addOrder(Order.asc("init"));

		list = getHibernateTemplate().findByCriteria(crit);
		logger.debug("-- -> contact report list : " + list.size());

		return list;
	}


	/**
	 * Describe <code>getWorkerReport</code> method here.
	 *
	 * @param  caWorks  a <code>CaWorks</code> value
	 * @return          a <code>List</code> value
	 */
	public List getWorkerReport(CaWorks caWorks) {
		List list = new ArrayList();
		DetachedCriteria crit =
				DetachedCriteria.forClass(CaWorks.class).
				add(Restrictions.between("init", caWorks.getInit(), caWorks.getEnd())).
				addOrder(Order.asc("init")).
				createCriteria("works_workers").
				add(Restrictions.eq("idworker", ((CaWorker) caWorks.getWorks_workers().get(0)).getIdworker()));

		list = getHibernateTemplate().findByCriteria(crit);
		logger.debug("-- -> worker report list : " + list.size());
		return list;
	}


  /**
   * Describe <code>getGroupReport</code> method here.
   *
   * @param caWorks a <code>CaWorks</code> value
   * @return a <code>List</code> value
   */
  public List getGroupReport(CaWorks caWorks) {
		List list = new ArrayList();

  DetachedCriteria crit =
		  DetachedCriteria.forClass(CaWorks.class).
		  add(Restrictions.between("init", caWorks.getInit(), caWorks.getEnd())).
		  addOrder(Order.asc("init")).
		  createCriteria("works_workers").
		  createCriteria("idgroup").
		  add(Restrictions.eq("idgroup", ((CaWorker)caWorks.getWorks_workers().get(0)).getIdgroup().getIdgroup()));
		list = getHibernateTemplate().findByCriteria(crit);
		logger.debug("-- -> group report list : " + list.size());
		return list;
	}
	

  /**
   * Describe <code>getPagedWorks</code> method here.
   *
   * @param page an <code>int</code> value
   * @param pageObjects an <code>int</code> value
   * @return a <code>List</code> value
   */
  public List getPagedWorks(int page, int pageObjects) {
		List list = new ArrayList();
	   logger.debug("-> finding paged list for page : " + page + " pageObjects : " + pageObjects);
		page--;
		DetachedCriteria crit =
		DetachedCriteria.forClass(CaWorks.class).addOrder(Order.desc("idwork"));
		//DetachedCriteria.forClass(CaWorks.class);
		list = getHibernateTemplate().findByCriteria(crit, page * pageObjects, pageObjects );		
				return list;
	}



  /**
   * Describe <code>getSortedWorks</code> method here.
   *
   * @param page an <code>int</code> value
   * @param pageObjects an <code>int</code> value
   * @param sortField a <code>String</code> value
   * @param order a <code>boolean</code> value
   * @return a <code>List</code> value
   */
  public List getSortedWorks(int page, int pageObjects, String sortField, boolean order) {
		List list = new ArrayList();
		Order o = null;
		logger.debug(
			"-> finding paged list for page : "
				+ page
				+ " pageObjects : "
				+ pageObjects);
		page--;
		if (order) {
			o = Order.desc(sortField);
		} else {
			o = Order.asc(sortField);
		}

		DetachedCriteria crit =
			DetachedCriteria.forClass(CaWorks.class).addOrder(o);
		list =
			getHibernateTemplate().findByCriteria(
				crit,
				page * pageObjects,
				pageObjects);
		return list;
	}



  /**
   * Describe <code>countWorks</code> method here.
   *
   * @return an <code>int</code> value
   */
  public int countWorks() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from CaWorks"));
	}


}

