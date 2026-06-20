package aplicacion.impl;

import aplicacion.ServicioMedioPago;
import interfaz.PagoDTO;
import interfaz.RespuestaPagoDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Random;
import java.util.UUID;

@ApplicationScoped
public class ServicioMedioPagoImpl implements ServicioMedioPago {

    private static final String TARJETA_APROBADA = "11111111";
    private static final String TARJETA_RECHAZADA = "22222222";

    private final Random random = new Random();

    @Override
    public RespuestaPagoDTO autorizarPago(PagoDTO pago) {

        if (TARJETA_APROBADA.equals(pago.getNumeroTarjeta())) {
            return aprobado(pago);
        }

        if (TARJETA_RECHAZADA.equals(pago.getNumeroTarjeta())) {
            return rechazado(pago, "ERROR_PAGO_RECHAZADO");
        }

        int resultado = random.nextInt(6);

        if (resultado < 5) {
            return aprobado(pago);
        }

        return rechazado(pago, "ERROR_PAGO_RECHAZADO_RANDOM");
    }

    private RespuestaPagoDTO aprobado(PagoDTO pago) {
        String codigo = "AUTH-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        return new RespuestaPagoDTO(
                true,
                codigo,
                "Pago autorizado correctamente",
                pago.getClienteId(),
                pago.getMonto()
        );
    }

    private RespuestaPagoDTO rechazado(PagoDTO pago, String codigoError) {
        return new RespuestaPagoDTO(
                false,
                codigoError,
                "Pago rechazado por el medio de pago",
                pago.getClienteId(),
                pago.getMonto()
        );
    }
}