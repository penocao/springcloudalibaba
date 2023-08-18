package com.zpcao.controller;

import com.zpcao.bean.Depart;
import com.zpcao.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/provider/depart")
@RestController
public class DepartController {

    @Autowired
    private DepartService departService;

    @PostMapping("/")
    public boolean saveHandler(@RequestBody Depart depart) {
        return departService.saveDepart(depart);
    }

    @DeleteMapping("/{id}")
    public boolean deleteHandler(@PathVariable("id") int id) {
        return departService.removeDepartById(id);
    }

    @PutMapping("/")
    public boolean updateHandler(@RequestBody Depart depart) {
        return departService.modifyDepart(depart);
    }

    @GetMapping("/{id}")
    public Depart getHandler(@PathVariable("id") int id) {
        return departService.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandler() {
        return departService.listAllDeparts();
    }

}
