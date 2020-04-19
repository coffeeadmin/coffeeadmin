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
 * Documentation for  interface <code>UsersDao</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public interface UsersDao {

	/**
	 * Describe <code>getUsers</code> method here.
	 *
	 * @return    a <code>List</code> value
	 */
	public List getUsers();


	/**
	 * Describe <code>getUsersbyId</code> method here.
	 *
	 * @param  caUsers  a <code>CaUsers</code> value
	 * @return          a <code>List</code> value
	 */
	public List getUsersbyId(CaUsers caUsers);


	/**
	 * Describe <code>getUsersbyEmail</code> method here.
	 *
	 * @param  caUsers  a <code>CaUsers</code> value
	 * @return          a <code>List</code> value
	 */
	public List getUsersbyEmail(CaUsers caUsers);


	/**
	 * Describe <code>updateUsers</code> method here.
	 *
	 * @param  command  an <code>Object</code> value
	 */
	public void updateUsers(Object command);


	/**
	 * Describe <code>removeUsers</code> method here.
	 *
	 * @param  caUsers  a <code>CaUsers</code> value
	 */
	public void removeUsers(CaUsers caUsers);

}

