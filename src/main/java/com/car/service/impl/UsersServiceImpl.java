package com.car.service.impl;

import com.car.dao.interfaces.RolesDAO;
import com.car.dao.interfaces.UsersDAO;
import com.car.entity.Car;
import com.car.entity.Orders;
import com.car.entity.Roles;
import com.car.entity.Users;
import com.car.service.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService
{

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private RolesDAO rolesDAO;

    @PersistenceContext
    EntityManager em;

    @Override
    public Users getUser(Long user_id)
    {
        Users users = findUserById(user_id);
        return users;
    }

    @Override
    public Users addUser(Users users, String secretCode)
    {
        Users user = null;
        Roles role = null;
        //boolean flag = usersDAO.findUserByLogin(users.getLogin());
        boolean flag = false;
        if (flag == true)
        {
            return null;
        }
        else
        {
            user = usersDAO.save(users);
            if(secretCode == "admin")
            {
                role = rolesDAO.save(new Roles("Mechanic"));
            }
            else
            {
                role = rolesDAO.save(new Roles("User"));
            }
/*            Query query = em.createQuery("SELECT r FROM roles_has_users r WHERE r.user_id = :user_id and r.role_id = :role_id");
            query.setParameter("role_id", role.getRole_id());
            query.setParameter("user_id", user.getUser_id());
            query.executeUpdate();*/
        }
        return user;
    }

    @Override
    public void deleteUser(Long user_id)
    {
        Users deleteUser = findUserById(user_id);
        usersDAO.delete(deleteUser);
    }

    @Override
    public List<Orders> getUserOrders(Long user_id)
    {
        return null;
    }

    @Override
    public List<Car> getUserCars(Long user_id)
    {
        return null;
    }

    @Override
    public Users findUserById(Long user_id)
    {
        return usersDAO.findOne(user_id);
    }

    @Override
    public boolean findUserByLogin(String login)
    {
        return usersDAO.findUserByLogin(login);
    }

    @Override
    public List<Users> getAllUsers()
    {
        return (List<Users>) usersDAO.findAll();
    }

/*    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }*/
}
