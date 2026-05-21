package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class MainJavaPQ {

    public static void main(String[] args) {

        PriorityQueue<Paciente> cola = new PriorityQueue<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"));

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(",");

                String nombre = partes[0].trim();
                String sintoma = partes[1].trim();
                char prioridad = partes[2].trim().charAt(0);

                Paciente paciente = new Paciente(nombre, sintoma, prioridad);

                cola.add(paciente);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error leyendo archivo.");
        }

        System.out.println("Orden de atención:");

        while (!cola.isEmpty()) {
            System.out.println(cola.poll());
        }
    }
}