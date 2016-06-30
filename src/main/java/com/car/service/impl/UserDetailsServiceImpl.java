package com.car.service.impl;

import com.car.dao.interfaces.UsersDAO;
import com.car.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

    @Autowired
    private UsersDAO usersDAO;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersDAO.findByUsername(username);
        /*List<Roles> role = entityManager.createQuery("select role from roles role" +
                " inner join role.users users where users.username=:username", Roles.class)
                .setParameter("username", username).getResultList();*/
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(users.getRoleList().get(0).getRole()));
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(users.getUsername(),
                        users.getPassword(),
                        roles);
        return userDetails;
    }
}
