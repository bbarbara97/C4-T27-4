package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="investigadores")//en caso que la tabla sea diferente
public class Investigadores {

	//Atributos de entidad estudiante
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private int id;
		@Column(name = "dni")//no hace falta si se llama igual
		private String dni;
		
		@Column(name = "nom_apels")//no hace falta si se llama igual
		private String nomApels;
		
		@OneToMany
	    @JoinColumn(name="id")
	    private List<Reserva> reserva;

		@ManyToOne
	    @JoinColumn(name = "facultad")
	    Facultad facultad;

		//Constructores
		
		public Investigadores() {

		}

		public Investigadores(int id, String dni, String nomApels, List<Reserva> reserva, Facultad facultad) {
			super();
			this.id = id;
			this.dni = dni;
			this.nomApels = nomApels;
			this.reserva = reserva;
			this.facultad = facultad;
		}

		//Getters y Setters
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getNomApels() {
			return nomApels;
		}

		public void setNomApels(String nomApels) {
			this.nomApels = nomApels;
		}

		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
		public List<Reserva> getReserva() {
			return reserva;
		}

		public void setReserva(List<Reserva> reserva) {
			this.reserva = reserva;
		}

		public Facultad getFacultad() {
			return facultad;
		}

		public void setFacultad(Facultad facultad) {
			this.facultad = facultad;
		}

		//Metodo toString
		
		@Override
		public String toString() {
			return "Investigadores [id=" + id + ", dni=" + dni + ", nomApels=" + nomApels + ", reserva=" + reserva
					+ ", facultad=" + facultad + "]";
		}
}
