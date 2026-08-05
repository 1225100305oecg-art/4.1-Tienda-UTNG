package oecg.gtid232;

import java.util.List;

public class ProductoService {

    private final ProductoDAO dao;

    public ProductoService() {
        dao = new ProductoDAOImpl();
    }

    public boolean agregarProducto(Producto producto) {
        return dao.insertar(producto);
    }

    public boolean actualizarProducto(Producto producto) {
        return dao.actualizar(producto);
    }

    public boolean eliminarProducto(int id) {
        return dao.eliminar(id);
    }

    public Producto buscarProducto(int id) {
        return dao.buscarPorId(id);
    }

    public List<Producto> listarProductos() {
        return dao.listar();
    }
}
