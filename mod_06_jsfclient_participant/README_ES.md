# Jakarta RESTful Web Services 3.1 Workshop Participant

## Módulo 6: Clientes RESTful Servlet y Jakarta Faces

En este módulo exploraremos los clientes RESTful que están basados en servidor. Esto significa que el cliente puede ser parte de un Servlet o en un POJO llamado desde una página Jakarta Faces. Trabajarás con los siguientes proyectos:

-   `mod_06_servletclient_participant`
-   `mod_06_jsfclient_participant`
-   `mod_06_restserver`

El `Mod_06_RestServer` está completo y es el host del servicio. Haga que esto se ejecute en el servidor antes de trabajar en cualquiera de los dos clientes.

**Los Proyectos**

Hay dos clientes diferentes en este módulo. El primero es el cliente basado en Servlet que utiliza una página HTML como entrada. El segundo es el cliente basado en Jakarta Faces. Aquí están los diseños de Maven.

![A screenshot of a computer Description automatically generated](media/79d728cb3d69d8431bd1e57cd292ba08.png)

### El archivo pom

Las dependencias del archivo pom son las mismas para ambas versiones, servlet y faces. Como el servidor ya tiene todas las bibliotecas que necesita las dependencias son bastante simples.

```
<dependencies>
   <dependency>
   <groupId>jakarta.platform</groupId>
   <artifactId>jakarta.jakartaee-api</artifactId>
   <version>${jakartaee-api.version}</version>
   <scope>provided</scope>
   </dependency>
</dependencies>
```

No se necesitan plugins.

### Veamos el archivo beans.xml

Este archivo es el mismo para todos los ejemplos.

### Veamos el web.xml

En el cliente Servlet todo lo que necesitas es el nombre del archivo de bienvenida. En este ejemplo el archivo de bienvenida es el archivo `index.html`.

El archivo web.xml del cliente Jakarta Faces también sólo necesita el nombre del archivo de bienvenida que en este caso es un archivo xhtml, `index.xhtml`. Hay dos ajustes opcionales. El `PROJECT_STAGE` determina los mensajes que Faces devuelve en caso de problema. El `FACELETS_SKIP_COMMENTS` determina si los comentarios en el archivo xhtml serán visibles si el usuario usa Ver Código Fuente en su navegador.

Veamos ahora qué hay que hacer para acabar con ambos clientes.

## Mod_06_ServletClient_participant

In this project a Jakarta Servlet will be the home of the REST services client code. The ServletClient.java is the target for a submit from the index.html page. The HTML form shows that when the Submit button is pressed the ServletClient will be called.

```
<form action="ServletClient" method="get">
```

La clase construye un `CompoundBean` utilizando los valores de los parámetros de la petición. A continuación hay un `callCompoundService` donde se introducirá el código del cliente REST.

La tarea de este Servlet es mostrar una página web. Mi ejemplo coloca el código de la página en el método `doGet`. El propósito de esto es mostrar la entrada y el resultado. Normalmente no se suele construir HTML en un Servlet. Una configuración más común es usar Jakarta Server Pages con Jakarta Servlets.

**Su tarea consiste en implementar el código del cliente RESTful en el archivo** `callCompoundService` **método.**

Veamos ahora la versión Faces.

### Mod_06_JSFClient_participant

En este proyecto prescindimos de los Servlets. En su lugar, el fichero `index.xhtml` es un fichero Jakarta Faces. Si no estás familiarizado con Faces, esta es una simple introducción. La página Faces se parece a una página HTML. A diferencia de un archivo HTML, esta página no se carga en el navegador. En su lugar, la página se carga en el servlet del framework Faces donde se traduce a HTML que se envía al navegador.

Este proyecto también emplea la internacionalización. Este es el propósito del archivo `faces-config.xml`. Tiene el nombre del paquete que contiene los bundles para cada idioma junto con el nombre del identificador que puedes usar en tu página de Faces. En el `index.xhtml` verás referencias como `#{msgs.principal}`. Esto significa que quieres el texto con la clave `principal` del paquete de idioma apropiado. Puedes encontrar los paquetes en la carpeta `src/main/resources/com/eclipse/bundles`. Hay un paquete por defecto, uno en inglés y otro en francés. El navegador del visitante informa al servidor de su idioma.

**Tu tarea es implementar el código del cliente RESTful en el método **callCompoundService**, muy similar al método **ServletClient**. La única diferencia es que JSF puede acceder a beans y llamar a métodos de acción directamente desde la página. Los métodos de acción deben devolver una cadena o null. La cadena podría ser la siguiente página para navegar, pero como se trata de una aplicación de una sola página, devolvemos null.

El código para interactuar con el servicio será el mismo código que el servlet pero con el resultado almacenado en el bean CDI y el valor de retorno establecido a null.

**¿Dónde estamos ahora?**
En este punto del taller, hemos visto cómo podemos construir servicios REST que pueden ejecutarse en un servidor o en una aplicación de escritorio. Hemos visto clientes desktop, Servlet y JSF. A continuación aprenderemos a construir un servicio que acepte un archivo binario como una imagen.
