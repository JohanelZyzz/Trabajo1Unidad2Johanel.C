/*La empresa municipal de agua potable de Loja desea cobrar y calcular mensualmente 
el valor exacto de consumo del agua potable de cada medidor que pertenece a un contribuyente,
de acuerdo a la ordenanza vigente, la cual establece la planilla de acuerdo a los siguientes rubros:
A) SERVICIO DE AGUA POTABLE: Para obtener el rubro ríjase en la siguiente tabla:

Consumo en m³/valor a cobrar
0 hasta 15 /$ 3.00
15 hasta 25 /$ 0.10 por cada m³ adicional a partir de la base y rango anterior.
25 hasta 40 /$ 0.20 por cada m³ adicional a partir de la base y rango anterior.
40 hasta 60 /$ 0.30 por cada m³ adicional a partir de la base y rango anterior.
60 en adelante /$ 0.35 por cada m³ adicional a partir de la base y rango anterior.

B) IMPUESTO DE ALCANTARILLADO:35% DEL VALOR DEL RUBRO DEL SERVICIO DE AGUA POTABLE.
C) TASA POR RECOLECCIÓN DE BASURA: 0.75 DÓLARES;
D) TASA POR COSTO DE PROCESAMIENTO DE DATOS: 0.50 DÓLARES
La ordenanza también permite descuentos para los medidores que estén registrados al 
contribuyente de la tercera edad o posean algún tipo discapacidad, para lo cual sólo se
los puede aplicar sobre el rubro del SERVICIO DE AGUA POTABLE, en base a las siguientes condiciones.
(a) Si pertenece a la tercera edad y su consumo está entre 0 hasta 15 m³ (rango base) existe
un descuento del 50%, en caso de exceder sólo se realizará el descuento del 30% sobre el rango base.
(b) Si pertenece a un discapacitado, se tomará como descuento su porcentaje de discapacidad s
ólo sobre el rango base.*/
package com.mycompany.practicasprogramacionaplicada.controller;

import java.util.Scanner;

public class ejercicio3unidad2 {

    public static double calcularValorAgua(double consumo) {
        double valor = 0;
        if (consumo <= 15) {
            valor = 3.00;
        } else if (consumo <= 25) {
            valor = 3.00 + (consumo - 15) * 0.10;
        } else if (consumo <= 40) {
            valor = 3.00 + 10 * 0.10 + (consumo - 25) * 0.20;
        } else if (consumo <= 60) {
            valor = 3.00 + 10 * 0.10 + 15 * 0.20 + (consumo - 40) * 0.30;
        } else {
            valor = 3.00 + 10 * 0.10 + 15 * 0.20 + 20 * 0.30 + (consumo - 60) * 0.35;
        }
        return valor;
    }

    public static double calcularDescuentoTerceraEdad(double valorAguaPotable, double consumo, boolean terceraEdad) {
        if (terceraEdad) {
            if (consumo <= 15) {
                return valorAguaPotable * 0.50;
            } else {
                return 3.00 * 0.30;
            }
        }
        return 0;
    }

    public static double calcularDescuentoDiscapacidad(double valorAguaPotable, boolean discapacidad, double porcentajeDiscapacidad) {
        if (discapacidad) {
            return valorAguaPotable * (porcentajeDiscapacidad / 100);
        }
        return 0;
    }

    public void ejecutar() {
        Scanner valor = new Scanner(System.in);

        System.out.println("Ingrese el consumo en m³:");
        double consumo = valor.nextDouble();
        
        System.out.println("¿Es contribuyente de tercera edad? (si/no):");
        boolean terceraEdad = valor.next().equalsIgnoreCase("si");
        
        System.out.println("¿Tiene discapacidad? (si/no):");
        boolean discapacidad = valor.next().equalsIgnoreCase("si");
        
        double porcentajeDiscapacidad = 0;
        if (discapacidad) {
            System.out.println("Ingrese el porcentaje de discapacidad:");
            porcentajeDiscapacidad = valor.nextDouble();
        }

        double valorAguaPotable = calcularValorAgua(consumo);
        double descuentoTerceraEdad = calcularDescuentoTerceraEdad(valorAguaPotable, consumo, terceraEdad);
        double descuentoDiscapacidad = calcularDescuentoDiscapacidad(valorAguaPotable, discapacidad, porcentajeDiscapacidad);
        double descuentoTotal = descuentoTerceraEdad + descuentoDiscapacidad;
        double impuestoAlcantarillado = valorAguaPotable * 0.35;
        double tasaRecoleccionBasura = 0.75;
        double tasaProcesamientoDatos = 0.50;
        
        double total = valorAguaPotable - descuentoTotal + impuestoAlcantarillado + tasaRecoleccionBasura + tasaProcesamientoDatos;

        System.out.printf("Valor del servicio de agua potable: $%.2f\n", valorAguaPotable);
        System.out.printf("Descuento por tercera edad: $%.2f\n", descuentoTerceraEdad);
        System.out.printf("Descuento por discapacidad: $%.2f\n", descuentoDiscapacidad);
        System.out.printf("Descuento total aplicado: $%.2f\n", descuentoTotal);
        System.out.printf("Impuesto de alcantarillado: $%.2f\n", impuestoAlcantarillado);
        System.out.printf("Tasa por recolección de basura: $%.2f\n", tasaRecoleccionBasura);
        System.out.printf("Tasa por costo de procesamiento de datos: $%.2f\n", tasaProcesamientoDatos);
        System.out.printf("Total a pagar: $%.2f\n", total);
    }
}
