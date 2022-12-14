package transport;

import java.util.Arrays;

public class Train extends Transport {
    private float price;
    private int time;
    private String stationName;
    private String stationFinal;
    private int wagonCount;

    public Train() {
        this(null,null,2000,"Россия","белый",0,0,0,null,null,0);
    }

    @Override
    public void refill() {
        System.out.println("нужно заправлять дизелем");
    }


    public Train(String brand, String model, int manufactureYear, String country, String color, int maxSpeed, float price, int time, String stationName, String stationFinal, int wagonCount) {
        super(brand, model, manufactureYear, country, color, maxSpeed);
        this.price = price;
        this.time = time;
        this.stationName = stationName;
        this.stationFinal = stationFinal;
        this.wagonCount = wagonCount;


    }


    public float getPrice() {
        return price;
    }

    public int getTime() {
        return time;
    }

    public String getStationName() {
        return stationName;
    }

    public String getStationFinal() {
        return stationFinal;
    }

    public int getWagonCount() {
        return wagonCount;
    }
}
