package com.example.demo;

import Models.ResponseModel;
import com.dao.DeleteProductByID;
import com.dao.LoginDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DeleteProduct {
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteProduct(HttpServletRequest request, @PathVariable("id") String id) {
        DeleteProductByID delete = new DeleteProductByID();

        if (delete.delete(Integer.parseInt(id))) return ResponseEntity.status(200).body("Success");
        else
            return ResponseEntity.status(401).body("Error");

    }
}
