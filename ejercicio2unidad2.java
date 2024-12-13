/*La empresa municipal de agua potable de Loja desea cobrar y calcular mensualmente 
elEl costo de las llamadas telefónicas internacionales depende de la zona geográfica
en la que se encuentre el país destino y del número de minutos hablados. En la siguiente
tabla se presenta el costo del minuto por hora. Cada zona se le ha asociado con una clave
(Use tipos de datos ENUMERADOS PARA LA ZONA).

ZONA  /  CODIGO  /  PRECIO MINUTO (USD)
AMÉRICA DEL NORTE/12/2.75
AMÉRICA CENTRAL/15/1.89
AMÉRICA DEL SUR/18/1.60
EUROPA/19/3.5
ASIA/23/4.5
ÁFRICA/25/3.1
OCEANÍA/29/3
RESTO DEL MUNDO/31/6*/
package com.mycompany.practicasprogramacionaplicada.controller;

import java.util.Scanner;

public class ejercicio2unidad2 {

    public enum Zona {
        AMERICA_DEL_NORTE(12, 2.75),
        AMERICA_CENTRAL(15, 1.89),
        AMERICA_DEL_SUR(18, 1.60),
        EUROPA(19, 3.5),
        ASIA(23, 4.5),
        AFRICA(25, 3.1),
        OCEANIA(29, 3),
        RESTO_DEL_MUNDO(31, 6);

        private final int codigo;
        private final double tarifaPorMinutoUSD;

        Zona(int codigo, double tarifaPorMinutoUSD) {
            this.codigo = codigo;
            this.tarifaPorMinutoUSD = tarifaPorMinutoUSD;
        }

        public int getCodigo() {
            return codigo;
        }

        public double getTarifaPorMinutoUSD() {
            return tarifaPorMinutoUSD;
        }

        public static Zona buscarPorCodigo(int codigo) {
            for (Zona zona : Zona.values()) {
                if (zona.getCodigo() == codigo) {
                    return zona;
                }
            }
            return null;
        }
    }

    private void imprimirZonas() {
        System.out.println("-- LISTA PARA LLAMADAS TELEFÓNICAS EXTRANJERAS --");
        for (Zona zona : Zona.values()) {
            System.out.printf("%s: Código %d, Tarifa por minuto $%.2f%n", zona, zona.getCodigo(), zona.getTarifaPorMinutoUSD());
        }
    }

    private int obtenerEntrada(String mensaje, Scanner scanner) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            scanner.next();
            System.out.print(mensaje);
        }
        return scanner.nextInt();
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        imprimirZonas();

        int codigoZona = obtenerEntrada("Ingrese el código de la zona: ", scanner);
        int minutosHablados = obtenerEntrada("Ingrese el tiempo hablado en minutos: ", scanner);

        Zona zona = Zona.buscarPorCodigo(codigoZona);
        if (zona != null) {
            double tarifaFinal = minutosHablados * zona.getTarifaPorMinutoUSD();
            System.out.printf("Su tarifa final es: $%.2f%n", tarifaFinal);
        } else {
            System.out.println("El código ingresado no corresponde a ninguna zona.");
        }
    }

    public static void main(String[] args) {
        new ejercicio2unidad2().ejecutar();
    }
}

