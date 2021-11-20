package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Result;
import com.mph.service.ResultService;

@RestController
@RequestMapping(value = "/result")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE }, allowCredentials = "false", allowedHeaders = "*")
public class ResultRestController {
    @Autowired
    ResultService resultService;
    @GetMapping("/allresult")
    public ResponseEntity<List<Result>> allResult() {
        List<Result> elist = resultService.getResultList();
        System.out.println(elist);
        if (elist.isEmpty()) {
            return new ResponseEntity<List<Result>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Result>>(elist, HttpStatus.OK);
    }
    
    @PostMapping("/addresult")
    public Result createResult(@RequestBody Result result) {
        resultService.addResult(result);
        return result;
    }
    @DeleteMapping("/deleteResult/{rid}")
    public ResponseEntity<?> updateResult(@PathVariable("rid") int eid) {
    
        
        List<Result> delist = resultService.deleteResult(eid);
        System.out.println(delist);
        if (delist.isEmpty()) {
            return new ResponseEntity<List<Result>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Result>>(delist, HttpStatus.OK);
    }
    
    @GetMapping("/byIdResult/{rid}")
    public ResponseEntity<?> getByIdResult(@PathVariable("rid") int eid) {
        Result delist = resultService.getResultID(eid);
        System.out.println(delist);
        
        if (delist==null) {
            return new ResponseEntity<Result>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Result>(delist, HttpStatus.OK);
    }
    
    
    
    
    
    
    
}
