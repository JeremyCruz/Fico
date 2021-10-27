package com.pe.fico.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pe.fico.entities.Rol;
import com.pe.fico.serviceInterface.IRolService;

@Controller
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private IRolService rS;
	
	@GetMapping("/new")
	public String newRol(Model model) {
		model.addAttribute("rol", new Rol());
		return "rol/rol";
	}
	
	@GetMapping("/list")
	public String listRol(Model model) {
		try {
			model.addAttribute("rol", new Rol());
			model.addAttribute("listaRoles", rS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "rol/listRol";
	}
	
	@PostMapping("/save")
	public String saveMarca(@Valid Rol rol, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "rol/rol";
		} else {
			int rpta = rS.insert(rol);
			if (rpta > 0) {
				model.addAttribute("mensaje", "El Rol que desea ingresar ya existe");
				return "rol/rol";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("rol", new Rol());
		return "redirect:/roles/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "id") Integer id, Model model) {

		try {
			if (id != null && id > 0) {
				rS.delete(id);
			}
		} catch (Exception e) {
			System.out.println("Error al eliminar");
		}
		model.addAttribute("listaRoles", rS.list());
		return "rol/listRol";

	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, RedirectAttributes objRedir) {

		Optional<Rol> rol = rS.listarId(id);
		if (rol == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "rol/rol";
		} else {
			model.addAttribute("rol", rol);
			return "rol/rol";
		}
	}
}
