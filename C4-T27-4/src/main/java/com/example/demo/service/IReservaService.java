package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Reserva;

public interface IReservaService {

	//Metodos del CRUD
			public List<Reserva> listarReserva(); //Listar All 
			
			public Reserva guardarReserva(Reserva reserva);	//Guarda un RegistroCurso CREATE
			
			public Reserva reservaXID(int id); //Leer datos de un RegistroCurso READ
			
			public Reserva actualizarReserva(Reserva reserva); //Actualiza datos del RegistroCurso UPDATE
			
			public void eliminarReserva(int id);// Elimina el RegistroCurso DELETE
}
