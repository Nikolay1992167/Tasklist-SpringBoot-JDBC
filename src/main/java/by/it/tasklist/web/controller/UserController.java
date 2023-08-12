package by.it.tasklist.web.controller;

import by.it.tasklist.domain.task.Task;
import by.it.tasklist.domain.user.User;
import by.it.tasklist.service.TaskService;
import by.it.tasklist.service.UserService;
import by.it.tasklist.web.dto.task.TaskDto;
import by.it.tasklist.web.dto.user.UserDto;
import by.it.tasklist.web.dto.validation.OnCreate;
import by.it.tasklist.web.dto.validation.OnUpdate;
import by.it.tasklist.web.mappers.TaskMapper;
import by.it.tasklist.web.mappers.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "User Controller", description = "User API")
public class UserController {

    private final UserService userService;
    private final TaskService taskService;
    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @PutMapping
    @Operation(summary = "Update user.")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#dto.id)")
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto dto){
        User user = userMapper.toEntity(dto);
        User updateUser = userService.update(user);
        return userMapper.toDto(updateUser);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id.")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public UserDto getById(@PathVariable Long id){
         User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id.")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public void deleteById(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    @Operation(summary = "Get all user tasks.")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id){
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping("/{id}/tasks")
    @Operation(summary = "Add tasks to user.")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public TaskDto createTask(@PathVariable Long id, @Validated(OnCreate.class) @RequestBody TaskDto dto){
        Task task = taskMapper.toEntity(dto);
        Task createdTask = taskService.create(task,id);
        return taskMapper.toDto(createdTask);
    }
}
