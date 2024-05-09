package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.entity.Role;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.repository.RoleRepository;
import com.thanhdong.tuyensinh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(Role role) {
        try {
            roleRepository.save(role);
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        throw new ErrorHandler("Can not delete role !");
    }

    @Override
    public List<Role> findAll() {
        try {
            return roleRepository.findAll();
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public Role findOne(int id) {
        try {
            return roleRepository.findById(id).get();
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }
}
