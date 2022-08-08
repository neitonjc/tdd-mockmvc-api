FROM adoptopenjdk/openjdk11:latest
WORKDIR /app
COPY tdd-mockmvc-api/target/tdd-mockmvc-api.jar /app/tdd-mockmvc-api.jar
ENTRYPOINT ["java", "-jar", "tdd-mockmvc-api.jar"]
