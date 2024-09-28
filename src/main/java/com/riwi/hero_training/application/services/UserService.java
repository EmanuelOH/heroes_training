package com.riwi.hero_training.application.services;

import com.riwi.hero_training.application.dtos.requests.UserRequestDto;
import com.riwi.hero_training.application.dtos.responses.UserResponseDto;
import com.riwi.hero_training.application.mappers.UserMapper;
import com.riwi.hero_training.domain.entities.UserEntity;
import com.riwi.hero_training.domain.ports.service.interfaces.IUserService;
import com.riwi.hero_training.infrastructure.persistence.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

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
