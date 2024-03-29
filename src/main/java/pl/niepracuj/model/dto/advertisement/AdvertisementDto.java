package pl.niepracuj.model.dto.advertisement;

import lombok.*;
import pl.niepracuj.model.dto.*;

import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDto { //dto do wypychania wszystkich elementow ogloszenia

    private Long id; // do zwracana co to za ogloszenia - response

    private String name;

    private LocalDateTime publishDate;

    private LocalDateTime expireDate;

    private Long salaryFrom;

    private Long salaryTo;

    private String description;

    private CompanyDto company;

    private TechnologyDto technology;

    private SeniorityDto seniority;

    private CityDto city;

    private Set<SkillDto> skills;
}

