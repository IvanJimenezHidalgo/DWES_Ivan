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
public class Marco extends TagSupport{
    

    
    
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        StringBuilder str = new StringBuilder();
        str.append("<div style='width: 80%;margin-left: 10%;border:1px solid blue;text-align:left;padding:2%;'>");
        try {
            out.write(String.valueOf(str));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Tag.EVAL_BODY_INCLUDE;
    }
    
    public int doEndTag() throws JspException {
        Writer out = pageContext.getOut();
        StringBuilder str = new StringBuilder("</div>");
        try {
            out.write(String.valueOf(str));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Tag.EVAL_PAGE;
    }

}
