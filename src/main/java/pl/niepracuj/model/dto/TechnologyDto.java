package pl.niepracuj.model.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;
import pl.niepracuj.model.enums.TechnologyEnum;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyDto {

    private Long id;

    private TechnologyEnum name;

}
