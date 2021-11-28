package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EmpleadoController {

	@GetMapping("/getEmpleados")
	public ArrayList<Empleado> getAllEmpleados() {
		ArrayList<Empleado> empleados = EmpleadoServiceStub.getAllEmpleados();
		if(empleados.isEmpty()){
			// throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"No existen empleados");
			throw new EmpleadosNotFound("No existen empleados");
		}
		return empleados;
	}

	@GetMapping("/getEmpleado/{id}")
	public Empleado getEmpleado(@PathVariable Long id) {
		Empleado empleado = EmpleadoServiceStub.getEmpleado(id);
		if(empleado == null){
			// throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"No existen ese empleado");
			throw new EmpleadosNotFound(String.format("No existe el empleado con id %s", id));
		}
		return empleado;
	}

	@PostMapping("/postEmpleado")
	public Empleado addEmpleado(@RequestBody Empleado empleado) {
		return EmpleadoServiceStub.addEmpleado(empleado);
	}

	@PutMapping("/putEmpleado/{id}")
	public Empleado updateEmpleado(@PathVariable long id, @RequestBody Empleado empleadoModificado) {
		Empleado empleado = EmpleadoServiceStub.getEmpleado(id);
		if(empleado == null){
			// throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"El empleado a modificar no existe");
			throw new EmpleadosNotFound(String.format("El empleado con id %s que desea modificar no existe", id));
		}
		return EmpleadoServiceStub.updateEmpleado(id, empleadoModificado);
	}

	@DeleteMapping("/deleteEmpleado/{id}")
	public Empleado deleteEmpleado(@PathVariable long id) {
		Empleado empleado = EmpleadoServiceStub.getEmpleado(id);
		if(empleado == null){
			// throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"El empleado a eliminar no existe");
			throw new EmpleadosNotFound(String.format("El empleado con id %s que desea eliminar no existe", id));
		}
		return EmpleadoServiceStub.deleteEmpleado(id);
	}
}
