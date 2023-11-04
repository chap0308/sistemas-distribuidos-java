package com.example.demo.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Auth.dto.LoginDto;
import com.example.demo.Auth.dto.RegisterDto;
import com.example.demo.Error.LocalNotFoundException;
import com.example.demo.Usuario.Usuario;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login")
    public boolean login( @Valid @RequestBody LoginDto loginDto) throws LocalNotFoundException, Exception {
        return authService.login(loginDto);
    }
    @PostMapping(value = "/register")
    public Usuario register( @Valid @RequestBody RegisterDto registerDto) throws Exception { 
        return authService.register(registerDto);
    }
    @GetMapping(value = "/user")
    public boolean isAuth( HttpServletRequest request ){
        return authService.isAuth(request);
    }

}
