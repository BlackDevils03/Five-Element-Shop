package com.project.DuAnTotNghiep.entity;

import lombok.*;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "bill_return")
public class BillReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @Nationalized
    private String returnReason;

    private LocalDateTime returnDate;

    private Integer percentFeeExchange;
    private Double returnMoney;

    private boolean isCancel;

    @OneToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @OneToMany(mappedBy = "billReturn", cascade = CascadeType.ALL)
    private List<ReturnDetail> returnDetails;

}
