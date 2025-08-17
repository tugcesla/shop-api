# ---------- Build stage ----------
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app

# Maven wrapper ve pom'u kopyala
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# Windows CRLF sorunlarını düzelt, wrapper'a izin ver
RUN sed -i 's/\r$//' mvnw && chmod +x mvnw
# Bağımlılıkları indir
RUN ./mvnw -B -DskipTests dependency:go-offline

# Kaynak kodu kopyala ve paketle
COPY src ./src
RUN ./mvnw -B -DskipTests package

# ---------- Run stage ----------
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Render'ın sağladığı PORT değişkenini Spring'e iletelim
ENV PORT=8080
EXPOSE 8080
CMD ["sh","-c","java -Dserver.port=${PORT} -jar app.jar"]
