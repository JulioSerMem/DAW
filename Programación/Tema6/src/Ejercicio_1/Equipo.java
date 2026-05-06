package Ejercicio_1;
import java.util.HashSet;
import java.util.Set;

public class Equipo {
    private String nombreEquipo;
    private Set<Alumno> alumnos;

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.alumnos = new HashSet<>();
    }

    public void añadirAlumno(Alumno a) throws Exception {
        if (!alumnos.add(a)) {
            throw new Exception("Error: El alumno con DNI " + a + " ya está en el equipo.");
        }
    }

    public void borrarAlumno(Alumno a) throws Exception {
        if (!alumnos.remove(a)) {
            throw new Exception("Error: El alumno no pertenece a este equipo.");
        }
    }

    public Alumno buscarAlumno(Alumno a) {
        for (Alumno al : alumnos) {
            if (al.equals(a)) return al;
        }
        return null;
    }

    public void mostrarEquipo() {
        System.out.println("--- Equipo: " + nombreEquipo + " ---");
        if (alumnos.isEmpty()) System.out.println("Vacío");
        for (Alumno a : alumnos) System.out.println(a);
    }

    public Equipo union(Equipo otro) {
        Equipo resultado = new Equipo("Unión de " + this.nombreEquipo + " y " + otro.nombreEquipo);
        resultado.alumnos.addAll(this.alumnos);
        resultado.alumnos.addAll(otro.alumnos);
        return resultado;
    }

    public Equipo interseccion(Equipo otro) {
        Equipo resultado = new Equipo("Intersección de " + this.nombreEquipo + " y " + otro.nombreEquipo);
        resultado.alumnos.addAll(this.alumnos);
        resultado.alumnos.retainAll(otro.alumnos); // Mantiene solo los comunes
        return resultado;
    }
}