package oecg.gtid232;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoServiceTest {

    private ProductoDAO dao;
    private ProductoService service;

    @BeforeEach
    void configurar() {
        dao = new ProductoDAO() {

            private final List<Producto> productos = new ArrayList<>();

            {
                productos.add(new Producto(
                        1,
                        "P001",
                        "Laptop",
                        "Laptop HP",
                        10000,
                        5
                ));

                productos.add(new Producto(
                        2,
                        "P002",
                        "Mouse",
                        "Mouse USB",
                        300,
                        10
                ));
            }

            @Override
            public boolean insertar(Producto producto) {
                productos.add(producto);
                return true;
            }

            @Override
            public boolean actualizar(Producto producto) {
                return true;
            }

            @Override
            public boolean eliminar(int id) {
                return true;
            }

            @Override
            public Producto buscarPorId(int id) {
                for (Producto producto : productos) {
                    if (producto.getId() == id) {
                        return producto;
                    }
                }

                return null;
            }

            @Override
            public Optional<Producto> findByCodigo(String codigo) {
                for (Producto producto : productos) {
                    if (producto.getCodigo().equals(codigo)) {
                        return Optional.of(producto);
                    }
                }

                return Optional.empty();
            }

            @Override
            public List<Producto> listar() {
                return productos;
            }
        };

        service = new ProductoService(dao);
    }

    @Test
    void registrar_productoValido_registraCorrectamente() {
        Producto producto = new Producto(
                "P003",
                "Teclado",
                "Teclado mecanico",
                800,
                5
        );

        assertTrue(service.registrar(producto));
    }

    @Test
    void registrar_productoNull_lanzaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.registrar(null)
        );
    }

    @Test
    void registrar_stockNegativo_lanzaIllegalArgumentException() {
        Producto producto = new Producto(
                "P003",
                "Teclado",
                "Teclado",
                800,
                -1
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.registrar(producto)
        );
    }

    @Test
    void registrar_precioNegativo_lanzaPrecioInvalidoException() {
        Producto producto = new Producto(
                "P003",
                "Teclado",
                "Teclado",
                -800,
                5
        );

        PrecioInvalidoException exception = assertThrows(
                PrecioInvalidoException.class,
                () -> service.registrar(producto)
        );

        assertEquals(-800, exception.getPrecio());
    }

    @Test
    void registrar_precioCero_esValido() {
        Producto producto = new Producto(
                "P003",
                "Producto gratis",
                "Prueba",
                0,
                5
        );

        assertTrue(service.registrar(producto));
    }

    @Test
    void registrar_codigoVacio_lanzaIllegalArgumentException() {
        Producto producto = new Producto(
                "",
                "Teclado",
                "Teclado",
                800,
                5
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.registrar(producto)
        );
    }

    @Test
    void vender_productoExistente_reduceStock() {
        Producto producto = service.vender("P001", 2);

        assertEquals(3, producto.getExistencia());
    }

    @Test
    void vender_productoInexistente_lanzaProductoNoEncontradoException() {
        ProductoNoEncontradoException exception = assertThrows(
                ProductoNoEncontradoException.class,
                () -> service.vender("P999", 1)
        );

        assertEquals("P999", exception.getCodigo());
    }

    @Test
    void vender_sinStock_verificaDetallesDeExcepcion() {
        StockInsuficienteException exception = assertThrows(
                StockInsuficienteException.class,
                () -> service.vender("P001", 10)
        );

        assertEquals("P001", exception.getCodigoProducto());
        assertEquals(5, exception.getStockActual());
        assertEquals(10, exception.getCantidadSolicitada());
    }

    @Test
    void vender_cantidadCero_lanzaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.vender("P001", 0)
        );
    }

    @Test
    void vender_cantidadNegativa_lanzaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.vender("P001", -2)
        );
    }

    @Test
    void buscar_productoExistente_regresaProducto() {
        Producto producto = service.buscarProducto(1);

        assertNotNull(producto);
        assertEquals("P001", producto.getCodigo());
    }

    @Test
    void eliminar_idNegativo_lanzaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.eliminarProducto(-1)
        );
    }
}
