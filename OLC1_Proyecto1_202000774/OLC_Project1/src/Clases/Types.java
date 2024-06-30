/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Clases;

/**
 *
 * @author Gerson
 */
public enum Types {
    INT,
    DECIMAL,
    BOOL,
    CHAR,
    STRING,
    ARRAY,
    VECTOR,
    NULL,
    STRUCT;
    
}

class ReturnTypes{
    public Object value;
    public Types type;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }
    public ReturnTypes(Object value, Types type){
        this.type = type;
        this.value = value;
    }
}
