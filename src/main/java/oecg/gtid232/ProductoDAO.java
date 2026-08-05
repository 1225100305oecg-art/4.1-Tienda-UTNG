package oecg.gtid232;

import java.util.List;

public interface ProductoDAO {

    boolean insertar(Producto producto);

    boolean actualizar(Producto producto);

    boolean eliminar(int id);

    Producto buscarPorId(int id);

    List<Producto> listar();
}
