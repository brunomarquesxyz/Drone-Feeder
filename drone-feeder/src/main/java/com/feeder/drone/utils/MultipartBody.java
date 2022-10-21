package com.feeder.drone.utils;

import java.io.InputStream;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import lombok.Getter;
import lombok.Setter;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

@Getter
@Setter
public class MultipartBody {
  @FormParam("file")
  @PartType(MediaType.APPLICATION_OCTET_STREAM)
  public InputStream file;

  @FormParam("fileName")
  @PartType(MediaType.TEXT_PLAIN)
  public String fileName;
}
