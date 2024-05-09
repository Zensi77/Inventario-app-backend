FROM ubuntu:latest
LABEL authors="USUARIO"

ENTRYPOINT ["top", "-b"]

# Usa una imagen base de OpenJDK 22
FROM adoptopenjdk/openjdk22:alpine-slim

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR construido por Maven al contenedor
COPY target/Inventario-0.0.1-SNAPSHOT.jar Inventario-0.0.1-SNAPSHOT.jar

# Expone el puerto 8080 en el contenedor
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot cuando el contenedor se inicie
CMD ["java", "-jar", "Inventario-0.0.1-SNAPSHOT.jar"]
