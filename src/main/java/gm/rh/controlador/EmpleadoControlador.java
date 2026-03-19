package gm.rh.controlador;

import gm.rh.modelo.Empleado;
import gm.rh.servicio.EmpleadoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/empleado") //http://localhost:8080/api/empleado
@CrossOrigin(origins = "*")
public class EmpleadoControlador {
    private EmpleadoServicio empleadoServicio;

    public EmpleadoControlador(EmpleadoServicio empleadoServicio) {
        this.empleadoServicio = empleadoServicio;
    }
    //Get /api/empleados -> listar todos
    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleado(){
        return ResponseEntity.ok(empleadoServicio.listarEmpleado());
    }

    // Get por ID
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoporId(@PathVariable Long id){
        Empleado emp = empleadoServicio.obtenerEmpleadoPorId(id);
        if (emp==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(emp);
    }

    //Post Crear
    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado){
        //Ignoramos un id entrante
        empleado.setIdEmpleado(null);
        Empleado creado = empleadoServicio.guardarEmpleado(empleado);
        URI location = URI.create("/api/empleado/" + creado.getIdEmpleado());
        return ResponseEntity.created(location).body(creado);
    }

    // actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado){
        Empleado existente = empleadoServicio.obtenerEmpleadoPorId(id);
        if (existente==null){
            return  ResponseEntity.notFound().build();
        }

        empleado.setIdEmpleado(id);
        Empleado actualizado = empleadoServicio.guardarEmpleado(empleado);
        return ResponseEntity.ok(actualizado);
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id){
        Empleado existente = empleadoServicio.obtenerEmpleadoPorId(id);
        if (existente==null){
            return ResponseEntity.notFound().build();
        }
        empleadoServicio.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }

}
