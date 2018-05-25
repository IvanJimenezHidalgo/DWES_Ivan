/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tags;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Ivan
 */
public class Link extends TagSupport implements DynamicAttributes {
    
    private String enlace;
    
    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        enlace = String.valueOf(value);
    }
    
    
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        StringBuilder str = new StringBuilder();
        str.append("<a href='").append(enlace).append("' style='color: black;text-decoration: none;font-weight: bold;'>");
        try {
            out.write(String.valueOf(str));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Tag.EVAL_BODY_INCLUDE;
    }
    
    public int doEndTag() throws JspException {
        Writer out = pageContext.getOut();
        StringBuilder str = new StringBuilder("</a>");
        try {
            out.write(String.valueOf(str));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Tag.EVAL_PAGE;
    }

}
