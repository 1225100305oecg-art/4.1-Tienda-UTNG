# Tienda UTNG

Proyecto de Programación Orientada a Objetos para la gestión de productos mediante Java, JDBC y MySQL.

## Funciones

- Agregar producto
- Buscar producto por ID
- Listar productos
- Actualizar producto
- Eliminar producto

## Tecnologías

- Java 11
- Maven
- JDBC
- MySQL
- Git / GitHub

## Estructura

```text
usodegit/
├── pom.xml
├── script.sql
├── .gitignore
├── README.md
└── src/
    └── main/
        └── java/
            └── oecg/
                └── gtid232/
                    ├── ConexionDB.java
                    ├── Producto.java
                    ├── ProductoDAO.java
                    ├── ProductoDAOImpl.java
                    ├── ProductoService.java
                    └── Main.java
```

## Base de datos

Ejecuta primero `script.sql` en MySQL.

La conexión está configurada para:

- Host: `localhost`
- Puerto: `3306 o 3245`
- Base de datos: `utng_tienda`
- Usuario: `root`
- Contraseña: `enrique`

Si tu contraseña de MySQL es diferente, modifica `ConexionDB.java`.

## Ejecución

En NetBeans:

1. Abre el proyecto como proyecto Maven.
2. Espera a que Maven descargue `mysql-connector-j`.
3. Ejecuta `Main.java`.

Desde terminal:

```bash
mvn clean compile
```

Para ejecutar el programa desde NetBeans, haz clic derecho sobre `Main.java` y selecciona **Run File**.

## Git

Los commits de la actividad pueden realizarse después de comprobar que el proyecto compila y que la conexión con MySQL funciona.

## Documentación de Git

El proyecto utiliza Git para el control de versiones y GitHub
para almacenar el repositorio y gestionar cambios mediante ramas
y Pull Requests.