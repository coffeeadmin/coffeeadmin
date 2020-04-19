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

import java.util.*;



/**
 * Documentation for  class <code>CaWorks</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class CaWorks implements java.io.Serializable {

	// Fields

	private Integer idwork;
	private List works_workers;
	private List work_files;
	private String content;
	private CaUsers iduser;
	private Date init;
	private Date end;
	private String status;
	private CaContacts idcontact;


	// Constructors

	/**
	 * Creates a new <code>CaWorks</code> instance.
	 */
	public CaWorks() { }


	/**
	 * Creates a new <code>CaWorks</code> instance.
	 *
	 * @param  idwork  an <code>Integer</code> value
	 */
	public CaWorks(Integer idwork) {
		this.idwork = idwork;
	}




	/**
	 * Describe <code>getContent</code> method here.
	 *
	 * @return    a <code>String</code> value
	 */
	public String getContent() {
		return this.content;
	}


	/**
	 * Describe <code>setContent</code> method here.
	 *
	 * @param  content  a <code>String</code> value
	 */
	public void setContent(String content) {
		this.content = content;
	}


	/**
	 * Describe <code>getIduser</code> method here.
	 *
	 * @return    a <code>CaUsers</code> value
	 */
	public CaUsers getIduser() {
		return this.iduser;
	}


	/**
	 * Describe <code>setIduser</code> method here.
	 *
	 * @param  iduser  a <code>CaUsers</code> value
	 */
	public void setIduser(CaUsers iduser) {
		this.iduser = iduser;
	}


	/**
	 * Describe <code>getInit</code> method here.
	 *
	 * @return    a <code>Date</code> value
	 */
	public Date getInit() {
		return this.init;
	}


	/**
	 * Describe <code>setInit</code> method here.
	 *
	 * @param  init  a <code>Date</code> value
	 */
	public void setInit(Date init) {
		this.init = init;
	}


	/**
	 * Describe <code>getEnd</code> method here.
	 *
	 * @return    a <code>Date</code> value
	 */
	public Date getEnd() {
		return this.end;
	}


	/**
	 * Describe <code>setEnd</code> method here.
	 *
	 * @param  end  a <code>Date</code> value
	 */
	public void setEnd(Date end) {
		this.end = end;
	}


	/**
	 * Describe <code>getStatus</code> method here.
	 *
	 * @return    a <code>String</code> value
	 */
	public String getStatus() {
		return this.status;
	}


	/**
	 * Describe <code>setStatus</code> method here.
	 *
	 * @param  status  a <code>String</code> value
	 */
	public void setStatus(String status) {
		this.status = status;
	}




	/**
	 * Describe <code>getIdcontact</code> method here.
	 *
	 * @return    a <code>CaContacts</code> value
	 */
	public CaContacts getIdcontact() {
		return idcontact;
	}


	/**
	 * Describe <code>setIdcontact</code> method here.
	 *
	 * @param  contacts  a <code>CaContacts</code> value
	 */
	public void setIdcontact(CaContacts contacts) {
		idcontact = contacts;
	}


	/**
	 * Describe <code>getIdwork</code> method here.
	 *
	 * @return    an <code>Integer</code> value
	 */
	public Integer getIdwork() {
		return idwork;
	}


	/**
	 * Describe <code>setIdwork</code> method here.
	 *
	 * @param  integer  an <code>Integer</code> value
	 */
	public void setIdwork(Integer integer) {
		idwork = integer;
	}


	/**
	 * Describe <code>getWorks_workers</code> method here.
	 *
	 * @return    a <code>List</code> value
	 */
	public List getWorks_workers() {
		return works_workers;
	}


	/**
	 * Describe <code>setWorks_workers</code> method here.
	 *
	 * @param  list  a <code>List</code> value
	 */
	public void setWorks_workers(List list) {
		works_workers = list;
	}


	/**
	 * Describe <code>getWork_files</code> method here.
	 *
	 * @return    a <code>List</code> value
	 */
	public List getWork_files() {
		return work_files;
	}


	/**
	 * Describe <code>setWork_files</code> method here.
	 *
	 * @param  list  a <code>List</code> value
	 */
	public void setWork_files(List list) {
		work_files = list;
	}

}

