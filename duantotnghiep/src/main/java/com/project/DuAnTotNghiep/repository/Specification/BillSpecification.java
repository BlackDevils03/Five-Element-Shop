package com.project.DuAnTotNghiep.repository.Specification;

import com.project.DuAnTotNghiep.dto.Bill.SearchBillDto;
import com.project.DuAnTotNghiep.entity.Bill;
import com.project.DuAnTotNghiep.entity.enumClass.BillStatus;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BillSpecification implements Specification<Bill> {
    private SearchBillDto searchBillDto;

    public BillSpecification(SearchBillDto searchBillDto) {
        this.searchBillDto = searchBillDto;
    }

    @Override
    public Predicate toPredicate(Root<Bill> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if(searchBillDto.getKeyword() != null) {
            String keyword = searchBillDto.getKeyword();

            Predicate billCodePredicate = criteriaBuilder.like(root.get("code"), "%" + keyword + "%");
            Predicate customerNamePredicate = criteriaBuilder.like(root.get("customer").get("name"), "%" + keyword + "%");
            Predicate phoneNumberPredicate = criteriaBuilder.like(root.get("customer").get("phoneNumber"), "%" + keyword + "%");

            Predicate combinedPredicate = criteriaBuilder.or(billCodePredicate, customerNamePredicate, phoneNumberPredicate);

            predicates.add(combinedPredicate);
        }

        predicates.add(criteriaBuilder.equal(root.get("returnStatus"), false));
        predicates.add(criteriaBuilder.equal(root.get("status"), BillStatus.HOAN_THANH));
        predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createDate"), LocalDateTime.now().plusDays(7)));
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
