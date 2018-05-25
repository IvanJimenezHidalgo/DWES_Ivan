/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tags;

import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Ivan
 */
public class FormatNumber extends TagSupport {

    private String formato;
    private double numero;

    public void setFormato(String fmt) {
        formato = fmt;
    }

    public void setNumero(String num) {
        numero = Double.parseDouble(num);
    }

    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        String num;
        DecimalFormat dec;
        if (formato.equals("entero")) {
            dec = new DecimalFormat("####");
            num = dec.format(numero);
        } else {
            dec = new DecimalFormat("####.##");
            num = dec.format(numero);
        }
        try {
            out.write(num);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Tag.SKIP_BODY;
    }

}
