package gm.rh.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    //Para que el valor de la llave primaria sea auto incremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;
    private String nombre;
    private String departamento;
    private Double sueldo;

    public Empleado(){

    }

    public Empleado(Long idEmpleado, String nombre, String departamento, Double sueldo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.departamento = departamento;
        this.sueldo = sueldo;
    }

    public Empleado(String nombre, String departamento, Double sueldo) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.sueldo = sueldo;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
