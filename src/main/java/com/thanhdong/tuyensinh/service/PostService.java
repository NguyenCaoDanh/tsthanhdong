package com.thanhdong.tuyensinh.service;

import com.thanhdong.tuyensinh.entity.Post;
import com.thanhdong.tuyensinh.generic.IGenericService;
import com.thanhdong.tuyensinh.model.request.PostRequest;

import java.util.List;
import java.util.Map;

public interface PostService extends IGenericService<Post> {
    void createPost(PostRequest request);

    Post updatePost(int id, PostRequest request);

    List<Post> postList(Map<String, String> params);

    Post approval(int postId, String status);
}
