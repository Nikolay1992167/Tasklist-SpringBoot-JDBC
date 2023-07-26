package by.it.tasklist.repository;

import by.it.tasklist.domain.user.Role;
import by.it.tasklist.domain.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.Optional;
@Mapper
public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByUserName(String username);
    void update(User user);
    void create(User user);
    void insertUserRole(@Param("userId") Long userId, @Param("role") Role role);
    boolean isTaskOwner(@Param("userId") Long userId, @Param("taskId") Long taskId);
    void delete(Long id);
}
