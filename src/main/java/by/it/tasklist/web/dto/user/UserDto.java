package by.it.tasklist.web.dto.user;

import by.it.tasklist.web.dto.validation.OnUpdate;
import by.it.tasklist.web.dto.validation.OnCreate;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Schema(description = "UserDto")
public class UserDto {
    @Schema(description = "User id", example = "1")
    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long id;

    @Schema(description = "User name", example = "Alex Morozov")
    @NotNull(message = "Name must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols.",  groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @Schema(description = "User email", example = "alexmorozov@gmail.com")
    @NotNull(message = "UserName must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "UserName length must be smaller than 255 symbols.",  groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @Schema(description = "User crypted password", example = "$2a$10$Tmrk..tMJ3LxaS2jN9HoReaoP1vOOFUfyN94lHHGnPmHI4yDWNq32")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null.", groups = {OnCreate.class, OnUpdate.class})
    private String password;

    @Schema(description = "User password confirmation", example = "$2a$10$Tmrk..tMJ3LxaS2jN9HoReaoP1vOOFUfyN94lHHGnPmHI4yDWNq32")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password confirmation must be not null.", groups = {OnCreate.class})
    private String passwordConfirmation;
}
