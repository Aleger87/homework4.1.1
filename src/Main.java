import transport.Bus;
import transport.Car;
import transport.Train;

public class Main {
    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        Car cars = new Car();
        Car.Key keyTrue = new Car.Key(true,true);
        Car.Key keyFalse = new Car.Key(false,false);
        Car.Key keyFalseTrue = new Car.Key(false,true);
        Car.Key keyTrueFalse = new Car.Key(true,false);

        Car lada = new Car("Lada", "Grande", 2015, "Россия", "Желтый", 1.7f,
                null,null,"В100АP781",0,true, keyTrue,160);
        cars.addCars(lada);
        Car.Insurance ins =  lada.new Insurance(360,3000,"12345678F");
        lada.setInsurance(ins);
        System.out.println(lada.getInsurance().getNumberInsurance());

        Car audi = new Car("Audi", "A8", 2020,
                "Германия", "черный", 3.0f,null, null,null,0,false, keyFalseTrue, 220);
        cars.addCars(audi);

        Car bmw = new Car("BMW", "Z8", 2021, "Германия", "черный", 3.0f,
                null, null,null,0,true, keyFalse, 280);
        cars.addCars(bmw);

        Car kia = new Car("Kia", "Sportage 4 поколение", 2018, "Южная Корея", "красный", 2.4f,
                null, null,null,0,false, keyTrueFalse, 180);
        cars.addCars(kia);

        Car hyundai = new Car("Hyundai", null, 0, "Южная Корея", null, 1.6f,
                null, null,null,0,false, keyTrue, 0);
        cars.addCars(hyundai);

        for (int i = 0; i < cars.getCars().length; i++) {
            printCarInfo(cars.getCars()[i]);
        }

        cars.checkTire(cars.getCars());

        /*
        * Поезд «Ласточка», модель B-901, 2011 год выпуска в России, скорость передвижения — 301 км/ч, отходит от Белорусского вокзала и следует до станции Минск-Пассажирский. Цена поездки — 3500 рублей, в поезде 11 вагонов.
        * Поезд «Ленинград», модель D-125, 2019 год выпуска в России, скорость передвижения — 270 км/ч, отходит от Ленинградского вокзала и следует до станции Ленинград-Пассажирский. Цена поездки — 1700 рублей, в поезде 8 вагонов.
        * */
        Train train = new Train();
        Train lastochka = new Train("Ласточка", "B-901", 2011,"Россия", null, 301,  3500f, 4,"Белорусского вокзала","Минск-Пассажирский", 11);
        train.addTrain(lastochka);
        Train lenangrad = new Train("Ленинград", "D-125", 2019, "Россия", null, 270, 1700f, 5, "Ленинградского вокзала", "Ленинград-Пассажирский", 8);
        train.addTrain(lenangrad);
        for (int i = 0; i < train.getTrains().length; i++) {
            printTrainsInfo(train.getTrains()[i]);
        }

        Bus bus = new Bus();
        System.out.println(bus.toString());


    }



    private static void printCarInfo(Car car) {

        System.out.println(car.getBrand()+ ", " +" номер "+ car.getRegistrationNumber()+ " " + car.getModel()+ ", год выпуска, " + car.getManufactureYear() + ", сборка в  " + car.getCountry() + ", цвет " + car.getColor() + ", объем двигателя " + car.getVolumeEngine() +" литра");
    }
    private static void printTrainsInfo(Train train) {

        System.out.println(train.getBrand()+ ", "  + train.getModel()+ ", год выпуска, " + train.getManufactureYear() + ", сборка в  " + train.getCountry() +
                " отходит от "+ train.getStationName() +" до станции " + train.getStationFinal() + ".  Цена поездки - " + train.getPrice() + " в поезде " + train.getWagonCount() + " вагонов");
    }
}