/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

/**
 *
 * @author Gerson
 */
public class Error {
    public int linea;
    public int columna;
    public String type;
    public String descripcion;
    public Error(int linea, int columna, String type, String descripcion){
        this.linea = linea;
        this.columna = columna;
        this.type = type;
        this.descripcion = descripcion;
        
    }
    
}
