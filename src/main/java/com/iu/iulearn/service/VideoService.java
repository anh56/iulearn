package com.iu.iulearn.service;

import com.iu.iulearn.model.Course;
import com.iu.iulearn.model.Video;

import java.util.List;

public interface VideoService {
    void addVideo(Video video);
    void updateVideo(Video video);
    void deleteVideo(int id);
    Video getVideoById(int id);
    Video getVideoByTitle(String title);
    Video getVideoByUrl(String url);
    Video getVideoByTimeCount(int timeCount);
    Video getVideoByCourse(Course course);
    Course getAllVideoCourse();
    List<Video> getAllVideos();
}
