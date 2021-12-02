package pe.edu.unmsm.GCP.utils;

public class RestaurantV2 {
    public String name;
    public String borough;
    public String cuisine;

    public RestaurantV2(String name, String borough, String cuisine) {
        this.name = name;
        this.borough = borough;
        this.cuisine = cuisine;
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
}
