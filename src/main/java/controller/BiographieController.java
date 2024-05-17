package controller;

import defunt.Biographie;
import defunt.Photos;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("biographie")
public class BiographieController {

    @POST
    @Transactional
    //@RolesAllowed({ "User", "Admin" })
    //@Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response enregistrerImage(@QueryParam("id") Long idDefunt, String data){
        //
        Biographie biographie = Biographie.find("idDef",idDefunt).firstResult();
        //
        if(biographie == null) {
            //
            Biographie biographie2 = new Biographie();
            biographie2.idDef = idDefunt;
            biographie2.text = data;
            biographie2.persist();
        }else {
            biographie.text = data;
        }
        //
        return Response.ok().build();
    }

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    //@RolesAllowed({ "User", "Admin" })
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response getImage(@QueryParam("id") Long id){
        //
        Biographie biographie = Biographie.find("idDef",id).firstResult();
        if(biographie != null){
            return Response.ok(biographie.text).build();
        }else{
            return Response.status(404).entity("").build();
        }
        //
    }

}
