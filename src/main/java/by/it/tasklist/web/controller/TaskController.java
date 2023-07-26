package by.it.tasklist.web.controller;

import by.it.tasklist.domain.task.Task;
import by.it.tasklist.service.TaskService;
import by.it.tasklist.web.dto.task.TaskDto;
import by.it.tasklist.web.dto.validation.OnUpdate;
import by.it.tasklist.web.mappers.TaskMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/tasks")
@RequiredArgsConstructor
@Validated
@Tag(name = "Task Controller", description = "Task API")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PutMapping
    @Operation(summary = "Update task.")
    public TaskDto update(@Validated(OnUpdate.class) @RequestBody TaskDto dto){
        Task task = taskMapper.toEntity(dto);
        Task updateTask = taskService.update(task);
        return taskMapper.toDto(updateTask);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get task by id.")
    public TaskDto getById(@PathVariable Long id){
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete task by id.")
    public void deleteById(@PathVariable Long id){
        taskService.delete(id);
    }
}
