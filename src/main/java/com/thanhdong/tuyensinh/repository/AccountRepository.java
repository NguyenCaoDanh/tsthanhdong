package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.Account;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AccountRepository extends IGenericRepository<Account, Integer> {
    Optional<Account> findByEmail(String username);
}
