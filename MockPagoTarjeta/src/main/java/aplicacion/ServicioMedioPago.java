package aplicacion;

import interfaz.PagoDTO;
import interfaz.RespuestaPagoDTO;

public interface ServicioMedioPago {

    RespuestaPagoDTO autorizarPago(PagoDTO pago);
}