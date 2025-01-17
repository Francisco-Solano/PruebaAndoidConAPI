## Prueba Android con API

El objetivo de este proyecto es lograr la conexion de una API desde Android Studio por lo que no habrá logica de codigo mayor a lo necesario para conseguir el objetivo.




## EXPLICACION DE LA IMAGEN CONTADOR

[![Ejercicio-M01.png](https://i.postimg.cc/63qcchc1/Ejercicio-M01.png)](https://postimg.cc/ft4YTm6x)

He usado el constraintLayout para poder hacer que la aplicancion sea responsive de una manera mas sencilla.

Todos los elementos de la aplicacion se han hecho constraint con respecto a la pantalla para que así si se aumenta o disminuye el tamaño de la pantalla, se adapte y mantenga la posicion. Los unicos elementos de la aplicacion distintos han sido los 3 botones de +, - y Reset.


Para el boton de + he hecho que el constraint sea respecto al texto del 0 que representa el numero, en su izquierda el lado de la pantalla y a la derecha el boton de reset para que asi este siempre a la misma distancia. En el constraint de abajo se ha puesto respecto a parte de abajo de la pantalla.

Para el boton RESET: Se ha centrado y se ha puesto el constraint respecto al texto del 0. Por los lados se ha puesto a la izquierda, derecha y  abajo la pantalla. Esto hará que el boton del centro sea el que mueva los otros dos botones ya que los dos estan en uno de sus costraints laterales "enganchados" al boton del centro y  si se cambia su posicion se movera el texto del 0 y los dos botones de los lados.

Boton de - : Como ya se ha mencionado su constraint izquierdo es respecto al boton de reset y despues su constraint de la derecha y abajo son respecto a la pantalla. El de arriba es respecto al texto del 0.


El texto de abajo del todo esta respecto a todos los lados de la pantalla para mantener su posicion. Tambien se ha modificado el tamaño y la fuente para tener similitud con figma.



## Login


## EXPLICACION DE LA IMAGEN LOGIN

[![Captura-de-pantalla-2023-12-19-155006.png](https://i.postimg.cc/XJBH385B/Captura-de-pantalla-2023-12-19-155006.png)](https://postimg.cc/47ZbQpBX)


Para la parte grafica del login He iniciado con un texto en el que pone login y he añadido la fuente poppins bold para que sea una letra con mas grosor. He hecho que ese texto este "enganchado" a cada lado de la pantalla para que mantenga en su misma posicion independientemete del tamaño de la pantalla. He hecho lo mismo con el resto de elementos los cuales explicare a continuacion:

EditText del nombre y la contraseña: Le he escrito "Nombre" y "Contraseña" respectivamente en el hint  y el texto desaparezca cuando el usuario vaya a escribir. Los constraints de de estos EditText son por todos los lados respecto a la pantalla excepto la parte de arriba que ha sido respecto al texto de login para que siempre haya la misma distancia entre el texto y los editText sin que el tamaño de la pantalla influya.


Boton de Login: Boton normal en el que he modificado el color y la letra para darle un diseño profesional. Mismo constraint que los EditText de Nombre y Contraseña pero la parte de arriba enganchada respecto a los editText para mantener la distancia.


Texto de abajo del todo: Constraint respecto a todos los lados de la pantalla y modificada como los demas elementos.







Ahora voy a cambiar el proyecto para que el segundo activity en vez de ser el contador sea un activity con un FrameLayout en el que se verán los diferentes fragments (mínimo home, contador, salir) y por otra parte una barra de navegación con la que podamos viajar entre los diferentes fragments.

Para este ejercicio he creado un nuevo activity al que he llamado MenuActivity que es el que muestra la barra de navegacion con los diferentes items dentro del menu. Cada item lleva al fragment correspondiente. En este caso todos estan en blanco excepto el del contador que lleva al contador que hemos realizado en las anteriores actividades.

A continuacion adjunto las imagenes he iré explicando como he conseguido llegar al resultado final

[![home.png](https://i.postimg.cc/PrRxWcVD/home.png)](https://postimg.cc/VdXm178s)




[![contador.png](https://i.postimg.cc/Y9R2hymh/contador.png)](https://postimg.cc/vg1wKhhs)




[![salir.png](https://i.postimg.cc/wxWTzZpr/salir.png)](https://postimg.cc/bdtjH6d0)




Como se puede ver en las imagenes dependiendo de qué icono selecciones en la barra te lleva a un diferente fragment. 

Primero cree una carpeta llamada navigation en la que iba mi archivo nav_graph.xml que se encargaria de definir la estructura y el flujo de navegación de la aplicación  utilizando el componente de navegación de Android. Este archivo se encarga de describir los fragmentos y las acciones de navegación entre ellos.

También cree una carpeta llamada menu en el que va mi archivo bottom_navigation_menu que se encarga se introducir los items dentro del menu y representa la estructura grafica de la aplicacion, el orden en el que se ven los iconos y la forma en la que el usuario los va a ver.

despues tengo una clase para cada fragment con su archivo .xml correspondiente. Practicamente el interior de todos tienen lo que escribe el editor de texto automaticamente cuando se crean ya que este ejercicio no pide rellenar esos fragments. El unico que si tiene contenido es el del contador ya que en su xml del fragment se ha escrito lo que tenia antes cuando era un activity. 


Para vincular los fragments en mi activityMenu he copiado el trozo de codigo proporcionado en el notion modificando la ruta a la mia, lo mismo para la navigation_bar.

Despues en el MenuActivity para hacer que dependiendo del icono que pulse el usuario lleve a un fragment u otro e utilizado setOnItemSelectedListener(item -> { para decir que si el itemID es igual al de cada uno de los fragments se utilice el método navigate para navegar a ese fragment especifico.

Por añadir algo más, prácticamente todos los fragments tienen sus bases de cuando se crean excepto el xml del contador como he mencionado antes. Para poder relacionarlos he utilizado en navGraph la opcion de relacionarlos utilizando las flechas de la interfaz grafica. 





## AÑADIR LA API


Voy a añadir un Fragment mas que se llame API y por otro lado crear un microservicio con una sola entidad.

[![capturaej04.png](https://i.postimg.cc/g2YpSWWN/capturaej04.png)](https://postimg.cc/N5PZFZLH)



Para este ejercicio he creado una API en INteliJ y la he consumido en android Studio siguiendo paso a paso un tutorial. 
He creado un nuevo fragment, he seleccionado el icono que he considerado mejor y he añadido en los if else que si se presiona ese icono en la navegacion lleve al fragment donde se encuentra la api. 

El microservicio ha sido creado en InteliJ utilizando lombok entre otras herramientas para hacerlo funcionar siguiendo las buenas practicas.

Al presionar el boton por el momento no ocurre nada pero en el LogCat tras haber invocado el metodo getAll en el create se muestra en el Log la lista de los productos.


Como algo extra a añadir he probado la API en postman para corroborar su funcionamiento antes de empezar con la parte en Android y ha ido bien

