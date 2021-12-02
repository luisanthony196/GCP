package pe.edu.unmsm.GCP.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import io.reactivex.Observable;
import pe.edu.unmsm.GCP.utils.Archivo;
import pe.edu.unmsm.GCP.utils.Restaurant;
import pe.edu.unmsm.GCP.utils.RestaurantV1;
import pe.edu.unmsm.GCP.utils.RestaurantV2;

@Service
public class RestaurantService {
    public Archivo a;
    public List<JSONObject> lineas;

    public void llenarDatos() {
        a = new Archivo();
        lineas = a.leer_archivo("restaurants.txt");
    }

    public List<RestaurantV2> caso1(HashMap<String, Object> params) {
        ArrayList<RestaurantV2> al = new ArrayList<>();
        Observable.fromIterable(lineas)
                .flatMap(word -> Observable.fromArray(word))
                .filter(i -> i.getString("borough").equals(params.get("barrio")))
                .subscribe(s -> {
                    al.add(new RestaurantV2(s.getString("name"), s.getString("borough"), s.getString("cuisine")));
                });
        return al;
    }
    
    public RestaurantV1 caso2(HashMap<String, Object> params) {
        RestaurantV1 rv1 = new RestaurantV1();
        Observable.fromIterable(lineas)
                .flatMap(word -> Observable.fromArray(word))
                .filter(i -> i.getString("restaurant_id").equals(params.get("restaurant_id")))
                .take(1)
                .subscribe(s -> {
                    JSONObject t = s.getJSONObject("address");
                    rv1.set(t.getString("building"), t.get("coord").toString(), t.getString("street"), t.getString("zipcode"), s.getString("name"), s.getString("borough"), s.getString("cuisine"), s.getString("restaurant_id"));
                });
        return rv1;
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

    public List<Restaurant> caso4(HashMap<String, Object> params, int page) {
        int skip = (int) Math.pow(5, page - 1);
        if (skip == 1)
            skip = 0;
        ArrayList<Restaurant> al = new ArrayList<>();
        Observable.fromIterable(lineas)
                .flatMap(word -> Observable.fromArray(word))
                .filter(i -> i.getString("borough").equals(params.get("barrio")))
                .filter(i -> i.getString("cuisine").equals(params.get("cocina")))
                .skip(skip)
                .take(5)
                .subscribe(s -> {
                    JSONObject t = s.getJSONObject("address");
                    al.add(new Restaurant(t.getString("building"), t.get("coord").toString(), t.getString("street"), t.getString("zipcode"), s.getString("name")));
                });
        return al;
    }
}
