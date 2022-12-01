package pl.niepracuj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.niepracuj.model.dto.AdvertisementDto;
import pl.niepracuj.service.advertisement.AdvertisementService;

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

    //@PostMapping("/create")
    //public CompanyDto createAdvertisement(@RequestBody AdvertisementCreateDto advertisementCreateDto) {
     //   return advertisementService.createAdvertisement(advertisementCreateDto);
    }
