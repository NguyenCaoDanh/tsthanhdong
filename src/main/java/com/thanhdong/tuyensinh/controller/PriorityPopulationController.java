package com.thanhdong.tuyensinh.controller;

import com.thanhdong.tuyensinh.entity.PriorityPopulation;
import com.thanhdong.tuyensinh.generic.GenericController;
import com.thanhdong.tuyensinh.generic.IGenericService;
import com.thanhdong.tuyensinh.service.PriorityPopulationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/priority-populations")
public class PriorityPopulationController  extends GenericController<PriorityPopulation> {
    protected PriorityPopulationController(PriorityPopulationService priorityPopulationService) {
        super(priorityPopulationService);
    }
}
