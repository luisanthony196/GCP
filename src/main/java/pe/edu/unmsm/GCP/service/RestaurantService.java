package pe.edu.unmsm.GCP.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.unmsm.GCP.utils.Archivo;

@Service
public class RestaurantService {
    public Archivo a;
    public List<String> lineas;

    public void llenarDatos() {
        a = new Archivo();
        lineas = a.leer_archivo("restaurants.txt");
    }
}
