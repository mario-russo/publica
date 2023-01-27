package br.com.russomario.publica.jwt;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.russomario.publica.dominio.Role;
import br.com.russomario.publica.repository.UsuarioRepository;

@Service
public class UsuarioDetailServeceImpl implements UserDetailsService {
    private UsuarioRepository usuarioRepository;
    
    public UsuarioDetailServeceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         var usuario = usuarioRepository.findByEmail(email);
        return new User(usuario.getEmail(),usuario.getSenha(),mapRolesToAuthorities(usuario.getRole()));
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNome())).collect(Collectors.toList());
    }
    
}
