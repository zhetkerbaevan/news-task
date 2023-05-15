package com.zhetkerbaeva_nazerke.newstask.controllers;


import com.zhetkerbaeva_nazerke.newstask.entities.Roles;
import com.zhetkerbaeva_nazerke.newstask.entities.Users;
import com.zhetkerbaeva_nazerke.newstask.services.UsersService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers(){
        return ResponseEntity.ok().body(usersService.getAllUsers());
    }

    @PostMapping("/save/user")
    public ResponseEntity<Users> saveUser(@RequestBody Users user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/save/user").toUriString());
        return ResponseEntity.created(uri).body(usersService.saveUser(user));
    }

    @PostMapping("/save/role")
    public ResponseEntity<Roles> saveRole(@RequestBody Roles roles){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/save/role").toUriString());
        return ResponseEntity.created(uri).body(usersService.saveRole(roles));
    }

    @PostMapping("/addRoletoUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm roleToUserForm){
        usersService.addRoleToUser(roleToUserForm.getUsername(), roleToUserForm.getRoleName());
        return ResponseEntity.ok().build();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class RoleToUserForm {
    private String username;
    private String roleName;
}