package com.riwi.hero_training.infrastructure.helpers;

import com.riwi.hero_training.domain.entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component // Se vuelve un componente de spring
public class JwtUtil {
    // Clave secreta que se utiliza para firmar los tokens. Se obtiene del archivo de configuración.
    @Value("${jwt.secret}")
    private String secretKey;

    // Tiempo de expiración del token en milisegundos. También se obtiene del archivo de configuración.
    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    // Método para obtener la clave de firma a partir de la clave secreta.
    private Key getSignInKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());  // Convierte la clave secreta en un objeto Key.
    }

    // Método para generar un token JWT a partir de un objeto User.
    public String generateToken(UserEntity user) {
        return Jwts.builder()
                .addClaims(Map.of(  // Agrega claims personalizados al token.
                        "id", user.getId(),  // ID del usuario
                        "role", user.getRole()  // Rol del usuario
                ))
                .setSubject(user.getName())  // Establece el sujeto (nombre de usuario) del token.
                .setIssuedAt(new Date(System.currentTimeMillis()))  // Fecha de creación del token.
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))  // Fecha de expiración del token.
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)  // Firma el token usando la clave secreta y el algoritmo HS256.
                .compact();  // Compacta el token y lo devuelve como un String.
    }

    // Método para extraer el nombre de usuario del token JWT.
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);  // Llama al método extractClaim para obtener el subject.
    }

    // Método para validar si el token es correcto, comparando el nombre de usuario y la expiración.
    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));  // Verifica si el nombre de usuario coincide y si el token no ha expirado.
    }

    // Método para verificar si el token ha expirado.
    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());  // Compara la fecha de expiración con la fecha actual.
    }

    // Método genérico para extraer un claim del token JWT.
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(extractAllClaims(token));  // Aplica el resolutor de claims al token.
    }

    // Método para extraer todos los claims del token JWT.
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()  // Crea un parser para el token.
                .setSigningKey(getSignInKey())  // Establece la clave de firma.
                .build()  // Construye el parser.
                .parseClaimsJws(token)  // Analiza el token y obtiene los claims.
                .getBody();  // Retorna el cuerpo del token que contiene los claims.
    }
}
