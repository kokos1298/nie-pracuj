package pl.niepracuj.model.dto;

import lombok.*;
import pl.niepracuj.model.dto.advertisement.AdvertisementDto;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {

    private Long id;

    private String name;

    private String surname;

    private  String email;

    private String introduction;

    private String path;


}
