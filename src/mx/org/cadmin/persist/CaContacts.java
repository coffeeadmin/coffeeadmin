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
 * Describe class <code>CaContacts</code> here.
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since .5
 * @version    0.6
 */
public class CaContacts implements java.io.Serializable {

	// Fields

	private Integer idcontact;
	private String title;
	private String fname;
	private String lname;
	private String email;
	private String corp;
	private Set works_contacts;


	// Constructors

	/**
	 * Creates a new <code>CaContacts</code> instance.
	 */
	public CaContacts() { }


	/**
	 * Creates a new <code>CaContacts</code> instance.
	 *
	 * @param  idcontact  an <code>Integer</code> value
	 */
	public CaContacts(Integer idcontact) {
		this.idcontact = idcontact;
	}



	// Property accessors

	/**
	 * Describe <code>getIdcontact</code> method here.
	 *
	 * @return    an <code>Integer</code> value
	 */
	public Integer getIdcontact() {
		return this.idcontact;
	}


	/**
	 * Describe <code>setIdcontact</code> method here.
	 *
	 * @param  idcontact  an <code>Integer</code> value
	 */
	public void setIdcontact(Integer idcontact) {
		this.idcontact = idcontact;
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
	 * Describe <code>getWorks_contacts</code> method here.
	 *
	 * @return    a <code>Set</code> value
	 */
	public Set getWorks_contacts() {
		return works_contacts;
	}


	/**
	 * Describe <code>setWorks_contacts</code> method here.
	 *
	 * @param  set  a <code>Set</code> value
	 */
	public void setWorks_contacts(Set set) {
		works_contacts = set;
	}

}

