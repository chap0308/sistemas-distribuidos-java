package com.example.demo.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.Auth.dto.LoginDto;
import com.example.demo.Auth.dto.RegisterDto;
import com.example.demo.Error.LocalNotFoundException;
import com.example.demo.Usuario.Usuario;
import com.example.demo.Usuario.UsuarioRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    //Si queremos colocar otra dependencia más, tenemos que colocar Autowired

    public static String generateToken() {
        // Genera un UUID aleatorio
        UUID uuid = UUID.randomUUID();
        
        // Convierte el UUID en una cadena de caracteres sin guiones
        String token = uuid.toString().replace("-", "");
        
        return token;
    }

    public boolean login(LoginDto loginDto ) throws LocalNotFoundException, Exception {
        // System.out.println(loginDto);
        Usuario usuario = usuarioRepository.findByEmail(loginDto.getEmail());
        if(usuario==null){
            throw new LocalNotFoundException("El usuario no existe");
        }
        // Crear un encoder
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Verificar la contraseña
        boolean esValida = encoder.matches(loginDto.getContraseña(), usuario.getContraseña());
        
        if(esValida){
            boolean isAdmin = usuario.isAdmin();
            return isAdmin;
        }else{
            throw new Exception("Contraseña incorrecta");
        }

    }

    public Usuario register(RegisterDto registerDto) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Usuario usuario = usuarioRepository.findByEmail(registerDto.getEmail());
        if (usuario != null) {
            throw new Exception("El email ya está registrado");
        }
        Usuario user = new Usuario();
        user.setNombre(registerDto.getNombre());
        user.setApellido(registerDto.getApellido());
        user.setEmail(registerDto.getEmail());
        // Encriptar contraseña
        String contraseñaEncriptada = encoder.encode(registerDto.getContraseña());
        user.setContraseña(contraseñaEncriptada);
        return usuarioRepository.save(user);
    }

    
    public boolean isAuth(HttpServletRequest request){
        // System.out.println(request);
        return true;
    }
}
