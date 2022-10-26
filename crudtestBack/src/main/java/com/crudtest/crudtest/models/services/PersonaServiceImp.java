package com.crudtest.crudtest.models.services;

import java.util.List;

import com.crudtest.crudtest.models.entity.Persona;
import com.crudtest.crudtest.models.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImp implements PersonaService{

    @Autowired
    private PersonaRepository repositorio;
    
    @Override
    public List<Persona> listar() {
        return repositorio.findAll();
    }

    @Override
    public Persona listarId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public Persona add(Persona p) {
        return repositorio.save(p);
    }

    @Override
    public Persona edit(Persona p) {
        return repositorio.save(p);
    }

    @Override
    public Persona delete(int id) {
        Persona p = repositorio.findById(id);
        if(p!=null){
            repositorio.delete(p);
        }
        return p;
    }
    
}
