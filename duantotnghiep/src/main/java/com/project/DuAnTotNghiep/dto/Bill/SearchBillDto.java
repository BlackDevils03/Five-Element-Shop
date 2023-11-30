package com.project.DuAnTotNghiep.dto.Bill;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchBillDto {
    private String keyword;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
}
