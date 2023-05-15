package com.zhetkerbaeva_nazerke.newstask.services.impl;

import com.zhetkerbaeva_nazerke.newstask.entities.Roles;
import com.zhetkerbaeva_nazerke.newstask.entities.Users;
import com.zhetkerbaeva_nazerke.newstask.repositories.RolesRepository;
import com.zhetkerbaeva_nazerke.newstask.repositories.UsersRepository;
import com.zhetkerbaeva_nazerke.newstask.services.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService, UserDetailsService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Users saveUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    @Override
    public Users getUser(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Roles saveRole(Roles role) {
        return rolesRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Users user = usersRepository.findByUsername(username);
        Roles role = rolesRepository.findByRole(roleName);
        user.getRoles().add(role);
        usersRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User is not found");
        } else {

        }
        Collection<SimpleGrantedAuthority> roles_auth = new ArrayList<>();
        user.getRoles().forEach(role -> {roles_auth.add(new SimpleGrantedAuthority(role.getRole())); });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles_auth);
    }
}
