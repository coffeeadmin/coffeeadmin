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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mx.org.cadmin.persist.CaWorker;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Documentation for  class <code>CaWorkerValidator</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class CaWorkerValidator implements Validator {

	/**
	 * Describe <code>supports</code> method here.
	 *
	 * @param  clazz  a <code>Class</code> value
	 * @return        a <code>boolean</code> value
	 */
	public boolean supports(Class clazz) {

		return clazz.equals(CaWorker.class);

	}


	/**
	 * Describe <code>validate</code> method here.
	 *
	 * @param  command  an <code>Object</code> value
	 * @param  errors   an <code>Errors</code> value
	 */
	public void validate(Object command, Errors errors) {

		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		CaWorker caWorker = (CaWorker) command;

		if (caWorker.getFname() == null || caWorker.getFname().trim().length() == 0) {
			errors.rejectValue("fname", "required.fname", null, "please enter first name");
		}

		if (caWorker.getLname() == null || caWorker.getLname().trim().length() == 0) {
			errors.rejectValue("lname", "required.lname", null, "please enter last name");
		}

		if (caWorker.getIdgroup().getIdgroup() == null || caWorker.getIdgroup().getIdgroup().intValue() < 1) {
			errors.rejectValue("idgroup.idgroup", "required.worker.idgroup", null, "please select workers group");
		}

		if (caWorker.getEmail() == null) {
			errors.rejectValue("email", "required.email", null, "please enter email");
		} else {
			Matcher m = p.matcher(caWorker.getEmail());
			if (!m.find()) {
				errors.rejectValue("email", "required.email", null, "please enter email");
			}
		}

	}

}

