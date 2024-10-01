package com.riwi.hero_training.application.services.auth;

import com.riwi.hero_training.application.dtos.requests.UserRequestDto;
import com.riwi.hero_training.application.dtos.responses.AuthUserResponseDto;
import com.riwi.hero_training.application.dtos.responses.UserResponseDto;
import com.riwi.hero_training.application.mappers.UserMapper;
import com.riwi.hero_training.domain.entities.UserEntity;
import com.riwi.hero_training.domain.enums.Roles;
import com.riwi.hero_training.domain.exceptions.InvalidCredentialException;
import com.riwi.hero_training.domain.ports.service.interfaces.IUserService;
import com.riwi.hero_training.infrastructure.helpers.JwtUtil;
import com.riwi.hero_training.infrastructure.persistence.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    @Autowired
    public final UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final JwtUtil jwtUtil;

    @Override
    public AuthUserResponseDto register(UserRequestDto request, Roles role) {
        //Verifica si el usuario existe
        UserEntity userDB = userRepository.findByUsernameOrEmail(request.getName(), request.getEmail());

        //Verifica si el usuario ya existe
        if(userDB != null){
            throw new InvalidCredentialException("Username register"); //Exception si el usuario ya existe
        }

        //Crea un nueco usuario
        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(this.passwordEncoder.encode(request.getPassword()))
                .role(role)
                .enabled(true)
                .build();


        //Guarda el usuario creado en la base de datos
        user = this.userRepository.save(user);

        //Genera la respuesta de registro e el token JWT
        return AuthUserResponseDto.builder()
                .message(user.getRole() + "successfully authenticated")
                .token(this.jwtUtil.generateToken(user))
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    @Override
    public UserEntity create(UserRequestDto userRequestDto) {
        UserEntity userEntity = userMapper.toEntity(userRequestDto);
        return userRepository.save(userEntity);
    }

    @Override
    public void delete(Long id) {
        if(!userRepository.existsById(id)){
            throw new EntityNotFoundException("User not found");
        }

        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponseDto> readAll() {
        List<UserEntity> listUser = userRepository.findAll();

        return listUser.stream()
                .map(userMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto readById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.toResponseDto(user);
    }

    @Override
    public UserEntity update(UserRequestDto userRequestDto, Long id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new EntityNotFoundException("User not found");
        }
        UserEntity userEntity = optionalUser.get();

        userEntity.setName(userRequestDto.getName());
        userEntity.setEmail(userEntity.getEmail());

        return userRepository.save(userEntity);
    }
}
