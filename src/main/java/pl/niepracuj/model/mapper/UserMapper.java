package pl.niepracuj.model.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.CityDto;
import pl.niepracuj.model.dto.UserDto;
import pl.niepracuj.model.entity.User;

@Component

public class UserMapper {


    public UserDto toDto (User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();

    }
}
