package pl.niepracuj.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "advertisements")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Instant publishDate;

    private Instant expireDate;

    private Long salaryFrom;

    private Long salaryTo;

    private String description;


    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToOne
    private Technology technology;

    @ManyToOne
    private Seniority seniority;

    @ManyToOne
    private City city;

    @ManyToMany
    @JoinTable(
            name = "adv_skills",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "adv_id")
    )
    private Set<Skill> skills;
}
