package pl.niepracuj.service.application;

import pl.niepracuj.model.dto.application.ApplicationCreateDto;
import pl.niepracuj.model.dto.ApplicationDto;

import java.io.IOException;

public interface ApplicationService {

    ApplicationDto createApplication(ApplicationCreateDto applicationCreateDto) throws IOException;
}
