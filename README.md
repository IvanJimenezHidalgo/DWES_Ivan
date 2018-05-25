Repositorio del 03/04/2018

03/04/2018 - Servlet Hola Mundo

06/04/2018 - Formulario Simple
			 Recoge los datos de un formulario y los muestra desde el servlet.

08/04/2018 - Formulario Complejo y Formulario Complejo con Validación
			 Primer formulario en el que se muestran los datos desde el servlet
			 Segundo formulario en el que se validan los campos en el servlet.

09/04/2018 - Servlet Ciclo de Vida
			Se usan los métodos del ciclo de vida de un servlet init, service y destroy.

12/04/2018 - Servlet Registro Usuarios
			Recoge los datos del formulario y los valida:
			- Si están correctos los muestra
			- Si no, muestra el formulario con los campos correctos y erróneos

			Añadido jsp Edad - Calcula la edad recibiendo la fecha de nacimiento

13/04/2018 - Contador de visitas con Cookies en JSP y con Sesión en Servlet
			 Contienen un botón para recargar la página y otro para reiniciar el contador.

			 Corrección del registro de usuario (Servlet), el formulario erróneo se llama a sí mismo hasta que se introducen los campos correctamente.
			 Calculo de edad (JSP), ya no se muestran los datos que sean 0.

16/04/2018 - Creación del proyecto 20180416_Ivan
			 Ejercicio de Calculadora Modelo Vista Controlador

17/04/2018 - Subida del proyecto funcionando
			 Archivos JSP index, resultado y error
			 Servlet Calcular
			 Bean Calculadora
			 Models Suma, Resta, Multiplicación y División (estáticos)
			 La calculadora permite introducir números decimales mediante html, controla la división por 0 mostrando el error y formatea la salida para no mostrar los decimales si son 0

17/04/2018 - Proyecto 20180417_JSP_Ivan Mostrar datos de formulario mediante JSP y Lenguaje de Expresiones
			 El servlet recibe los datos y rellena los beans mediante populate
			 Según el parámetro tipo redirige a salida jsp o lenguaje de expresiones

19/04/2018 - Proyecto 20180419 Tienda MVC sin cookies
			 
			 Se añaden los libros sin que se repitan, se guardan en sesión, se puede visualizar el carrito y volver a comprar sin perder nada. Al aceptar la compra, se invalida sesión y se vuelve al index. Excepciones al intentar guardar el título en el value de la cookie.

			 Calculadora actualizada a EL y JSTL, sigue admitiendo decimales y los formatea a la salida.

23/04/2018 - Proyecto Mastermind
			 Juego Mastermind MVC con JSTL

			 Añadida función de las cookies, a la tienda MVC

02/05/2018 - Proyecto Pool - CRUD Pool con la base de datos aves
			 Permite añadir, leer, actualizar y eliminar registros

			 Añadido apartado etiquetas personales JSP al proyecto 20180403

07/05/2018 - Proyecto 20180503 - CRUP Pool con objetos DAO y Base de Datos equiposdept
			 Añadir alumnos y equipos
			 Mostrar listas de ambos, alumnos y equipo asignados, equipos sin asignar
			 Actualizar alumno o equipo
			 Eliminar alumno o equipo

16/05/2018 - Proyectos hibernate
			 Una entidad por mapeo y anotación
			 Dos entidades uno a uno por mapeo y anotación

19/05/2018 - Proyecto 20180515_MapUnoaUnoBidi_Ivan
			 Dos entidades uno a uno bidireccional por  mapeo en Hibernate Presidente-País
			 CRUD estándar, con listado por presidente y por país

21/05/2018 - Movido proyecto Tienda Virtual InfoGanga a nuevo repositorio
			 Agrupar todos lo proyectos hibernate en una sola carpeta
			 Ejercicio AnotUnoaUnoBidi
			 Ejercicio en hibernate con dos tablas relacionadas una a una, Presidente-País, mediate anotaciones

22/05/2018 - Proyecto 20180522_MapUnoaN
			 Ejercicio CRUD Persona-Libros en hibernate con relacion uno a muchos por mapeo

24/05/2018 - Proyecto 20180524_AnotUnoaN_Ivan
			 Ejercicio CRUD Persona-Libros en hibernate con relación uno a muchos por anotación (Uso de objetos DAO genéricos)