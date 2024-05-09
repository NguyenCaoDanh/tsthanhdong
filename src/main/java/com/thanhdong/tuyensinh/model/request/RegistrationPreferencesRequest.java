package com.thanhdong.tuyensinh.model.request;

import com.thanhdong.tuyensinh.entity.RegistrationPreferences;
import lombok.Data;

import java.util.List;

@Data
public class RegistrationPreferencesRequest {
    List<RegistrationPreferences> registrationPreferencesList;
}
