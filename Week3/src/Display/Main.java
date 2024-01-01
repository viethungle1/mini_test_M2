package Display;
import Manager.MaterialManager;
import Material.Material;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Material> lists = new ArrayList<>();
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
            System.out.println("7. Procedure Discount");
            System.out.println("0. Exit");
            System.out.print("=> Enter a number: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ArrayList<Material> readData = readDataFromFile();
                    for (Material i : readData) {
                        System.out.println(i);
                    }
                    break;
                case 2:
                    readData = readDataFromFile();
                    MaterialManager.addNewMaterial(readData);
                    writeDataToFile(lists);
                    break;
                case 3:
                    MaterialManager.repairMaterial(lists);
                    break;
                case 4:
                    MaterialManager.removeMaterial(lists);
                    break;
                case 5:
                    System.out.println("Total of material: " + MaterialManager.totalAmount(lists) + "$");
                    break;
                case 6:
                    MaterialManager.collate(lists);
                    break;
                case 7:
                    MaterialManager.different(lists);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
    public static void writeDataToFile(ArrayList<Material> m) {
        try {
            FileOutputStream fos = new FileOutputStream("data.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(m);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Material> readDataFromFile(){
        ArrayList<Material> m = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.dat"));)
        {
            m = (ArrayList<Material>) ois.readObject();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return m;
    }

}