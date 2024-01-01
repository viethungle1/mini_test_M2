package Manager;
import Material.CrispyFlour;
import Material.Material;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import Material.Meat;

public class MaterialManager {
    public static final int ERROR = -1;
    public static void removeMaterial(ArrayList<Material> materials) {
        System.out.println("Enter the ID to remove material");
        Scanner scanner3 = new Scanner(System.in);
        String pick = scanner3.nextLine();
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getId().equals(pick)){
                materials.remove(materials.get(i));
            }
        }

    }
    public static void addNewMaterial(ArrayList<Material> materials) {
        System.out.println("Enter <F> or <M> to added materials");
        Scanner scanner1 = new Scanner(System.in);
        String inputAdd = scanner1.nextLine();
        if (inputAdd.equals("F")) {
            CreateMaterial material = newMaterial();
            System.out.println("Enter quantity");
            double quantity =scanner1.nextDouble();
            Material f = new CrispyFlour(material.id, material.name,material.manufacturingDate ,material.cost,quantity);
            materials.add(f);
        } else if (inputAdd.equals("M")) {
            CreateMaterial material = newMaterial();
            System.out.println("Enter weight");
            double weight = scanner1.nextDouble();
            Material m = new Meat(material.id, material.name,material.manufacturingDate ,material.cost,weight);
            materials.add(m);
        }else {
            System.out.println("Retype");
        }
    }

    public static void repairMaterial(ArrayList<Material> materials) {
        System.out.println("Enter the ID to edit material");
        Scanner scanner2 = new Scanner(System.in);
        String inputEdit = scanner2.nextLine();
        for (Material i : materials) {
            if (inputEdit.equals(i.getId())) {
                if (i instanceof CrispyFlour) {
                    CrispyFlour q = (CrispyFlour) i;
                    editMaterial(i);
                    System.out.println("Enter the quantity to edit");
                    double quantity = scanner2.nextDouble();
                    q.setQuantily(quantity);
                } else if (i instanceof Meat){
                    Meat w = (Meat) i;
                    editMaterial(i);
                    System.out.println("Enter the weight to edit");
                    double weight = scanner2.nextDouble();
                    w.setWeight(weight);
                }
            }
        }
    }
    public static void showList(ArrayList<Material> materials) {
        for (Material i : materials) {
            System.out.println(i);
        }
    }
    public static class CreateMaterial {
        public final String id;
        public final String name;
        public final LocalDate manufacturingDate;
        public final int cost;
        public CreateMaterial(String id, String name, LocalDate manufacturingDate, int cost) {
            this.id = id;
            this.name = name;
            this.manufacturingDate = manufacturingDate;
            this.cost = cost;
        }
    }
    public static CreateMaterial newMaterial () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID of the material");
        String id = scanner.nextLine();
        System.out.println("Enter the name of the material");
        String name = scanner.nextLine();
        System.out.println("Enter manufacturingDay");
        int day = scanner.nextInt();
        System.out.println("Enter manufacturingMonth");
        int month = scanner.nextInt();
        System.out.println("Enter manufacturingYear");
        int year = scanner.nextInt();
        LocalDate manufacturingDate = LocalDate.of(year,month,day);
        System.out.println("Enter cost of material");
        int cost = scanner.nextInt();
        CreateMaterial material = new CreateMaterial(id,name,manufacturingDate,cost);
        return material;
    }
    public static void editMaterial (Material material) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID to edit");
        String id = scanner.nextLine();
        material.setId(id);
        System.out.println("Enter the name to edit");
        String name = scanner.nextLine();
        material.setName(name);
        System.out.println("Enter the day to edit");
        int day = scanner.nextInt();
        System.out.println("Enter the month to edit");
        int month = scanner.nextInt();
        System.out.println("Enter the year to edit");
        int year = scanner.nextInt();
        LocalDate manufacturingDate = LocalDate.of(year,month,day);
        material.setmanufacturingDate(manufacturingDate);
        System.out.println("Enter the cost to edit");
        int cost = scanner.nextInt();
        material.setCost(cost);
    }

    public static void different(ArrayList<Material> materials) {
        for (Material i : materials) {
            double result = i.getAmount()- i.getRealMoney();
            if (result==i.getAmount()) {
                System.out.println(i.getName()+ " out of date");
            } else if (result== ERROR) {
                System.out.println(i.getName()+ " manufacturingDate is wrong");
            } else {
                System.out.println("Today " + i.getName() + " Dicount= " + result);
            }
        }
    }
    public static void collate(ArrayList<Material> materials) {
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
    public static int totalAmount (ArrayList<Material> a) {
        int total=0;
        for (Material i : a) {
            total += i.getAmount();
        }
        return total;
    }
}
