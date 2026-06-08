package interfaz;

public class PagoDTO {

    private String clienteId;
    private String numeroTarjeta;
    private double monto;

    public PagoDTO() {
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public double getMonto() {
        return monto;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}