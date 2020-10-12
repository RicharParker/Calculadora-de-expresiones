
package com.mycompany.calculadora.de.expresiones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try (
                Scanner sc = new Scanner(System.in)) {

            BufferedReader br = new BufferedReader(new FileReader("a.txt"));

            String linea = br.readLine();
            lCola queue = new lCola();
            for (int i = 0; i < linea.length(); i++) {
                char ingresar = linea.charAt(i);
                queue.add(ingresar);
            }
            lCola resultado = solver(queue);
            resultado.recorre();

            br.close();
        }

    }

    public static int orden(char signo) {

        char sign = signo;
        switch (sign) {
            case '+', '-' -> {
                return 2;
            }
            case '*', '/' -> {
                return 3;
            }
            case '^' -> {
                return 4;
            }
            case '(' -> {
                return 1;
            }
default ->  {
            }
        }
        return 0;
    }

    public static int operacion(int numero1, int numero2, char signo) {
        if (signo == '+') {
            return numero1 + numero2;
        }
        if (signo == '-') {
            return numero1 - numero2;
        }
        if (signo == '*') {
            return numero1 * numero2;
        }
        if (signo == '/') {
            return numero1 / numero2;
        }
        if (signo == '^') {
            return (int) Math.pow(numero1, numero2);
        }
        return 0;
    }

    public static lCola solver(lCola x) {
        lCola aux = x;
        Lapilar pila = new Lapilar();
        lCola salida = new lCola();
        while (aux.fin != null) {
            char signo = aux.fin.dato;
            boolean existe = verifica(signo);
            if (existe == true) {
                int ordenado = orden(signo);
                if (pila.isEmpty() == true) {
                    pila.push(signo);
                } else {
                    if (ordenado == 0) {
                        char ultimo = pila.pop();
                        int pro = orden(ultimo);
                        while (pro != 1) {
                            salida.add(ultimo);
                            if (pila.isEmpty() != true) {
                                ultimo = pila.pop();
                                pro = orden(ultimo);
                            } else {
                                pro = 1;
                            }
                        }

                    } if (ordenado == 1) {
                        pila.push(signo);
                    } else {
                        char tienepila = pila.pick();
                        int cotr = orden(tienepila);
                        boolean comparar = Mayor(ordenado, cotr);
                        if (comparar == true || cotr == 1) {
                            pila.push(signo);
                        } else {

                            char trans = pila.pop();
                            if (trans == '(' || trans == ')') {

                            } else {
                                salida.add(trans);
                            }

                            pila.push(signo);
                        }
                    }
                }
            } else {
                salida.add(signo);
            }
            aux.fin = aux.fin.anterior;
        }
        if (pila.isEmpty() != true) {
            while (pila.isEmpty() != true) {
                char ultimo = pila.pop();
                if (ultimo == '(' || ultimo == ')') {

                } else {

                    salida.add(ultimo);
                }
            }
        }
        return salida;

    }

    public static boolean Mayor(int x, int y) {
        return x > y;
    }

    public static boolean verifica(char x) {
        char caracter = x;
        return caracter == '(' || caracter == ')' || caracter == '*' || caracter == '+' || caracter == '-' || caracter == '/' || caracter == '^';
    }
}
