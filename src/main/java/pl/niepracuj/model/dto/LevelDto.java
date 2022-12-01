package pl.niepracuj.model.dto;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LevelDto {

    private Long id;

    private String name;

    private Integer score;

}
