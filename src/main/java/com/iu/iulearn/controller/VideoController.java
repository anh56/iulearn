package com.iu.iulearn.controller;


import com.iu.iulearn.model.Video;
import com.iu.iulearn.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/video")
public class VideoController {

    @Autowired
    private VideoService videoService;


    @GetMapping("/all")
    public Object getAllVideo(){
        try {
            return new ResponseEntity<>(videoService.getAllVideos(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/{id}")
    public Object getVideoById(@PathVariable int id){
        try {
            return new ResponseEntity<>(videoService.getVideoById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    public Object getVideoByLessionId(@RequestParam int lessonId){
        try {
            return new ResponseEntity<>(videoService.getVideoByLessonId(lessonId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public Object addMaterial(@RequestBody Video video) {
        try {
            videoService.addVideo(video);
            return new ResponseEntity<>("Video added", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Video add failed with exception: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }



    @PutMapping("/{id}")
    public Object updateVideo(@PathVariable int id, @RequestBody Video video) {
        try {
            video.setId(id);
            videoService.updateVideo(video);
            return new ResponseEntity<>("Updated video with id: " + id + " successful", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Update video with id: " + id + "failed with exception: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public Object deleteVideo(@PathVariable int id){
        try {
            videoService.deleteVideo(id);
            return new ResponseEntity<>("Deleted material with id: "+id, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>("Delete material with id: "+id+" failed with exception: "+e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }



}
