package controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import models.Device;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Path("device")
public class DeviceController {

    @GET
    @Path("all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDevices() {
        //
        return Response.ok(Device.listAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDevicesSaved(List<Device> devices) {
        //
        List<Device> dev = new LinkedList<>();
        //

        devices.forEach((d) -> {
            //Je vérifie
            HashMap params = new HashMap();
            params.put("mac", d.mac);
            params.put("name", d.name);

            Device device = (Device) Device.find("mac =: mac and name =: name", params).firstResult();
            if(device != null){
                dev.add(device);
            }
        });

        return Response.ok(dev).build();
    }

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getDeviceSave(Device device) {
        //
        device.persist();
        //
        return Response.ok("Enregistrement éffectué").build();
    }

    @POST
    @Path("saveall")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getDeviceSave(List<Device> devices) {
        //
        devices.forEach((device -> {
            device.persist();
        }));
        //
        return Response.ok("Enregistrement éffectué").build();
    }

}
