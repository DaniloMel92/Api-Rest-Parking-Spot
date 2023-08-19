package com.parking.parkingcontrol.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.parking.parkingcontrol.models.ParkingSpotModel;
import com.parking.parkingcontrol.repositores.RepoParkingSpot;

import jakarta.transaction.Transactional;

@Service
public class ParkingSpotService {
    final RepoParkingSpot repoParkingSpot;
    public ParkingSpotService(RepoParkingSpot repoParkingSpot) {
        this.repoParkingSpot = repoParkingSpot;
    }
    
    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel){
    
        return repoParkingSpot.save(parkingSpotModel);
    }

    public boolean existsByPlaca(String placa){
        return repoParkingSpot.existsByPlaca(placa);
    }
    public boolean existsByVaga(String vaga){
        return repoParkingSpot.existsByVaga(vaga);
    }
    public boolean existsByApartamentoAndBloco(String apartamento,String bloco){
        return repoParkingSpot.existsByApartamentoAndBloco(apartamento, bloco);
    }
    public Page<ParkingSpotModel> getTodos(org.springframework.data.domain.Pageable pageable){
        return repoParkingSpot.findAll(pageable);

    }
    public Optional<ParkingSpotModel>getIdVagaDeEstacionamento(UUID id){
       return repoParkingSpot.findById(id);
    }
    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel){
       repoParkingSpot.delete(parkingSpotModel);
    }
    
}
