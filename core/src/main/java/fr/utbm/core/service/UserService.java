/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.service;

import fr.utbm.core.dao.UserDao;
import fr.utbm.core.entity.User;

import org.springframework.stereotype.Service;

/**
 *
 * @author 
 */
@Service
public class UserService {
	public void registerUser(User u) {
        UserDao dao = new UserDao();
        dao.registerUser(u);
}
    
    public User getUser(int id){
        UserDao dao = new UserDao();
        return dao.getUser(id);
    }
    
    public void deleteUser(int id){
        UserDao dao = new UserDao();
        dao.deleteUser(id);
    }

}
