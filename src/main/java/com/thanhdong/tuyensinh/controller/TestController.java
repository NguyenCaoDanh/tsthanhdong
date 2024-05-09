package com.thanhdong.tuyensinh.controller;

import com.thanhdong.tuyensinh.entity.Account;
import com.thanhdong.tuyensinh.jwt.JwtService;
import com.thanhdong.tuyensinh.model.response.ResponseModel;
import com.thanhdong.tuyensinh.model.request.AuthRequest;
import com.thanhdong.tuyensinh.repository.RegistrationPreferencesRepository;
import com.thanhdong.tuyensinh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/test")
public class TestController {
    private final static String ROLE_NAME = "ADMIN";
    private final static String ROLE_TEST_AUTHORIZE = "hasAuthority('" + ROLE_NAME + "')";
    @Autowired
    private AccountService accountService;

    

    @GetMapping("/admin")
    @PreAuthorize(ROLE_TEST_AUTHORIZE)
    public ResponseEntity<?> test() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Success", LocalDate.now().toString(), accountService.findAll()));
    }

    @GetMapping("/test")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public ResponseEntity<?> test2() {
        //Lấy ra user từ token
        //Nếu không gửi token kêt quả là anonymousUser
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Success", LocalDate.now().toString(), null));
    }

    @Autowired
    private RegistrationPreferencesRepository registrationPreferencesRepository;


    @PostMapping("/regis")
//    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public ResponseEntity<?> add(@RequestBody Account account) {
        accountService.save(account);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Success", LocalDate.now().toString(), "Register successfully"));
    }


    @GetMapping("/abc")
    public ResponseEntity<?> abc()
    {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Success", LocalDate.now().toString(), "abc"));
    }

}
