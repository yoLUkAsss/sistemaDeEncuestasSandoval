# Sistema de Encuestas - Recuperatorio Arena 2015

Indicaciones:
Los trabajos deberán estar funcionando completamente a la hora de entregar sin errores. No se aceptarán entregas con errores por lo que pedimos a quienes entregan que si necesitan
utilizar las máquinas de la facultad dejen configurado su TP en las mismas con anticipación a la hora de entrega

Dominio:
Para la facu nos pidieron un sistema que ayude a planificar la distribución de cursos, proferos y horarios y detectar posibles cuellos de botella antes del día de la inscripción.
Es un sistema de por sí muy complejo por muchas variantes que hay que tener en cuenta, y como tarea del mega proyecto encomendado tenemos que armar una encuesta muy sencilla para 
empezar a juntar datos para hacer análisis preliminares.
Pusieron la encuesta en funcionamiento y despues de un tiempo nos pasaron feedback del comportamiento de la aplicación.


Lo que nos dijo el usuario:
	1. Agregar mail a cada respuesta de la encuesta, ahora es anonimo y no sabemos cómo distinguir las respuestas

	2. En las opciones de turnos dice “MANIANA” debería de decir “Mañana” (si, con ñ y solo la primer letra en mayúscula)

	3. Cuando se agrega una materia para cursar NO se refleja en la pantalla

	4. No se están validando los campos obligatorios (carrera, año de ingreso y al menos una materia a la que se piensa anotar)

El técnico que revisó el código nos dijo:
	1. El modelo es pésimo:
		a. Encuesta tiene atributos que sobran, responsabilidades que están solo por la pantalla, variables mal nombradas (carreraSeleccionada, etc) y malas elecciones en los tipos de datos
		
		b. Materia confunde el concepto de la materia en sí con la intención de inscripción a un turno ya que tiene turno pero solo tiene datos cuando la persona se quiere inscribir

		c. Falta modelar el concepto de Carrera, ahora se usan solo strings, cuando en realidad las materias dependen de la carrera

		d. El modelo de GraciasPorResponderWindow carece de todo tipo de sentido

	2. El uso del framework es pobre
		a. El manejo que se hace para mostrar los datos en los selectores es absurdo y podrían aprovecharse los bindings y adapters que tiene el framework

		b. Abrir una nueva ventana para dar una información desaprovecha las ventanas que ya vienen implementadas

		c. No se hacen las validaciones ni se muestran los errores

		d. Se hace un mal manejo de bindings en cuanto a la lista de materias aprobadas que provoca que no se refresque la pantalla

Se pide

	1. Crear al menos un proyecto que use arena y provea la funcionalidad (la actual y la pedida) buscada:
		a. Ingresar a la vista que permita responder la encuesta indicando un mail (válido)

		b. Responder la encuesta. Se deben realizar las validaciones correspondientes y notificar en caso de error.
		
		c. Una vez finalizada la encuesta ver la pantalla de agradecimiento

	2. Revisar el código actual y hacer los cambios que considere necesario para corregir las críticas que hace el técnico sobre el código actual. Se pueden realizar todos ​los cambios que se deseen (no es necesario mantener la estructura actual del código)