package by.it.tasklist.web.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JwtRequest {
    @NotNull(message = "UseName must be not null.")
    private String userName;
    @NotNull(message = "Password must be not null.")
    private String password;
}
