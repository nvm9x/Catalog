package kz.runtime.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import kz.runtime.entity.Category;

import java.util.Scanner;

public class Value {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();
        Value value = new Value();
        Scanner scan = new Scanner(System.in);

        Category category = manager.find(Category.class,2);
        for(int i=0;i<category.getDescriptions().size();i++){

            System.out.println("Введите название продукта для - "+category.getDescriptions().get(i).getName());
            String valueName = scan.nextLine();







        }
    }
}
