package com.parking.parkingcontrol.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ParkingSpotDto {
    @NotBlank
    private String vaga;
    @NotBlank
    @Size(max = 7)
    private String placa;
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotBlank
    private String cor;
    @NotBlank
    private String responsavel;
    @NotBlank
    private String apartamento;
    @NotBlank
    private String bloco;

    
	

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