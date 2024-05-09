package com.thanhdong.tuyensinh.controller;

import com.thanhdong.tuyensinh.entity.Profile;
import com.thanhdong.tuyensinh.entity.Question;
import com.thanhdong.tuyensinh.generic.GenericController;
import com.thanhdong.tuyensinh.model.request.QuestionRequest;
import com.thanhdong.tuyensinh.model.response.ResponseModel;
import com.thanhdong.tuyensinh.service.AccountService;
import com.thanhdong.tuyensinh.service.ProfileService;
import com.thanhdong.tuyensinh.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/questions")
public class QuestionController extends GenericController<Question> {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ProfileService profileService;
    protected QuestionController(QuestionService dao) {
        super(dao);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody QuestionRequest questionRequest) {
        try {
            Question question = new Question();
            question.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
            question.setContent(questionRequest.getContent());
            if (!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
                question.setQuestionerId(profileService.findByAccountId(accountService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getIdAccount()).getIdProfile());
            } else {
                if (profileService.findByEmail(questionRequest.getEmail()) != null) {
                    question.setQuestionerId(profileService.findByEmail(questionRequest.getEmail()).getIdProfile());
                } else {
                    Profile profile = new Profile();
                    profile.setEmail(questionRequest.getEmail());
                    profile.setFirstName(questionRequest.getFirstName());
                    question.setQuestionerId(profileService.saveThenGetId(profile));
                }
            }
            questionService.save(question);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseModel("Success", LocalDate.now().toString(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel("Error", LocalDate.now().toString(), e.getMessage()));
        }
    }
}
