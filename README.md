# 🏥 Hospital V&M - Ecosistema de Gestión Pro

Bienvenido al sistema integral de gestión hospitalaria **Hospital V&M**. Este proyecto ha sido desarrollado siguiendo los más altos estándares de arquitectura de software, utilizando un patrón **CSR (Controller-Service-Repository)** y un diseño de interfaz de usuario de vanguardia.

## 🚀 Características Principales

### Backend (Spring Boot 3.x)
- **Arquitectura CSR**: Separación clara de responsabilidades para escalabilidad y mantenimiento.
- **Persistencia con JPA/Hibernate**: Integración robusta con MySQL (o Oracle Cloud vía Wallet).
- **Consultas Optimizadas**: Reportes de costos procesados directamente en la base de datos mediante JPQL.
- **Ecosistema de Datos (Seeder)**: Carga automática de médicos, pacientes, tipos de usuario, fichas clínicas y atenciones al iniciar.
- **Documentación OpenAPI/Swagger**: Interfaz interactiva para probar la API en tiempo real.
- **Validaciones Pro**: Intercepción de datos corruptos mediante `@Valid` y `BindingResult`.

### Frontend (Premium Dashboard)
- **Diseño Moderno**: Interfaz basada en **Glassmorphism** y **Dark Mode**.
- **Dashboard Interactivo**: Visualización de estadísticas clave en tiempo real.
- **Gestión de Pacientes**: Formulario integrado para el registro de nuevos pacientes.
- **Tipografía y Estilo**: Uso de la fuente **Outfit** y **FontAwesome** para una estética premium.

## 🛠️ Tecnologías Utilizadas
- **Backend**: Java 17+, Spring Boot, Spring Data JPA, Lombok, Maven.
- **Base de Datos**: MySQL / MariaDB (Laragon).
- **Frontend**: HTML5, CSS3 (Vanilla), JavaScript (Vanilla).
- **Documentación**: Swagger UI (SpringDoc).

## 📂 Estructura del Proyecto
- `/src/main/java/com/hospital/hospitalvm`: Código fuente del backend.
- `/frontend`: Interfaz de usuario moderna.
- `application.properties`: Configuración de base de datos y servidor.

## 🏁 Cómo Ejecutar
1.  **Configurar Base de Datos**: Crea una base de datos llamada `db_hospital_vm` en tu MySQL local.
2.  **Iniciar Backend**: Ejecuta la clase `HospitalVmApplication` desde tu IDE (VS Code).
3.  **Probar API**: Accede a `http://localhost:8080/swagger-ui/index.html`.
4.  **Abrir Frontend**: Abre el archivo `frontend/index.html` en tu navegador favorito.

---
Desarrollado con ❤️ por **Antigravity AI Coding Assistant** para **KRATOSDOOMSLAYER**.
