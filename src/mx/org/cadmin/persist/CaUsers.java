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
 * Documentation for  class <code>CaUsers</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class CaUsers implements java.io.Serializable {

	// Fields

	private Integer iduser;
	private List users_groups ;
	private Set users_works = new HashSet();
	private String fname;
	private String lname;
	private String email;
	private String title;
	private String depmt;
	private String corp;
	private String password;


	// Constructors

	/**
	 * Creates a new <code>CaUsers</code> instance.
	 */
	public CaUsers() { }


	/**
	 * Creates a new <code>CaUsers</code> instance.
	 *
	 * @param  iduser  an <code>Integer</code> value
	 */
	public CaUsers(Integer iduser) {
		this.iduser = iduser;
	}



	// Property accessors

	/**
	 * Describe <code>getIduser</code> method here.
	 *
	 * @return    an <code>Integer</code> value
	 */
	public Integer getIduser() {
		return this.iduser;
	}


	/**
	 * Describe <code>setIduser</code> method here.
	 *
	 * @param  iduser  an <code>Integer</code> value
	 */
	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}


	/**
	 * Describe <code>getUsers_works</code> method here.
	 *
	 * @return    a <code>Set</code> value
	 */
	public Set getUsers_works() {
		return this.users_works;
	}


	/**
	 * Describe <code>setUsers_works</code> method here.
	 *
	 * @param  users_works  a <code>Set</code> value
	 */
	public void setUsers_works(Set users_works) {
		this.users_works = users_works;
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
	 * Describe <code>getTitle</code> method here.
	 *
	 * @return    a <code>String</code> value
	 */
	public String getTitle() {
		return this.title;
	}


	/**
	 * Describe <code>setTitle</code> method here.
	 *
	 * @param  title  a <code>String</code> value
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * Describe <code>getCorp</code> method here.
	 *
	 * @return    a <code>String</code> value
	 */
	public String getCorp() {
		return this.corp;
	}


	/**
	 * Describe <code>setCorp</code> method here.
	 *
	 * @param  corp  a <code>String</code> value
	 */
	public void setCorp(String corp) {
		this.corp = corp;
	}


	/**
	 * Describe <code>getPassword</code> method here.
	 *
	 * @return    a <code>String</code> value
	 */
	public String getPassword() {
		return this.password;
	}


	/**
	 * Describe <code>setPassword</code> method here.
	 *
	 * @param  password  a <code>String</code> value
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return
	 */
	public List getUsers_groups() {
		return users_groups;
	}

	/**
	 * @param list
	 */
	public void setUsers_groups(List list) {
		users_groups = list;
	}

}

