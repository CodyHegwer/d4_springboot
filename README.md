# d4 Backend Service

## Running locally
Prerequisite downloads
- Java 11 jdk https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
- PostgreSQL (I use 10) https://www.postgresql.org/download/
- Postman (useful) https://www.postman.com/downloads/

1. Create a postgres db locally and start it / get pgadmin lookin at it.
2. Ensure JAVA_HOME is pointing to java 11 jdk.
3. Ensure local testing properties are set in the application.properties (pointed at local db).
4. Run in root directory `./mvnw spring-boot:run`