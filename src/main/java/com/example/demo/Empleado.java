package com.example.demo;

public class Empleado {
	private Long id;
	private String nombre;
	private String telefono;
	private Long salario;

	public Empleado() {
	}

	public Empleado(Long id, String nombre, String telefono, Long salario) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getSalario() {
		return salario;
	}

	public void setSalario(Long salario) {
		this.salario = salario;
	}

	public String gettelefono() {
		return telefono;
	}

	public void settelefono(String telefono) {
		this.telefono = telefono;
	}
}
