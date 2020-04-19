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

import mx.org.cadmin.persist.CaWorks;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Documentation for  class <code>CaReportValidator</code> .
 *
 * @author     <a href="http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class CaReportValidator implements Validator {

	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());


	/**
	 *  Description of the Method
	 *
	 * @param  clazz  Description of the Parameter
	 * @return        Description of the Return Value
	 */
	public boolean supports(Class clazz) {

		return clazz.equals(CaWorks.class);

	}


	/**
	 * Describe <code>validate</code> method here.
	 *
	 * @param  command  an <code>Object</code> value
	 * @param  errors   an <code>Errors</code> value
	 */
	public void validate(Object command, Errors errors) {

		CaWorks caWorks = (CaWorks) command;
		logger.debug("-----> Works_workers is : " + caWorks.getWorks_workers());
		if (caWorks.getIduser().getIduser() != null && caWorks.getIduser().getIduser().intValue() < 1) {
			errors.rejectValue("iduser.iduser", "required.manager", null, "manager field required");
		} else if (caWorks.getIdcontact().getIdcontact() != null && caWorks.getIdcontact().getIdcontact().intValue() < 1) {
			errors.rejectValue("idcontact.idcontact", "required.contact", null, "contact field required");
		}

		if (caWorks.getInit() == null) {
			errors.rejectValue("init", "required.date", null, "date field required");
		}

		if (caWorks.getEnd() == null) {
			errors.rejectValue("end", "required.date", null, "date field required");
		}
	}

}

