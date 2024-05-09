package com.thanhdong.tuyensinh.controller;


import com.thanhdong.tuyensinh.dto.RecruitmentDTO;
import com.thanhdong.tuyensinh.entity.Recruitment;
import com.thanhdong.tuyensinh.model.response.ResponseModel;
import com.thanhdong.tuyensinh.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/recruitment")
public class RecruitmentController {

    @Autowired
    private RecruitmentService recruitmentService;


    @PostMapping()
//    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<?> createRecruitment(@RequestBody RecruitmentDTO recruitmentDTO) {
        try {
            Recruitment createdRecruitment = recruitmentService.createRecruitment(recruitmentDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseModel("Success", LocalDate.now().toString(), createdRecruitment));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel("Error", LocalDate.now().toString(), e.getMessage()));
        }
    }


    @PutMapping()
//    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<?> updateRecruitment(@RequestParam int idRecruitment, @RequestBody RecruitmentDTO recruitmentDTO) {
        try {
            Recruitment updatedRecruitment = recruitmentService.updateRecruitment(idRecruitment, recruitmentDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Success", LocalDate.now().toString(), updatedRecruitment));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel("Error", LocalDate.now().toString(), e.getMessage()));
        }
    }

}
