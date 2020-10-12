
package com.mycompany.calculadora.de.expresiones;

public class Lapilar {

    apilar inicio = null;

    public void push(char dato) {
        apilar nuevo = new apilar();
        nuevo.dato = dato;
        if (inicio == null) {
            nuevo.siguiente = inicio;
        }
        inicio = nuevo;
    }

    public char pop() {
        char resultado = inicio.dato;
        apilar aux = inicio;
        inicio = inicio.siguiente;
        aux.siguiente = null;
        return resultado;
    }

    public char pick() {
        return inicio.dato;
    }

    public boolean isEmpty() {
        return inicio == null;
    }    
}