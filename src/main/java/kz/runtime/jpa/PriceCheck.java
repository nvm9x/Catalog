package kz.runtime.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class PriceCheck {

    public static void priceCheck(){
        //Проверка на ввод числовых значений цены, а не строковых
        EntityManagerFactory factory = CentralFactory.createManager();
        EntityManager manager = factory.createEntityManager();

        Scanner scan = new Scanner(System.in);

       /* String price = scan.nextLine();
        boolean priceMatch = price.matches("^\\d{1,}$");
        while(!priceMatch){
            System.out.println("Неверные данные, введите цену");
            price = scan.nextLine();
            priceMatch = price.matches("^\\d{1,}$");

        }
        System.out.println("+++++++++++++++++++");
        System.out.println("Цена: "+price);*/



        while(true) {
            try {
                System.out.println("Введите цену");
                int priceTwo = Integer.parseInt(scan.nextLine());
                System.out.println("Цена " +priceTwo );
            } catch (NumberFormatException e) {
                System.out.println("Введите числовое значение");
                continue;
            }
            break;
        }
    }
}
