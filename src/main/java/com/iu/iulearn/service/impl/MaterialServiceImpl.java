package com.iu.iulearn.service.impl;

import com.iu.iulearn.model.Course;
import com.iu.iulearn.model.Lesson;
import com.iu.iulearn.model.Material;
import com.iu.iulearn.repository.MaterialRepository;
import com.iu.iulearn.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public void addMaterial(Material material) {
        materialRepository.save(material);
    }

    @Override
    public void updateMaterial(Material material) {
        Material materialToUpdate = materialRepository.findById(material.getId()).get();
        if (materialToUpdate != null){
            materialToUpdate.setTitle(material.getTitle());
            materialRepository.save(material);
        }
    }

    @Override
    public void deleteMaterial(int id) {
        materialRepository.deleteById(id);
    }

    @Override
    public Material getMaterialById(int id) {
        return materialRepository.findById(id).get();
    }

    @Override
    public Material getMaterialByTitle(String title) {
        return null;
    }

    @Override
    public Material getMaterialByMaterialUrl(String url) {
        return null;
    }

    @Override
    public Material getMaterialByContent(String content) {
        return null;
    }

    @Override
    public Material getMaterialByLesson(Lesson lesson) {
        return null;
    }

    @Override
    public List<Material> getMaterialByLessonId(int  lessonId) {
        return materialRepository.findByLessonId(lessonId) ;
    }

    @Override
    public Lesson getAllMaterialLesson() {
        return null;
    }

    @Override
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    @Override
    public List<Material> getMaterialByCourseId(int id) {
        return null;
    }
}
