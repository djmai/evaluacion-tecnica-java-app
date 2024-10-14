<img width="300px" align="right" alt="logo_mmmv" src="https://mmartinezdev.com/wp-content/uploads/2023/05/cropped-Red-M-Letter-Mosaic-Logo-Template-2-100x62.png">

# Evaluación Técnica JAVA App

Prueba técnica de una aplicación en Java que incluye funcionalidades de gestión de usuarios e inventarios

## Descripción

Prueba técnica de una aplicación en Java que incluye funcionalidades de gestión de usuarios e inventarios.

#### MTIE. Miguel Manuel Martínez Vázquez

![Versión](https://img.shields.io/badge/Versión-0.0.1-blue.svg)  ![GitHub User's stars](https://img.shields.io/github/stars/djmai)

[![donate](https://www.paypalobjects.com/es_ES/i/btn/btn_donate_SM.gif)](https://paypal.me/IngMiguelMartinez?locale.x=es_XC)  [![Whatsapp](https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white)](https://wa.link/7trr5f) 
![YouTube Channel Views](https://img.shields.io/youtube/channel/views/UCs-r-rohe5U2qoxI-m0QZIg) ![YouTube Channel Subscribers](https://img.shields.io/youtube/channel/subscribers/UCs-r-rohe5U2qoxI-m0QZIg)

### Funcionalidades

- Administración de inventario de productos
- Adminsitración de usuarios
- Historial de entradas y salidas de productos

### Requisitos de Instalación

1. Entorno de Desarrollo
   - NetBeans IDE (versión recomendada: 12.6 o superior)
   - JDK (Java Development Kit) (versión 8 o superior)

2. Servidor de Aplicaciones
   - GlassFish (versión recomendada: 5.1 o superior): Servidor de aplicaciones donde se despliega la aplicación web Java.

3. Base de Datos
   - MySQL (versión recomendada: 5.7 o superior)
   - Conector JDBC para MySQL


### Pasos de Instalación

1. Clona el repositorio.

   ```bash
   git clone https://github.com/djmai/evaluacion-tecnica-java-app.git
   ```

2.  Importar el Proyecto en NetBeans
    - Abre NetBeans.
    - En la barra de menú, selecciona File > Open Project...
    - Navega hasta la carpeta donde clonaste el repositorio y selecciona el proyecto.
    - Una vez cargado, NetBeans detectará automáticamente la estructura del proyecto si está bien configurado.

3. Configurar la Base de Datos MySQL
   - Asegúrate de que MySQL esté instalado y funcionando en tu máquina.
   - Accede a MySQL con tu cliente de base de datos (como MySQL Workbench o la línea de comandos de MySQL).
   - Dentro de la carpeta SCRIPTS del proyecto clonado, encontrarás los scripts SQL necesarios para crear la base de datos y poblarla con datos de prueba.
   - Ejecuta los scripts que se encuentran en la carpeta SCRIPTS en el siguiente orden:
     - Crear la base de datos y las tablas: Usa el script para crear las tablas necesarias.
      
      ```sql
      01_castores_db.sql -  Archivo para crear la DB
      02_data_castores_db.sql -   Archivo para insertar los datos a la db
      ```

     - Insertar datos iniciales: Si hay un script para poblar la base de datos con datos iniciales, ejecútalo.
  
4. Configurar el Servidor GlassFish
   - Asegúrate de que GlassFish esté instalado en tu máquina y configurado correctamente en NetBeans.
   - En NetBeans:
     - Ve a Tools > Servers.
     - Selecciona GlassFish y configúralo si es necesario, proporcionando la ruta de instalación.
     - Verifica que GlassFish esté configurado como el servidor predeterminado para este proyecto.

__NOTA__: <em>Antes de ejecutar el proyecto hay que verificar que las credenciales de conexion a MySQL sean las correctas o las mismas que estan en el archivo DatabaseConnection.java</em>

<em>Este archivo se encuenta en la ruta "Sources Packages/Config/DatabaseConnection"</em>

   ```php
   Los datos a modificar son los siguientes:

      - private static final String URL = "jdbc:mysql://localhost:3306/castores_db?autoReconnect=true&useSSL=false";
      - private static final String USER = "toor";  // Cambia esto por tu usuario de MySQL
      - private static final String PASSWORD = "root";  // Cambia esto por tu contraseña de MySQL
   ```

5. Construir y Ejecutar el Proyecto en NetBeans
   - En NetBeans, haz clic derecho sobre el proyecto y selecciona Clean and Build.
   - Después de la compilación, haz clic derecho nuevamente en el proyecto y selecciona Run. Esto iniciará la aplicación en el servidor GlassFish.
  
6. Acceder a la Aplicación
   - Una vez que el proyecto esté ejecutándose en GlassFish, abre un navegador web y ve a la dirección que has configurado. Por ejemplo:
  
      ```
      http://localhost:8080/nombre_proyecto
      ```
   Si todo salio correcto la aplicación debera mostrar el login inicial

7. Iniciar sesión
   - El sistema en su punto inicial al momento cuenta con usuarios registrados, con los cuales se puede validar su inicio de sesión y acceder al sistema
   
      ```
      juan.perez@empresa.com	password123	1	activo
      ana.gomez@empresa.com	password456	2	activo
      carlos.ruiz@empresa.com	password789	2	inactivo
      ```
   - Roles de los usuarios son dos (Administrador, Almacenista)

      | Permiso                             	| Administrador 	| Almacenista 	|
      |-------------------------------------	|---------------	|-------------	|
      | Ver módulo inventario               	|  ✓ |  ✓  |
      | Agregar nuevos productos            	|  ✓ |  X  |
      | Aumentar inventario                 	|  ✓ |  X  |
      | Dar de baja/reactivar un producto   	|  ✓ |  X  |
      | Ver módulo para Salida de productos 	|  X  |  ✓ |
      | Sacar inventario del almacén        	|  X  |  ✓ |
      | Ver módulo del histórico            	|  ✓ |  ✓ |
   


### Autores ✒️

_Nuestros colaboradores hasta el momento_

- **MTIE. Miguel Martinez** - [GitHub](https://github.com/djmai) - [Facebook](https://fb.com/mmmv8) - [Linkedin](https://linkedin.com/in/mmartinezdev)


### Gratitud 🎁

Muchas gracias por acceder y poder ver lo que es parte de mi trabajo, y no te olvides de:

- Comentar a otros sobre este proyecto 📢
- Invitar una cerveza 🍺 o un café ☕ a alguien del equipo.
- Dar las gracias públicamente 🤓.

---

⌨️ con ❤️ por [MTIE. Miguel Martinez](https://github.com/djmai) 😊

#### MTIE. Miguel Manuel Martínez Vázquez

[![donate](https://www.paypalobjects.com/es_ES/i/btn/btn_donate_SM.gif)](https://paypal.me/IngMiguelMartinez?locale.x=es_XC)
[![Whatsapp](https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white)](https://wa.link/7trr5f)
![YouTube Channel Views](https://img.shields.io/youtube/channel/views/UCs-r-rohe5U2qoxI-m0QZIg)
![YouTube Channel Subscribers](https://img.shields.io/youtube/channel/subscribers/UCs-r-rohe5U2qoxI-m0QZIg)