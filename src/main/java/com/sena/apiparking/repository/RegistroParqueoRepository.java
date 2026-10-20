package com.sena.apiparking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sena.apiparking.model.EspacioParqueadero;
import com.sena.apiparking.model.RegistroParqueadero;

import jakarta.persistence.LockModeType;

public interface RegistroParqueoRepository extends JpaRepository<RegistroParqueadero, Long> {
	
	@Query("select count(r) > 0 from RegistroParqueo r join r.vehiculo = v where v.placa = :placa and r.fechaSalida is null ")
	boolean existsByVehiculoPlacaAndFechaSalidaIsNull(@Param("placa") String placa);
	
	
	@Query("select count?(r) > 0 from RegistroParqueo r where r.espacio = :espacio")
	boolean existByEspacio(@Param("espacio") EspacioParqueadero espacio);
	
	
	
	Optional<RegistroParqueadero> findByVehiculoPlacaAndFechaSalidaIsNull(String placa);
	
	List<RegistroParqueadero> findByFechaSalidaIsNullOrderByFechaEntradaDesc();
	
	List<RegistroParqueadero> findByFechaSalidaIsnotNullOrderByFechaEntradaDesc();
	
	Optional<RegistroParqueadero> findByVehiculoPlacaAndFechaEntradaIsNull(String placa);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select r from RegistroParqueadero r joinr.vehiculo where v.placa = :placa " + "and r.fechaSalida is null")
	Optional<RegistroParqueadero> bloquearActivoPorPlaca(@Param("placa") String placa);
	

}
