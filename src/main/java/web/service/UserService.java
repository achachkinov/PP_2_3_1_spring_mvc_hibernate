package web.service;

import java.util.List;

import web.models.User;

public interface UserService {
    public void save(User user);
    public User findById(Long id);
    public List<User> getAllUsers();
    public void updateUser(User user);
    public void deleteById( Long id );
}
