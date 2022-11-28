package pl.niepracuj.model.mapper;

import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.CompanyDto;
import pl.niepracuj.model.entity.Company;

@Component //bo bedziemy go wstrzykiwac
public class CompanyMapper {

    //z encji do dto
    public CompanyDto toDto (Company company) {
        return CompanyDto.builder()
                .id(company.getId())
                .email(company.getEmail())
                .size(company.getSize())
                .address(company.getAddress())
                .name(company.getName())
                .build();
    }
    //w druga strone
    public Company toNewEntity(CompanyDto companyDto) { //newentity bo bez id wysylamy encje !
        return Company.builder()
                .address(companyDto.getAddress())
                .email(companyDto.getEmail())
                .size(companyDto.getSize())
                .name(companyDto.getName())
                .build();
    }
}
