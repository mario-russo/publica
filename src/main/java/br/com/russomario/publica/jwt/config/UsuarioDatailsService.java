package br.com.russomario.publica.jwt.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.jwt.auth.UsuarioDetails;
import br.com.russomario.publica.repository.UsuarioRepository;

public class UsuarioDatailsService implements UserDetailsService{

    private final UsuarioRepository repository;
    
    public UsuarioDatailsService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Usuario usuario = repository.findByEmail();

         if (usuario == null){
            throw new Error("usuario não Existe");
         }

        return new UsuarioDetails(usuario);
    }
    
}
