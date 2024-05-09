package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.Notification;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends IGenericRepository<Notification, Integer> {
}
