package gm.rh.servicio;

import gm.rh.modelo.Empleado;

import java.util.List;

public interface EmpleadoServicio {
    List<Empleado> listarEmpleado();
    Empleado obtenerEmpleadoPorId(Long id);
    Empleado guardarEmpleado(Empleado empleado);
    void eliminarEmpleado(Long id);
}
