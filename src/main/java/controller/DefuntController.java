package controller;

import defunt.Defunt;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Past;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Path("defunt")
public class DefuntController {
    //
    @GET
    @Path("{nom}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getAllDefunt(@PathParam("nom") String nom, @PathParam("date") String date){
        //
        //HashMap params = new HashMap();
        //params.put("nom",nom);
        //
        List<Defunt> defunt = Defunt.findAll().list();
        //
        List<Defunt> defunts = new LinkedList();
        //
        defunt.forEach((d)->{
            try {
                System.out.println("d.dateDece: "+d.dateDece+" :: "+(d.nom.toLowerCase().contains(nom.toLowerCase()) || d.postnom.toLowerCase().contains(nom.toLowerCase()) || d.prenom.toLowerCase().contains(nom.toLowerCase()) || d.dateDece.contains(date)));
                if (d.nom.toLowerCase().contains(nom.toLowerCase()) || d.postnom.toLowerCase().contains(nom.toLowerCase()) || d.prenom.toLowerCase().contains(nom.toLowerCase()) || d.dateDece.contains(nom)) {
                    //
                    Defunt defunt1 = new Defunt();
                    defunt1.id = d.id;
                    defunt1.nom = d.nom;
                    defunt1.postnom = d.postnom;
                    defunt1.prenom = d.prenom;
                    defunt1.dateNaissance = d.dateNaissance;
                    defunt1.dateDece = d.dateDece;
                    defunt1.qrcode = d.qrcode;
                    defunt1.idAcces = d.idAcces;
                    defunt1.photoProfile = d.photoProfile;
                    defunt1.cimetiere = d.cimetiere;
                    defunt1.adresseCimetiere = d.adresseCimetiere;

                    //
                    //d.accomplissement = new byte[0];
                    //d.biographie = new byte[0];
                    //d.profile = new byte[0];
                    //d.couverture = new byte[0];
                    defunts.add(defunt1);
                }
            }catch (Exception ex){

            }
        });
        //
        return Response.ok(defunts).build();
        //
    }

    @GET
    @Path("by/{nom}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getAllDefuntBy(@PathParam("nom") String nom){
        //
        HashMap params = new HashMap();
        params.put("nom",nom);
        //
        List<Defunt> defunt = Defunt.findAll().list();
        //
        List<Defunt> defunts = new LinkedList();
        //
        defunt.forEach((d)->{
            try {
                System.out.println("d.dateDece: "+d.dateDece+" :: "+(d.nom.toLowerCase().contains(nom.toLowerCase()) || d.postnom.toLowerCase().contains(nom.toLowerCase()) || d.prenom.toLowerCase().contains(nom.toLowerCase()) || d.dateDece.contains(nom)));
                if (d.nom.toLowerCase().contains(nom.toLowerCase()) || d.postnom.toLowerCase().contains(nom.toLowerCase()) || d.prenom.toLowerCase().contains(nom.toLowerCase()) || d.dateDece.contains(nom)) {
                    Defunt defunt1 = new Defunt();
                    defunt1.id = d.id;
                    defunt1.nom = d.nom;
                    defunt1.postnom = d.postnom;
                    defunt1.prenom = d.prenom;
                    defunt1.dateNaissance = d.dateNaissance;
                    defunt1.dateDece = d.dateDece;
                    defunt1.qrcode = d.qrcode;
                    defunt1.idAcces = d.idAcces;
                    defunt1.photoProfile = d.photoProfile;
                    defunt1.cimetiere = d.cimetiere;
                    defunt1.adresseCimetiere = d.adresseCimetiere;

                    //
                    //d.accomplissement = new byte[0];
                    //d.biographie = new byte[0];
                    //d.profile = new byte[0];
                    //d.couverture = new byte[0];
                    defunts.add(defunt1);
                }
            }catch (Exception ex){

            }
        });
        //
        return Response.ok(defunts).build();
        //
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getAllDefunts(){
        //
        List<Defunt> defunts = Defunt.findAll().list();
        //
        return Response.ok(defunts).build();
        //
    }
    //
    @PUT
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getProfile(Defunt defunt){
        //
        Defunt defunt1 = Defunt.findById(defunt.id);
        //
        defunt1.nom = defunt.nom;
        defunt1.postnom = defunt.postnom;
        defunt1.prenom = defunt.prenom;
        defunt1.dateNaissance = defunt.dateNaissance;
        defunt1.dateDece = defunt.dateDece;
        defunt1.idAcces = defunt.idAcces;
        //
        return Response.ok().build();
        //
    }

    //
    @GET
    @Path("one/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getOneDefunt(@PathParam("id") Long id){
        //
        Defunt defunt = Defunt.findById(id);
        //
        HashMap def = new HashMap();
        //
        def.put("id",defunt.id);
        def.put("photoProfile",defunt.photoProfile);
        def.put("nom",defunt.nom);
        def.put("postnom",defunt.postnom);
        def.put("prenom",defunt.prenom);
        def.put("dateDece",defunt.dateDece);
        def.put("dateNaissance",defunt.dateNaissance);
        def.put("cimetiere",defunt.cimetiere);
        def.put("adresseCimetiere",defunt.adresseCimetiere);
        def.put("qrcode",defunt.qrcode);
        def.put("idAcces",defunt.idAcces);
        //defunt.profile = new byte[0];
        //
        return Response.ok(def).build();
        //
    }

    @GET
    @Path("scan")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getScanQrCode(@QueryParam("qrcode") String qrcode){
        //
        Defunt defunt = Defunt.find("qrcode",qrcode).firstResult();
        if(defunt != null){
            //
            //defunt.profile = new byte[0];
            //
            HashMap def = new HashMap();

            def.put("id",defunt.id);
            def.put("photoProfile",defunt.photoProfile);
            def.put("nom",defunt.nom);
            def.put("postnom",defunt.postnom);
            def.put("prenom",defunt.prenom);
            def.put("dateDece",defunt.dateDece);
            def.put("dateNaissance",defunt.dateNaissance);
            def.put("cimetiere",defunt.cimetiere);
            def.put("adresseCimetiere",defunt.adresseCimetiere);
            def.put("qrcode",defunt.qrcode);
            def.put("idAcces",defunt.idAcces);

            return Response.ok(def).build();
            //
        }else{
            return Response.status(404).build();
        }
    }

    @GET
    @Path("profile")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getProfile(@QueryParam("id") Long id){
        //
        Defunt defunt = Defunt.findById(id);
        //
        return Response.ok(defunt.profile).build();
        //
    }

    @GET
    @Path("checkprofile")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getCheckProfile(@QueryParam("id") Long id){
        //
        Defunt defunt = Defunt.findById(id);
        //
        HashMap rep = new HashMap();
        rep.put("photoProfile",defunt.photoProfile);
        rep.put("id",defunt.id);
        //
        return Response.ok(rep).build();
        //
    }

    @PUT
    @Path("profile")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getProfile(@QueryParam("id") Long id, byte[] photo){
        //
        Defunt defunt = Defunt.findById(id);
        //
        defunt.profile = photo;
        defunt.photoProfile = true;
        //
        return Response.ok().build();
        //
    }

    @POST
    @Transactional
    //@Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response enregistrer(Defunt defunt){
        //
        defunt.persist();
        //
        return Response.ok().build();
    }

    @POST
    @Path("liste")
    @Transactional
    //@Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response getAllDefOf(List<String> defs){
        //
        System.out.println("defs: "+defs.size());
        System.out.println("defs: "+defs.get(0));
        //
        List<HashMap> defunts = new LinkedList<>();
        defs.forEach((d)->{
            //
            Defunt defun = Defunt.find("idAcces",d).firstResult();
            if(defun != null) {
                //
                HashMap defunt = new HashMap();
                defunt.put("id", defun.id);
                defunt.put("photoProfile", defun.photoProfile);
                defunt.put("nom", defun.nom);
                defunt.put("postnom", defun.postnom);
                defunt.put("prenom", defun.prenom);
                defunt.put("dateNaissance", defun.dateNaissance);
                defunt.put("dateDece", defun.dateDece);
                defunt.put("code", d);
                defunts.add(defunt);
            }
        });
        //
        return Response.ok(defunts).build();
    }

}
