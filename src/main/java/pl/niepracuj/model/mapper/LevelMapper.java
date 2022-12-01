package pl.niepracuj.model.mapper;

import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.LevelDto;
import pl.niepracuj.model.entity.Level;

@Component
public class LevelMapper {


    public LevelDto toDto (Level level) {
        return LevelDto.builder()
                .id(level.getId())
                .score(level.getScore())
                .name(level.getName())
                .build();
    }

    public Level toNewEntity(LevelDto levelDto) {
        return Level.builder()
                .score(levelDto.getScore())
                .name(levelDto.getName())
                .build();
    }
}
