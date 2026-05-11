package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackingParcels = new ArrayList<>();
    public static ParcelBox<StandardParcel> standardBox = new ParcelBox<>(100);
    public static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(50);
    public static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(80);


    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatusUpdate();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Обновить адрес доставки посылок");
        System.out.println("0 — Завершить");
    }


    // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
    private static void addParcel() {
        System.out.println("Введите какую посылку хотите отправить:\n1 - Стандартную\n2 - Хрупкую\n3 - Скоропортящаяся");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите описание послыки");
        String description = scanner.nextLine();
        System.out.println("Введите вес посылки");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите описание посылки");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Введите дату отправки посылки");
        int sendDay = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(standardParcel);
                System.out.println("Стандартная посылка добавлена");
                standardBox.addParcel(standardParcel);
                break;
            case 2:
                System.out.println("Введите срок хранения (дней):");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                System.out.println("Скоропортящаяся посылка добавлена");
                perishableBox.addParcel(perishableParcel);
                break;
            case 3:
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(fragileParcel);
                trackingParcels.add(fragileParcel);
                System.out.println("Хрупкая посылка добавлена");
                fragileBox.addParcel(fragileParcel);
                break;
            default:
                System.out.println("Введите верный номер посылки");

        }
    }

    // Пройти по allParcels, вызвать packageItem() и deliver()
    private static void sendParcels() {
        if (allParcels.isEmpty()) {
            System.out.println("Список посылок пуст!");
            return;
        }
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    // Посчитать общую стоимость всех доставок и вывести на экран
    private static void calculateCosts() {
        if (allParcels.isEmpty()) {
            System.out.println("Список посылок пуст!");
            return;
        }
        int cost = 0;
        for (Parcel parcel : allParcels) {
            cost = cost + parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость посылок" + cost);
    }

    private static void reportStatusUpdate() {
        if (trackingParcels.toArray().length == 0) {
            System.out.println("Посылок с трекингом нет!");
            return;
        }
        for (Trackable parcel : trackingParcels) {
            System.out.println("Введите адрес для посылки" + parcel);
            String newLocation = scanner.nextLine();
            parcel.reportStatus(newLocation);
        }
    }

}

