package edu.upc.dsa.services;


import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImp;
import edu.upc.dsa.models.Muestras;
import edu.upc.dsa.models.Persona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/covid", description = "Endpoint to Track Service")
@Path("/covid")

public class Covid19Service {

    private Covid19Manager tm;

    public Covid19Service() {
        this.tm = Covid19ManagerImp.getInstance();

    }

    @POST
    @ApiOperation(value = "create a new Persona", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Persona.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/createpersona")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response CreatePersona(Persona p) {

        Persona persona = this.tm.addPersona(p);
        return Response.status(201).entity(persona).build();

    }

    @POST
    @ApiOperation(value = "Extraer Muestra", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Muestras.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/extractmuestra/{idPersona}/{idLab}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response extractMuestra(@PathParam("idPersona") String idPersona, @PathParam("idLab") String idLab , Muestras m) {

        this.tm.extraerMuestra(m, idPersona, idLab);
        return Response.status(201).entity(m).build();
    }

    @GET
    @ApiOperation(value = "procesar muestra", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Muestras.class),
            @ApiResponse(code = 404, message = "Order not found")
    })
    @Path("/procesarmuestra/{idLab}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response procesarMuestra(@PathParam("idLab") String idLab) {

        Muestras m = this.tm.procesarMuestra(idLab);
        return Response.status(201).entity(m).build();
    }

    @GET
    @ApiOperation(value = "Listado de muestras", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Muestras.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Order not found")
    })
    @Path("orderbyusuario/{idPersona}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarMuestras(@PathParam("idPersona") String idPersona) {

        List<Muestras> listaMuestras = this.tm.listarMuestras(idPersona);

        GenericEntity<List<Muestras>> entity = new GenericEntity<List<Muestras>>(listaMuestras) {};
        return Response.status(201).entity(entity).build()  ;

    }


}
