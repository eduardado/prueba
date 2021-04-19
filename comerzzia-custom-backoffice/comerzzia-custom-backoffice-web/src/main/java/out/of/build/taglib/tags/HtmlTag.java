package com.comerzzia.taglib.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;


public class HtmlTag extends BodyTagSupport{

	/**
     * 
     */
    private static final long serialVersionUID = -3866886392808975349L;

	@Override
    public int doStartTag() throws JspException {
		
		try {
			
			// ############### META CONTENT ###############
			JspWriter out = pageContext.getOut();
	        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
	        out.println("<html>");
	        
        }
		catch (Exception e) {
			throw new JspTagException("doStartTag() - HtmlTag throws an exception: "+e.getMessage());
		}
	    return super.doStartTag();
    }

	@Override
    public int doEndTag() throws JspException {
		try {			
			JspWriter out = pageContext.getOut();
	        out.println("</html>");
        }
		catch (Exception e) {
			throw new JspTagException("doStartTag() - HtmlTag throws an exception: "+e.getMessage());
		}
	    return super.doEndTag();
    }

	@Override
    public int doAfterBody() throws JspException {

		try {
			BodyContent body = getBodyContent();
			JspWriter out = body.getEnclosingWriter();
			out.println(body.getString());
			body.clearBody();
			return super.doAfterBody();
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - HtmlTag throws an exception: "+e.getMessage());
		}
    }	
	
}
