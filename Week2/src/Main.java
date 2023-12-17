public class Main {
    public static void main(String[] args) {
        ProgrammingBook[] programmingBooks = new ProgrammingBook[5];
        programmingBooks[0] = new ProgrammingBook("P1", "Programming1", 50, "A", "Java", "1");
        programmingBooks[1] = new ProgrammingBook("P2", "Programming2", 60, "B", "NodeJS", "2");
        programmingBooks[2] = new ProgrammingBook("P3", "Programming3", 70, "C", "C++", "3");
        programmingBooks[3] = new ProgrammingBook("P4", "Programming4", 80, "D", "Pascal", "4");
        programmingBooks[4] = new ProgrammingBook("P5", "Programming5", 90, "E", "Python", "5");
        FictionBook[] fictionBooks = new FictionBook[5];
        fictionBooks[0] = new FictionBook("F1", "Fiction1", 80, "F", "Viễn tưởng 1");
        fictionBooks[1] = new FictionBook("F2", "Fiction2", 90, "F", "Viễn tưởng 2");
        fictionBooks[2] = new FictionBook("F3", "Fiction3", 100, "F", "Viễn tưởng 3");
        fictionBooks[3] = new FictionBook("F4", "Fiction4", 110, "F", "Viễn tưởng 4");
        fictionBooks[4] = new FictionBook("F5", "Fiction5", 120, "F", "Viễn tưởng 5");

        double sum = 0;
        double sumP = 0;
        double sumF = 0;
        for (int i = 0; i < programmingBooks.length; i++) {
            sumF += programmingBooks[i].getPrice();
        }
        for (int i = 0; i < fictionBooks.length; i++) {
            sumF += fictionBooks[i].getPrice();
        }
        sum = sumP + sumF;
        System.out.println("Giá 10 cuốn sách: " + sum);
        int count1 = 0;
        for (int i = 0; i < programmingBooks.length; i++) {
            if (programmingBooks[i].getLanguage().equals("Java")) {
                count1++;
            }
        }
        System.out.println("Số sách ngôn ngữ Java: "+count1);
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < fictionBooks.length; i++) {
            if (fictionBooks[i].getCategory().equals("Viễn tưởng 1")) {
                count2++;
            }
            if (fictionBooks[i].getPrice()<100) {
                count3++;
            }
        }
        System.out.println("Số sách category Viễn tưởng 1: "+count2);
        System.out.println("Số sách viễn tưởng giá nhỏ hơn 100: "+count3);
    }
}

