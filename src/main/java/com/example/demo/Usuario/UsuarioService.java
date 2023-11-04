package com.example.demo.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Error.LocalNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    // public Usuario createUsuario(Usuario usuario) {
    //     BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    //     try {
    //         // Encriptar contraseña
    //         String contraseñaEncriptada = encoder.encode(usuario.getContraseña());
    //         usuario.setContraseña(contraseñaEncriptada);
    //         return usuarioRepository.save(usuario);
    //     } catch (Exception e) {
    //         System.err.println(e.getMessage());
    //         return null;
    //     }
    // }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Integer id) throws LocalNotFoundException{

        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            throw new LocalNotFoundException("No se encontro el usuario");
        
        }
        return usuario;
        
    }

    // public Usuario getUsuarioByEmail(String email) {
    //     try {
    //         return usuarioRepository.findByEmail(email);
    //     } catch (Exception e) {
    //         return null;
    //     }
        
    // }

    public Usuario updateUsuario(Integer id, Usuario usuario) throws Exception{
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Usuario usuarioActual = this.getUsuarioById(id);
        
        Usuario usuarioRegistrado = usuarioRepository.findByEmail(usuario.getEmail());
        //*tiene que enviarnos todos los datos del cliente
        if (usuarioRegistrado != null && usuarioActual.getEmail() != usuarioRegistrado.getEmail()) {
            throw new Exception("El email ya está registrado en un usuario");
        }
        
        usuarioActual.setNombre(usuario.getNombre());
        usuarioActual.setApellido(usuario.getApellido());
        usuarioActual.setEmail(usuario.getEmail());
        if (usuario.getContraseña() != null) {
            usuarioActual.setContraseña(encoder.encode(usuario.getContraseña()));
        }
        usuarioActual.setAdmin(usuario.isAdmin());

        return usuarioRepository.save(usuarioActual);
    }

    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

}
