package pl.niepracuj.model.dto;

import lombok.*;
import pl.niepracuj.model.enums.SeniorityEnum;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeniorityDto {

    private Long id;

    private SeniorityEnum name;
}
