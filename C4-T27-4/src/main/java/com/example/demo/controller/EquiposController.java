package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Equipos;
import com.example.demo.service.EquiposServiceImpl;

@RestController
@RequestMapping("/api")
public class EquiposController {

	@Autowired
	EquiposServiceImpl equiposServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipos> listarEquipos(){
		return equiposServiceImpl.listarEquipos();
	}
	
	
	@PostMapping("/equipos")
	public Equipos salvarEquipos(@RequestBody Equipos equipos) {
		
		return equiposServiceImpl.guardarEquipos(equipos);
	}
	
	
	@GetMapping("/equipos/{id}")
	public Equipos EquiposXID(@PathVariable(name="id") int id) {
		
		Equipos Equipos_xid= new Equipos();
		
		Equipos_xid=equiposServiceImpl.equiposXID(id);
		
		System.out.println("Equipos XID: "+Equipos_xid);
		
		return Equipos_xid;
	}
	
	@PutMapping("/equipos/{id}")
	public Equipos actualizarEquipos(@PathVariable(name="id")int id,@RequestBody Equipos Equipos) {
		
		Equipos Equipos_seleccionado= new Equipos();
		Equipos Equipos_actualizado= new Equipos();
		
		Equipos_seleccionado= equiposServiceImpl.equiposXID(id);
		
		Equipos_seleccionado.setNombre(Equipos.getNombre());
		Equipos_seleccionado.setReserva(Equipos.getReserva());
		Equipos_seleccionado.setFacultad(Equipos.getFacultad());
		
		Equipos_actualizado = equiposServiceImpl.actualizarEquipos(Equipos_seleccionado);
		
		System.out.println("El equipo actualizado es: "+ Equipos_actualizado);
		
		return Equipos_actualizado;
	}
	
	@DeleteMapping("/equipos/{id}")
	public void eleiminarEquipos(@PathVariable(name="id")int id) {
		equiposServiceImpl.eliminarEquipos(id);
	}
}
