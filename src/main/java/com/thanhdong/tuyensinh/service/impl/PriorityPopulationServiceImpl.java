package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.entity.PriorityPopulation;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.repository.PriorityPopulationRepository;
import com.thanhdong.tuyensinh.service.PriorityPopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PriorityPopulationServiceImpl implements PriorityPopulationService {
    @Autowired
    private PriorityPopulationRepository priorityPopulationRepository;

    @Override
    public void save(PriorityPopulation priorityPopulation) {
        try {
            priorityPopulationRepository.save(priorityPopulation);
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        throw new ErrorHandler("Can not delete !");
    }

    @Override
    public List<PriorityPopulation> findAll() {
        try {
            return priorityPopulationRepository.findAll();
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public PriorityPopulation findOne(int id) {
        return priorityPopulationRepository.findById(id).orElseThrow(() -> new ErrorHandler("Can not find this priority population."));
    }
}
