package pl.niepracuj.service.advertisement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niepracuj.model.dto.AdvertisementDto;
import pl.niepracuj.model.mapper.AdvertisementMapper;
import pl.niepracuj.repository.AdvertisementRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final AdvertisementMapper advertisementMapper;
    @Override
    public List<AdvertisementDto> getAllAdvertisements() {
        return advertisementRepository.findAll().stream().map(advertisementMapper::toDto)
                .collect(Collectors.toList());
    }
}
