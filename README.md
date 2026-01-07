TurboMax Motors - Sistema de Venta de Automóviles utilizando Java con Swing 

Sistema de simulación básica de gestión y venta de automóviles, desarrollado con interfaz gráfica en Java Swing. Proyecto académico de fin de curso posteriormente reorganizado y mejorado hacia una aplicación con estructura orientada a objetos y mejores prácticas de programación, resultado de aprendizaje en clase e investigación  adicional. 

Sobre el Proyecto 

Este proyecto comenzó como un trabajo final para un curso de primer ciclo en mi instituto técnico. Posteriormente fue refactorizado para implementar mejores prácticas de programación, incluyendo:
- Programación orientada a objetos
- Gestión de datos mediante clases dedicadas (en memoria)
- Separación de responsabilidades
- Documentación básica con JavaDoc
- Control de versiones utilizando Git

Características
- Inicio de sesión con credenciales predefinidas para acceder al sistema.
- Gestión de automóviles, que permite:
  - Consultar la información detallada de un vehículo.
  - Listar todos los automóviles disponibles en el sistema.
  - Modificar los datos de un automóvil existente.
- Proceso de ventas de vehículos, aplicando cálculos aritméticos según:
  - Precio base del automóvil.
  - Descuentos configurables.
  - Obsequios asociados a la compra.
- Configuración de descuentos, permitiendo modificar los porcentajes aplicables a las ventas.
- Configuración de obsequios, ajustando los beneficios adicionales ofrecidos al cliente.
- Interfaz gráfic basada en diálogos (JDialog), organizada mediante menús y submenús para facilitar la navegación.
- Gestión de datos en memoria, utilizando clases dedicadas que simulan el comportamiento de un sistema.

Tecnologías  Utilizadas 
- Lenguaje: Java SE 8
- Interfaz Gráfica: Java Swing
- IDE: Eclipse
- Control de Versiones: Git y GitHub 
- Patrón de Diseño: Repositorio (gestion de datos en memoria)
- Arquitectura: Programación Orientada a Objetos

Cómo Ejecutar el Proyecto 
Requisitos Previos: 
  - JAVA JDK 8 o superior
  - Eclipse IDE (recomendado) o cualquier IDE compatible con proyectos Java
Pasos de Instalación
1. Clonar el repositorio:
   git clone https://github.com/tu-usuario/turbomax-motors-swing.git
2. Abrir el proyecto en Eclipse
   - Abrir Eclipse
   - Ir a File → Import → Existing Projects into Workspace
   - Seleccionar la carpeta del proyecto
   - Hacer clic en Finish
3. Ejecutar la aplicación
   - Navegar a:
     src/proyecto/Login.java
   - Click derecho sobre el archivo
   - Seleccionar Run As → Java Application

Credenciales de Prueba
Para acceder al sistema, utilice las siguientes credenciales predefinidas:
  - Usuario: admin
  - Contraseña: 1234

Aprendizajes
- Programación Orientada a Objetos: diseño de clases, encapsulamiento, reutilización de código y separación de responsabilidades.
- Patrón Repositorio: centralización y organización de la lógica de acceso a datos para facilitar el mantenimiento y la escalabilidad.
- Java Swing: Creación de interfaces gráficas, manejo de eventos y navegación entre ventanas de diálogos.
- Git y GitHub: control de versiones, manejo de repositorios, commits, sincronización remota y resolución de conflictos básicos.
- Documentación de código: aplicación de buenas prácticas mediante JavaDoc para mejorar la legibilidad y mantenibilidad.
- Refactorización: mejora de código existente manteniendo la funcionalidad original, reduciendo acoplamiento y mejorando la estructura general.

Limitaciones Conocidas 
- Sistema limitado a un conjunto fijo de modelos de automóviles predefinidos.
- Los datos no persisten al cerrar la aplicación (gestión completamente en memoria).
- El sistema de descuento y obsequios utiliza variables estáticas globales.
- No se utiliza una base de datos real.

Autor
Alexander Carrasco 
- Estudiante de Computación e Informática - 4to Ciclo
- Proyecto educativo personal 

Contribuciones 
Este es un proyecto educativo personal reorganizado y mejorado desarrollado como parte de mi proceso de aprendizaje. Actualmente no se aceptan pull requests, pero cualquier comentario, sugerencia o feedback es bienvenido.  
