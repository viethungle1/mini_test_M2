package Display;
import Manager.MaterialManager;
import Material.Material;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        ArrayList<Material> materials = new ArrayList<>();
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
            System.out.println("7. Procedure.Discount");
            System.out.println("0. Exit");
            System.out.print("=> Enter a number: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    MaterialManager.showList(materials);
                    break;
                case 2:
                    MaterialManager.addNewMaterial(materials);
                    break;
                case 3:
                    MaterialManager.repairMaterial(materials);
                    break;
                case 4:
                    MaterialManager.removeMaterial(materials);
                    break;
                case 5:
                    System.out.println("Total of material: " + MaterialManager.totalAmount(materials)+"$");
                    break;
                case 6:
                    MaterialManager.collate(materials);
                    break;
                case 7:
                    MaterialManager.different(materials);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }


}