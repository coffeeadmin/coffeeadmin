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
package mx.org.cadmin.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import mx.org.cadmin.persist.CaContacts;
import mx.org.cadmin.persist.CaFiles;
import mx.org.cadmin.persist.CaUsers;
import mx.org.cadmin.persist.CaWorker;
import mx.org.cadmin.persist.CaWorks;
import mx.org.cadmin.persist.ContactsDao;
import mx.org.cadmin.persist.UsersDao;
import mx.org.cadmin.persist.WorkerDao;
import mx.org.cadmin.persist.WorksDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

/**
 * Documentation for  class <code>AddWorkForm</code> .
 *
 * @author     <a href="http://http://www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @since 0.5
 * @version    0.6
 */
public class AddWorkForm extends MainWizForm {

	/**
	 * Describe variable <code>logger</code> here.
	 */
	protected final Log logger = LogFactory.getLog(getClass());
	private int EDIT_DATA = 0;
	private int UPLOAD = 1;
	private int MAIL = 2;
	List files = new ArrayList();
	private JavaMailSenderImpl sender;
	Map map = new HashMap();
	List list = new ArrayList();


	/**
	 * Creates a new <code>AddWorkForm</code> instance.
	 */
	public AddWorkForm() {
		setSessionForm(true);
		setBindOnNewForm(true);
	}



	/**
	 * Describe <code>referenceData</code> method here.
	 *
	 * @param  request  a <code>HttpServletRequest</code> value
	 * @param  command  an <code>Object</code> value
	 * @param  errors   an <code>Errors</code> value
	 * @param  page     an <code>int</code> value
	 * @return          a <code>Map</code> value
	 */
	protected Map referenceData(HttpServletRequest request,
			Object command,
			Errors errors,
			int page) {


		if (page == EDIT_DATA) {
			WorksDao wdao = (WorksDao) ctx.getBean("worksDao");
			UsersDao udao = (UsersDao) ctx.getBean("usersDao");
			ContactsDao cdao = (ContactsDao) ctx.getBean("contactsDao");
			WorkerDao wwdao = (WorkerDao) ctx.getBean("workerDao");
			SimpleDateFormat dformat;
			Date time = new Date();
			dformat = new SimpleDateFormat("yyyy-MM-dd");
			String idate = dformat.format(time);
			logger.debug("--->  referenceData EDIT_DATA");
			
			map.put("users", udao.getUsers());
			map.put("contacts", cdao.getContacts());
			map.put("worker", wwdao.getWorkers());
			map.put("idate", idate);
		} else if (page == UPLOAD) {
			CaWorks caWorks = (CaWorks) command;
			logger.debug("--->  referenceData UPLOAD");
			if (caWorks.getWork_files() != null) {

				files = caWorks.getWork_files();
			} else {
				files.clear();
			}

			map.put("files", files);
		} else if (page == MAIL) {
			logger.debug("--->  referenceData MAIL");

		}
		logger.debug("---> page number is : " + page);
		return map;
	}


	/**
	 * Describe <code>postProcessPage</code> method here.
	 *
	 * @param  request                 a <code>HttpServletRequest</code> value
	 * @param  command                 an <code>Object</code> value
	 * @param  errors                  an <code>Errors</code> value
	 * @param  page                    an <code>int</code> value
	 * @exception  MessagingException  if an error occurs
	 */
	protected void postProcessPage(
			HttpServletRequest request,
			Object command,
			Errors errors,
			int page) throws MessagingException {
		String filepath = new String();
		String filename = new String();
		int fileindex;
		CaFiles caFiles = new CaFiles();
		CaWorks caWorks = (CaWorks) command;
		File file = null;
		if (page == UPLOAD && request instanceof MultipartHttpServletRequest) {

			byte[] data;

			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile mf = multipartRequest.getFile("file");
			filename = mf.getOriginalFilename();
			if (filename != null && filename.length() > 0) {
				filename = randomizer() + filename;
				try {
					data = mf.getBytes();
					logger.debug("----> full path to files : " + request.getSession().getServletContext().getRealPath("/files/"));
					file = new File(request.getSession().getServletContext().getRealPath("/files/"), filename);
					FileOutputStream fos = new FileOutputStream(file);
					fos.write(data);
					fos.flush();
					fos.close();
				} catch (IOException e) {

					e.printStackTrace();
				}


				caFiles.setName(filename);
				files.add(caFiles);
				caWorks.setWork_files(files);
				WebUtils.setSessionAttribute(request, getFormSessionAttributeName(), caWorks);
			}
		} else if (page == UPLOAD && request.getParameter("fileindex") != null) {
			fileindex = (Integer.parseInt(request.getParameter("fileindex")));

			caFiles = (CaFiles) files.get(fileindex);
			filename = caFiles.getName();
			file = new File(request.getSession().getServletContext().getRealPath("/files/"), filename);
			if (file.exists() && file.canRead()) {
				file.delete();
				files.remove(fileindex);
			}

			logger.debug("----> erasing file : " + filename);
			caWorks.setWork_files(files);
			WorksDao wdao = (WorksDao) ctx.getBean("worksDao");
			wdao.updateWorks(caWorks);
			WebUtils.setSessionAttribute(request, getFormSessionAttributeName(), caWorks);
		} else if (page == MAIL) {
			String[] recipients = null;

			if (request.getParameterValues("mailbx") != null) {

				MimeMessage message = sender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
				list.clear();
				recipients = request.getParameterValues("mailbx");
				for (int i = 0; i < recipients.length; i++) {
					if (recipients[i].equals("usermail")) {
						list.add(caWorks.getIduser().getEmail());
					} else if (recipients[i].equals("contactmail")) {
						list.add(caWorks.getIdcontact().getEmail());
					} else if (recipients[i].equals("workermail")) {
						files = caWorks.getWorks_workers();

						for (Iterator iter = files.iterator();
								iter.hasNext();
								) {
							CaWorker caworker = (CaWorker) iter.next();
							list.add(caworker.getEmail());

						}
					} else if (recipients[i].equals("filesmail") && caWorks.getWork_files() != null) {
						files = caWorks.getWork_files();
						for (Iterator iter = files.iterator();
								iter.hasNext();
								) {
							caFiles = (CaFiles) iter.next();
							filename = caFiles.getName();
							if (filename != null && filename.length() > 0) {
								try {

									helper.addAttachment(filename, new File(request.getSession().getServletContext().getRealPath("/files/"), filename));
								} catch (MessagingException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}

					}
				}
				recipients = null;
				recipients = (String[]) list.toArray(new String[list.size()]);

				try {
					helper.setTo(recipients);
					if (request.getParameter("body") != null && request.getParameter("body").trim().length() > 0) {
						helper.setText(request.getParameter("body"));
					}
					if (request.getParameter("subject") != null && request.getParameter("subject").trim().length() > 0) {
						helper.setSubject(request.getParameter("subject"));
					}
					helper.setFrom(getMessageSourceAccessor().getMessage("work.mail.from"));


				} catch (MessagingException e) {

					e.printStackTrace();
				}
				logger.debug("----> sending mail : ");
				
				threadMail(sender, message);
			}

		}
	}


	/**
	 * Describe <code>formBackingObject</code> method here.
	 *
	 * @param  request               a <code>HttpServletRequest</code> value
	 * @return                       an <code>Object</code> value
	 * @exception  ServletException  if an error occurs
	 */
	protected Object formBackingObject(HttpServletRequest request)
			 throws ServletException {
		CaWorks caWorks = new CaWorks();
		CaContacts caContacts = new CaContacts();
		CaUsers caUsers = new CaUsers();
		this.init(request);
		if (request.getParameter("idwork") != null && request.getParameter("idwork").length() > 0) {
			WorksDao wdao = (WorksDao) ctx.getBean("worksDao");
			caWorks.setIdwork(new Integer(request.getParameter("idwork")));
			list = wdao.getWorksbyId(caWorks);
			caWorks = (CaWorks) list.get(0);
		} else {
			caWorks.setIdcontact(caContacts);
			caWorks.setIduser(caUsers);
			caWorks.getIdcontact().setIdcontact(new Integer(0));
			caWorks.getIduser().setIduser(new Integer(0));
		}

		return caWorks;
	}



	/**
	 * Describe <code>validatePage</code> method here.
	 *
	 * @param  command  an <code>Object</code> value
	 * @param  errors   an <code>Errors</code> value
	 * @param  page     an <code>int</code> value
	 * @param  finish   a <code>boolean</code> value
	 */
	protected void validatePage(Object command, Errors errors, int page, boolean finish) {
		logger.debug("----- validating page : " + page + " from finish? " + finish);

		if (finish) {
			logger.debug("---- validating finish submit");
			CaWorks caWorks = (CaWorks) command;
			ValidationUtils.rejectIfEmpty(errors, "content", "required.content", "content must be filled");
			ValidationUtils.rejectIfEmpty(errors, "status", "required.status", "status must be filled");

			if (caWorks.getIduser().getIduser() == null || caWorks.getIduser().getIduser().intValue() < 1) {
				logger.debug("----- iduser on cawork : " + caWorks.getIduser().getIduser());
				errors.rejectValue("iduser.iduser", "required.manager", null, "manager field required");
			}
			if (caWorks.getIdcontact().getIdcontact() == null) {
				errors.rejectValue("idcontact.idcontact", "required.contact", null, " contact field required");

			}
			if (caWorks.getInit() == null) {
				errors.rejectValue("init", "required.date", null, "date field required");
			}
		}
	}



	/**
	 *  Description of the Method
	 *
	 * @return    Description of the Return Value
	 */
	private String randomizer() {
		int random = (int) Math.round(Math.random() * 1000);
		return String.valueOf(random);
	}


	/**
	 *  Description of the Method
	 *
	 * @param  sender   Description of the Parameter
	 * @param  message  Description of the Parameter
	 */
	private void threadMail(final JavaMailSenderImpl sender, final MimeMessage message) {
		new Thread(
			new Runnable() {
				public void run() {
					logger.debug("--- > starting mail client on other thread");

					sender.send(message);
				}
			}).start();
	}


	private WorksDao worksDao;


	/**
	 * Describe <code>setworksDao</code> method here.
	 *
	 * @param  worksDao  a <code>WorksDao</code> value
	 */
	public void setworksDao(WorksDao worksDao) {
		this.worksDao = worksDao;
	}


	/**
	 * Describe <code>getWorksDao</code> method here.
	 *
	 * @return    a <code>WorksDao</code> value
	 */
	public WorksDao getWorksDao() {
		return worksDao;
	}


	/**
	 * Describe <code>getSender</code> method here.
	 *
	 * @return    a <code>JavaMailSenderImpl</code> value
	 */
	public JavaMailSenderImpl getSender() {
		return sender;
	}


	/**
	 * Describe <code>setSender</code> method here.
	 *
	 * @param  impl  a <code>JavaMailSenderImpl</code> value
	 */
	public void setSender(JavaMailSenderImpl impl) {
		sender = impl;
	}

}

