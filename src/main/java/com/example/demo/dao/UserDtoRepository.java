package com.example.demo.dao;

import com.example.demo.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDtoRepository extends JpaRepository<UserDto,String> {

}
