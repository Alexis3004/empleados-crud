Aplicación api de empleados usando Spring boot y maven como herramienta de build

Para compilar: mvn compile

Para ejecutar Tests: mvn test

Para crear artefacto de despliegue (.jar): mvn package

Para ejecutar usando spring pluging mvn spring-boot:run y luego acceder a http://localhost:8082/

Documentación api empleados

1
Método:Get
ruta:/getEmpleados
EndPoint:http://localhost:8082/getEmpleados
Descripción: Obtiene todos los empleados, debe obtener tres que están creados por defecto
Salida:
[
    {
        "id": 1,
        "nombre": "Felipe",
        "telefono": "3192996631",
        "salario": 12000000
    },
    {
        "id": 2,
        "nombre": "Alexis",
        "telefono": "3232335276",
        "salario": 12000000
    },
    {
        "id": 2,
        "nombre": "Jenny",
        "telefono": "3204877763",
        "salario": 12000000
    }
]


2
Método:Get
ruta:/getEmpleado/{id}
EndPoint ejemplo:http://localhost:8082/getEmpleado/1
Descripción: Obtiene un empleado específico, en el ejemplo el empleado 1
Salida:
{
    "id": 1,
    "nombre": "Felipe",
    "telefono": "3192996631",
    "salario": 12000000
}


3
Método:Post
ruta:/postEmpleado
EndPoint:http://localhost:8082/postEmpleado
Descripción: Guarda un empleado, recibe un Json y devuelve el objeto guardado
Json ejemplo:{"id": 4, "nombre": "Pepito", "telefono": "0123456789", "salario": 9000000}
Salida:
{
    "id": 4,
    "nombre": "Pepito",
    "telefono": "0123456789",
    "salario": 9000000
}


4
Método:Put
ruta:/putEmpleado/{id}
EndPoint ejemplo:http://localhost:8082/putEmpleado/4
Descripción: Actualiza un empleado, recibe un Json con todso los parámetrosy devuelve el objeto actualizado
Json ejemplo:{"id": 4, "nombre": "Pepe", "telefono": "9876543210", "salario": 12000000}
Salida:
{
    "id": 4,
    "nombre": "Pepe",
    "telefono": "9876543210",
    "salario": 12000000
}


5
Método:Delete
ruta:/deleteEmpleado/{id}
EndPoint ejemplo:http://localhost:8082/deleteEmpleado/4
Descripción: Elimina un empleado, recibe el id del empleado a eliminar y devuelve el empleado eliminado
Salida:
{
    "id": 4,
    "nombre": "Pepe",
    "telefono": "9876543210",
    "salario": 12000000
}