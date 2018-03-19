package com.lz.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.SunHints;

@RestController
public class Hello {
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String Hello() {
        return "Hello SpringBoot!";
    }
}
