package com.thanhdong.tuyensinh.repository;

import com.thanhdong.tuyensinh.entity.Post;
import com.thanhdong.tuyensinh.generic.IGenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends IGenericRepository<Post, Integer> {

    Optional<Post> findByFacultyId(Integer facultyId);

    Optional<Post> findByNamePost(String namePost);

}
