# Construction
# Changez 17 par 21 ici
FROM eclipse-temurin:21-jdk-alpine AS build
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Exécution
# Changez 17 par 21 ici
FROM eclipse-temurin:21-jre-alpine
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
