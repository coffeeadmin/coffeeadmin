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
package mx.org.cadmin.valid;

import mx.org.cadmin.persist.CaGroups;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Documentation for  class <code>CaGroupsValidator</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class CaGroupsValidator implements Validator {

	/**
	 * Describe <code>supports</code> method here.
	 *
	 * @param  clazz  a <code>Class</code> value
	 * @return        a <code>boolean</code> value
	 */
	public boolean supports(Class clazz) {

		return clazz.equals(CaGroups.class);
	}


	/**
	 * Describe <code>validate</code> method here.
	 *
	 * @param  command  an <code>Object</code> value
	 * @param  errors   an <code>Errors</code> value
	 */
	public void validate(Object command, Errors errors) {

		CaGroups caGroups = (CaGroups) command;
		if (caGroups.getDescription() == null || caGroups.getDescription().trim().length() == 0) {
			errors.rejectValue("description", "required.name", null, "name is required");
		}
		if (caGroups.getIduser().getIduser() == null || caGroups.getIduser().getIduser().intValue() < 1) {
			errors.rejectValue("iduser.iduser", "required.group.iduser", null, "please select manager");
		}
	}

}

