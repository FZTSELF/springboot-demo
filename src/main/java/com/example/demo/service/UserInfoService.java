package com.example.demo.service;

import com.example.demo.dao.UserDtoRepository;
import com.example.demo.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 */

@Service
public class UserInfoService {

    @Autowired
    UserDtoRepository userDtoRepository;

    private Logger log= LoggerFactory.getLogger(UserInfoService.class);

    public UserDto getUserDto(){
        UserDto userDto=new UserDto("123","哈哈哈");
        log.info("UserInfoService-getUserDto,出参，当前用户：{}",userDto.getUserName());
        return userDto;
    }

    /**
     * 增加用户
     * @param userDto
     */
    public void addUserDto(UserDto userDto){
        userDtoRepository.save(userDto);
        log.info("UserInfoService-addUserDto,入参，当前用户：{}",userDto.getUserName());
    }

    /**
     * 根据id查询用户
     * @param id
     * @return userDto
     */
    public UserDto getUserDtoById(String id){
        Optional<UserDto> userOpt = userDtoRepository.findById(id);
        UserDto userDto=null;
        if(userOpt.isPresent()){
            userDto = userDtoRepository.findById(id).get();
            log.info("UserInfoService-getUserDtoById,出参,当前用户：{}",userDto.getUserName());
        }
        return userDto;
    }

    /**
     * 修改用户
     * @param userDto
     */
    public boolean modifyUserDto(UserDto userDto){
        Optional<UserDto> userOpt = userDtoRepository.findById(userDto.getId());
        if(userOpt.isPresent()){
            userDtoRepository.save(userDto);
            log.info("UserInfoService-modifyUserDto,入参，当前用户：{}",userDto.getUserName());
            return true;
        }else {
            System.out.println("用户不存在");
            return false;
        }

    }

    /**
     * 查询全部用户
     * @return userDtos
     */
    public List<UserDto> getUserDtoAll(){
        
        List<UserDto> userDtos=userDtoRepository.findAll();
        log.info("UserInfoService-getUserDtoAll,出参");
        System.out.println("全部用户："+userDtos);
        return userDtos;
    }

    /**
     * 根据id删除用户
     * @param id
     */
    public boolean deleteUserDtoById(String id){
        UserDto userDto=getUserDtoById(id);
        if(userDto!=null){
            userDtoRepository.deleteById(id);
            log.info("UserInfoService-deleteUserDtoById,入参");
            return true;
        }else {
            System.out.println("用户不存在");
            return false;
        }

    }
}
