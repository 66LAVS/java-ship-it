package ru.yandex.practicum.delivery;

//скоропортящаяся посылка
public class PerishableParcel extends Parcel {
    public static final int deliveryCost = 3;
    int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        if ((getSendDay() + timeToLive) < currentDay) {
            System.out.println("Срок годности посылки не истек!");
            return true;
        } else {
            System.out.println("Срок годности посылки истек!");
            return false;
        }
    }
    @Override
    protected int getBaseCost() {
        return deliveryCost;
    }

}
