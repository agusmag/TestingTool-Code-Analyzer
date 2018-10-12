/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metricas;

import java.util.HashSet;

/**
 *
 * @author LoMaximo
 */
public class HalsteadMetrica {
    private int cantOperandosUnicos;
    private int cantOperandosTotales;
    private int cantOperadoresUnicos;
    private int cantOperadoresTotales;
    private int longitud;
    private double volumen;
    /**
     * Un Set para que guarde solo operadores sin repetir
     */
    HashSet<String> operadoresConjunto = new HashSet<>();
    /**
     * Un Set para que guarde solo operandos sin repetir
     */
    HashSet<String> operandosConjunto = new HashSet<>();
    /**
     * Posibles operadores en java
     */
    String operadores[] = {"if", "else", "case", "default", "for", "while", "catch", "throw", 
            "+", "-", "*", "/", "==", "!=", "=", "<=", ">=", "<", ">", 
            "&&", "||"};
    
    public HalsteadMetrica(String metodo){
        
        String lineasMetodo[] = metodo.split("\n");
        
        for (String linea : lineasMetodo) {  
             
            //Buscando los operadores en la linea 
            for(int i = 0; i < this.operadores.length - 1; i++) {
                if(linea.contains(this.operadores[i])) { 
                    this.cantOperadoresTotales++;
                    this.operadoresConjunto.add(this.operadores[i]); 
                }
            } 
                
            //Buscando los operandos de la linea
            String operandos[] = linea.split("^.*(if|else|case|default|for|while|"
                    + "catch|throw|\\+|-|\\*|\\/" 
                    + "|={1}?|!=|={2}?|<=|>=|<{1}?|>{1}?|&&|\\|{2}?).*"); 
            for (String operando : operandos) {
                this.cantOperandosTotales++;
                this.operandosConjunto.add(operando); 
            }
        }
        
        this.cantOperadoresUnicos = operadoresConjunto.size();
        this.cantOperandosUnicos = operandosConjunto.size();
        
        this.longitud = cantOperadoresTotales + cantOperandosTotales;
        this.volumen = longitud * (Math.log(this.cantOperadoresUnicos+this.cantOperandosUnicos)/Math.log(2));
    }
    
    public int getLongitud(){
        return this.longitud;
    }
    
    public double getVolumen(){
        return this.volumen;
    }
    
    public int getOperadoresTotales(){
        return this.cantOperadoresTotales;
    }
    
    public int getOperadoresUnicos(){
        return this.cantOperadoresUnicos;
    }
    
    public int getOperandosTotales(){
        return this.cantOperandosTotales;
    }
    
    public int getOperandosUnicos(){
        return this.cantOperandosUnicos;
    }
}
