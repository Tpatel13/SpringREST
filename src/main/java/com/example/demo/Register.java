package com.example.demo;

import Models.ResponseModel;
import com.dao.RegisterDao;
import com.sun.research.ws.wadl.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class Register {


    @RequestMapping(path = "/register/{type}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseModel> login(HttpServletRequest request, @PathVariable("type") String type, @RequestBody Map<String, String> data) {

        RegisterDao register = new RegisterDao();
        String name = data.get("name"), email = data.get("email"), password = data.get("password");
        if (register.addUser(name, email, password, type)) {
            return ResponseEntity.status(200).body(new ResponseModel(name, password, "Success Fully Registered", type));
        } else
            return ResponseEntity.status(401).body(new ResponseModel(name, password, "Something went wrong", type));
    }

}