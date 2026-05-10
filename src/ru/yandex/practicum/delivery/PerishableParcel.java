package ru.yandex.practicum.delivery;
//скоропортящаяся посылка
public class PerishableParcel extends Parcel{
    int timeToLive;
    public static int deliveryCost = 3;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getDeliveryCost() {
        return getWeight() * deliveryCost;
    }

    public boolean isExpired(int currentDay){
        if((getSendDay() + timeToLive) >= currentDay) return false;
        else return true;
    }
}
