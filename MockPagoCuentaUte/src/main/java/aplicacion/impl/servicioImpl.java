package aplicacion.impl;

import aplicacion.servicio;
import dominio.Respuesta;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class servicioImpl implements servicio {

    public Respuesta procesarPago(String cuentaUte,String monto,String clienteID){

        Respuesta r = new Respuesta();

        r.setEstado("ACEPTADO");
        r.setMensaje("Pago procesado correctamente");
        r.setTransactionId("PAY-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        r.setClienteId(clienteID);
        r.setMonto(monto);
        r.setCuentaUte(cuentaUte);

        return r;

    }
}
