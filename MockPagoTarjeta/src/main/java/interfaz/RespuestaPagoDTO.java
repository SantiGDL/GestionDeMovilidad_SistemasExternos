package interfaz;

public class RespuestaPagoDTO {

    private boolean autorizado;
    private String codigo;
    private String mensaje;
    private String clienteId;
    private double monto;

    public RespuestaPagoDTO() {
    }

    public RespuestaPagoDTO(boolean autorizado, String codigo, String mensaje, String clienteId, double monto) {
        this.autorizado = autorizado;
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.clienteId = clienteId;
        this.monto = monto;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getClienteId() {
        return clienteId;
    }

    public double getMonto() {
        return monto;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}