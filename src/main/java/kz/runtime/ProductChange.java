package kz.runtime;

import jakarta.persistence.*;
import kz.runtime.entity.Category;
import kz.runtime.entity.Description;
import kz.runtime.entity.Product;
import kz.runtime.entity.Value;

import java.util.List;
import java.util.Scanner;

public class ProductChange {
    public static void main(String[] args) {

        //Задания
        //  1--Если я не ввожу новую информацию,остается старая
        // При запросе айди реализовать проверку на корректность ввода айди,
        // повторно запрашивать до тех пор пока не введен правильный айди

        //2--
        //задание
        //если значения характеристик не заполнены или отсутвуют в таблице value
        // но в таблице характеристик они сущетсвуют
        // то программа должна запрашивать заполнить эти характеристики
        // например у 4 продукта есть только два заполненных значения
        // 4 продукт относится ко 2 категории и у него 4 характеристики
        // количество характеристик

        //select для поиска значения харакеристики сделать
        //если нашел значит обновляю если нет - создаю

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите айди продукта");
        String productId = scanner.nextLine();

        Product product = manager.find(Product.class, productId);

        try {
            manager.getTransaction().begin();
            /*String newProduct = scanner.nextLine();
            String newPrice = scanner.nextLine();
            if(!newProduct.isEmpty()){
                product.setName(newProduct);
            }
            if(!newPrice.isEmpty()){
                int newPrice1 = Integer.valueOf(newPrice);
                product.setPrice(newPrice1);}

            manager.persist(product);


            for(int i=0;i<product.getValueList().size();i++) {
                String name = product.getValueList().get(i).getName();
                System.out.println("Изменить value_name " + name);
                System.out.println("Введите новое значение");
                String newValue = scanner.nextLine();
                if (newValue.isEmpty()) {
                    product.setName(product.getName());
                    manager.persist(product);
                } else {
                    product.getValueList().get(i).setName(newValue);
                    manager.persist(product.getValueList().get(i));
                }



            }*/


            int sizeList = product.getCategory().getDescriptions().size(); //количество характеристик

            for (int i = 0; i < sizeList; i++) {
                TypedQuery<Value> valueTypedQuery = manager.createQuery("select v from Value v where" +
                        " v.description.id =?1 and v.product.id=?2 ", Value.class);
                Description description = product.getCategory().getDescriptions().get(i);
                //System.out.println(productId);
                //System.out.println(description.getId());
                valueTypedQuery.setParameter(1, description.getId());
                valueTypedQuery.setParameter(2, productId);

                try {
                    Value valueObj = valueTypedQuery.getSingleResult();
                    System.out.println(valueObj);
//                    System.out.println("Обновить значение, введите новое значение характеристики");
//                    System.out.println(product.getCategory().getDescriptions().get(i).getName() + "---");
//                    String newValue = scanner.nextLine();
//                    product.getValueList().get(i).setName(newValue);
//                    System.out.println("Новое значение" + product.getValueList().get(i).getName());
                } catch (NoResultException e) {
                    System.out.println("catch");
//                    Value value = new Value();
//                    value.setProduct(product);
//                    value.setDescription(description);
//                    String newValueCatch = scanner.nextLine();
//                    value.setName(newValueCatch);
//                    manager.persist(value);
                }

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
