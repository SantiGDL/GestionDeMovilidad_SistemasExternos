package aplicacion;

import dominio.Respuesta;

public interface servicio {

    Respuesta procesarPago(String cuentaUte,String monto,String clienteID);
}
