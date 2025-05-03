# 📁 FileSplitter

Aplicación web desarrollada en **Java 17 + Spring Boot + Thymeleaf** que permite a un usuario subir un archivo, dividirlo en fragmentos de tamaño configurable y descargar cada uno por separado. Ideal para enviar archivos grandes por partes.

---

## 🚀 Características

- ✅ Interfaz web intuitiva y responsiva (HTML5 + Thymeleaf)
- ✅ Soporte para arrastrar y soltar archivos (drag-and-drop)
- ✅ División de archivos por tamaño personalizado (en bytes)
- ✅ Generación de fragmentos numerados (`archivo.0.pdf`, `archivo.1.pdf`, etc.)
- ✅ Descarga individual de cada fragmento
- ✅ Reconstrucción del archivo desde los fragmentos (validado en sistema operativo)
- ✅ Estructura basada en principios **SOLID**
- ✅ Arquitectura limpia: separación en controladores, servicios, mapeadores y gateways

---

## 🛠️ Tecnologías

- Java 17
- Spring Boot 3.x
- Thymeleaf
- Maven
- HTML5/CSS3

---

## 📦 Instalación local 

1. Clona el repositorio:
   ```bash
   git https://github.com/bernar2cl/Astra-Group.git
   cd Astra-Group
   cd filesplitter

2. Compila y ejecuta la aplicación:
bash
./mvnw spring-boot:run

3. Accede en tu navegador:
   http://localhost:8080


🧪 Validación de Fragmentos
Después de generar los fragmentos, puedes reconstruir el archivo original con:

En macOS/Linux:
cat archivo.0.pdf archivo.1.pdf archivo.2.pdf > archivo.pdf

En Windows:
copy /b archivo.0.pdf + archivo.1.pdf + archivo.2.pdf archivo.pdf


📁 Estructura del proyecto
filesplitter/
├─ src/
│   └─ main/
│       ├─ java/
│       │   └─ com/astragroup/filesplitter/
│       │       ├─ application/
│       │       │   ├─ get/
│       │       │   └─ post/
│       │       ├─ infrastructure/controller/
│       └─ resources/
│           ├─ templates/
│           │   ├─ index.html
│           │   └─ resultado.html
│           └─ application.properties
└─ pom.xml


👨‍💻 Autor
Desarrollado por Bernardo Adolfo Cornejo López
📧 bernar2@gmail.com
🔗 LinkedIn (https://www.linkedin.com/in/bernardo-adolfo-cornejo-l%C3%B3pez-878b9855/)
🔗 GitHub(https://github.com/bernar2cl)
