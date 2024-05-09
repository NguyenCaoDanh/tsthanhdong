package com.thanhdong.tuyensinh.service.impl;

import com.thanhdong.tuyensinh.entity.Post;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.model.request.PostRequest;
import com.thanhdong.tuyensinh.repository.PostRepository;
import com.thanhdong.tuyensinh.service.PostService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;

    @Override
    public void save(Post post) {
        try {
            postRepository.save(post);
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        throw new ErrorHandler("Can not delete !");
    }

    @Override
    public List<Post> findAll() {
        try {
            return postRepository.findAll();
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public Post findOne(int id) {
        try {
            Optional<Post> optionalPost = postRepository.findById(id);
            if (optionalPost.isPresent()) {
                return optionalPost.get();
            } else {
                throw new ErrorHandler("Post not found with id: " + id);
            }
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public List<Post> postList(Map<String, String> params) {
        try {
            if (params.containsKey("idPost")) {
                int idPost = Integer.parseInt(params.get("idPost"));
                Optional<Post> optionalPost = postRepository.findById(idPost);
                if (optionalPost.isPresent()) {
                    return Collections.singletonList(optionalPost.get());
                } else {
                    throw new ErrorHandler("Post not found with id: " + idPost);
                }
            }
            if (params.containsKey("facultyId")) {
                int facultyId = Integer.parseInt(params.get("facultyId"));
                Optional<Post> optionalPost = postRepository.findByFacultyId(facultyId);
                if (optionalPost.isPresent()) {
                    return Collections.singletonList(optionalPost.get());
                } else {
                    throw new ErrorHandler("Post not found with faculty id: " + facultyId);
                }
            }
            if (params.containsKey("namePost")) {
                String namePost = params.get("namePost");
                Optional<Post> optionalPost = postRepository.findByNamePost(namePost);
                if (optionalPost.isPresent()) {
                    return Collections.singletonList(optionalPost.get());
                } else {
                    throw new ErrorHandler("Post not found with id: " + namePost);
                }
            }

            return Collections.emptyList();
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public void createPost(PostRequest request) {
        try {
            Post post = new Post();
            post.setNamePost(request.getPost().getNamePost());
            post.setImage(request.getPost().getImage());
            post.setContent(request.getPost().getContent());
            post.setOther(request.getPost().getOther());
            post.setDisable(request.getPost().getDisable());
            post.setFacultyId(request.getPost().getFacultyId());
            postRepository.save(post);
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }

    }

    @Override
    public Post updatePost(int id, PostRequest request) {
        try {
            Post post = postRepository.findById(id).get();
            post.setNamePost(request.getPost().getNamePost());
            post.setImage(request.getPost().getImage());
            post.setContent(request.getPost().getContent());
            post.setOther(request.getPost().getOther());
            post.setDisable(request.getPost().getDisable());
            post.setFacultyId(request.getPost().getFacultyId());
            postRepository.save(post);
            return post;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public Post approval(int postId, String status) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isEmpty()) {
            throw new ErrorHandler("Cannot find post by id");
        } else {
            Post post = postOptional.get();
            if (status.equals("active")) {
                post.setDisable((byte) 0);
            } else if (status.equals("disable")) {
                post.setDisable((byte) 1);
            } else {
                return post;
            }

            Post postUpdate = postRepository.save(post);
            return postUpdate;
        }
    }


}
