package ru.yandex.practicum.delivery;

//скоропортящаяся посылка
public class PerishableParcel extends Parcel {
    public static int deliveryCost = 3;
    int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getDeliveryCost() {
        return getWeight() * deliveryCost;
    }

    public boolean isExpired(int currentDay) {
        return (getSendDay() + timeToLive) < currentDay;
    }
}
