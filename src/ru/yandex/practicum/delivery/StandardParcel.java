package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    protected static final int deliveryCost = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected int getBaseCost() {
        return deliveryCost;
    }
}
