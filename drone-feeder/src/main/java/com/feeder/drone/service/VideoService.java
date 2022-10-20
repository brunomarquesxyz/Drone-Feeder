package com.feeder.drone.service;

import com.feeder.drone.entity.Video;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@ApplicationScoped
public class VideoService {
  @Transactional
  public void createVideo(MultipartForm file) {
    var video = new Video();
  }

  public List<Video> getAllVideos() {
    return Video.listAll();
  }

  public Video getVideoByName(String videoName) {
    return Video.findVideoByName(videoName);
  }

  @Transactional
  public Video updateVideo(Long id, Video videoToUpdate) {
    Video entity = Video.findById(id);

    /* Video.update("path = ?1 WHERE id = ?2", videoToUpdate.getPath(), id); */
    Video.update("name = ?1 WHERE id = ?2", videoToUpdate.getName(), id);

    return entity;
  }

  @Transactional
  public Boolean deleteVideo(Long videoId) {
    return Video.deleteById(videoId);
  }
}
