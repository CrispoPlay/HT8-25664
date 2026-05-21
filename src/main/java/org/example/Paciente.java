/**
 * Clase Paciente
 * Modela al paciente con sus atributos y métodos
 */
package org.example;

public class Paciente implements Comparable<Paciente> {

    private String nombre;
    private String sintoma;
    private char prioridad;

    /**
     * Constructor con Parámetros
     * @param nombre
     * @param sintoma
     * @param prioridad
     */
    public Paciente(String nombre, String sintoma, char prioridad) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.prioridad = prioridad;
    }

    /**
     * Setters y Getters
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public char getPrioridad() {
        return prioridad;
    }

    /**
     * Override de herencia de comparable
     * @param otro the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.prioridad, otro.prioridad);
    }

    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + prioridad;
    }
}
