import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Material flour1 = new CrispyFlour("1", "F1", LocalDate.of(2019, 12, 1), 140, 100);
        Material flour2 = new CrispyFlour("2", "F2", LocalDate.of(2020, 6, 1), 130, 100);
        Material flour3 = new CrispyFlour("3", "F3", LocalDate.of(2021, 12, 1), 120, 100);
        Material flour4 = new CrispyFlour("4", "F4", LocalDate.of(2023, 6, 1), 110, 100);
        Material flour5 = new CrispyFlour("5", "F5", LocalDate.of(2023, 12, 25), 100, 100);
        Material meat1 = new Meat("1", "M1", LocalDate.of(2023, 12, 30), 500, 10);
        Material meat2 = new Meat("2", "M2", LocalDate.of(2023, 12, 10), 1000, 20);
        Material meat3 = new Meat("3", "M3", LocalDate.of(2023, 12, 15), 250, 5);
        Material meat4 = new Meat("4", "M4", LocalDate.of(2023, 12, 20), 1500, 30);
        Material meat5 = new Meat("5", "M5", LocalDate.of(2023, 12, 10), 2000, 40);
        ArrayList<Material> materials = new ArrayList<>();
        materials.add(flour1);
        materials.add(flour2);
        materials.add(flour3);
        materials.add(flour4);
        materials.add(flour5);
        materials.add(meat1);
        materials.add(meat2);
        materials.add(meat3);
        materials.add(meat4);
        materials.add(meat5);
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("MENU");
            System.out.println("1. Total of material");
            System.out.println("2. Reorganize material");
            System.out.println("3. Discount cost");
            System.out.println("0. Exit");
            System.out.print("=> Enter a number: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Total of material: " + totalCost(materials)+"$");
                    break;
                case 2:
                    collate(materials);
                    break;
                case 3:
                    different(materials);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    private static void different(ArrayList<Material> materials) {
        for (Material i : materials) {
            double result = i.getCost()- i.getRealMoney();
            System.out.println("Today " + i.getName() + " DicountCost= " + result);
        }
    }
    private static void collate(ArrayList<Material> materials) {
        Comparator<Material> comparator = new Comparator<>() {
            @Override
            public int compare(Material o1, Material o2) {
                return o1.getCost() - o2.getCost();
            }
        };
        Collections.sort(materials, comparator);
        for (Material i : materials) {
            System.out.println(i);
        }
    }
    private static int totalCost (ArrayList<Material> a) {
        int total=0;
        for (Material i : a) {
            total += i.getCost();
        }
        return total;
    }
}