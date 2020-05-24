package com.api.ator.demoapi.dao;

import com.api.ator.demoapi.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<Usuario, Integer> {

    Usuario findByEmail(String email);
}
