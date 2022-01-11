package com.demoDigital.demo.controllers;

import com.demoDigital.demo.services.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/digitalcv")
public class DigitalCVController {
    @Autowired
    AuthService authService;

}
