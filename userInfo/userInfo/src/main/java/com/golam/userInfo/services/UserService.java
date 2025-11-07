package com.golam.userInfo.services;

import com.golam.userInfo.dtos.UserDto;
import com.golam.userInfo.entities.User;
import com.golam.userInfo.mapper.UserInfoMapper;
import com.golam.userInfo.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserInfoRepository userInfoRepository;


    public UserDto saveUser(UserDto userDto) {
        User user = UserInfoMapper.Instance.mapUserDtoToUser(userDto);
        Optional<User> savedUser = Optional.of(userInfoRepository.save(user));
        if(!savedUser.isPresent()){
            return null;
        }
        return UserInfoMapper.Instance.mapUserToUserDto(savedUser.get());
    }

    public UserDto getUserById(int id) {
        Optional<User> user = userInfoRepository.findById(id);
        if(user.isPresent()){
            return UserInfoMapper.Instance.mapUserToUserDto(user.get());
        }
        return null;
    }
}
