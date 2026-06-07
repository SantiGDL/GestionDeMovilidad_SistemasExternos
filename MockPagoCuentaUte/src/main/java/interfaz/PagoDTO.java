package interfaz;

public class PagoDTO {
    private String clienteID;
    private String cuentaUte;
    private String monto;

    public String getClienteID() {
        return clienteID;
    }

    public String getCuentaUte() {
        return cuentaUte;
    }

    public String getMonto() {
        return monto;
    }

    public void setClienteID(String clienteID) {
        this.clienteID = clienteID;
    }

    public void setCuentaUte(String cuentaUte) {
        this.cuentaUte = cuentaUte;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

}
