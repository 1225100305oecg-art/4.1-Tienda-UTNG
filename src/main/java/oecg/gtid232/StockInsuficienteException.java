package oecg.gtid232;

public class StockInsuficienteException extends RuntimeException {

    private final String codigoProducto;
    private final int stockActual;
    private final int cantidadSolicitada;

    /
    public StockInsuficienteException(String codigoProducto, int stockActual, int cantidadSolicitada) {
        super(String.format(
                "Stock insuficiente para el producto %s. Stock actual: %d, cantidad solicitada: %d",
                codigoProducto,
                stockActual,
                cantidadSolicitada
        ));

        this.codigoProducto = codigoProducto;
        this.stockActual = stockActual;
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public int getStockActual() {
        return stockActual;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }
}
