FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia todos os arquivos do seu projeto para dentro do container
COPY . .

# CORREÇÃO: Dá permissão de execução para o Maven Wrapper
RUN chmod +x mvnw

# Executa o build do projeto gerando o arquivo .jar
RUN ./mvnw clean package -DskipTests

# Comando para iniciar a aplicação
# Certifique-se de que o nome do .jar no seu pom.xml é exatamente WorkShop-0.0.1-SNAPSHOT
CMD ["java", "-jar", "target/WorkShop-0.0.1-SNAPSHOT.jar"]
