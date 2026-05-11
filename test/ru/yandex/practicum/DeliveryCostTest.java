package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

public class DeliveryCostTest {

    @Test
    public void shouldGive100ifStandartParcelAndWeight50() {
        int coast = 100;
        StandardParcel standardParcel = new StandardParcel("1", 50, "2", 3);
        Assertions.assertEquals(coast, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldGive150ifPersihableParcelAndWeight50() {
        int coast = 150;
        PerishableParcel perishableParcel = new PerishableParcel("1", 50, "2", 3, 1);
        Assertions.assertEquals(coast, perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldGive200ifFragileParcelAndWeight50() {
        int coast = 200;
        FragileParcel fragileParcel = new FragileParcel("1", 50, "2", 3);
        Assertions.assertEquals(coast, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldGiveTrueIfPersihableParcelAndisExpired30andTimeToLive30() {
        int currentDay = 30;
        PerishableParcel perishableParcel = new PerishableParcel("1", 50, "2", 3, 30);
        Assertions.assertFalse(perishableParcel.isExpired(currentDay));
    }

    @Test
    public void shouldGiveFalseIfPersihableParcelAndisExpired29andTimeToLive30() {
        int currentDay = 31;
        PerishableParcel perishableParcel = new PerishableParcel("1", 50, "2", 3, 28);
        Assertions.assertFalse(perishableParcel.isExpired(currentDay));
    }

    @Test
    public void shouldGiveTrueIfPersihableParcelAndisExpired27andTimeToLive30() {
        int currentDay = 31;
        PerishableParcel perishableParcel = new PerishableParcel("1", 50, "2", 3, 27);
        Assertions.assertTrue(perishableParcel.isExpired(currentDay));
    }


    @Test
    public void shouldFalseIfWeight100andMaxWeight50() {
        int maxWeight = 50;
        FragileParcel fragileParcel = new FragileParcel("1", 100, "2", 3);
        ParcelBox<FragileParcel> parcelBox = new ParcelBox<>(maxWeight);
        parcelBox.addParcel(fragileParcel);
        Assertions.assertEquals(0, parcelBox.getSize());
    }

    @Test
    public void shouldFalseIfWeight100andMaxWeight100() {
        int maxWeight = 100;
        FragileParcel fragileParcel = new FragileParcel("1", 100, "2", 3);
        ParcelBox<FragileParcel> parcelBox = new ParcelBox<>(maxWeight);
        parcelBox.addParcel(fragileParcel);
        Assertions.assertEquals(1, parcelBox.getSize());
    }

    @Test
    public void shouldTrueIfWeight49andMaxWeight50() {
        int maxWeight = 50;
        FragileParcel fragileParcel = new FragileParcel("1", 49, "2", 3);
        ParcelBox<FragileParcel> parcelBox = new ParcelBox<>(maxWeight);
        parcelBox.addParcel(fragileParcel);
        Assertions.assertEquals(1, parcelBox.getSize());
    }

}
