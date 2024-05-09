package com.thanhdong.tuyensinh.service;

import com.thanhdong.tuyensinh.model.request.OTPRequest;
import com.thanhdong.tuyensinh.model.request.OtpValidRequest;


public interface OTPService {
    boolean sendOTP(OTPRequest otpRequest);

    String verifyOTP(OtpValidRequest otpValidRequest);
}
