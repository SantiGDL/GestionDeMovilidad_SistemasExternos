package interfaz;

import aplicacion.ServicioMedioPago;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/medioPago")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MedioPagoApi {

    @Inject
    private ServicioMedioPago servicioMedioPago;

    // funcion para verificar formato de cedula -> 1234567-8
    private boolean verificarFormatoCedula(String cedula) {
        return cedula != null && cedula.matches("\\d{7}-\\d");
    }

    // funcion para verificar formato de tarjeta -> debe tener 8 digitos
    private boolean verificarFormatoTarjeta(String numeroTarjeta) {
        return numeroTarjeta != null && numeroTarjeta.matches("\\d{8}");
    }

    //http://localhost:8080/ServicioMedioPagoMock/api/medioPago/autorizar
    @POST
    @Path("/autorizar")
    public Response autorizarPago(PagoDTO pago) {

        if (pago == null) {
            RespuestaPagoDTO respuesta = new RespuestaPagoDTO(
                    false,
                    "ERROR_DATOS_INVALIDOS",
                    "Debe enviar los datos del pago",
                    null,
                    0
            );

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(respuesta)
                    .build();
        }

        if (!verificarFormatoCedula(pago.getClienteId())) {
            RespuestaPagoDTO respuesta = new RespuestaPagoDTO(
                    false,
                    "ERROR_CEDULA_INVALIDA",
                    "La cédula debe tener el formato 1234567-8",
                    pago.getClienteId(),
                    pago.getMonto()
            );

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(respuesta)
                    .build();
        }

        if (!verificarFormatoTarjeta(pago.getNumeroTarjeta())) {
            RespuestaPagoDTO respuesta = new RespuestaPagoDTO(
                    false,
                    "ERROR_TARJETA_INVALIDA",
                    "El número de tarjeta debe tener 8 dígitos",
                    pago.getClienteId(),
                    pago.getMonto()
            );

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(respuesta)
                    .build();
        }

        if (pago.getMonto() <= 0) {
            RespuestaPagoDTO respuesta = new RespuestaPagoDTO(
                    false,
                    "ERROR_MONTO_INVALIDO",
                    "El monto debe ser mayor a cero",
                    pago.getClienteId(),
                    pago.getMonto()
            );

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(respuesta)
                    .build();
        }

        RespuestaPagoDTO respuesta = servicioMedioPago.autorizarPago(pago);

        if (respuesta.isAutorizado()) {
            return Response.ok(respuesta).build();
        }

        return Response.status(Response.Status.PAYMENT_REQUIRED)
                .entity(respuesta)
                .build();
    }
}