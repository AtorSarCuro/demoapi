package com.api.ator.demoapi.service;

import com.api.ator.demoapi.dao.UserDao;
import com.api.ator.demoapi.entity.Usuario;
import com.api.ator.demoapi.model.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userDao.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        User user1 = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
        return user1;
    }

    public Usuario save(UsuarioDto user) {
        Usuario usuario = new Usuario();
        usuario.setName(user.getName());
        usuario.setEmail(user.getEmail());
        usuario.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(usuario);
    }
}
