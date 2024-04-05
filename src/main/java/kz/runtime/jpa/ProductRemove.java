package kz.runtime.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import kz.runtime.entity.Product;
import kz.runtime.entity.Value;


public class ProductRemove {


    public static void productRemove(){
        EntityManagerFactory factory = CentralFactory.createManager();
        EntityManager manager = factory.createEntityManager();

        Product product = manager.find(Product.class, 1);


        try {
            manager.getTransaction().begin();

            for(int i=0;i<product.getValueList().size();i++){
                manager.remove(product.getValueList().get(i));
            }
            manager.remove(product);


            manager.getTransaction().commit();
        } catch (Exception e){
            manager.getTransaction().rollback();
            throw new RuntimeException();
        }
        manager.close();
        factory.close();
    }
}
