/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

/**
 *
 * @author Ivan
 */
public class Numero {
    
    private int[] numero;
    private int heridos;
    private int muertos;
    private int ronda;
    private String salida;
    
    public Numero(int cifras){
        numero = generarNumero(cifras);
        ronda = 1;
    }
    
    public int[] generarNumero(int cifras){
        numero = new int[cifras];
        int ale;
        boolean mal;
        for(int i=0;i<numero.length;i++){
            numero[i] = 11;
            do{
                mal = false;
                ale = (int) (Math.random()* 10);
                for(int n:numero){
                    if(ale==n){
                        mal = true;
                    }
                }
            }while(mal);
            numero[i] = ale;
        }
        return numero;
    }
    public boolean comprobarNumero (int[] entrada){
        boolean ok = false;
        muertos = 0;
        heridos = 0;
        salida = "<p>Has introducido ";
        for(int i=0;i<entrada.length;i++){
            salida+=entrada[i];
            for(int j=0;j<entrada.length;j++){
                if(entrada[i]==numero[j] && i==j){
                    muertos++;
                }else if(entrada[i]==numero[j] && i!=j){
                    heridos++;
                }
            }
        }
        if(muertos==entrada.length){
            salida+="</p><p>Enhorabuena has acertado el número";
            ok = true;
        }else{
            ronda = ronda+1;
            salida+="</p><p>Has conseguido "+heridos+" heridos y "+
                muertos+" muertos</p>";
        }
        return ok;
    }
    
    public String getNumero(){
        String num = "";
        for(int n:numero){
            num+=n;
        }
        return num;
    }
    public int getRonda(){
        return ronda;
    }
    public String getEntrada(){
        String entrada = "";
        for(int i=0;i<numero.length;i++){
            entrada+="<input type='number' name='"+i+"' value='0' min='0' max='9' class='num'/>&nbsp;&nbsp;";
        }
        return entrada;
    }
    public String getSalida(){
        return salida;
    }
    
}
