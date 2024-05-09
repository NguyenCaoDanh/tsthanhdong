package com.thanhdong.tuyensinh.generic;


import com.thanhdong.tuyensinh.model.response.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

public class GenericController<T> {
    private IGenericService<T> dao;
    protected GenericController(IGenericService<T> dao) {
        this.dao = dao;
    }

    @GetMapping("/list")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Success", LocalDate.now().toString(), dao.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel("Error", LocalDate.now().toString(), e.getMessage()));
        }
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Success", LocalDate.now().toString(), dao.findOne(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel("Error", LocalDate.now().toString(), e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            dao.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseModel("Success", LocalDate.now().toString(), "Delete success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseModel("Error", LocalDate.now().toString(), e.getMessage()));
        }
    }
}
