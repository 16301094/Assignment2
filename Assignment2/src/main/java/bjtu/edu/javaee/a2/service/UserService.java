package bjtu.edu.javaee.a2.service;

import bjtu.edu.javaee.a2.domain.User;

public interface UserService {

    Iterable<User> getAllUsers();
    User getUserById(Integer id);
    User saveUser(User contact);
    void deleteUser(Integer id);
    User getUserDetail(final int id);
}
