/*Una compañía de autos usados paga $2,500.00 de sueldo a sus empleados por mes, Además agrega pagos
extras a sus sueldos como: una comisión de $250.00 por cada automóvil vendido cuyo valor de venta 
supere el $10,000.00 y el 5% de utilidad del valor total de ventas.  La compañía necesita emitir un 
informe desglosado por empleado donde indique el número total de autos vendidos, el valor total de 
los autos que vendió, el monto total que se le debería pagar al final del mes, indicando: el sueldo 
mensual, la comisión por cada automóvil y la utilidad por el valor total de la venta. También debe 
permitir ingresar la venta de los automóviles hasta que se desee y luego emitir el respectivo informe.*/

package com.mycompany.practicasprogramacionaplicada.controller;

import java.util.Scanner;

public class ejercicio1unidad2 {

    public static class Informe {
        public int totalVehiculos = 0;
        public double ventasTotales = 0;
        public double salarioFinal = 0;
        public double comisionesPorVehiculo = 0;
        public double comisionesTotales = 0;
    }

    public static double calcularComisionesVehiculo(double precioVehiculo) {
        return precioVehiculo > 10000 ? 250 : 0;
    }

    public static double calcularComisionesPorVentas(double ventasTotales) {
        return ventasTotales * 0.05;
    }

    public void ejecutar() {
        double salarioBase = 2500;
        Informe informe = new Informe();
        Scanner valor = new Scanner(System.in);
        int contador = 1;

        while (true) {
            System.out.printf("Ingrese el precio final del vehículo %d: ", contador);
            if (valor.hasNextDouble()) {
                double precioVehiculo = valor.nextDouble();
                informe.ventasTotales += precioVehiculo;
                informe.comisionesPorVehiculo += calcularComisionesVehiculo(precioVehiculo);
                System.out.println("¿Quiere registrar otro vehículo? (sí/no)");
                if (!valor.next().equalsIgnoreCase("si")) {
                    break;
                }
                contador++;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                valor.next(); 
            }
        }

        informe.totalVehiculos = contador;
        informe.comisionesTotales = calcularComisionesPorVentas(informe.ventasTotales);
        informe.salarioFinal = salarioBase + informe.comisionesPorVehiculo + informe.comisionesTotales;

        System.out.printf("Total de vehículos vendidos: %d%n", informe.totalVehiculos);
        System.out.printf("Ventas totales: %.2f%n", informe.ventasTotales);
        System.out.printf("Salario inicial: %.2f%n", salarioBase);
        System.out.printf("Total de comisiones por cada vehículo vendido: %.2f%n", informe.comisionesPorVehiculo);
        System.out.printf("Total de utilidad del valor total de ventas: %.2f%n", informe.comisionesTotales);
        System.out.printf("Salario total del empleado: %.2f%n", informe.salarioFinal);
    }

    public static void main(String[] args) {
        new ejercicio1unidad2().ejecutar();
    }
}
