package com.airtelbg.app;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AppErrorController implements ErrorController{

	private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Error Occured. This path may not occure. Try changing method type,request body.";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}