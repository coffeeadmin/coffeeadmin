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
 *  <code>CaFiles</code> is the bean class for files .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class CaFiles implements java.io.Serializable {

	// Fields

	private String name;
	private CaWorks work;

	// Constructors

	/**
	 * Creates a new <code>CaFiles</code> instance.
	 */
	public CaFiles() { }


	/**
	 * Creates a new <code>CaFiles</code> instance.
	 *
	 * @param  name  a <code>String</code> value
	 */
	public CaFiles(String name) {
		this.name = name;
	}



	/**
	 * Describe <code>getName</code> method here.
	 *
	 * @return    a <code>String</code> value
	 */
	public String getName() {
		return name;
	}


	/**
	 * Describe <code>setName</code> method here.
	 *
	 * @param  string  a <code>String</code> value
	 */
	public void setName(String string) {
		name = string;
	}


	/**
	 * Describe <code>getWork</code> method here.
	 *
	 * @return    a <code>CaWorks</code> value
	 */
	public CaWorks getWork() {
		return work;
	}


	/**
	 * Describe <code>setWork</code> method here.
	 *
	 * @param  works  a <code>CaWorks</code> value
	 */
	public void setWork(CaWorks works) {
		work = works;
	}

}

