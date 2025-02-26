package com.entregable.ClienteApiRest.models;

import java.time.LocalDate;

import com.entregable.ClienteApiRest.dto.ClienteDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name = "clientes")
@Data
@Builder
@AllArgsConstructor
public class Cliente {
    @Id//clave primaria autogenerada
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nacimiento")
    private LocalDate fecha;//fecha local

    public Cliente() {}//constructor vacio
    //convierte a ClienteDto
    public ClienteDto toClienteDto(){
        return ClienteDto.builder()
               .nombreDto(this.nombre)
               .apellidoDto(this.apellido)
               .nacimientoDto(this.fecha)
               .build();
    }
}
