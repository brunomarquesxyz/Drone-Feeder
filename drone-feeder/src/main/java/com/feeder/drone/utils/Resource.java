package com.feeder.drone.utils;

import java.io.File;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

public class Resource {
  @FormParam("file")
  public File file;
}
