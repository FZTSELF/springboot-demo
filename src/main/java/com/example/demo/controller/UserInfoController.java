package com.example.demo.controller;



import com.example.demo.dto.UserDto;
import com.example.demo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {



    private Logger log= LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("userInfo")
    public String userInfo(){

        log.info("UserInfoController-userInfo日志");
        return userInfoService.getUserDto().toString();
    }

    @GetMapping("addUser")
    public String addUser(UserDto userDto){

        System.out.println("用户："+userDto.getUserName());
        userInfoService.addUserDto(userDto);
        log.info("UserInfoController-addUser日志");
        return userDto.toString();
    }

    @GetMapping("userOne")
    public String getUserOne(String id){
        UserDto userDto=userInfoService.getUserDtoById(id);
        log.info("UserInfoController-getUserOne日志");
        return userDto.toString();
    }

    @GetMapping("modify")
    public String modifyUser(UserDto userDto){

        userInfoService.modifyUserDto(userDto);
        log.info("UserInfoController-modifyUser日志");
        return null;
    }

    @GetMapping("userAll")

    public String getUserAll(){

        List<UserDto> userDtos=userInfoService.getUserDtoAll();
        log.info("UserInfoController-getUserAll日志");
        return userDtos.toString();
    }

    @GetMapping("deleteUser")
    public String deleteUser(String id){

        userInfoService.deleteUserDtoById(id);
        log.info("UserInfoController-deleteUser日志");
        return null;
    }
}
