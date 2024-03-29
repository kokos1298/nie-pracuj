package pl.niepracuj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.LevelDto;
import pl.niepracuj.service.level.LevelService;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/level")
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;

    @GetMapping("/all")
    public List<LevelDto> getLevels() {
        return levelService.getAllLevels();
    }

    @PostMapping("/create")
    public LevelDto createLevel(@RequestBody LevelDto levelDto) {
        return levelService.createLevel(levelDto);
    }
}
