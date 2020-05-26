package com.iu.iulearn.service;

import com.iu.iulearn.model.Course;
import com.iu.iulearn.model.Lesson;
import com.iu.iulearn.model.Material;

import java.util.List;

public interface MaterialService {
    void addMaterial(Material material);
    void updateMaterial(Material material);
    void deleteMaterial(int id);
    Material getMaterialById(int id);
    Material getMaterialByTitle(String title);
    Material getMaterialByMaterialUrl(String url);
    Material getMaterialByContent(String content);
    Material getMaterialByLesson(Lesson lesson);
    List<Material> getMaterialByLessonId(int lessonId);

    Lesson getAllMaterialLesson();
    List<Material> getAllMaterials();
    List<Material> getMaterialByCourseId(int id);
}
