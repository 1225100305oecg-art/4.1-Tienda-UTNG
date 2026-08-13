package oecg.gtid232;


public class PrecioInvalidoException extends RuntimeException {

    private final double precio;

    public PrecioInvalidoException(double precio) {
        super("Precio invalido: " + precio + ". El precio debe ser mayor o igual a 0.");
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
