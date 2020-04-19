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
 * Documentation for  interface <code>GroupsDao</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public interface GroupsDao {

	/**
	 * Describe <code>getGroups</code> method here.
	 *
	 * @return    a <code>List</code> value
	 */
	public List getGroups();


	/**
	 * Describe <code>getGroupsbyId</code> method here.
	 *
	 * @param  caGroups  a <code>CaGroups</code> value
	 * @return           a <code>List</code> value
	 */
	public List getGroupsbyId(CaGroups caGroups);


	/**
	 * Describe <code>updateGroups</code> method here.
	 *
	 * @param  command  an <code>Object</code> value
	 */
	public void updateGroups(Object command);


	/**
	 * Describe <code>removeGroups</code> method here.
	 *
	 * @param  caGroups  a <code>CaGroups</code> value
	 */
	public void removeGroups(CaGroups caGroups);

}

