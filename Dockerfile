# Construction
FROM eclipse-temurin:17-jdk-alpine AS build
COPY . .
# AJOUTEZ CETTE LIGNE POUR CORRIGER LE PERMISSION DENIED
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Exécution (le reste ne change pas)
FROM eclipse-temurin:17-jre-alpine
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
