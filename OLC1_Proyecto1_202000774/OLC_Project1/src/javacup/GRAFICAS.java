/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacup;

import java.util.ArrayList;
import java.util.LinkedList;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Gerson
 */
public class GRAFICAS {

    private LinkedList<String> label;
    private LinkedList<Double> values;
    private String titulo;
    private LinkedList<String> ejex;
    private LinkedList<Double> ejey;
    private String titulox;
    private String tituloy;
    DefaultPieDataset data = new DefaultPieDataset();

    public GRAFICAS(LinkedList<String> label, LinkedList<Double> values, String titulo) {
        this.label = label;
        this.values = values;
        this.titulo = titulo;
    }

    public GRAFICAS(String titulo, LinkedList<String> ejex, LinkedList<Double> ejey, String titulox, String tituloy) {
        this.titulo = titulo;
        this.ejex = ejex;
        this.ejey = ejey;
        this.titulox = titulox;
        this.tituloy = tituloy;
    }

    public LinkedList<String> getLabel() {
        return label;
    }

    public DefaultPieDataset getData() {
        return data;
    }

    public void setData(DefaultPieDataset data) {
        this.data = data;
    }

    public void setLabel(LinkedList<String> label) {
        this.label = label;
    }

    public LinkedList<Double> getValues() {
        return values;
    }

    public void setValues(LinkedList<Double> values) {
        this.values = values;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LinkedList<String> getEjex() {
        return ejex;
    }

    public void setEjex(LinkedList<String> ejex) {
        this.ejex = ejex;
    }

    public LinkedList<Double> getEjey() {
        return ejey;
    }

    public void setEjey(LinkedList<Double> ejey) {
        this.ejey = ejey;
    }

    public String getTitulox() {
        return titulox;
    }

    public void setTitulox(String titulox) {
        this.titulox = titulox;
    }

    public String getTituloy() {
        return tituloy;
    }

    public void setTituloy(String tituloy) {
        this.tituloy = tituloy;
    }

}
