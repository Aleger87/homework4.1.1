package transport;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Car extends Transport {
    public class Insurance{
        private int periodDayInsurance;
        private float costInsurance;
        private String numberInsurance;

        public Insurance(int periodDayInsurance, float costInsurance, String numberInsurance) {
            if (periodDayInsurance != 0) {
                checkPeriodInsurance(periodDayInsurance);
                this.periodDayInsurance = periodDayInsurance;
            }

            this.costInsurance = costInsurance;

            if (numberInsurance == null || numberInsurance.isEmpty() || numberInsurance.isBlank()) {
                this.numberInsurance = "default";
            }else{
                chekNumberInsurance(numberInsurance);
                this.numberInsurance = numberInsurance;
            }
        }

        private void chekNumberInsurance(String numberInsurance) {
            if (numberInsurance.length() != 9) {
                System.out.println("Номер страховки некорректный");
                System.exit(-1);
            }
        }

        private void checkPeriodInsurance(int periodDayInsurance) {
            if (periodDayInsurance <= 0 || periodDayInsurance > 365) {
                System.out.println("нужно срочно ехать оформлять новую страховку");
                System.exit(-1);
            }
        }

        public int getPeriodInsurance() {
            return periodDayInsurance;
        }

        public float getCostInsurance() {
            return costInsurance;
        }

        public String getNumberInsurance() {
            return numberInsurance;
        }
    }

    public static class Key {
        private boolean remoteEngineStart;
        private boolean keylessAccess;



        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;
        }


        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }

    private float volumeEngine;
    private String transmission;
    private String bodyType;
    private String registrationNumber;
    private int seat;
    private boolean winterTire;
    private Key key;
    Insurance insurance;

    public Car(){

        this ("default", "default", 2000, "default", "белый", 1.5f,
                null, null,null,0,false,null,0);
    }

    @Override
    public void refill() {
        System.out.println("можно заправлять бензином, дизелем на заправке или заряжать");
    }

    public Car(String brand, String model, int manufactureYear,  String country, String color,
               float volumeEngine, String transmission, String bodyType, String registrationNumber,
               int seat, boolean winterTire, Key key, int maxSpeed) {
        super (brand, model,manufactureYear,country,color,maxSpeed);

        if (key == null) {
            Key newKey = new Key(false, false);
            this.key = newKey;
        }

        this.winterTire = winterTire;


        if (seat < 0) {
            this.seat = 0;
        }else {
            this.seat = seat;
        }

        if (bodyType == null) {
            this.bodyType = "default";
        }else {
            this.bodyType = bodyType;
        }

        if (transmission == null) {
            this.transmission = "default";
        }else{
            this.transmission = transmission;
        }

        if (volumeEngine == 0.0f) {
            this.volumeEngine = 1.5f;
        }else {
            this.volumeEngine = volumeEngine;
        }

        if (registrationNumber == null) {
            this.registrationNumber = "default";
        }else {
            checkRegistrationNumber(registrationNumber);
            this.registrationNumber = registrationNumber;
        }
    }


    public void checkTire(Car[] cars) {
        int[] month = {10,11,12,1,2,3}; //зимняя резина
        LocalDate localDate = LocalDate.now();

        for (int i = 0; i < cars.length; i++) {
            for (int monthNumber : month) {
                if (monthNumber == localDate.getMonthValue() && cars[i].isWinterTire()==false) {
                    System.out.println("на машине " + cars[i].getBrand() + " нужно заменить резину на зимнюю");
                }
            }
            if (localDate.getMonthValue() >=4 && localDate.getMonthValue() <= 9 && cars[i].isWinterTire()==true) {
                System.out.println("на машине " + cars[i].getBrand() + " нужно заменить резину на летнюю");
            }

        }

    }

    private void checkRegistrationNumber (String registrationNumber) {
        int x;
        if (registrationNumber.length()==8){
            x=2;
        }else {
            x=3;
        }
        final String regex = "[АВЕКМНОРСТУХABCEHKMOPTX][0-9]{3}[АВЕКМНОРСТУХABCEHKMOPTX]{2}[0-9]{"+ x +"}\\z";
        final String string = registrationNumber;

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS | Pattern.UNICODE_CASE | Pattern.COMMENTS);
        final Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            //System.out.println("Полное соответствие: " + matcher.group(0));

            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Группа " + i + ": " + matcher.group(i));
            }
        }else{
            System.out.println("Номер автомобиля " + this.getBrand() + " не соответствует");
            System.exit(-1);
        }

    }

    public Key getKey() {
        return key;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setWinterTire(boolean winterTire) {
        this.winterTire = winterTire;
    }

    public boolean isWinterTire() {
        return winterTire;
    }

    public float getVolumeEngine() {
        return volumeEngine;
    }

    public void setVolumeEngine(float volumeEngine) {
        this.volumeEngine = volumeEngine;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getSeat() {
        return seat;
    }


}
