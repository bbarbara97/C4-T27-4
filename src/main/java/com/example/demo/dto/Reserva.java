package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Reserva")//en caso que la tabala sea diferente
public class Reserva {
	
	//Atributos de entidad registro_curso
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private int id;
		
		@ManyToOne
	    @JoinColumn(name = "id_investigador")
	    Investigadores dni;
	 
		@ManyToOne
	    @JoinColumn(name = "num_serie")
	    Equipos numSerie;
			
		@Column(name = "comienzo")//no hace falta si se llama igual
		private Date comienzo;
		@Column(name = "fin")//no hace falta si se llama igual
		private Date fin;
		

		//Constructores
		
		public Reserva() {

		}

		public Reserva(int id, Investigadores dni, Equipos numSerie, Date comienzo, Date fin) {
			this.id = id;
			this.dni = dni;
			this.numSerie = numSerie;
			this.comienzo = comienzo;
			this.fin = fin;
		}

		//Getters y Setters
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Investigadores getDni() {
			return dni;
		}

		public void setDni(Investigadores dni) {
			this.dni = dni;
		}

		public Equipos getNumSerie() {
			return numSerie;
		}

		public void setNumSerie(Equipos numSerie) {
			this.numSerie = numSerie;
		}

		public Date getComienzo() {
			return comienzo;
		}

		public void setComienzo(Date comienzo) {
			this.comienzo = comienzo;
		}

		public Date getFin() {
			return fin;
		}

		public void setFin(Date fin) {
			this.fin = fin;
		}

		//Metodo toString
		
		@Override
		public String toString() {
			return "Reserva [id=" + id + ", dni=" + dni + ", numSerie=" + numSerie + ", comienzo=" + comienzo + ", fin="
					+ fin + "]";
		}
		
}
