package com.zpcao.service;

import com.zpcao.bean.Depart;
import com.zpcao.repository.DepartRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepsitory departRepsitory;

    @Override
    public boolean saveDepart(Depart depart) {
        Depart depart1 = departRepsitory.save(depart);
        if (depart1 != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDepartById(int id) {
        if (departRepsitory.existsById(id)) {
            departRepsitory.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart depart1 = departRepsitory.save(depart);
        if (depart != null) {
            return true;
        }
        return false;
    }

    @Override
    public Depart getDepartById(int id) {
        if (departRepsitory.existsById(id)) {
            return departRepsitory.getReferenceById(id);
        }
        Depart depart = new Depart();
        depart.setName("no this depart");
        return depart;
    }

    @Override
    public List<Depart> listAllDeparts() {
        return departRepsitory.findAll();
    }
}
