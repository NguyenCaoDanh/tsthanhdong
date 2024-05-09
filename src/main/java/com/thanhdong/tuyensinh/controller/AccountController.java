package com.thanhdong.tuyensinh.controller;

import com.thanhdong.tuyensinh.dto.RegistrationDTO;
import com.thanhdong.tuyensinh.entity.Account;
import com.thanhdong.tuyensinh.entity.Profile;
import com.thanhdong.tuyensinh.exception.ExceptionResponse;
import com.thanhdong.tuyensinh.generic.GenericController;
import com.thanhdong.tuyensinh.jwt.JwtService;
import com.thanhdong.tuyensinh.model.request.AuthRequest;
import com.thanhdong.tuyensinh.model.request.ChangePasswordRequest;
import com.thanhdong.tuyensinh.model.response.ResponseModel;
import com.thanhdong.tuyensinh.service.AccountService;
import com.thanhdong.tuyensinh.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final static String ROLE_NAME = "CUSTOMER";
    private final static String ROLE_TEST_AUTHORIZE = "hasAuthority('" + ROLE_NAME + "')";
    @Autowired
    private AccountService accountService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/change-password")
    @PreAuthorize(ROLE_TEST_AUTHORIZE)
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest body) {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String email = userDetails.getUsername();
            if (!email.equals(body.getEmail())) {
                return new ResponseEntity<>(new ResponseModel("error", LocalDateTime.now().toString(), "access denied"), HttpStatus.BAD_REQUEST);
            }
            Account account = accountService.findByUsername(email);
            if (!accountService.checkOldPassword(body.getOldPassword(), account.getPassword())) {
                return new ResponseEntity<>(new ResponseModel("error", LocalDateTime.now().toString(), "Old password is incorrect"), HttpStatus.BAD_REQUEST);
            } else {
                account.setPassword(body.getNewPassword());
                accountService.save(account);
                return new ResponseEntity<>(new ResponseModel("success", LocalDateTime.now().toString(), "password has been changed!"), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ExceptionResponse(LocalDateTime.now().toString(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUserName(),
                        authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Success", LocalDate.now().toString(), jwtService.generateToken(authRequest.getUserName())));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseModel("Error", LocalDate.now().toString(), new UsernameNotFoundException("")));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationDTO registrationDTO) {
        try {
            Profile profile = profileService.register(registrationDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseModel("Success", LocalDate.now().toString(), profile));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel("Error", LocalDate.now().toString(), e.getMessage()));
        }
    }
}
