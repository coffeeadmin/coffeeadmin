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
 * <code>CaGroups</code> is the bean class for groups .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class CaGroups implements java.io.Serializable {

	// Fields

	/**
	 * Describe variable <code>idgroup</code> here.
	 */
	private Integer idgroup;
	/**
	 * Describe variable <code>group_worker</code> here.
	 */
	private Set group_worker;
	/**
	 * Describe variable <code>description</code> here.
	 */
	private String description;
	/**
	 * Describe variable <code>iduser</code> here.
	 */
	private CaUsers iduser;


	// Constructors

	/**
	 * Creates a new <code>CaGroups</code> instance.
	 */
	public CaGroups() {
		CaUsers caUsers = new CaUsers();
		this.iduser = caUsers;
	}


	/**
	 * Creates a new <code>CaGroups</code> instance.
	 *
	 * @param  idgroup  an <code>Integer</code> value
	 */
	public CaGroups(Integer idgroup) {
		this.idgroup = idgroup;
	}



	// Property accessors

	/**
	 * Describe <code>getIdgroup</code> method here.
	 *
	 * @return    an <code>Integer</code> value
	 */
	public Integer getIdgroup() {
		return this.idgroup;
	}


	/**
	 * Describe <code>setIdgroup</code> method here.
	 *
	 * @param  idgroup  an <code>Integer</code> value
	 */
	public void setIdgroup(Integer idgroup) {
		this.idgroup = idgroup;
	}


	/**
	 * Describe <code>getGroup_worker</code> method here.
	 *
	 * @return    a <code>Set</code> value
	 */
	public Set getGroup_worker() {
		return this.group_worker;
	}


	/**
	 * Describe <code>setGroup_worker</code> method here.
	 *
	 * @param  group_worker  a <code>Set</code> value
	 */
	public void setGroup_worker(Set group_worker) {
		this.group_worker = group_worker;
	}


	/**
	 * Describe <code>getDescription</code> method here.
	 *
	 * @return    a <code>String</code> value
	 */
	public String getDescription() {
		return this.description;
	}


	/**
	 * Describe <code>setDescription</code> method here.
	 *
	 * @param  description  a <code>String</code> value
	 */
	public void setDescription(String description) {
		this.description = description;
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


}

