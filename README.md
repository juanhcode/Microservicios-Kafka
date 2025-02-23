# Microservicios con Kafka

Este proyecto implementa dos microservicios en Spring Boot: un **Productor** y un **Consumidor** de mensajes de Kafka. Utiliza Docker Compose para desplegar **Kafka, Zookeeper y Kafka UI**.

## 📌 Prerrequisitos
Antes de ejecutar el proyecto, asegúrate de tener instalados:
- **Docker** y **Docker Compose**
- **Java 17** o superior
- **Maven**

---
## 🚀 Instalación y Ejecución

### 1️⃣ Levantar Kafka y sus dependencias
Ejecuta el siguiente comando para iniciar Kafka, Zookeeper y la UI de Kafka:
```bash
docker-compose up -d
```
📌 Esto iniciará los contenedores en segundo plano.

### 2️⃣ Compilar y ejecutar los microservicios
Ejecuta los siguientes comandos en cada uno de los microservicios (**producer** y **consumer**):
```bash
cd producer
mvn clean package
java -jar target/producer-0.0.1-SNAPSHOT.jar
```
```bash
cd consumer
mvn clean package
java -jar target/consumer-0.0.1-SNAPSHOT.jar
```

---
## 📡 Uso

### ✅ Enviar un mensaje a Kafka
Haz una petición **POST** para enviar un mensaje:
```bash
curl -X POST "http://localhost:8080/api/producer/send?message=HolaKafka"
```
📌 **Productor** enviará el mensaje a Kafka.

### ✅ Ver el mensaje en Kafka UI
Abre [Kafka UI](http://localhost:8085) en tu navegador:
1. Ve a "Clusters" → "local"
2. Navega a "Topics" → "nombre-del-topic"
3. Verás el mensaje publicado en la cola.

### ✅ Confirmar que el Consumidor recibe el mensaje
El **Consumer** imprimirá en la consola:
```
Mensaje recibido: HolaKafka
```

---
## 📜 Estructura del Proyecto
```
/kafka-microservices
│── /producer  # Microservicio Productor
│── /consumer  # Microservicio Consumidor
│── docker-compose.yml  # Configuración de Kafka y Zookeeper
```

---
## 🛑 Apagar los servicios
Para detener todos los contenedores:
```bash
docker-compose down
```

---
## 🛠️ Troubleshooting
Si Kafka no se conecta correctamente, intenta reiniciar los servicios con:
```bash
docker-compose down && docker-compose up -d
```
Si los microservicios no encuentran Kafka, asegúrate de que `bootstrap-servers` en `application.yml` está configurado como:
```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
```

