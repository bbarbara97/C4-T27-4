package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="facultad")//en caso que la tabla sea diferente
public class Facultad {

	//Atributos de entidad estudiante
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private int codigo;
		@Column(name = "nombre")//no hace falta si se llama igual
		private String nombre;
		
		@OneToMany
	    @JoinColumn(name="codigo")
	    private List<Equipos> equipos;
		
		@OneToMany
	    @JoinColumn(name="codigo")
	    private List<Investigadores> investigadores;

		//Constructores
		
		public Facultad() {

		}

		public Facultad(int codigo, String nombre, List<Equipos> equipos, List<Investigadores> investigadores) {
			super();
			this.codigo = codigo;
			this.nombre = nombre;
			this.equipos = equipos;
			this.investigadores = investigadores;
		}

		//Getters y Setters
		
		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipos")
		public List<Equipos> getEquipos() {
			return equipos;
		}

		public void setEquipos(List<Equipos> equipos) {
			this.equipos = equipos;
		}

		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigadores")
		public List<Investigadores> getInvestigadores() {
			return investigadores;
		}

		public void setInvestigadores(List<Investigadores> investigadores) {
			this.investigadores = investigadores;
		}
		
		//Metodo toString
	
		@Override
		public String toString() {
			return "Facultad [codigo=" + codigo + ", nombre=" + nombre + ", equipos=" + equipos + ", investigadores="
					+ investigadores + "]";
		}
}
