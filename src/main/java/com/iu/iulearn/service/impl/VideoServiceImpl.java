package com.iu.iulearn.service.impl;


import com.iu.iulearn.model.Course;
import com.iu.iulearn.model.Lesson;
import com.iu.iulearn.model.Video;
import com.iu.iulearn.repository.VideoRepository;
import com.iu.iulearn.service.MaterialService;
import com.iu.iulearn.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public void addVideo(Video video) {
        videoRepository.save(video);
    }

    @Override
    public void updateVideo(Video video) {
        Video videoToUpdate = videoRepository.findById(video.getId()).get();
        if (videoToUpdate != null){
            videoToUpdate.setTitle(video.getTitle());
            videoRepository.save(video);
        }
    }

    @Override
    public void deleteVideo(int id) {
        videoRepository.deleteById(id);
    }

    @Override
    public Video getVideoById(int id) {
        return videoRepository.findById(id).get();
    }

    @Override
    public Video getVideoByTitle(String title) {
        return null;
    }

    @Override
    public Video getVideoByUrl(String url) {
        return null;
    }

    @Override
    public Video getVideoByTimeCount(int timeCount) {
        return null;
    }

    @Override
    public Video getVideoByCourse(Course course) {
        return null;
    }

    @Override
    public Lesson getAllVideoLesson() {
        return null;
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @Override
    public List<Video> getVideoByLessonId(int lessonId) {
        return videoRepository.findByLessonId(lessonId) ;
    }
}
