package com.thanhdong.tuyensinh.service;

import com.thanhdong.tuyensinh.entity.Account;
import com.thanhdong.tuyensinh.generic.IGenericService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends IGenericService<Account>, UserDetailsService {
    boolean checkOldPassword(String oldpassword, String oldPasswordRequest);

    Account findByUsername(String username);
}
