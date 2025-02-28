package web.dao;

import java.util.List;

import web.models.User;

public interface UserDao {
    public void save(User user);
    public User findById(Long id);
    public List<User> getAllUsers();
    public void updateUser(User user);
    public void deleteById( Long id );
}
