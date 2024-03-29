package pl.niepracuj.service.advertisement;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import pl.niepracuj.model.dto.advertisement.AdvertisementSearchCriteriaDto;
import pl.niepracuj.model.entity.Advertisement;
import pl.niepracuj.model.entity.Advertisement_;
import pl.niepracuj.model.entity.City_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class AdvertisementSpecification implements Specification<Advertisement> {

    private final AdvertisementSearchCriteriaDto criteriaDto;

    @Override
    public Predicate toPredicate(Root<Advertisement> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
       return criteriaBuilder.and(advertisementNameLike(root, criteriaBuilder),
               cityLike(root, criteriaBuilder),
               seniorityNameEquals(root, criteriaBuilder),
               technologyNameEquals(root, criteriaBuilder),
               salaryFromLessThanOrEqualTo(root, criteriaBuilder),
               salaryToGraterThanOrEqualTo(root, criteriaBuilder));
    }

    //szukanie oferty po name
    private Predicate advertisementNameLike(Root<Advertisement> root, CriteriaBuilder criteriaBuilder) {
        return nonNull(criteriaDto.getName()) ?
                criteriaBuilder.like(criteriaBuilder.lower(root.get(Advertisement_.NAME)), "%" + criteriaDto.getName().toLowerCase() + "%") : //to jest metamodel
                alwaysTruePredicate(criteriaBuilder);
    }

    private Predicate cityLike(Root<Advertisement> root, CriteriaBuilder criteriaBuilder) {
        return nonNull(criteriaDto.getCityName()) ?
                criteriaBuilder.like(criteriaBuilder.lower(root.get(Advertisement_.CITY).get(City_.NAME)), "%" + criteriaDto.getCityName().toLowerCase() + "%") : //metamodel
                alwaysTruePredicate(criteriaBuilder);
    }

    //szukanie po seniority
    private Predicate seniorityNameEquals(Root<Advertisement> root, CriteriaBuilder criteriaBuilder) {
        return nonNull(criteriaDto.getSeniorityName()) ?
                criteriaBuilder.equal(root.get("seniority").get("name"), criteriaDto.getSeniorityName()) :
                alwaysTruePredicate(criteriaBuilder);
    }

    private Predicate technologyNameEquals(Root<Advertisement> root, CriteriaBuilder criteriaBuilder) {
        return nonNull(criteriaDto.getTechnologyName()) ?
                criteriaBuilder.equal(root.get("technology").get("name"), criteriaDto.getTechnologyName()) :
                alwaysTruePredicate(criteriaBuilder);
    }

    private Predicate salaryFromLessThanOrEqualTo(Root<Advertisement> root, CriteriaBuilder criteriaBuilder) {
       return nonNull(criteriaDto.getSalaryTo()) ?
               criteriaBuilder.lessThanOrEqualTo(root.get("salaryFrom"), criteriaDto.getSalaryTo()) :
               alwaysTruePredicate(criteriaBuilder);
    }
    private Predicate salaryToGraterThanOrEqualTo(Root<Advertisement> root, CriteriaBuilder criteriaBuilder) {
        return nonNull(criteriaDto.getSalaryFrom()) ?
                criteriaBuilder.greaterThanOrEqualTo(root.get("salaryTo"), criteriaDto.getSalaryFrom()) :
                alwaysTruePredicate(criteriaBuilder);
    }
    private Predicate alwaysTruePredicate(CriteriaBuilder criteriaBuilder){
        return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
    }
}
