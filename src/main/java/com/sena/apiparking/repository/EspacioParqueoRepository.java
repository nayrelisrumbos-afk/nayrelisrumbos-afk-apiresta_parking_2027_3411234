package com.sena.apiparking.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sena.apiparking.model.EspacioParqueadero;
import com.sena.apiparking.model.EstadoEspacio;
import com.sena.apiparking.model.TipoVehiculo;

import jakarta.persistence.LockModeType;

public interface EspacioParqueoRepository  extends JpaRepository<EspacioParqueadero, Long>{
	
	@Query("select  count(e) > 0 from EspacioParqueo e where e.numero = :numero")
	boolean existsByNumero(@Param("numero") Integer numero);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<EspacioParqueadero> findFirstByTipoAndEstadoOrderByNumeroAsc( TipoVehiculo tipo, EstadoEspacio estado);
	
	
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select e from EspacioParqueadero e where e.numero = :numero")
Optional<EspacioParqueadero> bloquearPorNumero(@Param("numero") Integer numero);
	

}
