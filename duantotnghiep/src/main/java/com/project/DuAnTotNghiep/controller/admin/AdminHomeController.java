package com.project.DuAnTotNghiep.controller.admin;

import com.project.DuAnTotNghiep.dto.Bill.BillDtoInterface;
import com.project.DuAnTotNghiep.dto.Product.ProductDto;
import com.project.DuAnTotNghiep.repository.BillRepository;
import com.project.DuAnTotNghiep.service.BillService;
import com.project.DuAnTotNghiep.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeController {
    private final BillService billService;
    private final ProductService productService;

    private final BillRepository billRepository;

    public AdminHomeController(BillService billService, ProductService productService, BillRepository billRepository) {
        this.billService = billService;
        this.productService = productService;
        this.billRepository = billRepository;
    }

    @GetMapping("/admin")
    public String viewAdminHome(Model model) {
        Page<BillDtoInterface> billDtos = billService.findAll(Pageable.ofSize(10));
        Page<ProductDto> productDtos = productService.getAllProductApi(Pageable.ofSize(10));

        model.addAttribute("totalBillQuantity", billDtos.getTotalElements());
        model.addAttribute("totalProduct", productDtos.getTotalElements());
        model.addAttribute("revenue", billRepository.calculateTotalRevenue());
        return "/admin/index";
    }
}
