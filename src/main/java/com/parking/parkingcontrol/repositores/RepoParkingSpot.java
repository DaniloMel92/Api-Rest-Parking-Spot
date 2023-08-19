package com.parking.parkingcontrol.repositores;

import java.util.UUID;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.parkingcontrol.models.ParkingSpotModel;
@Repository
public interface RepoParkingSpot extends JpaRepository<ParkingSpotModel,UUID>{
    boolean existsByPlaca(String placa);
    boolean existsByVaga(String vaga);
    boolean existsByApartamentoAndBloco(String apartamento,String bloco);
    
    

}
