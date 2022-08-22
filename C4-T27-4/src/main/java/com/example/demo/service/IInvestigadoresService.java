package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Investigadores;

public interface IInvestigadoresService {

	//Metodos del CRUD
			public List<Investigadores> listarInvestigadores(); //Listar All 
			
			public Investigadores guardarInvestigadores(Investigadores investigadores);	//Guarda un Estudiante CREATE
			
			public Investigadores investigadoresXID(int id); //Leer datos de un Estudiante READ
			
			public Investigadores actualizarInvestigadores(Investigadores investigadores); //Actualiza datos del estudiante UPDATE
			
			public void eliminarInvestigadores(int id);// Elimina el estudiante DELETE
}
