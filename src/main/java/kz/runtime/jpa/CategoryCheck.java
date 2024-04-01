package kz.runtime.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import kz.runtime.entity.Category;

import java.util.Scanner;

public class CategoryCheck {
    public static void main(String[] args) {
        // При запросе айди реализовать проверку на корректность ввода айди,
        // повторно запрашивать до тех пор пока не введен правильный айди
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите айди");
        String categoryId = scan.next();
        Category category = manager.find(Category.class,categoryId);
       while(category==null){
           System.out.println("Неверный ID, веедите еще раз");
           categoryId = scan.nextLine();
           category = manager.find(Category.class,categoryId);
       }
        System.out.println(category.getName());

    }
}
