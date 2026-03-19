# Usar imagen base de Java
FROM eclipse-temurin:17-jdk

# Crear carpeta app
WORKDIR /app

# Copiar el jar generado
COPY target/*.jar app.jar

# Exponer puerto
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java","-jar","app.jar"]
