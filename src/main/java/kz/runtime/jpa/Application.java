package kz.runtime.jpa;

import kz.runtime.CreateCategory;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбрать действие");
        System.out.println("1-создать категорию");
        System.out.println("2- проверить наличие категории в списке");
        System.out.println("3-создать продукт");
        System.out.println("4- удалить категорию");
        System.out.println("5- удалить продукт");
        System.out.println("6- изменить категорию");

        int num = Integer.parseInt(scanner.nextLine());

        switch (num) {
            case 1:
                System.out.println("Создаем категорию");
                CreateCategory.createCategory();
                break;
            case 2:
                System.out.println("проверить наличие категории в списке");
                CategoryCheck.categoryCheck();
                break;

            case 3:
                System.out.println("создать продукт");
                CreateProduct.createProduct();
                break;

            case 4:
                System.out.println("удалить категорию");
                DeleteCategory.deleteCategory();

                break;

            case 5:
                System.out.println("удалить продукт");
                ProductRemove.productRemove();
                break;

            case 6:
                System.out.println("Обновить цену продукта");
                UpdateProductPrice.updatePrices();


                break;

            default:
                System.out.println("Вариант не существует,введите еще раз");
        }

    }
}
