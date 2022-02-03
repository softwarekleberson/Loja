package br.com.alura.mvc.siteLoja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.alura.mvc.siteLoja.model.Pedido;
import br.com.alura.mvc.siteLoja.model.statusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(statusPedido status);
	
}

