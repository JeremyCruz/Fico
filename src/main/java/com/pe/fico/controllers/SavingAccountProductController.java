package com.pe.fico.controllers;


import java.text.ParseException;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.pe.fico.entities.SavingAccountProduct;
import com.pe.fico.service.ITypeSavingAccountService;
import com.pe.fico.service.ISavingAccountProductService;
import com.pe.fico.service.IProductService;

//savingaccount SavingAccountProduct
@Controller
@RequestMapping("/savingaccounts")
public class SavingAccountProductController {
	
	@Autowired
	private ISavingAccountProductService sap;
	
	@Autowired
	private ITypeSavingAccountService tap;
	
	@Autowired
	private IProductService pService;
	
	@GetMapping("/new")
	public String newAccount(Model model) {
		model.addAttribute("savingaccount", new SavingAccountProduct());
		model.addAttribute("listaTipoCuentasAhorro", tap.list());
		model.addAttribute("listaProductos", pService.list());
		model.addAttribute("savingaccount", new SavingAccountProduct());
		return "savingaccount/savingaccount";
	}
	
	@GetMapping("/list")
	public String listAccounts(Model model) {
		try {
			model.addAttribute("savingaccount", new SavingAccountProduct());
			model.addAttribute("listaCuentasAhorro", sap.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "savingaccount/listSavingAccounts";
	}
	
	@RequestMapping("/save")
	public String insertAccounts(@ModelAttribute @Valid SavingAccountProduct objSap, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaTipoCuentasAhorro", tap.list());
			model.addAttribute("listaProductos", pService.list());
			return "savingaccount/savingaccount";
		} else {
			boolean flag = sap.insert(objSap);
			if (flag) {
				return "redirect:/savingaccounts/list";
			} else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/savingaccounts/new";
			}
		}

	}
	@RequestMapping("/list")
	public String listAccounts(Map<String, Object> model) {
		model.put("listaCuentasAhorro", sap.list());
		return "savingaccount/listSavingAccounts";

	}

	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute SavingAccountProduct Sap) {
		sap.listarId(Sap.getIdSavingAccount());
		return "savingaccount/listSavingAccounts";

	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, RedirectAttributes objRedir) {

		SavingAccountProduct objSap = sap.listarId(id);
		if (objSap == null) {
			objRedir.addFlashAttribute("mensaje", "OcurriÃ³ un error");
			return "redirect:/savingaccounts/list";
		} else {
			model.addAttribute("listaTipoCuentasAhorro", tap.list());
			model.addAttribute("listaProductos", pService.list());
			model.addAttribute("savingaccount", objSap);
			return "savingaccount/savingaccount";
		}
	}
}
