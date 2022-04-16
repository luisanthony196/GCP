package pe.edu.unmsm.GCP.utils;

public class Restaurant {
  public Direccion address;
  public String name;

  public Restaurant(String building, String coord, String street, String zipcode, String name) {
    address = new Direccion(building, coord, street, zipcode);
    this.name = name;
  }

  public Direccion getAddress() {
    return this.address;
  }

  public void setAddress(Direccion address) {
    this.address = address;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}