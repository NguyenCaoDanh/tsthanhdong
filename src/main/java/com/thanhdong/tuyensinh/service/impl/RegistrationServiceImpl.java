package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.entity.Profile;
import com.thanhdong.tuyensinh.entity.RegistrationPreferences;
import com.thanhdong.tuyensinh.repository.EnrollmentApplicationRepository;
import com.thanhdong.tuyensinh.repository.ProfileRepository;
import com.thanhdong.tuyensinh.repository.RegistrationPreferencesRepository;
import com.thanhdong.tuyensinh.service.RegistrationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationPreferencesRepository registrationPreferencesRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private EnrollmentApplicationRepository enrollmentApplicationRepository;


    @Override
    public void save(Profile profile) {

    }

    @Override
    public void delete(int idRegistrationPreferences) {

        registrationPreferencesRepository.deleteById(idRegistrationPreferences);
    }

    @Override
    public List<Profile> findAll() {
        return null;
    }

    @Override
    public Profile findOne(int id) {
        return null;
    }

    @Override
    public void updateRegistrationService(String email, List<RegistrationPreferences> request) {
        profileRepository.findByEmail(email).ifPresent(profile -> {
            enrollmentApplicationRepository.findByProfileId(profile.getIdProfile()).ifPresent(
                    enrollmentApplication -> {
                        registrationPreferencesRepository.findByEnrollmentApplicationId(enrollmentApplication.getIdEnrollmentApplication()).ifPresent(
                                listRegistrationPreferences -> {
                                    for (RegistrationPreferences registrationPreferences : listRegistrationPreferences) {
                                        registrationPreferencesRepository.deleteById(registrationPreferences.getIdRegistrationPreferences());
                                    }
                                }
                        );
                        for (RegistrationPreferences registrationPreferences : request) {
                            RegistrationPreferences rp = new RegistrationPreferences();
                            rp.setEnrollmentApplicationId(enrollmentApplication.getIdEnrollmentApplication());
                            rp.setRegistrationPreferencesStatusId(1);
                            rp.setRecruitmentId(registrationPreferences.getRecruitmentId());
                            rp.setPriorityLevel(registrationPreferences.getPriorityLevel());
                            registrationPreferencesRepository.save(rp);
                        }

                    }
            );
        });
    }

}

