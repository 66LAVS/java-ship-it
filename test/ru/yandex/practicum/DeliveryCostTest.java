package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;

public class DeliveryCostTest {

    @Test
    public void shouldGive100ifStandartParcelAndWeight50() {
        int coast = 100;
        StandardParcel standardParcel = new StandardParcel("1",50,"2",3);
        Assertions.assertEquals(coast, standardParcel.getDeliveryCost());
    }

    @Test
    public void shouldGive150ifPersihableParcelAndWeight50() {
        int coast = 150;
        PerishableParcel perishableParcel = new PerishableParcel("1",50,"2",3,1);
        Assertions.assertEquals(coast, perishableParcel.getDeliveryCost());
    }

    @Test
    public void shouldGive200ifFragileParcelAndWeight50() {
        int coast = 200;
        FragileParcel fragileParcel = new FragileParcel("1",50,"2",3);
        Assertions.assertEquals(coast, fragileParcel.getDeliveryCost());
    }

    @Test
    public void shouldGiveTrueIfPersihableParcelAndisExpired30andTimeToLive30() {
        int currentDay = 30;
        PerishableParcel perishableParcel = new PerishableParcel("1",50,"2",3,30);
        Assertions.assertFalse(perishableParcel.isExpired(30));
    }

    @Test
    public void shouldFalseIfWeight100andMaxWeight50() {
        int weight = 100;
        FragileParcel fragileParcel = new FragileParcel("1",100,"2",3);
        ParcelBox<FragileParcel> parcelBox = new ParcelBox<>(50);
        parcelBox.addParcel(fragileParcel);
        Assertions.assertEquals(0, parcelBox.getSize());
    }

    @Test
    public void shouldFalseIfWeight100andMaxWeight100() {
        int weight = 100;
        FragileParcel fragileParcel = new FragileParcel("1",100,"2",3);
        ParcelBox<FragileParcel> parcelBox = new ParcelBox<>(100);
        parcelBox.addParcel(fragileParcel);
        Assertions.assertEquals(1, parcelBox.getSize());
    }



}
