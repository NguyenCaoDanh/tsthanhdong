package com.thanhdong.tuyensinh.service;

import com.thanhdong.tuyensinh.dto.RegistrationDTO;
import com.thanhdong.tuyensinh.entity.Profile;
import com.thanhdong.tuyensinh.generic.IGenericService;

public interface ProfileService extends IGenericService<Profile> {
    int saveThenGetId(Profile profile);

    Profile findByAccountId(int AccountId);

    Profile findByEmail(String email);

    Profile register(RegistrationDTO registrationDTO);
}
