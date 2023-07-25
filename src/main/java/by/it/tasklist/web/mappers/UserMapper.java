package by.it.tasklist.web.mappers;

import by.it.tasklist.domain.user.User;
import by.it.tasklist.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}
