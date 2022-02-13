package com.cms.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Health {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String healthName;
    private String regNumber;
    private String managerName;

}
