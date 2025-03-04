package web.dao;

import java.util.List;

import web.models.User;

public interface UserDao {
    void save(User user);
    User findById(Long id);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteById(Long id);
}
