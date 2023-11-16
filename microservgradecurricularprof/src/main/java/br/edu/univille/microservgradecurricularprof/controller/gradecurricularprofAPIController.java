package br.edu.univille.microservgradecurricularprof.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.azure.core.annotation.PathParam;

import br.edu.univille.microservgradecurricularprof.entity.gradecurricularprof;
import br.edu.univille.microservgradecurricularprof.service.gradecurricularprofService;

@RestController
@RequestMapping("/api/v1/gradecurricularprof")
public class gradecurricularprofAPIController {

    @Autowired
    private gradecurricularprofService service;

    @GetMapping
    public ResponseEntity<List<gradecurricularprof>> listagradecurricularprof(){
        //var listagradecurricularprof = new ArrayList<gradecurricularprof>();
        var listagradecurricularprof = service.getAll();

        return new ResponseEntity<List<gradecurricularprof>>(listagradecurricularprof, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<gradecurricularprof> buscargradecurricularprof(@PathParam("id") String id){
        var gradecurricularprof = service.getById(id);
        if(gradecurricularprof == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<gradecurricularprof>
            (gradecurricularprof, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<gradecurricularprof> inserirgradecurricularprof(@RequestBody gradecurricularprof gradecurricularprof){
        if(gradecurricularprof == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        gradecurricularprof = service.saveNew(gradecurricularprof);
        return 
            new ResponseEntity<gradecurricularprof>
            (gradecurricularprof, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<gradecurricularprof> atualizargradecurricularprof(@PathVariable("id")  String id, @RequestBody gradecurricularprof gradecurricularprof){
        if(gradecurricularprof == null || id == ""  || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        gradecurricularprof = service.update(id, gradecurricularprof);
        if(gradecurricularprof == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
        new ResponseEntity<gradecurricularprof>
        (gradecurricularprof, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<gradecurricularprof> removergradecurricularprof(@PathVariable("id")  String id){
        if(id == ""  || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var gradecurricularprof = service.delete(id);
        if(gradecurricularprof == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
        new ResponseEntity<gradecurricularprof>
        (gradecurricularprof, HttpStatus.OK);
    }
}