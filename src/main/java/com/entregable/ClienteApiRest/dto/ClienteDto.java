package com.entregable.ClienteApiRest.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//ClienteDto para los response 
public class ClienteDto {
    private String nombreDto;
    private String apellidoDto;
    private LocalDate nacimientoDto;
    private Integer edad;
}
