package pe.edu.unmsm.GCP.utils;

public class RestaurantV1 {
public Direccion address;
  public String name;
  public String borough;
  public String cuisine;
  public String restaurant_id;

  public RestaurantV1() { }

  public void set(String building, String coord, String street, String zipcode, String name, String borough, String cuisine, String restaurant_id) {
    address = new Direccion(building, coord, street, zipcode);
    this.name = name;
    this.borough = borough;
    this.cuisine = cuisine;
    this.restaurant_id = restaurant_id;
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

  public String getBorough() {
    return this.borough;
  }

  public void setBorough(String borough) {
    this.borough = borough;
  }

  public String getCuisine() {
    return this.cuisine;
  }

  public void setCuisine(String cuisine) {
    this.cuisine = cuisine;
  }

  public String getRestaurant_id() {
    return this.restaurant_id;
  }

  public void setRestaurant_id(String restaurant_id) {
    this.restaurant_id = restaurant_id;
  }
}
