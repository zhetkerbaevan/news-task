package com.zhetkerbaeva_nazerke.newstask.services;

import com.zhetkerbaeva_nazerke.newstask.entities.Roles;
import com.zhetkerbaeva_nazerke.newstask.entities.Users;

import java.util.List;

public interface UsersService {
    Users saveUser(Users user);
    Users getUser(String username);
    List<Users> getAllUsers();
    Roles saveRole(Roles role);
    void addRoleToUser(String username, String roleName);

}
