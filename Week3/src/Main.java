import java.time.LocalDate;
import java.util.*;
public class Main {
    public static final int EROR = -1;
    public static void main(String[] args) {
        Material flour1 = new CrispyFlour("0", "F1", LocalDate.of(2019, 12, 1), 50, 5);
        Material flour2 = new CrispyFlour("1", "F2", LocalDate.of(2020, 6, 1), 40, 5);
        Material flour3 = new CrispyFlour("2", "F3", LocalDate.of(2021, 12, 1), 30, 5);
        Material flour4 = new CrispyFlour("3", "F4", LocalDate.of(2023, 6, 1), 20, 5);
        Material flour5 = new CrispyFlour("4", "F5", LocalDate.of(2023, 12, 25),10 , 5);
        Material meat1 = new Meat("5", "M1", LocalDate.of(2023, 12, 30), 100, 1);
        Material meat2 = new Meat("6", "M2", LocalDate.of(2023, 12, 10), 110, 2);
        Material meat3 = new Meat("7", "M3", LocalDate.of(2023, 12, 15), 105, 3);
        Material meat4 = new Meat("8", "M4", LocalDate.of(2023, 12, 20), 130, 4);
        Material meat5 = new Meat("9", "M5", LocalDate.of(2023, 12, 10), 140, 5);
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
            System.out.println("1. Show list");
            System.out.println("2. Add material");
            System.out.println("3. Edit material");
            System.out.println("4. Remove material");
            System.out.println("5. Total of material");
            System.out.println("6. Arrange material");
            System.out.println("7. Discount");
            System.out.println("0. Exit");
            System.out.print("=> Enter a number: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    showList(materials);
                    break;
                case 2:
                    addNewMaterial(materials);
                    break;
                case 3:
                    repairMaterial(materials);
                    break;
                case 4:
                    removeMaterial(materials);
                    break;
                case 5:
                    System.out.println("Total of material: " + totalAmount(materials)+"$");
                    break;
                case 6:
                    collate(materials);
                    break;
                case 7:
                    different(materials);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    private static void removeMaterial(ArrayList<Material> materials) {
        System.out.println("Enter the ID to remove material");
        Scanner scanner3 = new Scanner(System.in);
        String pick = scanner3.nextLine();
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getId().equals(pick)){
                materials.remove(materials.get(i));
            }
        }

    }
    private static void addNewMaterial(ArrayList<Material> materials) {
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

    private static void repairMaterial(ArrayList<Material> materials) {
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
    private static void showList(ArrayList<Material> materials) {
        for (Material i : materials) {
            System.out.println(i);
        }
    }
    private static class CreateMaterial {
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
    private static CreateMaterial newMaterial () {
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
    private static void editMaterial (Material material) {
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

    private static void different(ArrayList<Material> materials) {
        for (Material i : materials) {
            double result = i.getAmount()- i.getRealMoney();
            if (result==i.getAmount()) {
                System.out.println(i.getName()+ " out of date");
            } else if (result== EROR) {
                System.out.println(i.getName()+ " manufacturingDate is wrong");
            } else {
                System.out.println("Today " + i.getName() + " Dicount= " + result);
            }
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
    private static int totalAmount (ArrayList<Material> a) {
        int total=0;
        for (Material i : a) {
            total += i.getAmount();
        }
        return total;
    }
}