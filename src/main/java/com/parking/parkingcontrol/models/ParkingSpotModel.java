package com.parking.parkingcontrol.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DBPARKINGSPOT")
public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String vaga;
    @Column(nullable = false, unique = true, length = 7)
    private String placa;
    @Column(nullable = false, length = 70)
    private String marca;
    @Column(nullable = false,length = 70)
    private String modelo;
    @Column(nullable = false,length = 70)
    private String cor;
    @Column(nullable = false)
    private LocalDateTime data;
    @Column(nullable = false,length = 130)
    private String responsavel;
    @Column(nullable = false,length = 30)
    private String apartamento;
    @Column(nullable = false,length = 30)
    private String bloco;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVaga() {
        return this.vaga;
    }

    public void setVaga(String vaga) {
        this.vaga = vaga;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getResponsavel() {
        return this.responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getApartamento() {
        return this.apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getBloco() {
        return this.bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }


}
