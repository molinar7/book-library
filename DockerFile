FROM openjdk:8
EXPOSE 8080
ADD target/book-library.jar book-library.jar
ENTRYPOINT ["java", "-jar", "/book-library.jar"]
