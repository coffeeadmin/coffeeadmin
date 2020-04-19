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


import java.util.List;

/**
 * Documentation for  interface <code>WorksDao</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @version    0.6
 * @since 0.5
 */
public interface WorksDao {

	/**
	 * Describe <code>getWorks</code> method here.
	 *
	 * @return    a <code>List</code> value
	 */
	public List getWorks();


	/**
	 * Describe <code>getWorksbyId</code> method here.
	 *
	 * @param  caWorks  a <code>CaWorks</code> value
	 * @return          a <code>List</code> value
	 */
	public List getWorksbyId(CaWorks caWorks);


	/**
	 * Describe <code>updateWorks</code> method here.
	 *
	 * @param  command  an <code>Object</code> value
	 */
	public void updateWorks(Object command);


	/**
	 * Describe <code>removeWorks</code> method here.
	 *
	 * @param  caWorks  a <code>CaWorks</code> value
	 */
	public void removeWorks(CaWorks caWorks);


	/**
	 * Describe <code>getDateReport</code> method here.
	 *
	 * @param  caWorks  a <code>CaWorks</code> value
	 * @return          a <code>List</code> value
	 */
	public List getDateReport(CaWorks caWorks);


	/**
	 * Describe <code>getUserReport</code> method here.
	 *
	 * @param  caWorks  a <code>CaWorks</code> value
	 * @return          a <code>List</code> value
	 */
	public List getUserReport(CaWorks caWorks);


	/**
	 * Describe <code>getContactReport</code> method here.
	 *
	 * @param  caWorks  a <code>CaWorks</code> value
	 * @return          a <code>List</code> value
	 */
	public List getContactReport(CaWorks caWorks);


	/**
	 * Describe <code>getWorkerReport</code> method here.
	 *
	 * @param  caWorks  a <code>CaWorks</code> value
	 * @return          a <code>List</code> value
	 */
	public List getWorkerReport(CaWorks caWorks);

  /**
   * Describe <code>getGroupReport</code> method here.
   *
   * @param caWorks a <code>CaWorks</code> value
   * @return a <code>List</code> value
   */
  public List getGroupReport(CaWorks caWorks);

  /**
   * Describe <code>getPagedWorks</code> method here.
   *
   * @param page an <code>int</code> value
   * @param pageObjects an <code>int</code> value
   * @return a <code>List</code> value
   */
  public List getPagedWorks(int page, int pageObjects);

  /**
   * Describe <code>getSortedWorks</code> method here.
   *
   * @param page an <code>int</code> value
   * @param pageObjects an <code>int</code> value
   * @param sortField a <code>String</code> value
   * @param order a <code>boolean</code> value
   * @return a <code>List</code> value
   */
  public List getSortedWorks(int page, int pageObjects, String sortField, boolean order);

  /**
   * Describe <code>countWorks</code> method here.
   *
   * @return an <code>int</code> value
   */
  public int countWorks();

}

