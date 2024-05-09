package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.entity.Question;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.repository.QuestionRepository;
import com.thanhdong.tuyensinh.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void delete(int id) {
        throw new ErrorHandler("Can not delete question !");
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question findOne(int id) {
        return questionRepository.findById(id).get();
    }
}
