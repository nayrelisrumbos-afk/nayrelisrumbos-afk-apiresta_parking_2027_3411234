package com.sena.apiparking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "espacios_parqueos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EspacioParqueadero{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_espacio;
	@Column(nullable = false)
	private Integer numero;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoVehiculo tipo;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
    @Builder.Default
	private EstadoEspacio estado = EstadoEspacio.LIBRE;
}