package br.com.alura.mvc.siteLoja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.siteLoja.model.Pedido;
import br.com.alura.mvc.siteLoja.model.statusPedido;
import br.com.alura.mvc.siteLoja.repository.PedidoRepository;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model) {
		
		List<Pedido>pedidos = pedidoRepository.findAll();
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable ("status") String status,  Model model) {
		List<Pedido> pedidos = pedidoRepository.findByStatus(statusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "home"; 
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String orError() {
		return "redirect:/home";
	}
}
