package com.api.ator.demoapi.service;

import com.api.ator.demoapi.entity.Usuario;
import com.api.ator.demoapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    @Qualifier("usuarioRepository")
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByEmail(s);
        return new User(user.getEmail(), user.getPassword(), false, false, false, false, buildGranted());

    }

    public List<GrantedAuthority> buildGranted() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("Administrador"));
        return grantedAuthorities;
    }
}
