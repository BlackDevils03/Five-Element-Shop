package com.project.DuAnTotNghiep.repository;

import com.project.DuAnTotNghiep.dto.CustomerDto.CustomerDto;
import com.project.DuAnTotNghiep.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByCode(String code);

    Customer findTopByOrderByIdDesc();

    @Query("SELECT c FROM Customer c WHERE c.code LIKE %:keyword% OR c.name LIKE %:keyword% OR c.phoneNumber LIKE %:keyword%")
    Page<Customer> searchCustomerKeyword(String keyword,Pageable pageable);

//    @Query("SELECT distinct c from Customer c join Bill b on c.id = b.customer.id join BillDetail bd on b.id = bd.id where bd.id = :billDetailId")
//    Customer findByBillDetailId(@Param("billDetailId") Long billDetailId);
//
//    @Query("SELECT distinct c from Customer c join Bill b on c.id = b.customer.id join BillDetail bd on b.id = bd.id join ReturnDetail rd on bd.id = rd.billDetail.id join BillReturn br on br.id = rd.billReturn.id where bd.id = :billReturnId")
//    Customer findByBillBillReturnId(@Param("billReturnId") Long billReturnId);

}
