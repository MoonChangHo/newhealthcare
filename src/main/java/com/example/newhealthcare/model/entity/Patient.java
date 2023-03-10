package com.example.newhealthcare.model.entity;

import com.example.newhealthcare.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@Builder
@Accessors(chain = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert //null 값인 field는 제외하고 삽입
//@ToString(exclude = {"dandpList","sensorList","reservationList","diagnosisList"})
public class Patient extends BaseEntity {

    @Id
    @Column(name="patient_id", nullable = false)
    private String patientId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String born;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    private String gender;

    //Patient 1 : N DandP
    //mappedBy= DandP테이블의 외래키
    @OneToMany(fetch=FetchType.LAZY,mappedBy = "patientId")
    @OrderBy(value = "connectSq asc")
    private List<DandP> dandpList;

    //Patient 1 : N Sensor
    @OneToMany(fetch=FetchType.LAZY,mappedBy = "patientId")
    @OrderBy(value = "sq asc")
    private List<Sensor> sensorList;

    @OneToMany(fetch=FetchType.LAZY,mappedBy = "patientId")
    @OrderBy(value = "resDate asc,resTime asc")
    private List<Reservation> reservationList;

    @OneToMany(fetch=FetchType.LAZY,mappedBy = "selPatientId")
    @OrderBy(value = "diaDate asc")
    private List<Diagnosis> diagnosisList;

}
