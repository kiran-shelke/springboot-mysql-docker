FROM eclipse-temurin:17

LABEL mentainer="Kiran Shelke"

WORKDIR /app

COPY target/EmployeeManagementSystem-0.0.1-SNAPSHOT.jar /app/EmployeeManagementSystem.jar

ENTRYPOINT ["java","-jar","EmployeeManagementSystem.jar"]