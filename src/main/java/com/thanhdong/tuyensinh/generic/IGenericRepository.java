package com.thanhdong.tuyensinh.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepository<T, Y> extends JpaRepository<T, Y> {
}
