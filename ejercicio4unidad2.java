/*Reconozca, genere mediante teclado, y resuelva la siguiente serie
(1 / 1)^2 + (1 / 3)^4 - (2 / 5)^6 - (3 / 7)^8 + (5 / 9)^10 + (8 / 11)^12.....*/

package com.mycompany.practicasprogramacionaplicada.controller;

import java.util.Scanner;

public class ejercicio4unidad2 {

    public static double calcularSerie(int numTerminos, StringBuilder serie) {
        double resultado = 0.0;
        int fib1 = 1, fib2 = 1;
        int impar = 1;
        int exponente = 2;
        int signo = 1;

        for (int i = 1; i <= numTerminos; i++) {
            int fibonacci = fib1;
            fib1 = fib2;
            fib2 = fibonacci + fib1;

            double termino = Math.pow((double) fibonacci / impar, exponente) * signo;

            if (i > 1) {
                serie.append(signo == 1 ? " + " : " - ");
            }
            serie.append("(").append(fibonacci).append("/").append(impar).append(")^").append(exponente);
            
            resultado += termino;

            impar += 2;
            exponente += 2;
            if (i % 4 == 2 || i % 4 == 3) {
                signo = -1;
            } else {
                signo = 1;
            }
        }

        return resultado;
    }

    public void ejecutar() {
        Scanner valor = new Scanner(System.in);
        
        System.out.print("Ingrese el número de términos de la serie que desea calcular: ");
        int numTerminos = valor.nextInt();

        System.out.print("La serie es: ");
        StringBuilder serie = new StringBuilder();

        double resultado = calcularSerie(numTerminos, serie);

        System.out.println(serie.toString());
        System.out.printf("El resultado de la serie con %d términos es: %.2f\n", numTerminos, resultado);
    }
}

