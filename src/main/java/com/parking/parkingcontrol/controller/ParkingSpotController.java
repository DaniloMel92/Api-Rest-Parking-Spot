package com.parking.parkingcontrol.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.parkingcontrol.dto.ParkingSpotDto;
import com.parking.parkingcontrol.models.ParkingSpotModel;
import com.parking.parkingcontrol.services.ParkingSpotService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {
    final ParkingSpotService parkingSpotService;
        public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
        }
        @PostMapping
        public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotdDto){
            if(parkingSpotService.existsByPlaca(parkingSpotdDto.getPlaca())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito placa de carro já cadastrada");
            }
            if (parkingSpotService.existsByVaga(parkingSpotdDto.getVaga())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("A vaga já está cadastrada para o responsável");
            }
            if (parkingSpotService.existsByApartamentoAndBloco(parkingSpotdDto.getApartamento(),parkingSpotdDto.getBloco())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("A vaga já esta cadastrada para este bloco e apartamento");
            }
            var parkingSpotModel = new ParkingSpotModel();
            BeanUtils.copyProperties(parkingSpotdDto, parkingSpotModel);
            parkingSpotModel.setData(LocalDateTime.now(ZoneId.of("UTC")));
            return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));

        }
        @GetMapping
        public ResponseEntity<Page<ParkingSpotModel>> getTodosVagasEstacionamento(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)org.springframework.data.domain.Pageable pageable){
            return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.getTodos(pageable));
        }
        @GetMapping("/{id}")
        public ResponseEntity <Object> getIdVagaDeEstacionamento(@PathVariable(value = "id")UUID id){
            Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.getIdVagaDeEstacionamento(id);
            if(!parkingSpotModelOptional.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
            }
            return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
        }
        @DeleteMapping("/{id}")
        public ResponseEntity <Object> deleteVaga(@PathVariable(value = "id")UUID id){
            Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.getIdVagaDeEstacionamento(id);
            if(!parkingSpotModelOptional.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada");
            }
            parkingSpotService.delete(parkingSpotModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Vaga de estacionamento deletada com sucesso");
        }
        @PutMapping("/{id}")
        public ResponseEntity<Object> update(@PathVariable(value = "id")UUID id,@RequestBody @Valid ParkingSpotDto parkingSpotDto){
            Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.getIdVagaDeEstacionamento(id);
            if(!parkingSpotModelOptional.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O registro não existe");
            }
            var parkingSpotModel = parkingSpotModelOptional.get();
            parkingSpotModel.setApartamento(parkingSpotDto.getApartamento());
            parkingSpotModel.setBloco(parkingSpotDto.getBloco());
            parkingSpotModel.setCor(parkingSpotDto.getCor());
            parkingSpotModel.setMarca(parkingSpotDto.getMarca());
            parkingSpotModel.setModelo(parkingSpotDto.getModelo());
            parkingSpotModel.setPlaca(parkingSpotDto.getPlaca());
            parkingSpotModel.setResponsavel(parkingSpotDto.getResponsavel());
            parkingSpotModel.setVaga(parkingSpotDto.getVaga());
            return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
        }

    }

