package com.thanhdong.tuyensinh.controller;

import com.thanhdong.tuyensinh.entity.Post;
import com.thanhdong.tuyensinh.exception.ErrorHandler;
import com.thanhdong.tuyensinh.generic.GenericController;
import com.thanhdong.tuyensinh.jwt.JwtService;
import com.thanhdong.tuyensinh.model.request.PostRequest;
import com.thanhdong.tuyensinh.model.response.ResponseModel;
import com.thanhdong.tuyensinh.service.PostService;
import com.thanhdong.tuyensinh.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class PostController extends GenericController<Post> {
    private final static String ROLE_NAME = "ADMIN";
    private final static String ROLE_TEST_AUTHORIZE = "hasAuthority('" + ROLE_NAME + "')";
    @Autowired
    private PostService postService;

    protected PostController(PostService postService) {
        super(postService);
    }

    @PatchMapping("/approval")
    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<?> approval(@RequestParam int id, @RequestParam String status) {
        Post post = postService.approval(id, status);
        return ResponseUtil.success(post);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public ResponseEntity<?> createPost(@RequestBody PostRequest request) {
        try {
            postService.createPost(request);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Success", LocalDate.now().toString(), null));
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    @PutMapping("/")
    @PreAuthorize("hasAnyAuthority('admin','employee')")
    public ResponseEntity<Object> updatePostById(@RequestParam int id, @RequestBody PostRequest request) {
        try {
            Post updatePost = postService.updatePost(id, request);
            return new ResponseEntity<>(updatePost, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getOnePost(@RequestParam Map<String, String> params) {
        try {
            if (!params.isEmpty()) {
                List<Post> data = postService.postList(params);
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("success", LocalDate.now().toString(), data));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseModel("error", LocalDate.now().toString(), "Thiếu tham số!"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel("error", LocalDate.now().toString(), e.getMessage()));
        }
    }
}
