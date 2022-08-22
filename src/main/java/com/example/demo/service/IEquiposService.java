package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Facultad;
import com.example.demo.dto.Equipos;

public interface IEquiposService {

	//Metodos del CRUD
			public List<Equipos> listarEquipos(); //Listar All 
			
			public Equipos guardarEquipos(Equipos equipos);	//Guarda un Estudiante CREATE
			
			public Equipos equiposXID(int id); //Leer datos de un Estudiante READ
			
			public Equipos actualizarEquipos(Equipos equipos); //Actualiza datos del estudiante UPDATE
			
			public void eliminarEquipos(int id);// Elimina el estudiante DELETE
}
