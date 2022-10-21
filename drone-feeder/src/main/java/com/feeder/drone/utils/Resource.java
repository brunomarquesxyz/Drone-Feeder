package com.feeder.drone.utils;

import java.io.File;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

/**
 * The type Resource.
 */
public class Resource {
  /**
   * The File.
   */
  @FormParam("file")
  public File file;
}
