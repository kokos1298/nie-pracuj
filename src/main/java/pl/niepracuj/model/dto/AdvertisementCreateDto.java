package pl.niepracuj.model.dto;

import lombok.*;

import java.time.Instant;
import java.util.Set;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementCreateDto { //dto do stworzenia ogloszenia

    private String name;

    private Instant expireDate;

    private Long salaryFrom;

    private Long salaryTo;

    private String description;

    private Long companyId;

    private Long technologyId;

    private Long seniorityId;

    private Long cityIdy;

    private Set<SkillCreateDto> skills;
}
