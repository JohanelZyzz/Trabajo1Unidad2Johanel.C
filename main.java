package com.mycompany.practicasprogramacionaplicada.views;

import com.mycompany.practicasprogramacionaplicada.controller.ejercicio1unidad2;
import com.mycompany.practicasprogramacionaplicada.controller.ejercicio2unidad2;
import com.mycompany.practicasprogramacionaplicada.controller.ejercicio3unidad2;
import com.mycompany.practicasprogramacionaplicada.controller.ejercicio4unidad2;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner valor = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("-- MENÚ PRINCIPAL --");
            System.out.println("Seleccione el número perteneciente a cada opción:");
            System.out.println("1. Ejercicio 1 Unidad 2");
            System.out.println("2. Ejercicio 2 Unidad 2");
            System.out.println("3. Ejercicio 3 Unidad 2");
            System.out.println("4. Ejercicio 4 Unidad 2");
            System.out.println("5. Salir");
            opcion = valor.nextInt();
            
            switch (opcion) {
                case 1:
                    ejercicio1unidad2 ejercicio1 = new ejercicio1unidad2();
                    ejercicio1.ejecutar();
                    break;
                case 2:
                    ejercicio2unidad2 ejercicio2 = new ejercicio2unidad2();
                    ejercicio2.ejecutar();
                    break;
                case 3:
                    ejercicio3unidad2 ejercicio3 = new ejercicio3unidad2();
                    ejercicio3.ejecutar();
                    break;
                case 4:
                    ejercicio4unidad2 ejercicio4 = new ejercicio4unidad2();
                    ejercicio4.ejecutar();
                    break;
                case 5:
                    System.out.println("El programa ha finalizado.");
                    break;
                default:
                    System.out.println("Por favor, ingrese un número válido.");
                    break;
            }
        } while (opcion != 5);
    }
}
