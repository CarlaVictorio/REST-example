package edu.upc.dsa.services;


import edu.upc.dsa.PartidasManager;
import edu.upc.dsa.PartidasManagerImpl;
import edu.upc.dsa.models.Juego;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/tracks", description = "Endpoint to Track Service")
@Path("/tracks")
public class PartidasService {

    private PartidasManager tm; //Gestor de la capa Integration

    public PartidasService() {
        this.tm = PartidasManagerImpl.getInstance();
        if (tm.size()==0) {
            this.tm.addTrack("La Barbacoa", "Georgie Dann");
            this.tm.addTrack("Despacito", "Luis Fonsi");
            this.tm.addTrack("Enter Sandman", "Metallica");
        }


    }

    @GET //es el seu mètode associat
    @ApiOperation(value = "get all Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Juego.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracks() {

        List<Juego> tracks = this.tm.findAll();

        GenericEntity<List<Juego>> entity = new GenericEntity<List<Juego>>(tracks) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Juego.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("id") String id) {
        Juego t = this.tm.getTrack(id); //TM es un gestor, està a la capa Integration
        if (t == null) return Response.status(404).build(); //si no hi ha track
        else  return Response.status(201).entity(t).build(); // si hi ha track, empaqueto i envio amb un 201,
                                                            // monta la frase directament amb la resposta en JSON
    }

    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Juego t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteTrack(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(Juego track) {

        Juego t = this.tm.updateTrack(track); //crida a la capa d'abaix per actualitzar el Track

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Juego.class), //tot bé
            @ApiResponse(code = 500, message = "Validation Error") //error de validació

    })

    @Path("/")  //arriba una instancia/objecte buit, es crea automàticamente, no arriba un JSON
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Juego track) {

        if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();
        this.tm.addTrack(track);
        return Response.status(201).entity(track).build();
    }

}