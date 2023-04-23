# p7_F_ParqueVehiculos
Práctica 7 Final - Parque de Vehículos

PFinalTema7: Parque de vehículos
Esta práctica tiene como objetivo afianzar los conceptos de herencia, polimorfismo e interfaces, además de practicar la clase ArrayList (listas genéricas de objetos). Para ello, será necesario revisar el Anexo XI correspondiente.
Se pide añadir funcionalidades al programa creado en la práctica final del tema 6 (pFinalTema6) donde se creaban coches de la clase Coche. En aquel caso, se utilizaban diferentes formas de hacerlo, diferentes constructores, y se almacenaban los coches creados en un vector de referencias a Coche, que se iba consultando para extraer información sobre los coches creados.
Ahora vamos a ampliar nuestro parque de vehículos no sólo a Coches, si no a Vehículos en general, utilizando la herencia, el polimorfismo y las interfaces.
En nuestro parque de vehículos podrán aparcarse diferentes tipos de vehículos:
•	Coche
•	Autobús
•	Motocicleta
•	Avioneta
•	Yate
Todos ellos heredarán de la clase Vehiculo, que será abstracta, y tendrán los siguientes atributos en común:
•	matricula: cadena de texto. Con un valor aleatorio por defecto, al crearse el objeto. Ésta no se pasará por parámetro, se asignará un valor aleatorio al crear el vehículo.
•	marca: cadena de texto.
•	modelo: cadena de texto.
•	color: cadena de texto. Por defecto, el color será blanco
•	kilometros: será un número decimal positivo. Inicialmente será 0.
•	numPuertas: Número entero positivo.
•	numPlazas: Número entero positivo.
Al igual que en la Fábrica de Coches, se definirá una variable estática para el número de vehículos y una constante estática para el máximo de vehículos (por defecto, 5).
La clase vehículo dispondrá como mínimo de dos constructores, uno sin parámetros, inicializando con valores por defecto y otro con parámetros, para pasarle valores.
También dispondrá de los métodos:
•	arrancar(), acelerar() y frenar(): todos ellos, métodos abstractos que se implementarán en cada clase concreta. (Mostrarán por pantalla la acción realizada por cada vehículo).
•	toString(): método sobreescrito que en la implementación en cada clase concreta devolverá una cadena (String) con una explicación de las características de cada objeto. Podrá definirse parte del método en la clase abstracta Vehiculo y después, sobreescribiendo el método en las clases concretas. (Utilizando la parte común de las características llamando al método en la superclase, por ejemplo).
Además, para cada clase concreta, se crearán los siguientes atributos:
•	Coche: numAirbags, techoSolar (si dispone de él), tieneRadio
•	Autobús: tipoRecorrido, esEscolar 
•	Motocicleta: potenciaMotor, tieneMaletero
•	Avioneta: Aeropuerto, maxKg
•	Yate: tieneCocina, numMotores, metrosEslora
Algunos de los vehículos podrán circular (caminar), otros podrán volar, otros podrán navegar. Para ello, utilizaremos las interfaces: (que definen comportamientos)
•	PuedeCircular: por tierra
•	PuedeNavegar: por agua
•	PuedeVolar: por aire
Cada interfaz contendrá un método abstracto llamada circular(), navegar() o volar(), que en las clases concretas mostrará por pantalla un mensaje indicando por qué lugares puede realizar dichas acciones o comportamientos.
Por ejemplo: (implementado en la clase concreta correspondiente)
•	circular() para un coche: “Esto es un coche y los coches puede circular por carreteras, autovías y autopistas”.
•	circular() para una avioneta: “Esto es una avioneta y las avionetas sólo pueden circular dentro de los aeropuertos.”
Como mínimo, para cada clase concreta, definiremos el constructor sin parámetros y otro constructor al que le pasemos los parámetros importantes. Con dos constructores por clase será suficiente. Dichos constructores harán una llamada a los constructores de la superclase para inicializar variables comunes a todas las clases concretas.
Aparte de los propios setters y getters de cada clase, y de los constructores ya explicados, cada clase concreta dispone de los siguientes métodos:
•	Clase Coche:
o	Método tunear(color): este método deja el cuentakilómetros a cero y le instala un techo solar, en el caso de que no lo tuviera ya instalado. Y pinta el coche de un color. Muestra un mensaje indicando la operación.
o	Método aparcar(): este método indicará con un mensaje que el coche está aparcando.
•	Clase Autobús:
o	Método abrirPuertas() y aparcar(): muestra un mensaje indicando la operación.
•	Clase Motocicleta:
o	Método brincar() y aparcar(): muestra un mensaje indicando la operación.
•	Clase Avioneta:
o	Métodos despegar() y aterrizar(): estos método mostrarán por pantalla un mensaje indicando la acción que realiza la avioneta.
•	Clase Yate:
o	Método zarpar() y atracar(): estos método mostrarán por pantalla un mensaje indicando la acción que realiza el yate.
Se creará una clase llamada Parque, en la que implementaremos el programa principal, que realizará las siguientes acciones:
•	Mostrará al usuario un menú, similar al de la Fábrica de Coches, para crear 5 tipos de vehículos (coche, autobús, motocicleta, avioneta o yate), pidiendo los datos necesarios en cada caso.
•	Los vehículos creados se irán almacenando en un objeto de tipo ArrayList<Vehiculo>. Para recorrerlo, consultarlo o cualquier operación sobre él, se deberán utilizar los métodos de esta clase. (Consultar el Anexo XI).Una vez implementado con Vehiculos, pensad cuál sería solución si se tratase de un ArrayList de Object y extraer conclusiones de qué es mejor y porqué.
•	El menú permitirá mostrar los datos de cada vehículo del Parque. Para ello, por menú se pedirá una matrícula, se buscará el vehículo y se mostrarán sus capacidades.
Las opciones del menú serán: (a modo de ejemplo, pero podrá variarse)
1.	Crear un coche (con o sin datos)
2.	Crear un autobús (con o sin datos)
3.	Crear una motocicleta (con o sin datos)
4.	Crear una avioneta (con o sin datos)
5.	Crear un yate (con o sin datos)
6.	Mostrar características de todos los vehículos del parque
7.	… (más operaciones, nº opcional...)
8.	Salir del programa
•	Tened en cuenta que los objetos entran con tipos concretos al ArrayList, pero salen del ArrayList como vehículos. Por tanto, el programa deberá comprobar el tipo de cada objeto para ir mostrando sus capacidades e ir realizando las operaciones con cada vehículo. Para ello, se definirán dos métodos en la clase Parque:
o	tipoVehiculo(): se le pasará por parámetro un vehículo de tipo Vehiculo, obtenido del ArrayList, y el método devolverá un entero indicando el tipo de vehículo. Tened en cuenta incluir un código de error (-1).
o	mostrarArray(): se le pasará por parámetro el objeto de tipo ArrayList y lo recorrerá para ir mostrando los datos (caracteristicas()) y las capacidades (interfaces: qué es capaz de hacer) de cada vehículo. Este método llamará a tipoVehiculo para saber el tipo de cada objeto obtenido del ArrayList, y realizará un casting del objeto, para actuar con él como un objeto de su tipo concreto correspondiente.
Deberá entregarse la solución en un archivo comprimido llamado PFinalTema7NombreyApellidos, mediante esta tarea, en el que se incluirá:
•	La imagen del diagrama de clases UML llamada clases.
•	Los archivos .java del programa
•	El archivo .jar del programa ejecutable (revisar el Anexo II).
•	Añadir la URL nueva del repositorio en bitBucket, independiente de la práctica anteior.
NOTA: Al implementar el método toString(), tened en cuenta que se puede aprovechar la funcionalidad del método en la superclase y llamaremos así al método heredado con super(), para después añadir funcionalidades. 
NOTA: Dada la complejidad de esta práctica, lo aconsejable es comenzar con el diseño de las clases e interfaces, mediante el diagrama de clases UML, y después ir implementando código poco a poco. Os recomiendo dejar para el final la implementación del código del programa principal, teniendo en cuenta que existe bastante código y elementos de los diagramas que se pueden reaprovechar de la práctica de la Fábrica de Coches

