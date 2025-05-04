# Conversor de Monedas – Proyecto Java

Una aplicación de línea de comandos desarrollada en Java que permite realizar conversiones de divisas en tiempo real utilizando la API de ExchangeRate.

## ✨ Características principales

- 🔄 **Conversión en tiempo real:** Consulta tasas de cambio actualizadas mediante la API de ExchangeRate.
- ⚡ **Sistema de caché eficiente:** Almacena temporalmente los datos para reducir llamadas innecesarias a la API.
- 🔁 **Conversión bidireccional:** Compatible con cualquier par de monedas soportadas.
- 💻 **Interfaz CLI intuitiva:** Menú interactivo accesible desde la terminal.
- 🛡️ **Manejo robusto de errores:** Gestión de excepciones para problemas de red o entradas inválidas.

## 🛠️ Stack tecnológico

- **Java 17**
- **Maven** – Gestión de dependencias y ciclo de vida del proyecto
- **GSON** – Procesamiento de datos JSON
- **Diseño Orientado a Objetos**
- **Integración con APIs RESTful**

## 📁 Estructura del Proyecto

ConversorMonedas/
├── src/
│ └── main/
│ └── java/
│ ├── MenuPrincipal.java # Controla el menú y la interacción con el usuario
│ ├── ConversorMoneda.java # Contiene la lógica de conversión y el consumo de la API
│ └── InputHelper.java # Validación y procesamiento de entradas
├── pom.xml # Archivo de configuración Maven

markdown
Copiar
Editar

## 🧠 Principios aplicados

Este proyecto aplica conceptos clave del desarrollo profesional en Java:

- Separación clara de responsabilidades
- Modularidad y mantenibilidad del código
- Integración limpia con servicios externos (REST APIs)
- Eficiencia mediante caching

## 🚀 Cómo ejecutar

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tu_usuario/ConversorMonedas.git
   cd ConversorMonedas
Compila el proyecto con Maven:

bash
Copiar
Editar
mvn clean install
Ejecuta la aplicación:

bash
Copiar
Editar
java -cp target/ConversorMonedas-1.0.jar MenuPrincipal
Asegúrate de tener configurada tu clave de API de ExchangeRate API en el archivo correspondiente o como variable de entorno.

📄 Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.
