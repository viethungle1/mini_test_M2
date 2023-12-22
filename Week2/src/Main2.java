public class Main2 {
    public static void main(String[] args) {
        ProgrammingBook b1 = new ProgrammingBook ("1","book1",10,"a","PHP","a");
        ProgrammingBook b2 = new ProgrammingBook ("1","book2",20,"b","Java","b");
        ProgrammingBook b3 = new ProgrammingBook ("1","book3",30,"c","C","c");
        ProgrammingBook b4 = new ProgrammingBook ("1","book4",40,"d","C#","d");
        ProgrammingBook b5 = new ProgrammingBook ("1","book5",50,"e",".Net","e");
        FictionBook b6 = new FictionBook ("1","book6",60,"f","Viễn tưởng 1");
        FictionBook b7 = new FictionBook ("1","book6",70,"f","Viễn tưởng 2");
        FictionBook b8 = new FictionBook ("1","book6",80,"f","Viễn tưởng 3");
        FictionBook b9 = new FictionBook ("1","book6",90,"f","Viễn tưởng 4");
        FictionBook b10 = new FictionBook ("1","book6",100,"f","Viễn tưởng 5");
        ProgrammingBook[] proGrammingBooks = {b1,b2,b3,b4,b5};
        FictionBook[] fictionBooks = {b6, b7, b8, b9, b10};
        Book[][] books = {proGrammingBooks, fictionBooks};
        System.out.println ("Tổng tiền sách là:" + totalPrice (books));
        System.out.println ("Số sách Java:" + countJavaBook (books));
        System.out.println ("Số sách viễn tưởng:"  + countFictionBook (books));
        System.out.println ("Số sách viễn tưởng có giá nhỏ hơn 100:" + countFictionBookLess100 (books));
    }



    public static int totalPrice(Book[][] arr) {
        int total = 0;
        for (Book[] i: arr) {
            for (Book j:i) {
                total += j.getPrice ();
            }
        }
        return total;
    }
    public static int countJavaBook(Book[][] arr){
        int count = 0;
        for (int i =0; i< arr.length; i++) {
            if (arr[i] instanceof ProgrammingBook[]) {
                for (int j =0; j < arr[i].length; j++) {
                    ProgrammingBook proBook = (ProgrammingBook) arr[i][j];
                    if (proBook.getLanguage ().equals ("Java")) {
                        count++;
                    }

                }
            }
        }
        return count;
    }
    public static int countFictionBook(Book[][] arr){
        int count = 0;
        for (Book[] i:arr){
            if(i instanceof FictionBook[]){
                for (Book j: i) {
                    FictionBook fictionBook = (FictionBook)j;
                    if (fictionBook.getCategory ().equals ("Viễn tưởng 1")){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static int countFictionBookLess100(Book[][] arr){
        int count = 0;
        for (Book[] i:arr){
            if(i instanceof FictionBook[]){
                for (Book j: i) {
                    FictionBook fictionBook = (FictionBook)j;
                    if (fictionBook.getPrice () < 100){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
