public class ProgrammingBook extends Book {
    private String language;

    private String framework;

    public ProgrammingBook() {
    }

    public ProgrammingBook(String bookCode, String name, double price, String author, String language, String framework) {
        super(bookCode, name, price, author);
        this.language = language;
        this.framework = framework;
    }

    public String getLanguage() {
        return language;
    }
    public String getFramework() {
        return framework;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public void setFramework(String framework) {
        this.framework = framework;
    }
    @Override
    public void setBookCode(String bookCode) {
        super.setBookCode(bookCode);
    }
    @Override
    public String getBookCode() {
        return super.getBookCode();
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public void setAuthor(String author) {
        super.setAuthor(author);
    }
    @Override
    public String getAuthor() {
        return super.getAuthor();
    }
    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }
    @Override
    public double getPrice() {
        return super.getPrice();
    }
}

