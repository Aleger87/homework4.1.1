
public class Transport {
    private String brand;
    private  String  Model;
    private int  manufactureYear;
    private String manufactureCountry;
    private String color;
    private  int maxSpeed;




    public void setColor(String color) {
        if (color.isEmpty() || color == null || color.isBlank()) {
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

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return Model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public String getManufactureCountry() {
        return manufactureCountry;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
