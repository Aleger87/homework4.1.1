package transport;

public class Transport {
    private String brand;
    private  String  model;
    private int  manufactureYear;
    private String country;
    private String color;
    private  int maxSpeed;



    public Transport () {
        this(null, null,2000,null,null,0);
    }

    public Transport(String brand, String model, int manufactureYear, String country, String color, int maxSpeed) {
        if (brand == null) {
            this.brand = "default";
        }else {
            this.brand = brand;
        }

        if (model == null) {
            this.model = "default";
        }else {
            this.model = model;
        }
        if (manufactureYear <= 0) {
            this.manufactureYear = 2000;
        } else {
            this.manufactureYear = manufactureYear;
        }

        if (country == null) {
            this.country = "default";
        }else {
            this.country = country;
        }
        setColor(color);
        setMaxSpeed(maxSpeed);
    }

    public void setColor(String color) {
        if (color == null || color.isEmpty()  || color.isBlank()) {
            this.color = "белый";
        } else {
            this.color = color;
        }
    }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed == 0) {
            this.maxSpeed = 40;
        } else {
            this.maxSpeed = maxSpeed;
        }

        this.maxSpeed = maxSpeed;
    }
    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufactureYear=" + manufactureYear +
                ", country='" + country + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
