# Manual de usuario: Proyecto II Estructura de datos  
## Inmplementación de Matriz Octogonal

## Introducción
La matriz octogonal tiene valores numéricos o elementos dispuestos en ocho direcciones, incluyendo arriba, abajo, izquierda, derecha y las cuatro diagonales.  Una matriz octogonal puede ser vista como una extensión de una matriz cuadrada convencional, en la que los elementos adicionales que se encuentran en las ocho direcciones proporcionan información adicional sobre los datos contenidos en la matriz.

## Requisitos en el sistema.
- Se requiere un sistema operativo windows 10
- El entorno de desarrollo a utilizar queda a discreción del usuario ya que no se necesita ninguna interfaz gráfica.  
- Visual Code
- Netbeans
- Editor de Texto. 


# Clases y sus funciones
## Clase Nodo
Los atributos:  
  private Nodo arriba;
  - private Nodo abajo
  - private Nodo izquierda;
  - private Nodo derecha;
  - private Vehiculo vehiculo;
  
  los 5 atributos representa cada puntero a otro nodo y los punteros arriba, abajo, izquierda y derecha se utilizan para conectar un nodo 
    
 El contructor se utilizará para inicializar los valores a los atributos. 
 
 Los metodos Get y Set se utilizan para acceder los valores de los atributos de la clase. los metodos get get devuelven el valor y los set actualizan el valor. 
 
 ## Clase Vehiculo
 Se utilizan para representar los vehículos que es nuestra base en donde vamos almacenar los datos. Estos serán llamados Placa, color, linea, modelo y propietario y serán utilizados cuando coloquen la ubicación de la matriz. 
 
 El contructor en la primera no recibe ningun argumento y la otra recibe los atributos del vehiculo. 
 
 ## Clase Matriz
 ## Insertar
 En el método insertar se encarga de ingresar datos según filas y columnas. Este le  tiene una condición que si ingresa ubicación errónea muestra un mensaje que dice que la posición no es válida. 
 
 De lo contrario se enlaza con los 5 atributos. 
 
 ## Buscar
 Este método busca un vehículo por su placa en la matriz y devuelve el nodo que lo contiene. Si el vehículo no está en la matriz, devuelve null.
 
 ## Eliminar   
 Este método busca un vehículo por su placa en la matriz y lo elimina. Si el vehículo no está en la matriz, se imprime un mensaje de error. Si el vehículo está en la matriz, se elimina y se enlazan los nodos adyacentes en la matriz.
 
 ## Imprimir 
 Recorre las linkedlist sus filas y columnas este método imprime la matriz. Si una celda contiene un vehículo, se imprime la representación en cadena del vehículo. De lo contrario, se imprime null.
 
 # Main
 - Se importa y se crea el la clase escaner para leer la entrada del usuario. 
 - Se utiliza un switch para mostrarle varias opciones dadas a su gusto.
 
 ## Opción 1 
 Si el usuario elige ingresar Fila y columna para la creación de una matriz.
 
 ## Opción 2
 Verifica si se ha credado una matriz
 
 ## Opción 3
  se verifica si se ha creado una matriz. Si no es así, se muestra un mensaje de error. Si se ha creado una matriz, se pide al usuario que ingrese la placa del vehículo que desea buscar. Luego, se busca en la matriz el nodo que contiene el vehículo con esa placa y se muestra en la consola si se encuentra o no.
  
  ## Opción 4
  permite al usuario elegir cómo desea eliminar un vehículo de la matriz.
  Se le ofroce 2 opciones 1 con eliminar filas y columas. 
  Se le ofrece la segunda opción que elimine por la placa.
  
  ## Opción 5 
  Se le permite al usuario finalizar con la ejecución del programa. 
  
  # Conclución
   Las matrices octogonales son una herramienta útil en ciertos contextos donde se necesita una disposición ordenada de información y se requiere una mayor cantidad de elementos que una matriz regular de dos dimensiones.
  
  
  
 
 

 
    
    
 
