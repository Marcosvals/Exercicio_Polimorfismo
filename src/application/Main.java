package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.print("Enter the number of products: ");
            int n = sc.nextInt();

            List<Product> products = new ArrayList<>();

            for(int i = 1; i<=n; i++){
                System.out.printf("Product #%d data: \n", i);
                System.out.print("Commom, used or imported (c/u/i)?");
                char productType = sc.next().charAt(0);

                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();

                if(productType == 'c'){ //Instancia o objeto na classe product//
                    Product commomProduct = new Product(name, price);
                    products.add(commomProduct);
                }
                else if(productType == 'u') { // instancia o objeto na subclasse UsedProduct//
                    System.out.print("Manufacture data (DD/MM/YYYY): ");
                    sc.nextLine();
                    Date manufactureData = sdf.parse(sc.next());
                    Product usedProduct = new UsedProduct(name, price, manufactureData);
                    products.add(usedProduct);
                }
                else if(productType == 'i') {
                    System.out.print("Customs fee: ");
                    double customFee = sc.nextDouble();
                    Product importedProduct = new ImportedProduct(name, price, customFee);
                    products.add(importedProduct);
                }
            }

            System.out.println();
            System.out.println("PRICE TAGS: ");
            for (Product p : products){
                System.out.println(p.priceTag());
            }

            sc.close();
    }
}
