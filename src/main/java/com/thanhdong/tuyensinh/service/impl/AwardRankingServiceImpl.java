package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.entity.AwardRanking;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.repository.AwardRankingRepository;
import com.thanhdong.tuyensinh.service.AwardRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardRankingServiceImpl implements AwardRankingService {
    @Autowired
    private AwardRankingRepository awardRankingRepository;
    @Override
    public void save(AwardRanking awardRanking) {
        throw new ErrorHandler("Can not create or update.");
    }

    @Override
    public void delete(int id) {
        throw new ErrorHandler("Can not delete.");
    }

    @Override
    public List<AwardRanking> findAll() {
        try {
            return awardRankingRepository.findAll();
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public AwardRanking findOne(int id) {
        return null;
    }
}
