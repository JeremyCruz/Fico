package com.pe.fico.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pe.fico.entities.Customer;
import com.pe.fico.serviceInterface.ICustomerService;
import com.pe.fico.serviceInterface.IRolService;
import com.pe.fico.serviceInterface.IUploadFileService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private ICustomerService cS;

	@Autowired
	private IRolService rS;

	@Autowired
	private IUploadFileService uS;

	@GetMapping("/new")
	public String newCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("listaRoles", rS.list());
		model.addAttribute("products", new Customer());
		return "customer/customer";
	}
	
	@GetMapping("/home")
	public String newHome(Model model) {
		return "fragments/home";
	}

	@GetMapping("/list")
	public String listCustomer(Model model) {
		try {
			model.addAttribute("customer", new Customer());
			model.addAttribute("listaCustomers", cS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "customer/listCustomer";
	}

	@RequestMapping("/save")
	public String insertCustomer(@ModelAttribute @Valid Customer customer, BindingResult binRes, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status)
			throws ParseException {		
		if (binRes.hasErrors()) {
			model.addAttribute("listaRoles", rS.list());
			return "customer/customer";
		} else {
			if (!foto.isEmpty()) {
				if (customer.getIdCustomer() > 0 && customer.getPhotoCustomer() != null
						&& customer.getPhotoCustomer().length() > 0) {

					uS.delete(customer.getPhotoCustomer());
				}

				String uniqueFilename = null;
				try {
					uniqueFilename = uS.copy(foto);
				} catch (IOException e) {
					e.printStackTrace();
				}

				flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");
				customer.setPhotoCustomer(uniqueFilename);
			}
			int rpta = cS.insertDni(customer);
			if (rpta > 0) {
				model.addAttribute("mensaje", "El DNI ingresado ya existe");
				model.addAttribute("listaRoles", rS.list());
				return "customer/customer";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
			boolean flag = cS.insert(customer);
			if (flag) {
				return "redirect:/customers/list";
			} else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/customers/new";
			}
		}	
	}

	@GetMapping(value = "/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;

		try {
			recurso = uS.load(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}

	@GetMapping(value = "/view/{id}")
	public String view(@PathVariable(value = "id") int id, Map<String, Object> model, RedirectAttributes flash) {

		Customer customer = cS.listarId(id);

		if (customer == null) {
			flash.addFlashAttribute("error", "El registro no existe en la base de datos");
			return "customer/listCustomer";
		}

		model.put("customer", customer);
		model.put("titulo", "Detalle de registro: " + customer.getNameCustomer());

		return "customer/ver";
	}

	@RequestMapping("/list")
	public String listCustomer(Map<String, Object> model) {
		model.put("listaCustomers", cS.list());
		return "customer/listCustomer";

	}

	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Customer cus) {
		cS.listarId(cus.getIdCustomer());
		return "customer/listCustomer";

	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, RedirectAttributes objRedir) {

		Customer objPro = cS.listarId(id);
		if (objPro == null) {
			objRedir.addFlashAttribute("mensaje", "OcurriÃ³ un error");
			return "redirect:/customer/list";
		} else {
			model.addAttribute("listaRoles", rS.list());
			model.addAttribute("customer", objPro);
			return "customer/customer";
		}
	}

}
