package pl.niepracuj.model.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.AdvertisementDto;
import pl.niepracuj.model.dto.SkillDto;
import pl.niepracuj.model.entity.Advertisement;
import pl.niepracuj.model.entity.Skill;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AdvertisementMapper {

    private final CompanyMapper companyMapper;
    private final TechnologyMapper technologyMapper;
    private final SeniorityMapper seniorityMapper;
    private final CityMapper cityMapper;

    private final SkillMapper skillMapper;

    public AdvertisementDto toDto (Advertisement advertisement) {
        return AdvertisementDto.builder()
                .id(advertisement.getId())
                .name(advertisement.getName())
                .publishDate(advertisement.getPublishDate())
                .expireDate(advertisement.getExpireDate())
                .salaryFrom(advertisement.getSalaryFrom())
                .salaryTo(advertisement.getSalaryTo())
                .description(advertisement.getDescription())
                .company(companyMapper.toDto(advertisement.getCompany()))
                .technology(technologyMapper.toDto(advertisement.getTechnology()))
                .seniority(seniorityMapper.toDto(advertisement.getSeniority()))
                .city(cityMapper.toDto(advertisement.getCity()))
                .skills(getSkills(advertisement.getSkills()))
                .build();

    }
    //metoda robiaca seta ze skillsdto
    private Set<SkillDto> getSkills(Set<Skill> skills) {
        return skills.stream().map(skillMapper::toDto).collect(Collectors.toSet());
    }
}
