package oecg.gtid232;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner teclado = new Scanner(System.in);
    private static final ProductoService servicio = new ProductoService();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    agregar();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    listar();
                    break;
                case 4:
                    actualizar();
                    break;
                case 5:
                    eliminar();
                    break;
                case 6:
                    System.out.println("Programa terminado.");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 6);

        teclado.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("========== TIENDA UTNG ==========");
        System.out.println("1. Agregar producto");
        System.out.println("2. Buscar producto");
        System.out.println("3. Mostrar productos");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Salir");
    }

    private static void agregar() {
        System.out.println("\n--- AGREGAR PRODUCTO ---");

        String nombre = leerTexto("Nombre: ");
        String descripcion = leerTexto("Descripcion: ");
        double precio = leerDouble("Precio: ");
        int existencia = leerEntero("Existencia: ");

        Producto producto = new Producto(nombre, descripcion, precio, existencia);

        if (servicio.agregarProducto(producto)) {
            System.out.println("Producto agregado correctamente.");
        } else {
            System.out.println("No se pudo agregar el producto.");
        }
    }

    private static void buscar() {
        System.out.println("\n--- BUSCAR PRODUCTO ---");

        int id = leerEntero("ID: ");
        Producto producto = servicio.buscarProducto(id);

        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void listar() {
        System.out.println("\n--- PRODUCTOS ---");

        List<Producto> productos = servicio.listarProductos();

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    private static void actualizar() {
        System.out.println("\n--- ACTUALIZAR PRODUCTO ---");

        int id = leerEntero("ID del producto: ");

        Producto existente = servicio.buscarProducto(id);

        if (existente == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        String nombre = leerTexto("Nombre: ");
        String descripcion = leerTexto("Descripcion: ");
        double precio = leerDouble("Precio: ");
        int existencia = leerEntero("Existencia: ");

        Producto producto = new Producto(id, nombre, descripcion, precio, existencia);

        if (servicio.actualizarProducto(producto)) {
            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el producto.");
        }
    }

    private static void eliminar() {
        System.out.println("\n--- ELIMINAR PRODUCTO ---");

        int id = leerEntero("ID: ");

        if (servicio.eliminarProducto(id)) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el producto.");
        }
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero entero valido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero valido.");
            }
        }
    }
}
