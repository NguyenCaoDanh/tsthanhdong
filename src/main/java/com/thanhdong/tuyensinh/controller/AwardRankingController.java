package com.thanhdong.tuyensinh.controller;

import com.thanhdong.tuyensinh.entity.AwardRanking;
import com.thanhdong.tuyensinh.generic.GenericController;
import com.thanhdong.tuyensinh.generic.IGenericService;
import com.thanhdong.tuyensinh.service.AwardRankingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/awardrankings")
public class AwardRankingController extends GenericController<AwardRanking> {
    protected AwardRankingController(AwardRankingService dao) {
        super(dao);
    }
}
