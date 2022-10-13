package transport;

public class Bus extends Transport{
    public Bus (){
        super();
    }

    @Override
    public void refill() {
        System.out.println("можно заправлять бензином или дизелем на заправке");
    }
}
