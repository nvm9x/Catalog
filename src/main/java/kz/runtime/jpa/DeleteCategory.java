package kz.runtime.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import kz.runtime.entity.Category;
import kz.runtime.entity.Product;

import java.util.Scanner;

public class DeleteCategory {

    public static void deleteCategory(){
        EntityManagerFactory factory = CentralFactory.createManager();
        EntityManager manager = factory.createEntityManager();
        //удалить категорию

        // удалить категорию если в ней нет товаров
        Scanner scan = new Scanner(System.in);
        System.out.println("Выберите категорию (удалить)");
        String categoryId= scan.nextLine();
        Category category = manager.find(Category.class,categoryId);
        try {
            manager.getTransaction().begin();
            if (category.getProducts().isEmpty()) {
                manager.remove(category);
            } else {
                Product product = null;
                for (int i = 0; i < category.getProducts().size(); i++) {
                    product = category.getProducts().get(i);
                    manager.remove(product);
                }
                for (int j = 0; j < product.getValueList().size(); j++) {
                    manager.remove(product.getValueList().get(j));
                }

                manager.getTransaction().commit();


            }
        }

        catch (Exception e){
            manager.getTransaction().rollback();
            throw new RuntimeException();
        }
        manager.close();
        factory.close();
    }
}
