package fr.utbm.core.service;

import org.springframework.stereotype.Service;

import fr.utbm.core.dao.UserDao;
import fr.utbm.core.entity.User;

/**
 *
 * @author Julien
 */
@Service
public class UserService {
	public void registerUser(User u) {
		UserDao dao = new UserDao();
		dao.registerUser(u);
	}

	public User getUser(int id) {
		UserDao dao = new UserDao();
		return dao.getUser(id);
	}

	public void deleteUser(int id) {
		UserDao dao = new UserDao();
		dao.deleteUser(id);
	}

}
