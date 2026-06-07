package interfaz;

import aplicacion.servicio;
import dominio.Respuesta;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/medioPago")
public class PagoApi {

    @Inject
    private servicio servicios;

    @POST
    @Path("/pagar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response procesarPago(PagoDTO dto){
        Respuesta r = servicios.procesarPago(dto.getCuentaUte(),dto.getMonto(),dto.getClienteID());
        return Response
                .status(Response.Status.CREATED)
                .entity(r)
                .build();
    }
}
