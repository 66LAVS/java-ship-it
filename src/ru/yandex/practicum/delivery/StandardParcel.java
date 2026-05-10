package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    public static int deliveryCost = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }


    @Override
    public int getDeliveryCost() {
        return deliveryCost * getWeight();
    }


}
