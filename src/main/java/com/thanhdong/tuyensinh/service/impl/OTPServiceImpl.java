package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.entity.Account;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.model.request.OTPRequest;
import com.thanhdong.tuyensinh.model.request.OtpValidRequest;
import com.thanhdong.tuyensinh.repository.AccountRepository;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor

public class OTPServiceImpl implements com.thanhdong.tuyensinh.service.OTPService {
    @Autowired
    private final JavaMailSender javaMailSender;
    @Autowired
    private final AccountRepository userRepository;


    // Generate a 6-digit OTP
    private static String generateOTP() {
        Random random = new Random();
        int otpLength = 6;
        StringBuilder sb = new StringBuilder(otpLength);
        for (int i = 0; i < otpLength; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    // Load HTML template from resources
    private String loadHtmlTemplate(String templateName) throws IOException {
        try (InputStream inputStream = new ClassPathResource(templateName).getInputStream()) {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    private void sendHtmlEmail(String to, String subject, String htmlBody) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlBody, true);
            javaMailSender.send(message);
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public boolean sendOTP(OTPRequest otpRequest) {
        Account acc = userRepository.findByEmail(otpRequest.getEmail()).orElseThrow(() -> new ErrorHandler("Account not found"));
        String otp = generateOTP();
        try {
            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            acc.setOTP(otp);
            acc.setUpdateAt(timestamp);
            userRepository.save(acc);
            String htmlContent = loadHtmlTemplate("templates/OTP.html");
            htmlContent = htmlContent.replace("codeOtp", otp);
            htmlContent = htmlContent.replace("userName", acc.getEmail());
            sendHtmlEmail(otpRequest.getEmail(), otpRequest.getSubject(), htmlContent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorHandler("Can not send OTP");
        }

    }

    @Override
    public String verifyOTP(OtpValidRequest otpValidRequest) {
        Account acc = userRepository.findByEmail(otpValidRequest.getEmail()).orElseThrow(() -> new ErrorHandler("Account not found"));
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        Timestamp updateAt = acc.getUpdateAt();
        long diffSeconds = (timestamp.getTime() - updateAt.getTime()) / 1000;
        if (diffSeconds > 60) {
            return "expired";
        }
        String otp = acc.getOTP();
        if (otp == null) {
            return "not exist";
        }
        if (otp.equals(otpValidRequest.getOtp())) {
            return "valid";
        } else {
            return "invalid";
        }
    }
}
