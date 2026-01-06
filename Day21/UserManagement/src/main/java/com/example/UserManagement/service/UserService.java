package com.example.UserManagement.service;

import com.example.UserManagement.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO userDTO);
    boolean deleteUser(Long id);
}
