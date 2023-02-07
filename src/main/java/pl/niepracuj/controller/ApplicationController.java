package pl.niepracuj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.application.ApplicationCreateDto;
import pl.niepracuj.model.dto.ApplicationDto;
import pl.niepracuj.service.application.ApplicationService;

import java.io.IOException;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/create")
    public ApplicationDto createApplication(ApplicationCreateDto applicationCreateDto) throws IOException { //przesylanie pliku
        return applicationService.createApplication(applicationCreateDto);
    }
}
