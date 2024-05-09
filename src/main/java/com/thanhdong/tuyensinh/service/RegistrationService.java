package com.thanhdong.tuyensinh.service;

import com.thanhdong.tuyensinh.entity.Profile;
import com.thanhdong.tuyensinh.entity.RegistrationPreferences;
import com.thanhdong.tuyensinh.generic.IGenericService;

import java.util.List;

public interface RegistrationService extends IGenericService<Profile> {
    void updateRegistrationService(String email, List<RegistrationPreferences> registrationPreferencesList);
}

