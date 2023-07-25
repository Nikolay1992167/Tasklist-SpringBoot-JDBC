package by.it.tasklist.repository.impl;

import by.it.tasklist.domain.user.Role;
import by.it.tasklist.domain.user.User;
import by.it.tasklist.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void create(User user) {

    }

    @Override
    public void insertUserRole(Long userId, Role role) {

    }

    @Override
    public void isTaskOwner(Long userId, Long taskId) {

    }

    @Override
    public void delete(Long id) {

    }
}
