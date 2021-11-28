Aplicación api de empleados usando Spring boot y maven como herramienta de build

Para compilar: mvn compile <br>

Para ejecutar Tests: mvn test

Para crear artefacto de despliegue (.jar): mvn package

Para ejecutar usando spring pluging mvn spring-boot:run y luego acceder a http://localhost:8082/

Documentación api empleados

1 <br>
Método:Get <br>
ruta:/getEmpleados <br>
EndPoint:http://localhost:8082/getEmpleados <br>
Descripción: Obtiene todos los empleados, debe obtener tres que están creados por defecto <br>
Salida:<br>
[<br>
    {<br>
        "id": 1,<br>
        "nombre": "Felipe",<br>
        "telefono": "3192996631",<br>
        "salario": 12000000<br>
    },<br>
    {<br>
        "id": 2,<br>
        "nombre": "Alexis",<br>
        "telefono": "3232335276",<br>
        "salario": 12000000<br>
    },<br>
    {<br>
        "id": 2,<br>
        "nombre": "Jenny",<br>
        "telefono": "3204877763",<br>
        "salario": 12000000<br>
    }<br>
]<br>

<br>
2<br>
Método:Get<br>
ruta:/getEmpleado/{id}<br>
EndPoint ejemplo:http://localhost:8082/getEmpleado/1<br>
Descripción: Obtiene un empleado específico, en el ejemplo el empleado 1<br>
Salida:<br>
{<br>
    "id": 1,<br>
    "nombre": "Felipe",<br>
    "telefono": "3192996631",<br>
    "salario": 12000000<br>
}<br>
<br>

3<br>
Método:Post<br>
ruta:/postEmpleado<br>
EndPoint:http://localhost:8082/postEmpleado<br>
Descripción: Guarda un empleado, recibe un Json y devuelve el objeto guardado<br>
Json ejemplo:{"id": 4, "nombre": "Pepito", "telefono": "0123456789", "salario": 9000000}<br>
Salida:<br>
{<br>
    "id": 4,<br>
    "nombre": "Pepito",<br>
    "telefono": "0123456789",<br>
    "salario": 9000000<br>
}<br>

<br>
4<br>
Método:Put<br>
ruta:/putEmpleado/{id}<br>
EndPoint ejemplo:http://localhost:8082/putEmpleado/4<br>
Descripción: Actualiza un empleado, recibe un Json con todso los parámetrosy devuelve el objeto actualizado<br>
Json ejemplo:{"id": 4, "nombre": "Pepe", "telefono": "9876543210", "salario": 12000000}<br>
Salida:<br>
{<br>
    "id": 4,<br>
    "nombre": "Pepe",<br>
    "telefono": "9876543210",<br>
    "salario": 12000000<br>
}<br>

<br>
5<br>
Método:Delete<br>
ruta:/deleteEmpleado/{id}<br>
EndPoint ejemplo:http://localhost:8082/deleteEmpleado/4<br>
Descripción: Elimina un empleado, recibe el id del empleado a eliminar y devuelve el empleado eliminado<br>
Salida:<br>
{<br>
    "id": 4,<br>
    "nombre": "Pepe",<br>
    "telefono": "9876543210",<br>
    "salario": 12000000<br>
}<br>
