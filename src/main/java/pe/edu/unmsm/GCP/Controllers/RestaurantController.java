package pe.edu.unmsm.GCP.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.GCP.service.RestaurantService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class RestaurantController {
    @Autowired 
    RestaurantService rs;

    @PostMapping("/caso1")
    public String caso1(@RequestBody String barrio) {
        return "hello";
    }

    @PostMapping("/caso3")
    public List<String> caso3(@RequestBody String barrio) {
        rs.llenarDatos();
        return rs.caso3(barrio);
    }
}