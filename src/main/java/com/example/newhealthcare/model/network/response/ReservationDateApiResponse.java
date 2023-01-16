package com.example.newhealthcare.model.network.response;

import com.example.newhealthcare.dto.DateDTO;
import com.example.newhealthcare.dto.DoctorResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDateApiResponse {
    private List<DoctorResponseDTO> doctor;
    private List<DateDTO> dateDTOList;
}
