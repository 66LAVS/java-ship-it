package ru.yandex.practicum.delivery;
//хрупкая посылка
public class FragileParcel extends Parcel implements Trackable{
    public static int deliveryCost = 4;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getDeliveryCost() {
        return deliveryCost * getWeight();
    }

    @Override
    public void packageItem(){
        System.out.println("Посылка " + getDescription() + " обёрнута в защитную плёнку");
    };

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + getDescription() + " изменила местоположение на " + newLocation);
    }
}
