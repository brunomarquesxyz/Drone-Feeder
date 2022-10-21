package com.feeder.drone.utils;

import java.io.InputStream;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import lombok.Getter;
import lombok.Setter;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

/**
 * The type Multipart body.
 */
@Getter
@Setter
public class MultipartBody {
  /**
   * The File.
   */
  @FormParam("file")
  @PartType(MediaType.APPLICATION_OCTET_STREAM)
  public InputStream file;

  /**
   * The File name.
   */
  @FormParam("fileName")
  @PartType(MediaType.TEXT_PLAIN)
  public String fileName;
}
