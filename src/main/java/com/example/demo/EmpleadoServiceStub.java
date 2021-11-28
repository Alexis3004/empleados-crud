package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;

public class EmpleadoServiceStub {

	private static HashMap<Long, Empleado> empleados = new HashMap<>();
	private static Long index = 3L;

	static {
		empleados.put(1L, new Empleado(1L, "Felipe", "3192996631", 12000000L));
		empleados.put(2L, new Empleado(2L, "Alexis", "3232335276", 12000000L));
		empleados.put(3L, new Empleado(3L, "Jenny", "3204877763", 12000000L));
	}

	public static ArrayList<Empleado> getAllEmpleados() {
		return new ArrayList<>(empleados.values());
	}

	public static Empleado getEmpleado(Long id) {
		return empleados.get(id);
	}

	public static Empleado addEmpleado(Empleado empleado) {
		index += 1;
		empleado.setId(index);
		empleados.put(index, empleado);
		return empleado;
	}

	public static Empleado updateEmpleado(Long id, Empleado empleado) {
		empleado.setId(id);
		empleados.put(id, empleado);
		return empleado;
	}

	public static Empleado deleteEmpleado(Long id) {
		return empleados.remove(id);
	}
}
