package uo.sdi.persistence;

import uo.sdi.model.User;
import uo.sdi.persistence.util.GenericDao;

public interface UserDao extends GenericDao<User, Long> {

	User findByLogin(String login, String password);

	User findByLogin(String login);

}
