package controller;

import defunt.Photos;
import defunt.Videos;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.LinkedList;
import java.util.List;

@Path("media")
public class MediaController {
    @POST
    @Path("image")
    @Transactional
    @RolesAllowed({ "User", "Admin" })
    //@Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response enregistrerImage(@QueryParam("id") Long idDefunt, byte[] data){
        //
        Photos photos = new Photos();
        photos.idDef = idDefunt;
        photos.media = data;
        photos.persist();
        //
        return Response.ok().build();
    }

    @GET
    @Path("images")
    @Transactional
    @RolesAllowed({ "User", "Admin" })
    //@Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response getAllImages(@QueryParam("id") Long idDefunt){
        //
        List<Photos> photos = Photos.find("idDef",idDefunt).list();
        List<Long> photos2 = new LinkedList<>();
        //
        photos.forEach((p)->{
            photos2.add(p.id);
        });
        //
        return Response.ok(photos2).build();
    }

    @GET
    @Path("imagedata")
    @Transactional
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @RolesAllowed({ "User", "Admin" })
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response getImage(@QueryParam("id") Long id){
        //
        Photos photo = Photos.findById(id);
        //
        return Response.ok(photo.media).build();
    }

    @POST
    @Path("video")
    @Transactional
    @RolesAllowed({ "User", "Admin" })
    //@Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response enregistrerVideo(@QueryParam("id") Long idDefunt, byte[] data){
        //
        Videos videos = new Videos();
        videos.idDef = idDefunt;
        videos.media = data;
        videos.persist();
        //
        return Response.ok().build();
    }

    @GET
    @Path("videos")
    @Transactional
    @RolesAllowed({ "User", "Admin" })
    //@Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response getAllVideos(@QueryParam("id") Long idDefunt){
        //
        List<Videos> videos = Videos.find("idDef",idDefunt).list();
        List<Long> videos2 = new LinkedList<>();
        //
        videos.forEach((p)->{
            videos2.add(p.id);
        });
        //
        return Response.ok(videos2).build();
    }

    @GET
    @Path("videodata")
    @Transactional
    @Produces(MediaType.MEDIA_TYPE_WILDCARD)
    @RolesAllowed({ "User", "Admin" })
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response getVideo(@QueryParam("id") Long id){
        //
        Videos videos = Videos.findById(id);
        //
        return Response.ok(videos.media).build();
    }

    @DELETE
    @Path("video")
    @Transactional
    @RolesAllowed({ "User", "Admin" })
    //@Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response supprimerVideo(@QueryParam("id") Long idDefunt){
        //
        Videos.deleteById(idDefunt);
        //
        return Response.ok().build();
    }

    @DELETE
    @Path("image")
    @Transactional
    @RolesAllowed({ "User", "Admin" })
    //@Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response supprimerImage(@QueryParam("id") Long idDefunt){
        //
        Photos.deleteById(idDefunt);
        //
        return Response.ok().build();
    }

}
