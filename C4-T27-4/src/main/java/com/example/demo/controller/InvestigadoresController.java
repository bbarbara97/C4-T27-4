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

import com.example.demo.dto.Investigadores;
import com.example.demo.service.InvestigadoresServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadoresController {

	@Autowired
	InvestigadoresServiceImpl investigadoresServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigadores> listarInvestigadores(){
		return investigadoresServiceImpl.listarInvestigadores();
	}
	
	
	@PostMapping("/investigadores")
	public Investigadores salvarInvestigadores(@RequestBody Investigadores investigadores) {
		
		return investigadoresServiceImpl.guardarInvestigadores(investigadores);
	}
	
	
	@GetMapping("/investigadores/{id}")
	public Investigadores InvestigadoresXID(@PathVariable(name="id") int id) {
		
		Investigadores Investigadores_xid= new Investigadores();
		
		Investigadores_xid=investigadoresServiceImpl.investigadoresXID(id);
		
		System.out.println("Investigadores XID: "+Investigadores_xid);
		
		return Investigadores_xid;
	}
	
	@PutMapping("/investigadores/{id}")
	public Investigadores actualizarProductos(@PathVariable(name="id")int id,@RequestBody Investigadores Investigadores) {
		
		Investigadores Investigadores_seleccionado= new Investigadores();
		Investigadores Investigadores_actualizado= new Investigadores();
		
		Investigadores_seleccionado= investigadoresServiceImpl.investigadoresXID(id);
		
		Investigadores_seleccionado.setDni(Investigadores.getDni());
		Investigadores_seleccionado.setNomApels(Investigadores.getNomApels());
		Investigadores_seleccionado.setReserva(Investigadores.getReserva());
		Investigadores_seleccionado.setFacultad(Investigadores.getFacultad());
		
		Investigadores_actualizado = investigadoresServiceImpl.actualizarInvestigadores(Investigadores_seleccionado);
		
		System.out.println("El producto actualizado es: "+ Investigadores_actualizado);
		
		return Investigadores_actualizado;
	}
	
	@DeleteMapping("/investigadores/{id}")
	public void eleiminarInvestigadores(@PathVariable(name="id")int id) {
		investigadoresServiceImpl.eliminarInvestigadores(id);
	}
	
}
