package kz.runtime.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import kz.runtime.entity.Category;
import kz.runtime.entity.Description;
import kz.runtime.entity.Product;
import kz.runtime.entity.Value;

import java.util.List;
import java.util.Scanner;

public class CreateProduct {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавить продукт");
        String addProduct = scanner.nextLine();
        System.out.println("Введите цену");
        int addPrice = scanner.nextInt();
        System.out.println("Введите значение продукта");
        String productName = scanner.nextLine();

        Category category = manager.find(Category.class, 2);
       /* TypedQuery<Category> categoryQuery = manager.createQuery("select c from Category c", Category.class);
        List<Category> categories = categoryQuery.getResultList();
        for (Category category1 : categories) {
            System.out.println(category1.getName());*/

            try {
                manager.getTransaction().begin();

                Product product = new Product();
                product.setName(addProduct);
                product.setPrice(addPrice);
                product.setCategory(category);
                manager.persist(product);
                Value value = new Value();
                for (int i = 0; i < category.getDescriptions().size(); i++) {
                    System.out.println("Введите значение характеристики для - " + category.getDescriptions().get(i).getName());
                    String valueName = scanner.nextLine();
                    value.setName(productName);
                    value.setDescription(category.getDescriptions().get(i));
                    value.setProduct(product);
                    manager.persist(value);
                }

                manager.getTransaction().commit();
            } catch (Exception e) {
                manager.getTransaction().rollback();
                throw new RuntimeException(e);
            }
            manager.close();
            factory.close();
        }
    }

