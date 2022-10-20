package com.feeder.drone.rest;

import com.feeder.drone.entity.Video;
import com.feeder.drone.service.VideoService;
import com.feeder.drone.utils.MultipartBody;
import com.feeder.drone.utils.Resource;
import com.sun.mail.iap.ByteArray;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.annotations.jaxrs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/video")
public class VideoResource {

  @Inject
  VideoService videoService;

 /*  @POST
  @Path(value = "/{deliveryId}")
  @FormParam("file")
  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.MULTIPART_FORM_DATA})
  public Response createVideo(@PathParam("deliveryId") long deliveryId, @MultipartForm Resource file) {
    MultipartBody videoFile = new MultipartBody();
    videoFile.setFile(file.file.getCanonicalFile());

  } */

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllVideos() {
    List<Video> allVideos = videoService.getAllVideos();
    return Response.ok(allVideos).build();
  }

  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVideoById(@PathParam("name") String videoName) {
    Video videoRegistered = videoService.getVideoByName(videoName);
    return Response.ok(videoRegistered).build();
  }
}
