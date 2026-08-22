# Tienda UTNG

Proyecto de **Programación Orientada a Objetos** para la gestión de productos mediante **Java, JDBC y MySQL**.

El sistema permite realizar operaciones CRUD sobre productos, utilizando una arquitectura organizada mediante DAO y Service, conexión a una base de datos MySQL y excepciones personalizadas para controlar errores específicos.

---

## Funciones

El sistema cuenta con las siguientes funciones principales:

- Agregar producto.
- Buscar producto por ID.
- Listar todos los productos.
- Actualizar producto.
- Eliminar producto.
- Validar precios.
- Validar stock disponible.
- Controlar productos que no existen.
- Realizar pruebas unitarias de las funcionalidades principales.

---

## Tecnologías

El proyecto utiliza las siguientes tecnologías:

- **Java 11**
- **Maven**
- **JDBC**
- **MySQL**
- **JUnit**
- **Git / GitHub**
- **NetBeans**

---

## Arquitectura del proyecto

El proyecto utiliza una estructura basada en diferentes responsabilidades:

### Modelo

La clase `Producto.java` representa la información de un producto.

Contiene los datos principales del producto y sus métodos correspondientes para consultar y modificar sus valores.

### DAO

La interfaz `ProductoDAO.java` define las operaciones que se pueden realizar sobre los productos.

La clase `ProductoDAOImpl.java` implementa dichas operaciones utilizando JDBC para comunicarse con MySQL.

### Service

La clase `ProductoService.java` contiene la lógica de negocio del sistema.

Esta capa utiliza el DAO para realizar las operaciones y permite aplicar las validaciones necesarias antes de modificar la información.

### Conexión

La clase `ConexionDB.java` se encarga de establecer la conexión entre Java y MySQL mediante JDBC.

### Principal

La clase `Main.java` contiene el punto de entrada del programa y permite ejecutar el sistema.

### Pruebas

El proyecto contiene clases para realizar pruebas de las funcionalidades:

- `PersonaTest.java`
- `ProductoServiceTest.java`

---

## Estructura

```text
4.1-Tienda-UTNG/
│
├── pom.xml
├── script.sql
├── .gitignore
├── README.md
├── LEAME.md
│
└── src/
    └── main/
        └── java/
            └── oecg/
                └── gtid232/
                    │
                    ├── ConexionDB.java
                    ├── Main.java
                    ├── Persona.java
                    ├── PersonaTest.java
                    ├── PrecioInvalidoException.java
                    ├── Producto.java
                    ├── ProductoDAO.java
                    ├── ProductoDAOImpl.java
                    ├── ProductoNoEncontradoException.java
                    ├── ProductoService.java
                    ├── ProductoServiceTest.java
                    └── StockInsuficienteException.java
