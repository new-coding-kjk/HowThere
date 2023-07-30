package com.howthere.app.entity;

import com.howthere.app.auditing.Period;
import com.howthere.app.entity.rentCarType.RentCarType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter @ToString
@Table(name = "TBL_RENT_CAR")
@SQLDelete(sql = "UPDATE TBL_RENT_CAR SET DELETED = 1 WHERE ID = ?")
@Where(clause = "DELETED = 0")
public class RentCar extends Period {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @Enumerated(EnumType.STRING)
    private RentCarType rentCarType;
    private String rentCarName;
    private Integer rentCarPrice;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private RentCarCompany rentCarCompany;


}
