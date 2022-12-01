package pl.niepracuj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.CompanyDto;
import pl.niepracuj.service.company.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    //endpoint do pobierania firm:
    @GetMapping("/all") //wybierze wszystkie
    public List<CompanyDto> getCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping("/create")
    public CompanyDto createCompany(@RequestBody CompanyDto companyDto) { //requetbody to firma ktora mamy stworzyc
        return companyService.createCompany(companyDto);
    }
}
