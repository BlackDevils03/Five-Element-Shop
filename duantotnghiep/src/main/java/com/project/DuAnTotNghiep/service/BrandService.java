package com.project.DuAnTotNghiep.service;

import com.project.DuAnTotNghiep.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    Page<Brand> getAllBrand(Pageable pageable);

    Brand save(Brand brand);

    void delete(Long id);

    Optional<Brand> findById(Long id);

    List<Brand> getAll();
}
