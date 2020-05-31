package com.iu.iulearn.controller;


import com.iu.iulearn.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
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



}
