package com.thanhdong.tuyensinh.util;

import com.thanhdong.tuyensinh.model.response.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public class ResponseUtil {
    public static ResponseEntity<?> success(Object data) {
        ResponseModel resModel = new ResponseModel();
        resModel.setStatus("Success");
        resModel.setTimestamp(LocalDate.now().toString());
        resModel.setData(data);
        return ResponseEntity.status(HttpStatus.OK).body(resModel);
    }

    public static ResponseEntity<?> error(String message) {
        ResponseModel resModel = new ResponseModel();
        resModel.setStatus("Error");
        resModel.setTimestamp(LocalDate.now().toString());
        resModel.setData(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resModel);
    }
}
