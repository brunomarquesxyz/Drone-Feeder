package com.feeder.drone.service;

import com.feeder.drone.entity.Video;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

/**
 * The type Video service.
 */
@ApplicationScoped
public class VideoService {
  /**
   * Create video.
   *
   * @param file the file
   */
  @Transactional
  public void createVideo(MultipartForm file) {
    var video = new Video();
  }

  /**
   * Gets all videos.
   *
   * @return the all videos
   */
  public List<Video> getAllVideos() {
    return Video.listAll();
  }

  /**
   * Gets video by name.
   *
   * @param videoName the video name
   * @return the video by name
   */
  public Video getVideoByName(String videoName) {
    return Video.findVideoByName(videoName);
  }

  /**
   * Update video video.
   *
   * @param id            the id
   * @param videoToUpdate the video to update
   * @return the video
   */
  @Transactional
  public Video updateVideo(Long id, Video videoToUpdate) {
    Video entity = Video.findById(id);

    /* Video.update("path = ?1 WHERE id = ?2", videoToUpdate.getPath(), id); */
    Video.update("name = ?1 WHERE id = ?2", videoToUpdate.getName(), id);

    return entity;
  }

  /**
   * Delete video boolean.
   *
   * @param videoId the video id
   * @return the boolean
   */
  @Transactional
  public Boolean deleteVideo(Long videoId) {
    return Video.deleteById(videoId);
  }
}
