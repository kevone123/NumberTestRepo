package com.example.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.NumberObj;
import com.example.service.NumberService;

@RestController
@RequestMapping("/test")
public class NumberController {
	

    @Autowired
    private NumberService service;
    

    

    @GetMapping
    public List<NumberObj> findAll() {
        return service.findAll();
    }
    
    @GetMapping(value = "/{id}")
    public NumberObj findAllbyId(@RequestParam Long id) {
    	return service.findAllbyId(id);
    }
    
    
    @PostMapping(value = "/addnumber")
    @ResponseStatus(value=HttpStatus.OK)
    public void addNumber(@RequestBody NumberObj number) {
    	service.addNumber(number);
    }
    
    @PutMapping(value = "/updatenumber")
    public void updateNumber(@RequestBody NumberObj number) {
    	service.updateNumber(number);
    }
    
}
