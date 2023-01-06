package pl.niepracuj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.AdvertisementCreateDto;
import pl.niepracuj.model.dto.AdvertisementDto;
import pl.niepracuj.service.advertisement.AdvertisementService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/adv")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @GetMapping("/all") //wybierze wszystkie
    public List<AdvertisementDto> getAdvertisements() {
        return advertisementService.getAllAdvertisements();
    }

    @PostMapping("/create") //wkladanie nowych ogloszen
    public AdvertisementDto createAdvertisement(@RequestBody @Valid AdvertisementCreateDto advertisementCreateDto) {
        return advertisementService.createAdvertisement(advertisementCreateDto);
    }
}
