package pl.niepracuj.service.advertisement;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.niepracuj.exception.exceptions.EntityNotFoundException;
import pl.niepracuj.model.dto.advertisement.AdvertisementCreateDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementSearchCriteriaDto;
import pl.niepracuj.model.entity.Advertisement;
import pl.niepracuj.model.entity.Skill;
import pl.niepracuj.model.mapper.AdvertisementMapper;
import pl.niepracuj.model.mapper.SkillMapper;
import pl.niepracuj.repository.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Serwis do obsługi ogłoszeń
 * @author kamila
 */
@Service
@Transactional
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final AdvertisementMapper advertisementMapper;

    private final SkillMapper skillMapper;

    private final CompanyRepository companyRepository;

    private final TechnologyRepository technologyRepository;

    private final SeniorityRepository seniorityRepository;

    private final CityRepository cityRepository;

    private final SkillRepository skillRepository;

    private final LevelRepository levelRepository;

    /**
     * Pobierz wszystkie ogłoszenia
     * @return Lista ogłoszeń
     */
    @Override
    public List<AdvertisementDto> getAllAdvertisements() {
        return advertisementRepository.findAll().stream().map(advertisementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdvertisementDto> getAllAdvertisementsForCompany(Long companyId) {
        return advertisementRepository.findByCompany_Id(companyId).stream().map(advertisementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdvertisementDto> getAdvertisementsByCriteria(AdvertisementSearchCriteriaDto criteriaDto, Pageable pageable) {
        var specification = new AdvertisementSpecification(criteriaDto);
        Page<Advertisement> advertisements = advertisementRepository.findAll(specification, pageable);
        return advertisements.getContent().stream().map(advertisementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdvertisementDto createAdvertisement(AdvertisementCreateDto createDto) {
        Advertisement advertisement = advertisementMapper.toNewEntity(createDto);
        advertisement.setPublishDate(LocalDateTime.now());
        advertisement.setCompany(companyRepository.findById(createDto.getCompanyId())
                .orElseThrow(() -> new EntityNotFoundException("Company", createDto.getCompanyId())));
        advertisement.setTechnology(technologyRepository.findById(createDto.getTechnologyId())
                .orElseThrow(() -> new EntityNotFoundException("Technology", createDto.getTechnologyId())));
        advertisement.setSeniority(seniorityRepository.findById(createDto.getSeniorityId())
                .orElseThrow(() -> new EntityNotFoundException("Seniority", createDto.getSeniorityId())));
        advertisement.setCity(cityRepository.findById(createDto.getCityIdy())
                .orElseThrow(() -> new EntityNotFoundException("City", createDto.getCityIdy())));

        List<Skill> skills = createDto.getSkills().stream()
                .map(skillCreateDto -> {
                    Skill skill = skillMapper.toNewEntity(skillCreateDto);
                    skill.setLevel(levelRepository.findById(skillCreateDto.getLevelId())
                            .orElseThrow(() -> new EntityNotFoundException("Level", skillCreateDto.getLevelId())));
                    return skill;
                }).collect(Collectors.toList()); //przemapowanie skila na encje i do encji dodanie level z bazy + zapisac w bazie

        advertisement.setSkills(new HashSet<>(skillRepository.saveAllAndFlush(skills)));
        return advertisementMapper.toDto(advertisementRepository.save(advertisement));
    }
}