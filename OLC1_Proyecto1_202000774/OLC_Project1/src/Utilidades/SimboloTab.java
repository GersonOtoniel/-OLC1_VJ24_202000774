/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

/**
 *
 * @author Gerson
 */
public class SimboloTab {
    public int linea;
    public int columna;
    public String id;
    public String typeId;
    public String type;
    public String env;
    public String value;
    public String mutabilidad;
    public int n = 0;
    public SimboloTab(int linea, int columna, String id, String typeId, String type, String env, String value , String mutabilidad){
        this.columna = columna;
        this.env = env;
        this.id = id;
        this.linea = linea;
        this.type = type;
        this.typeId = typeId;
        this.value = value;
        this.mutabilidad = mutabilidad;
    }
    
    public String getFile(){
        return "<tr><td>" + this.n + "</td>"
                + "<td>" + this.id + "</td>"
                + "<td>" + this.typeId + "</td>"
                + "<td>" + this.type + "</td>"
                + "<td>" + this.env + "</td>"
                + "<td>" + this.value + "</td>"
                + "<td>" + this.linea + "</td>"
                + "<td>" + this.columna + "</td></tr>";
    }
    
    
}
