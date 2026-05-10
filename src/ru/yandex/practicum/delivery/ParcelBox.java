package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {

    private int maxWeight;
    private int size = 0;
    private final ArrayList<T> parcelBox = new ArrayList<>();

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getSize() {
        return size;
    }

    public void addParcel(T parcel) {
        if (this.maxWeight < parcel.getWeight()) {
            System.out.println("Вес посылки слишком большой!!");
        } else {
            parcelBox.add(parcel);
            System.out.println("Посылка " + parcel + " добавлена в коробку!");
            size = size + 1;
            maxWeight = maxWeight - parcel.getWeight();
            System.out.println("Остаточный вес " + maxWeight);
        }
    }

    public void getAllParcels() {
        if (size == 0) {
            System.out.println("Коробка пуста!");
            return;
        }
        System.out.println("Содержимое коробки: ");
        for (T parcel : parcelBox) {
            System.out.println(parcel);
        }
    }
}