package com.thanhdong.tuyensinh.repository;


import com.thanhdong.tuyensinh.entity.Question;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends IGenericRepository<Question, Integer> {
}
