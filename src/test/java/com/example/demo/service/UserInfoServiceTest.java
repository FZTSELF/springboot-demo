package com.example.demo.service;

import com.example.demo.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void getUserDto() {
        UserDto userDto=userInfoService.getUserDto();
        System.out.println(userDto);
    }

    @Test
    void addUserDto() {
        UserDto userDto=new UserDto("9999","王五");
        userInfoService.addUserDto(userDto);
    }

    @Test
    void getUserDtoById() {
        UserDto userDto=userInfoService.getUserDtoById("8888");
        System.out.println("找到用户："+userDto);
    }

    @Test
    void modifyUserDto() {
        UserDto userDto=new UserDto("0000","www");
        userInfoService.modifyUserDto(userDto);
    }

    @Test
    void getUserDtoAll() {
        List<UserDto> userDtos=userInfoService.getUserDtoAll();
        System.out.println(userDtos);
    }

    @Test
    void deleteUserDtoById() {
        boolean bool=userInfoService.deleteUserDtoById("6666");
        if(bool){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

}