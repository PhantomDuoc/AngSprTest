
package com.crudtest.crudtest.models.repositories;

import java.util.List;

import com.crudtest.crudtest.models.entity.Persona;
import org.springframework.data.repository.Repository;

public interface PersonaRepository extends Repository<Persona, Integer> {
    List<Persona>findAll();
    Persona findById(int id);
    Persona save(Persona p);
    void delete(Persona p);
}
