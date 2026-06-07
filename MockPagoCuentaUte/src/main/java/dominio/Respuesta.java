package dominio;

public class Respuesta {
    private String estado;
    private String mensaje;
    private String transactionId;
    private String clienteId;
    private String monto;
    private String cuentaUte;

    public Respuesta() {
    }

    public String getEstado() {
        return estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getMonto() {
        return monto;
    }

    public String getCuentaUte() {
        return cuentaUte;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public void setCuentaUte(String cuentaUte) {
        this.cuentaUte = cuentaUte;
    }
}
