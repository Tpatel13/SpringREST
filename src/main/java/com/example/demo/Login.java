package com.example.demo;


import Models.ResponseModel;
import com.dao.LoginDao;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Login {


    @RequestMapping(path = "/login/{type}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ResponseModel> login(HttpServletRequest request, @PathVariable("type") String type, @RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {


        LoginDao login = new LoginDao();

        try {
            String[] data = login.checkLogin(name, password, type);
            if(data!=null) return ResponseEntity.status(200).body(new ResponseModel(name, password, "Correct Password"));
            else return ResponseEntity.status(401).body(new ResponseModel(name, password, "Wrong Credentials"));

        } catch (Exception e) {
            return ResponseEntity.status(401).body(new ResponseModel(name, password, "Wrong Credentials"));

        }
    }

}
