package transport;

import java.util.Arrays;

public class Train extends Transport {
    private float price;
    private int time;
    private String stationName;
    private String stationFinal;
    private int wagonCount;
    private Train[] trains;

    public Train() {
        this(null,null,2000,"Россия","белый",0,0,0,null,null,0);
    }


    public Train(String brand, String model, int manufactureYear, String country, String color, int maxSpeed, float price, int time, String stationName, String stationFinal, int wagonCount) {
        super(brand, model, manufactureYear, country, color, maxSpeed);
        this.price = price;
        this.time = time;
        this.stationName = stationName;
        this.stationFinal = stationFinal;
        this.wagonCount = wagonCount;
        trains = new Train[0];

    }
    public void addTrain (Train train){
        this.trains = Arrays.copyOf(getTrains(),  getTrains().length+1);
        this.trains[this.trains.length-1] = train;
    }

    public Train[] getTrains() {
        if (trains == null){
            trains = new Train[0];
        }
        return trains;
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
