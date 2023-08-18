package com.zpcao.controller;

import com.zpcao.bean.Depart;
import com.zpcao.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/provider/depart")
@RestController
public class DepartController {

    @Autowired
    private DepartService departService;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discovery")
    public List<String> discoveryHandler() {
        // 获取注册中心所有服务名称
        List<String> services = discoveryClient.getServices();
        for (String serviceName :
                services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
            for (ServiceInstance instance :
                    instances) {
                Map<String, Object> map = new HashMap<>();
                map.put("serviceName", serviceName);
                map.put("serviceId", instance.getServiceId());
                map.put("serviceHost", instance.getHost());
                map.put("servicePort", instance.getPort());
                map.put("uri", instance.getUri());
                System.out.println(map);

            }
        }

        return services;

    }

}
