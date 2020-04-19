/****************************************************************************
*
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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.ModelAndView;



/**
 * Documentation for  class <code>FileController</code> .
 *
 * @author <a href="www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @version 0.6
 */
public class FileController extends CoffeeController {

  /**
   * Describe <code>fileShow</code> method here.
   *
   * @param request a <code>HttpServletRequest</code> value
   * @param response a <code>HttpServletResponse</code> value
   * @return a <code>ModelAndView</code> value
   * @exception ServletException if an error occurs
   * @exception IOException if an error occurs
   */
  public ModelAndView fileShow(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		File f = null;
		ServletContext sctx = request.getSession().getServletContext();
		String file = request.getParameter("dload");
		f =
			new File(
				request.getSession().getServletContext().getRealPath("/files/"),
				file);
		int l = (int) f.length();
		BufferedInputStream st =
			new BufferedInputStream(new FileInputStream(f));
		String mimetype = sctx.getMimeType(file);
		response.setBufferSize(l);
		response.setContentType(mimetype);
		response.setHeader(
			"Content-Disposition",
			"attachment; filename=\"" + file + "\"");
		response.setHeader("Pragma", "public");
		response.setHeader("Cache-Control", "max-age=0");
		response.setContentLength(l);
		FileCopyUtils.copy(st, response.getOutputStream());
		st.close();
		logger.debug("serving file : " + f.getName());
		response.getOutputStream().flush();
		response.getOutputStream().close();
		return null;
		}

}
