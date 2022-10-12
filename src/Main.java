import transport.Car;

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


    }



    private static void printCarInfo(Car car) {

        System.out.println(car.getBrand()+ ", " +" номер "+ car.getRegistrationNumber()+ " " + car.getModel()+ ", год выпуска, " + car.getManufactureYear() + ", сборка в  " + car.getCountry() + ", цвет " + car.getColor() + ", объем двигателя " + car.getVolumeEngine() +" литра");
    }
}