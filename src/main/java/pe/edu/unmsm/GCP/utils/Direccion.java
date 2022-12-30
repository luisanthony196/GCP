package pe.edu.unmsm.GCP.utils;

public class Direccion {
	public String building;
	public String coord;
	public String street;
	public String zipcode;

	public Direccion(String building, String coord, String street, String zipcode) {
		this.building = building;
		this.coord = coord;
		this.street = street;
		this.zipcode = zipcode;
	}

	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getCoord() {
		return this.coord;
	}

	public void setCoord(String coord) {
		this.coord = coord;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
