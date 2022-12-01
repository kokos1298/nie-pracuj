package pl.niepracuj.model.entity;

import lombok.*;
import pl.niepracuj.model.enums.TechnologyEnum;

import javax.persistence.*;

@Entity
@Table(name = "technologies")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) //trzeba powiedziec ze enum to string
    private TechnologyEnum name;
}
