package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.dto.RegistrationDTO;
import com.thanhdong.tuyensinh.entity.Account;
import com.thanhdong.tuyensinh.entity.Profile;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.repository.AccountRepository;
import com.thanhdong.tuyensinh.repository.ProfileRepository;
import com.thanhdong.tuyensinh.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void save(Profile profile) {
        try {
            profileRepository.save(profile);
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        throw new ErrorHandler("Can not delete profile.");
    }

    @Override
    public List<Profile> findAll() {
        try {
            return profileRepository.findAll();
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public Profile findOne(int id) {
        return profileRepository.findById(id).orElseThrow(() -> new ErrorHandler("Can not find profile."));
    }

    @Override
    public int saveThenGetId(Profile profile) {
        try {
            return profileRepository.save(profile).getIdProfile();
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public Profile findByAccountId(int AccountId) {
        return profileRepository.findByAccountId(AccountId).orElseThrow(() -> new ErrorHandler("Can not find profile."));
    }

    @Override
    public Profile findByEmail(String email) {
        return profileRepository.findByEmail(email).orElseThrow(() -> new ErrorHandler("Can not find email."));
    }

    @Override
    public Profile register(RegistrationDTO registrationDTO) {
        try {
            String email = registrationDTO.getEmail();
            Profile output = new Profile();
            //trường hợp tìm thấy email trong profile
            if (profileRepository.findByEmail(email).isPresent()) {
                Profile profile = profileRepository.findByEmail(email).get();
                //trường hợp tìm thấy account có cùng email
                if (accountRepository.findByEmail(email).isPresent()) {
                    throw new ErrorHandler("Email " + profile.getEmail() + " already exists");
                    //trường hợp không tìm thấy email và không liên kết với bất kỳ account nào
                } else if (profile.getAccountId() == null) {
                    // Tạo một đối tượng Account từ thông tin đăng ký
                    Account account = new Account();
                    account.setEmail(registrationDTO.getEmail()); // Sử dụng email làm tên đăng nhập
                    account.setPassword(passwordEncoder.encode(registrationDTO.getPassword())); // Mã hóa mật khẩu trước khi lưu
                    account.setRoleId(3); // đặt mặc định là tài khoản custumer role id =3
                    // Lưu thông tin Account vào cơ sở dữ liệu
                    account = accountRepository.save(account);

                    // Tạo một đối tượng Profile từ thông tin đăng ký
                    profile.setFirstName(registrationDTO.getFirstName());
                    profile.setLastName(registrationDTO.getLastName());
                    profile.setPhone(registrationDTO.getPhone());
                    profile.setGender(registrationDTO.getGender());
                    profile.setDateOfBirth(registrationDTO.getDateOfBirth());
                    profile.setEmail(registrationDTO.getEmail());
                    profile.setAccountId(account.getIdAccount());// Liên kết với tài khoản mới tạo
                    output = profileRepository.save(profile);
                }
            //trường hợp không tìm thấy email trong profile
            } else {
                // Tạo một đối tượng Account từ thông tin đăng ký
                Account account = new Account();
                account.setEmail(registrationDTO.getEmail()); // Sử dụng email làm tên đăng nhập
                account.setPassword(passwordEncoder.encode(registrationDTO.getPassword())); // Mã hóa mật khẩu trước khi lưu
                account.setRoleId(3); // đặt mặc định là tài khoản custumer role id =3
                // Lưu thông tin Account vào cơ sở dữ liệu
                account = accountRepository.save(account);

                // Tạo một đối tượng Profile từ thông tin đăng ký
                Profile profile = new Profile();
                profile.setFirstName(registrationDTO.getFirstName());
                profile.setLastName(registrationDTO.getLastName());
                profile.setPhone(registrationDTO.getPhone());
                profile.setGender(registrationDTO.getGender());
                profile.setDateOfBirth(registrationDTO.getDateOfBirth());
                profile.setEmail(registrationDTO.getEmail());
                profile.setAccountId(account.getIdAccount());// Liên kết với tài khoản mới tạo
                output = profileRepository.save(profile);
            }
            return output;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }
}
