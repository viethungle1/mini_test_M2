public class Not_use {
    public static void main(String[] args) {
//      Tạo 5 cuốn sách ProgrammingBook và 5 cuốn FictionBook
        System.out.println("a)");
        int sumP=0;
        Book[]arrProgramming = new Book[5];
        for (int i = 0; i < arrProgramming.length; i++) {
            arrProgramming[i] = new ProgrammingBook();
            arrProgramming[i].setPrice(Math.round(Math.random()*(90-70+1)+70));
            System.out.println("Giá sách lập trình thứ " + i + " là " + arrProgramming[i].getPrice()+"$");
            sumP += arrProgramming[i].getPrice();
        }
        System.out.println("--------------------------------");
        int sumF = 0;
        Book[]arrFiction = new Book[5];
        for (int i = 0; i < arrFiction.length ; i++) {
            arrFiction[i] = new FictionBook();
            arrFiction[i].setPrice(Math.round(Math.random()*(110-90+1)+90));
            System.out.println("Giá sách viễn tưởng thứ " + i + " là " + arrFiction[i].getPrice()+"$");
            sumF += arrFiction[i].getPrice();
        }
        System.out.println("--------------------------------");
        System.out.println("b)");
//      Tính tổng tiền 10 cuốn sách
        double sum=0;
        sum = sumF+sumP;
        System.out.println("Tổng giá 10 cuốn sách là " + sum +"$");
        System.out.println("--------------------------------");
        System.out.println("c)");
//      Đếm số sách ProgrammingBook có languague là Java
        int countProgramming = 0;
        for (int i = 0; i < arrProgramming.length; i++) {
            if (arrProgramming[i] instanceof ProgrammingBook) {
                ProgrammingBook a = (ProgrammingBook) arrProgramming[i];
                if (arrProgramming[i].getPrice() > 80) {
                    a.setLanguage("java");
                    countProgramming++;
                }
            }
        }
        System.out.println("số sách có language Java là: " +countProgramming);
//      Đếm số sách FictionBook có category là Viễn tưởng 1
        System.out.println("--------------------------------");
        System.out.println("d)");
        int countFiction = 0;
        int countFiction2= 0;
        for (int i = 0; i < arrFiction.length; i++) {
            FictionBook b = (FictionBook) arrFiction[i];
            if (arrFiction[i].getPrice()>100) {
                b.setCategory("Viễn tưởng 1");
                countFiction++;
            }
            if (arrFiction[i].getPrice()<100) {
                countFiction2++;
            }
        }
        System.out.println("số sách có category (Viễn tưởng 1) là: " +countFiction);
        System.out.println("--------------------------------");
        System.out.println("e)");
        System.out.println("số sách FictionBook có giá <100 là: " +countFiction2);
    }
}