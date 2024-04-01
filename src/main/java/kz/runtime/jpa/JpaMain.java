package kz.runtime.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import kz.runtime.entity.Category;
import kz.runtime.entity.Product;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // Maven - отдельная программа (не часть jdk,idea) выполняюзщая функции автоматизации
        // процесса сборки Java приложений по сценарию сборки описанному в файле
        //конфигурации pom.xml
        // Под автоматизацией сборки подразумеватеся настройка модулей прокета,
        // определение внешних зависимостей и их версий, конфигурирование дополнительных плагинов,
        // настройка сценариев развертывания проекта (deploy) и так далее.
        // Жизненным циклом называется определенный этап проекта проходящий жо его финальной
        // сборки, каждый жизненный цикл состоит из перечня фаз, каждая фаза определяет
        // действия проводимое над проектом (запуск тесток, компиляция, установка зависимостей и так далее).


        // При работе над большим проектом зачастую недостточно возможностей
        // предоставляемыъ стандартной библиотекой JDK, есть вохможность подключить к проекту
        // дополнительные внешние библиотеки, они же называются зависимостями.
        // У одного проекта может быть множество зависимостей. Зависимости можно подключать
        // при помощи инструментария среда разработки

        // Для работы с реляционными базами данных в стандартной библиотеке JDK
        // есть модуль под названием JDBC, данный модуль позволяет в полной мере без ограничений
        // выполнять любые манипуляции с сервером любой реляционной базы данных.

        //JPA - JAVA EE - один из модулей java EE/JAKARTA EE, описывает взаимодействие между java
        // и базами данных по принципу ORM.
        // ORM - OBJECT RELATIONAL MAPPING - модель которая основана на сопставлении табличных данных
        // и данных которые мы используем в джаве - система объектно реляционного сопоставления, то есть основной
        //функцией является преобразование табличных данных к объектам языка
        // table isers
        //id serial8
        // first_name varchar
        // birthdate date
        // income int4

        // Согласно спецификации JPA JAVA класс являющийся репрезентацией
        // одной записи конкретной таблицы стоит называть сущностью (entity)

        //  Важно отметить что JPA это в первую очередь спецификация (стандарт)
        // описывающая принцип взаимодейсвтия с реляционными базами данных, но
        // не предоставляющая конкретных классов для использования. В стандарте
        // описаны прогрвсе объекты которые должны быть реализованы и и х методы,аммирования и наоборрот
        // но самой реализации нет


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

        //возвращает сущность типа Т по заданному значению первичного ключа, если сущность не найlена
        //результатом будет null
        //.*find(Class<T> clazz, Object id) : T

//        Category category = manager.find(Category.class, 2);
//        System.out.println(category.getName());



       /* Product product = manager.find(Product.class, 4);
        System.out.println(product.getName());
         System.out.println(product.getPrice());
        System.out.println(product.getCategory().getName());*/
        /*int sum=0;
        int average=0;
        int count =0;

         Category category = manager.find(Category.class, 2);
         System.out.println(category.getName());
         for(int i=0;i<category.getProducts().size();i++){
        System.out.println(category.getProducts().get(i).getName());
        sum+=category.getProducts().get(i).getPrice();
        count++;
         }
         average=sum/count;

        System.out.println("Средняя цена "+average);*/


        //МАКСИМАЛЬНАЯ ЦЕНА ТОВАРА
       /* int max=0;

        Category category = manager.find(Category.class,1);
        System.out.println(category.getName());

        for(int i =0; i< category.getProducts().size();i++){
            if(category.getProducts().get(i).getPrice()>category.getProducts().get(i+1).getPrice()){
                max=category.getProducts().get(i).getPrice();
                System.out.println("Максимальная цена товара "+ max);
                System.out.println(category.getProducts().get(i).getName());
            }
        }*/

        //Товар с характеристиками и их значениями

        /*Product product = manager.find(Product.class, 2);
        System.out.println(product.getName());

        for (int i = 0; i < product.getValueList().size(); i++) {
            System.out.println(product.getValueList().get(i).getName());
           // System.out.println(product.);
        }

        manager.close();
        factory.close();*/

        //.*.persist(T entity) : void' - привязывет переданную через параматеры сущность
        //к обхекту EntityManager. Привязанная сущность сохраняется в локальной кэш EntityManager

       /* try {

            manager.getTransaction().begin();*/


       /* Category category = new Category();
        category.setName("Мебель");
        manager.persist(category);*/

          /*  Category category = manager.find(Category.class,3);
            category.setName("Game");

            manager.remove(category);

        manager.getTransaction().commit();
        } catch(Exception e) {
            manager.getTransaction().rollback();
            throw new RuntimeException();
        }



        manager.close();
        factory.close();*/

            /////////////////////////////////////////////////////

          /*  TypedQuery<Category> categoriesQuery = manager.createQuery("select c from Category  c", Category.class);



            List<Category> categories = categoriesQuery.getResultList();
            for (Category category : categories) {
                System.out.println(category.getName());*/

            //Вывести все товары стоимость которых находится между 500 и 1500
          /*  TypedQuery<Product> productQuery = manager.createQuery("select p from Product p where p.price between 500 and 1500", Product.class);
            List<Product> products = productQuery.getResultList();
            for (Product product:products){
                System.out.println(product.getName());
            }*/

         /*int minPrice = 150_000;
            int maxPrice = 350_000;
        TypedQuery<Product> productsQuery1 = manager.createQuery("select p from Product p where p.price between ?1 and ?2", Product.class);
        productsQuery1.setParameter(1,minPrice);
        productsQuery1.setParameter(2,maxPrice);
        List<Product> products1 = productsQuery1.getResultList();
        for (Product product:products1){
            System.out.println(product.getName());
        }*/
        // select p from Prosuct p where :from and :to

        TypedQuery<Long> productsCountQuery = manager.createQuery("select count(p.id) from Product p",
                Long.class);
        long productsCount = productsCountQuery.getSingleResult();
        System.out.println(productsCount);





        }
    }























