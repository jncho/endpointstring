# Ejemplo Endpoint Spring Boot

Servicio REST en donde el usuario podrá guardar en base de datos una palabra deseada y su versión en mayúsculas.
El método /add junto a su parámetro "record" son los que se tendrán que utilizar para poder usar el servicio.
La siguiente petición será válida: /data?record=hola

# Configuración del entorno

Para poder usar este servicio se deberá tener instalado:  
    - Java JDK 8+  
    - Maven  
    - Crear variable de entorno JAVA_HOME apuntando al directorio donde se encuentra Java instalado.  
    

# Ejecución del servicio (por terminal)

Para crear el .jar del proyecto:  
    `mvnw package`  
Para ejecutar el servidor:  
    `java -jar target/endpointstring-0.0.1-SNAPSHOT.jar es.gt.endpointstring.EndpointstringApplication`  
    
# Ejecución del servicio (por IntelliJ IDEA)

El repositorio es un proyecto de IntelliJ IDEA. Abriéndolo con este IDE se puede acceder a los comandos predefinidos
de maven y poder construir el .jar. Una vez generado el archivo se puede arrancar el servidor ejecutando la clase
EndpointstringApplication.