package com.bryan.developer.curso.microservicio.items.ws.rests;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bryan.developer.curso.microservicio.items.entities.Item;
import com.bryan.developer.curso.microservicio.items.services.ItemService;
import com.bryan.developer.curso.microservicio.items.util.LogAbstract;
import static com.bryan.developer.curso.microservicio.items.util.MsItemsConstantes.ROOT;;

@RestController
@RequestMapping(ROOT + "/items")
public class ItemRest extends LogAbstract {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar(){
		LOG.info("Ejecutando el siguiente Metodo de la Clase: " + getClass().getName() + " - "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return itemService.listarItems();
	}
	
	@GetMapping("/listar/{id}/cantidad/{cantidad}")
	public Item mostrar(@PathVariable Long id, @PathVariable Integer cantidad) {
		LOG.info("Ejecutando el siguiente Metodo de la Clase: " + getClass().getName() + " - "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return itemService.encontrarItem(id, cantidad);
	}

}
