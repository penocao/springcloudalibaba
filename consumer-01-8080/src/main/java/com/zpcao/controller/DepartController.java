package com.zpcao.controller;

import com.zpcao.bean.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/consumer/depart")
@RestController
public class DepartController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String SERVICE_PROVIDER = "http://localhost:8081/provider/depart/";

    @PostMapping("/")
    public boolean saveHandler(@RequestBody Depart depart) {
        return restTemplate.postForObject(SERVICE_PROVIDER, depart, Boolean.class);
    }

    @DeleteMapping("/{id}")
    public void deleteHandler(@PathVariable int id) {
        restTemplate.delete(SERVICE_PROVIDER + "{1}", id);
    }

    @PutMapping("/")
    public void updateHandler(@RequestBody Depart depart) {
        restTemplate.put(SERVICE_PROVIDER, depart);
    }

    @GetMapping("/{id}")
    public Depart getHandler(@PathVariable int id) {
        return restTemplate.getForObject(SERVICE_PROVIDER + "{1}", Depart.class, id);
    }

    @GetMapping("/list")
    public List<Depart> listHandler() {
        return restTemplate.getForObject(SERVICE_PROVIDER + "list", List.class);
    }
}
