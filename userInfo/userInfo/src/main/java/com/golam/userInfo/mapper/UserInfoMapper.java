package com.golam.userInfo.mapper;

import com.golam.userInfo.dtos.UserDto;
import com.golam.userInfo.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInfoMapper {
    UserInfoMapper Instance = Mappers.getMapper(UserInfoMapper.class);
    User mapUserDtoToUser(UserDto userDto);
    UserDto mapUserToUserDto(User user);
}
