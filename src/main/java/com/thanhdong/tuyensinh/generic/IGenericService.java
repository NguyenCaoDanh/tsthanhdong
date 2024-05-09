package com.thanhdong.tuyensinh.generic;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IGenericService<T> {
    void save(T t);

    void delete(int id);

    List<T> findAll();

    T findOne(int id);

}
