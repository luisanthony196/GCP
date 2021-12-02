package pe.edu.unmsm.GCP.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import io.reactivex.Observable;
import pe.edu.unmsm.GCP.utils.Archivo;

@Service
public class RestaurantService {
    public Archivo a;
    public List<JSONObject> lineas;

    public void llenarDatos() {
        a = new Archivo();
        lineas = a.leer_archivo("restaurants.txt");
    }

    public List<String> caso3(String barrio) {
        ArrayList<String> al = new ArrayList<>();
        Observable.fromIterable(lineas)
                .flatMap(word -> Observable.fromArray(word.getString("borough")))
                .subscribe(s -> al.add(s));
        return al;
    }
}
