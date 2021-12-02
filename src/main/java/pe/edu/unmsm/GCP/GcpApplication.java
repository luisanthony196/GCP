package pe.edu.unmsm.GCP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import io.reactivex.Observable;
import pe.edu.unmsm.GCP.utils.Archivo;

@SpringBootApplication
public class GcpApplication {
  // public static Archivo archivo;
  // public static List<String> lineas;

	public static void main(String[] args) {
		SpringApplication.run(GcpApplication.class, args);
    // archivo = new Archivo();
    // lineas = archivo.leer_archivo("restaurants.txt");
    // operaciones_archivo(lineas);
    // contar_palabras(lineas);
	}

  // private static void operaciones_archivo(List<String> lineas2) {
  //   Observable.fromIterable(lineas2)
  //     .flatMap(word -> Observable.fromArray(word.split(" ")))
  //     .subscribe(s -> System.out.println(s));
  // }

  // private static void contar_palabras(List<String> lineas2) {
  //   Observable.fromIterable(lineas2)
  //     .flatMap(word -> Observable.fromArray(word.split(" "))).count()
  //     .subscribe(s -> System.out.println(" Numero de palabras " + s));
  // }
}
