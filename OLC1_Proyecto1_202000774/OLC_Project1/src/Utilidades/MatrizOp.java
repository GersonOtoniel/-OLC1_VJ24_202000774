/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import Clases.Types;

/**
 *
 * @author Gerson
 */
public class MatrizOp {
    
    public static final Types[][] plus = {
        {Types.INT, Types.DECIMAL, Types.NULL, Types.INT, Types.STRING},
        {Types.DECIMAL, Types.DECIMAL, Types.NULL, Types.DECIMAL, Types.STRING},
        {Types.NULL, Types.NULL, Types.NULL, Types.NULL, Types.STRING},
        {Types.INT, Types.DECIMAL, Types.NULL, Types.STRING, Types.STRING},
        {Types.STRING, Types.STRING, Types.STRING, Types.STRING, Types.STRING}
    };

    
    public static final Types[][] minus = {
        {Types.INT, Types.DECIMAL, Types.INT},
        {Types.DECIMAL, Types.DECIMAL, Types.DECIMAL},
        {Types.INT, Types.DECIMAL, Types.NULL}
    };
    
     public static final Types[][] mult = {
        {Types.INT, Types.DECIMAL, Types.INT},
        {Types.DECIMAL, Types.DECIMAL, Types.DECIMAL},
        {Types.INT, Types.DECIMAL, Types.NULL}
    };
     
    public static final Types[][] div = {
        {Types.DECIMAL, Types.DECIMAL, Types.DECIMAL},
        {Types.DECIMAL, Types.DECIMAL, Types.DECIMAL},
        {Types.DECIMAL, Types.DECIMAL, Types.NULL}
    };
    
    public static final Types[][] pow = {
        {Types.INT, Types.DECIMAL},
        {Types.DECIMAL, Types.DECIMAL}
    };
    
    public static final Types[][] mod = {
        {Types.DECIMAL, Types.DECIMAL},
        {Types.DECIMAL, Types.DECIMAL}
    };





    
    /*public static void main(String[] args){
        int num1 = 4;
        int num2 = 2;
        
        int temp = 1;
        
        while(temp < num2){
            num1 *= num1;
            temp++;
        }
        
        System.out.println(num1);
    }*/
}
