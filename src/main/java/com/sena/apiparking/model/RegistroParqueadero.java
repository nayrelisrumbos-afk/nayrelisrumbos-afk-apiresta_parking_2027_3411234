package com.sena.apiparking.model;

import java.time.LocalDateTime;
import java.util.jar.Attributes.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "registros_parqueos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroParqueadero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_registro;
	@ManyToOne(optional = false)
	@JoinColumn (name = "espacio_id", nullable = false)
	
	private EspacioParqueadero espacio;
	@Column(nullable = false)
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	private Double valrPagado;
	
}