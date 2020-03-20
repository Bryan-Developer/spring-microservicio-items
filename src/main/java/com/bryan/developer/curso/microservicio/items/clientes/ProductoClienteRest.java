package com.bryan.developer.curso.microservicio.items.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bryan.developer.curso.microservicio.items.entities.Producto;
import static com.bryan.developer.curso.microservicio.items.util.MsItemsConstantes.ROOT;;

@FeignClient(name = "microservicio-productos", url = "localhost:8001")
public interface ProductoClienteRest {

	@GetMapping(ROOT + "/productos")
	public List<Producto> listarProductos();

	@GetMapping(ROOT + "/productos/listar/{id}")
	public Producto mostrarProducto(@PathVariable Long id);

}
