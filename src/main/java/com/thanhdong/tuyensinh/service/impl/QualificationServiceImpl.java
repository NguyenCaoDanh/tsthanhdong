package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.entity.Qualification;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.repository.QualificationRepository;
import com.thanhdong.tuyensinh.service.QualificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QualificationServiceImpl implements QualificationService {
    @Autowired
    private final QualificationRepository qualificationRepository;

    @Override
    public void save(Qualification qualification) {
        try {
            qualificationRepository.save(qualification);
        } catch (Exception e) {
            throw new ErrorHandler(" Can't save qualification :" + e.getMessage());
        }

    }

    @Override
    public void delete(int id) {
        throw new ErrorHandler("Can't delete qualification !");
    }

    @Override
    public List<Qualification> findAll() {
        try {
            return qualificationRepository.findAll();
        } catch (Exception e) {
            throw new ErrorHandler("Can't find all qualification: " + e.getMessage());
        }
    }

    @Override
    public Qualification findOne(int id) {
        try {
            return qualificationRepository.findById(id).orElseThrow(() -> new ErrorHandler("Cannot find qualification by id " + id));
        } catch (Exception e) {
            throw new ErrorHandler("Cannot find qualification by id: " + e.getMessage());
        }
    }

}
