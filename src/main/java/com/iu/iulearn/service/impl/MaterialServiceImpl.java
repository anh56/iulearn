package com.iu.iulearn.service.impl;

import com.iu.iulearn.model.Course;
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

    }

    @Override
    public void updateMaterial(Material material) {

    }

    @Override
    public void deleteMaterial(int id) {

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
    public Material getMaterialByCourse(Course course) {
        return null;
    }

    @Override
    public List<Material> getMaterialByCourseId(int  coursedId) {
        return materialRepository.findByCourseId(coursedId) ;
    }

    @Override
    public Course getAllMaterialCourse() {
        return null;
    }

    @Override
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }
}
