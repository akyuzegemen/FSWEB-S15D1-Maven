package org.example.models;

import java.util.*;


public class Grocery {
    public static List<String> groceryList = new ArrayList<>();


    public void startGrocery()
    {
        Scanner input = new Scanner(System.in); // Scanner nesnesi oluşturulur
        String inp = input.nextLine();
        while (!Objects.equals(inp, "0"))
        {
            if(Objects.equals(inp, "1"))
            {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String ekle = input.nextLine();
                addItems(ekle);
            }
            else if (Objects.equals(inp, "2"))
            {
                System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                String cikar = input.nextLine();
                removeItems(cikar);
            }

        }
        return;
    }

    public static void addItems(String input)
    {
        if(input.contains(",")) {
            input = input.replaceAll(" ", "");
            List<String> eklenecek = new ArrayList<>(Arrays.asList(input.split(",")));
            for (String item : eklenecek)
            {
                if(!groceryList.contains(item)) groceryList.add(item);
            }

        }
        else if(!checkItemIsInlist(input)) groceryList.add(input);

        printSorted();
    }

    public static void removeItems (String input)
    {
        if(input.contains(",")) {
            input = input.replaceAll(" ", "");
            List<String> sil = new ArrayList<>(Arrays.asList(input.split(",")));
            groceryList.removeAll(sil);
        }
        else groceryList.remove(input);
        printSorted();
    }

    public static void printSorted()
    {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
    public static boolean checkItemIsInlist(String product)
    {
        return groceryList.contains(product);
    }
}
