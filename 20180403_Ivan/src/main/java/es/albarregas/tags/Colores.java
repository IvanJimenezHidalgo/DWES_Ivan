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
public class Colores extends TagSupport implements DynamicAttributes {
    
    private String texto;
    
    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        texto = String.valueOf(value);
    }
    
    
    public int doStartTag() throws JspException {
        String[] colores = {"red","pink","orange","yellow","violet","green","blue","brown","black","grey"};
        Writer out = pageContext.getOut();
        StringBuilder str = new StringBuilder();
        int[] ind = random(texto);
        for(int i=0;i<texto.length();i++){
            str.append("<font size='5px' color='").append(colores[ind[i]]).append("'>").append(texto.charAt(i)).append("</font>");
        }
        
        try {
            out.write(String.valueOf(str));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Tag.SKIP_BODY;
    }
    
    private int[] random(String texto){
        boolean ok;
        int rnd = 0;
        int[] ind = new int[texto.length()];
        for(int i=0;i<ind.length;i++){
            ind[i]=11;
            do{
               ok = true;
               rnd = (int)(Math.random()*10);
               for(int j=0;j<ind.length;j++){
                   if(rnd==ind[j]){
                       ok = false;
                   }
               }
            }while(!ok);  
            ind[i] = rnd;
        }
        return ind;
    }

}
