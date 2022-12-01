package pl.niepracuj.model.dto;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {

    private Long id;

    private String name;

    private StateDto state;
    
}
