package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.awt.*;
import java.util.Date;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    private  int empId;
    private  String empFirstName;
    private  String empLastName;
    private long empContactNumber;
    private  String empEmailId;
    private long empuId;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date empDob;
}
