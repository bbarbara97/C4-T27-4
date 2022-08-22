package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Facultad;

public interface IFacultadService {

	//Metodos del CRUD
			public List<Facultad> listarFacultad(); //Listar All 
			
			public Facultad guardarFacultad(Facultad facultad);	//Guarda un Estudiante CREATE
			
			public Facultad facultadXID(int id); //Leer datos de un Estudiante READ
			
			public Facultad actualizarFacultad(Facultad facultad); //Actualiza datos del estudiante UPDATE
			
			public void eliminarFacultad(int id);// Elimina el estudiante DELETE
}
