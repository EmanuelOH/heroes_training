package com.riwi.hero_training.infrastructure.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class AppConfig {
    @Autowired
    private final UserDetailsService userDetailsService;

    //Los Beans son instancias de clases que el contenedor de Spring maneja automaticamente y los inyecta donde se necesite
    //PasswordEncoder proporciona metodos para codificar y verificar contraseñas
    @Bean // Define un bean para el codificador de contraseñas
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); //Retorna un codificador BCrypt para encriptar las contraseñas
    }

    //AuthenticationManager es el que se encarga de la gestion del proceso de autentificacion del usuario
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
        throws Exception{
        return authenticationConfiguration.getAuthenticationManager(); //Obtiene el AuthentificadorManager del contexto de autentificaion
    }

    //AuthenticationProvider es el que lleva acabo el proceso de autentificacion de un usuario
    @Bean
    public AuthenticationProvider authenticationProvider(){
        // DaoAuthenticationProvider es una clase que se utiliza para proporcionar autenticacion
        // de los usuarios me diante la verificacion de las credenciales
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(); // Crea una instancia de DaoAuthenticationProvider

        authenticationProvider.setPasswordEncoder(passwordEncoder()); // Establece el codificador de contraseñas
        authenticationProvider.setUserDetailsService(userDetailsService); // Establece el servicio de detalles del usuario
        return authenticationProvider; // Retorna el AuthenticationProvider configurado
    }
}
