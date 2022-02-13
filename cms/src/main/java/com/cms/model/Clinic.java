package com.cms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clinicName;
    private String regNumber;
    private String managerName;

}
