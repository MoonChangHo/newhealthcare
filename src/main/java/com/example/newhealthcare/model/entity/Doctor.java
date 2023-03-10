package com.example.newhealthcare.model.entity;

import com.example.newhealthcare.BaseEntity;
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
//@ToString(exclude = {"dandpList","diagnosisList"})
public class Doctor extends BaseEntity {
    @Id
    @Column(name="doctor_id")
    private String doctorId;

    private String password;

    private String email;

    private String name;

    private String phone;

    private String major;

    private String code;

    private String gender;

    //Doctor 1 : N DandP
    //cascadeType.Remove= 의사가 삭제될시 환자들도 모두 삭제 (어디 테이블의 환자까지 적용 될진 모름)
    @OneToMany(fetch=FetchType.LAZY,mappedBy = "doctorId")
    @OrderBy(value = "connectSq asc")
    private List<DandP> dandpList;

    @OneToMany(fetch=FetchType.LAZY,mappedBy = "doctorId")
    @OrderBy(value = "diaNum asc")
    private List<Diagnosis> diagnosisList;

}
