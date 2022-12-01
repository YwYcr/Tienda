package com.tienda.service;

import com.tienda.dao.UsuarioDao;
import com.tienda.dao.CreditoDao;
import com.tienda.domain.Rol;
import com.tienda.domain.Usuario;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")

public class UsuarioService implements UserDetailsService {
    
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //se busca usuario en la tabla  usuario
        Usuario usuario = usuarioDao.findByUsername(username);
        if (usuario==null){
            throw new UsernameNotFoundException(username);            
        }
        
        //Se cargan los roles del usuario en un array
        var roles =new ArrayList<GrantedAuthority>();
        //se recorre el ArrayList del objeto Usuario
        
        for(Rol rol:usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        //Retorna un UserDetails con la info 
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
        
        }
        
    }
    
    


