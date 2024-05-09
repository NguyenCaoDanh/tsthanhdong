package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.entity.SpecializedClass;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.repository.SpecializedClassRepository;
import com.thanhdong.tuyensinh.service.SpecializedClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SpecializedClassServiceImpl implements SpecializedClassService {
    @Autowired
    private final SpecializedClassRepository specializedClassRepository;
    @Override
    public void save(SpecializedClass specializedClass) {
        try{
            specializedClassRepository.save(specializedClass);
        }catch (Exception e){
            throw new ErrorHandler("Cant save specialized class: "+ e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        throw new ErrorHandler("Can't delete specialized class with id: "+id);
    }

    @Override
    public List<SpecializedClass> findAll() {
        try{
            return specializedClassRepository.findAll();
        }catch (Exception e){
            throw new ErrorHandler("Can't find all Specialized Class: "+e.getMessage());
        }
    }

    @Override
    public SpecializedClass findOne(int id) {
        try{
            return specializedClassRepository.findById(id).orElseThrow(()->new ErrorHandler("Cannot find Specialized Class By id: "+id));
        }catch (Exception e){
            throw  new ErrorHandler("Can't find Specialized Class By Id: "+id);
        }
    }

}
