package com.example.droid.entity;

import com.example.droid.validator.MyValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.util.resources.LocaleData;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="droids", uniqueConstraints={@UniqueConstraint(columnNames = {"manufacturer" , "modelId"})})
public class DroidEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @MyValidation
    private String manufacturer;
    @Column(nullable = false)
    private String modelId;
    @Column(nullable = false)
    private String builtAt;

}
