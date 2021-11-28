package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmpleadoController.class)
class SpringCrudApplicationTests {
	@Autowired
    private MockMvc mvc;

	@Test
	@DisplayName("obtener todos los empleados")
	public void getEmpleadosTest() throws Exception{
		mvc.perform(get("/getEmpleados").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(3)))
			.andExpect(jsonPath("$[0].nombre", is("Felipe")))
			.andExpect(jsonPath("$[1].nombre", is("Alexis")))
			.andExpect(jsonPath("$[2].nombre", is("Jenny")));
	}

	@Test
	@DisplayName("obtener el empleado 1")
	public void getEmpleadoTest() throws Exception{
		mvc.perform(get("/getEmpleado/{id}",1).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.nombre", is("Felipe")))
			.andExpect(jsonPath("$.telefono", is("3192996631")));
	}

	@Test
	@DisplayName("guardar un empleado")
	public void postEmpleadoTest() throws Exception{
		Empleado empleado = new Empleado(4L, "Pepito", "1234567890", 9000000L);
		mvc.perform(post("/postEmpleado")
			.content(asJsonString(empleado))
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(4)))
			.andExpect(jsonPath("$.nombre", is("Pepito")))
			.andExpect(jsonPath("$.telefono", is("1234567890")));

		mvc.perform(get("/getEmpleados").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(4)));
	}

	@Test
	@DisplayName("actualizar el empleado 3")
	public void updateEmpleadoTest() throws Exception{
		Empleado empleado = new Empleado(3L, "Marcela", "0987654321", 13000000L);
		/**
		 * Actualizamos al empleado 4
		 */
		mvc.perform(put("/putEmpleado/{id}",3)
			.content(asJsonString(empleado))
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(3)))
			.andExpect(jsonPath("$.nombre", is("Marcela")))
			.andExpect(jsonPath("$.telefono", is("0987654321")));

		/**
		 * Comprobamos que se haya actualizado
		 */
		mvc.perform(get("/getEmpleado/{id}",3).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(3)))
			.andExpect(jsonPath("$.nombre", is("Marcela")))
			.andExpect(jsonPath("$.telefono", is("0987654321")));
	}

	@Test
	@DisplayName("eliminar empleado 4")
	public void deleteEmpleadoTest() throws Exception{
		mvc.perform(delete("/deleteEmpleado/{id}", 4)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(4)))
			.andExpect(jsonPath("$.nombre", is("Pepito")))
			.andExpect(jsonPath("$.telefono", is("1234567890")));

		mvc.perform(get("/getEmpleados").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(3)));
	}


	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
