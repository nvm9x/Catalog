package kz.runtime.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import kz.runtime.entity.Category;

import java.util.Scanner;

public class UpdateProductPrice {
    public static void main(String[] args) {
        //Ввести айди категории и все товары которые относятся к этой категори
        // и их стоимость должна быть увеличена н процент который вы вводите
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

        try {
            manager.getTransaction().begin();
            Scanner scan = new Scanner(System.in);
            System.out.println("Выберите ID");
            String categoryId = scan.nextLine();
            Category category = manager.find(Category.class, categoryId);
            System.out.println("Введите процент на который увеличите стоимость");
            double percent = Double.parseDouble(scan.nextLine());
            int newPrice;
            for (int i = 0; i < category.getProducts().size(); i++) {
                int price = category.getProducts().get(i).getPrice();
                newPrice = (int)(price + (price * percent / 100));
                category.getProducts().get(i).setPrice(newPrice);
                manager.persist(category.getProducts().get(i)); //не обязательно

            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
