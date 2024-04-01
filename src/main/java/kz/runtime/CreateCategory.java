package kz.runtime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import kz.runtime.entity.Category;
import kz.runtime.entity.Description;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CreateCategory {
    public static void main(String[] args) {
        //Задания
        // Добавить категорию category
        // Добавить характеристики description
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавить категорию");
        String categoryName = scanner.nextLine();
        System.out.println("Введите эти характеристики: страна производства, материал");
        String descriptionName = scanner.nextLine();
        String[] array =  descriptionName.split(",");

        // Введите название характеристики: Мебель
        // Введите характеристики категории: страна производства, материал

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

        try{
            manager.getTransaction().begin();

            // Если категория с введенным названием уже существует, то вывести
            // соответсвующее сообщение и запросить название повторно, повторять запрос
            // до тех пор пока не будет введено уникальное название
            // категории которого нет в таблице.

            //сделать запрос, а потом сравнить


            TypedQuery<Long> categoryQuery = manager.createQuery("select count(c.id) from Category c where c.name = ?1",Long.class);
            categoryQuery.setParameter(1, categoryName);
           long categoryCount= categoryQuery.getSingleResult();
           while(categoryCount>0) {
               System.out.println("Категория уже существует,введите еще раз");
               categoryName = scanner.nextLine();
               categoryQuery.setParameter(1,categoryName);
               categoryCount=categoryQuery.getSingleResult();

           }

           Category category = new Category();

               category.setName(categoryName);
               //
               manager.persist(category);

               for (int i = 0; i < array.length; i++) {
                   Description description = new Description();
                   description.setDescription(category);
                   description.setName(array[i]);
                   manager.persist(description);

               }
               manager.getTransaction().commit();



        } catch(Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException(e);
        }



        manager.close();
        factory.close();
    }
}
