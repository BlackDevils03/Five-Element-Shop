package com.project.DuAnTotNghiep.repository;

import com.project.DuAnTotNghiep.entity.BillReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BillReturnRepository extends JpaRepository<BillReturn, Long>, JpaSpecificationExecutor<BillReturn> {
    BillReturn findTopByOrderByIdDesc();
}
