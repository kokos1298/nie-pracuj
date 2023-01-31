package pl.niepracuj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.niepracuj.model.dto.ApplicationCreateDto;
import pl.niepracuj.model.dto.ApplicationDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementCreateDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementSearchCriteriaDto;
import pl.niepracuj.service.advertisement.AdvertisementService;
import pl.niepracuj.service.application.ApplicationService;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
