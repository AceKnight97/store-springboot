package com.demoDigital.demo.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  // @RequestMapping(value = "/masterdata", method = RequestMethod.GET, produces =
  // MediaType.APPLICATION_JSON_VALUE)
  @RequestMapping("/masterdata")
  public String masterdata() {
    return "skill_compentence.json";
  }

  @RequestMapping("/hello")
  @ResponseBody
  public String hello() {
    return "Hello Triet";
  }
}
