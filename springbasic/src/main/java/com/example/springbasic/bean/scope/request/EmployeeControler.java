package com.example.springbasic.bean.scope.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.ws.Provider;

@Controller
public class EmployeeControler{
    @Autowired
    private Provider<EmployeeDetails>
}
