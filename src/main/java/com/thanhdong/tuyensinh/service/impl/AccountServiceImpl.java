package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.config.AccountUserDetailsImpl;
import com.thanhdong.tuyensinh.entity.Account;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.repository.AccountRepository;
import com.thanhdong.tuyensinh.repository.RoleRepository;
import com.thanhdong.tuyensinh.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(Account account) {
        try {
            account.setPassword(passwordEncoder.encode(account.getPassword()));
            accountRepository.save(account);
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            Account account =
                    accountRepository.findById(id).get();
            account.setDisable((byte) 1);
            accountRepository.save(account);
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public List<Account> findAll() {
        try {
            return accountRepository.findAll();
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public Account findOne(int id) {
        return accountRepository.findById(id).orElseThrow(() -> new ErrorHandler("Can not find account."));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByEmail(username);
        if (account.isPresent() && account.get().getDisable() == 0)
            return new AccountUserDetailsImpl(
                    account.get().getEmail(),
                    account.get().getPassword(),
                    roleRepository.findById(account.get().getRoleId()).get().getRole());
        else throw new ErrorHandler("Username is not exist !");
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByEmail(username).orElseThrow(() -> new ErrorHandler("Email does not exist !"));
    }

    @Override
    public boolean checkOldPassword(String oldpassword, String oldPasswordRequest) {
        return passwordEncoder.matches(oldpassword, oldPasswordRequest);
    }
}

