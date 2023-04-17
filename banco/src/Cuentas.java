public class Cuentas {
    private int[] movimientos;
    private TiposCuenta tiposCuenta;

    public Cuentas(int[] movimientos, TiposCuenta tiposCuenta) {
        this.movimientos = movimientos;
        this.tiposCuenta = tiposCuenta;
    }

    public int[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(int[] movimientos) {
        this.movimientos = movimientos;
    }

    public TiposCuenta getTiposCuenta() {
        return tiposCuenta;
    }

    public void setTiposCuenta(TiposCuenta tiposCuenta) {
        this.tiposCuenta = tiposCuenta;
    }
}
