package pe.edu.unmsm.GCP.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.edu.unmsm.GCP.service.RestaurantService;
import pe.edu.unmsm.GCP.utils.Restaurant;
import pe.edu.unmsm.GCP.utils.RestaurantV1;
import pe.edu.unmsm.GCP.utils.RestaurantV2;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class RestaurantController {
	@Autowired
	RestaurantService rs;

	@PostMapping("/caso1")
	public List<RestaurantV2> caso1(@RequestBody HashMap<String, Object> params) {
		rs.llenarDatos();
		return rs.caso1(params);
	}

	@PostMapping("/caso2")
	public RestaurantV1 caso2(@RequestBody HashMap<String, Object> params) {
		rs.llenarDatos();
		return rs.caso2(params);
	}

	@GetMapping("/barrios")
	public List<String> barrios() {
		rs.llenarDatos();
		return rs.getBarrios();
	}

	@PostMapping("/numrest")
	public List<Integer> numrest(@RequestBody HashMap<String, Object> params) {
		rs.llenarDatos();
		return rs.getNumRestaurantes(params);
	}

	@PostMapping("/caso4")
	public List<Restaurant> caso4(@RequestBody HashMap<String, Object> params, @RequestParam int page) {
		rs.llenarDatos();
		return rs.caso4(params, page);
	}
}
