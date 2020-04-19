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
 * Documentation for  class <code>CaWorker</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class CaWorker implements java.io.Serializable {

	private Integer idworker;
	private List worker_workers;
	private String fname;
	private String lname;
	private String email;
	private String depmt;
	private CaGroups idgroup;


	// Constructors

	/**
	 * Creates a new <code>CaWorker</code> instance.
	 */
	public CaWorker() { }


	/**
	 * Creates a new <code>CaWorker</code> instance.
	 *
	 * @param  idworker  an <code>Integer</code> value
	 */
	public CaWorker(Integer idworker) {
		this.idworker = idworker;
	}




	/**
	 * Describe <code>getFname</code> method here.
	 *
	 * @return    a <code>String</code> value
	 */
	public String getFname() {
		return this.fname;
	}


	/**
	 * Describe <code>setFname</code> method here.
	 *
	 * @param  fname  a <code>String</code> value
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}


	/**
	 * Describe <code>getLname</code> method here.
	 *
	 * @return    a <code>String</code> value
	 */
	public String getLname() {
		return this.lname;
	}


	/**
	 * Describe <code>setLname</code> method here.
	 *
	 * @param  lname  a <code>String</code> value
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}


	/**
	 * Describe <code>getEmail</code> method here.
	 *
	 * @return    a <code>String</code> value
	 */
	public String getEmail() {
		return this.email;
	}


	/**
	 * Describe <code>setEmail</code> method here.
	 *
	 * @param  email  a <code>String</code> value
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * Describe <code>getDepmt</code> method here.
	 *
	 * @return    a <code>String</code> value
	 */
	public String getDepmt() {
		return this.depmt;
	}


	/**
	 * Describe <code>setDepmt</code> method here.
	 *
	 * @param  depmt  a <code>String</code> value
	 */
	public void setDepmt(String depmt) {
		this.depmt = depmt;
	}


	/**
	 * Describe <code>getIdgroup</code> method here.
	 *
	 * @return    a <code>CaGroups</code> value
	 */
	public CaGroups getIdgroup() {
		return this.idgroup;
	}


	/**
	 * Describe <code>setIdgroup</code> method here.
	 *
	 * @param  idgroup  a <code>CaGroups</code> value
	 */
	public void setIdgroup(CaGroups idgroup) {
		this.idgroup = idgroup;
	}




	/**
	 * Describe <code>getIdworker</code> method here.
	 *
	 * @return    an <code>Integer</code> value
	 */
	public Integer getIdworker() {
		return idworker;
	}


	/**
	 * Describe <code>setIdworker</code> method here.
	 *
	 * @param  integer  an <code>Integer</code> value
	 */
	public void setIdworker(Integer integer) {
		idworker = integer;
	}


	/**
	 * Describe <code>getWorker_workers</code> method here.
	 *
	 * @return    a <code>List</code> value
	 */
	public List getWorker_workers() {
		return worker_workers;
	}


	/**
	 * Describe <code>setWorker_workers</code> method here.
	 *
	 * @param  list  a <code>List</code> value
	 */
	public void setWorker_workers(List list) {
		worker_workers = list;
	}

}

