package pe.edu.unmsm.GCP.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;

public class Archivo {
	FileReader lectura;
	BufferedReader contenido;

	public Archivo() { }

	public ArrayList<JSONObject> leer_archivo(String nomarchivo){
		ArrayList<JSONObject> listado = new ArrayList<>();
		String linea="";
		try {
			lectura= new FileReader(new ClassPathResource(nomarchivo).getFile());
			contenido = new BufferedReader(lectura);
			linea = contenido.readLine();
			while(linea != null && linea.length() >0) {
				listado.add(new JSONObject(linea));
				linea = contenido.readLine();
			}
			contenido.close();
			lectura.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listado;

	}

}
