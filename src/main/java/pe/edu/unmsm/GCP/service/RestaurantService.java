package pe.edu.unmsm.GCP.service;

import java.util.ArrayList;
import java.util.HashMap;
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

    public List<String> getBarrios() {
        ArrayList<String> al = new ArrayList<>();
        Observable.fromIterable(lineas)
                .flatMap(word -> Observable.fromArray(word.getString("borough")))
                .distinct()
                // .filter(i -> i.equals(params.get("barrio")))
                .subscribe(s -> al.add(s));
        return al;
    }
    
    public List<Integer>getNumRestaurantes(HashMap<String, Object> params) {
        ArrayList<Integer> al = new ArrayList<>();
        System.out.println(params.get("barrio"));
        Observable.fromIterable(lineas)
                .flatMap(word -> Observable.fromArray(word.getString("borough")))
                .filter(i -> i.equals(params.get("barrio")))
                .count()
                // .reduce((total, next) -> total + next)
                .subscribe(s -> al.add(Integer.parseInt(s + "")));
        return al;
    }
}
