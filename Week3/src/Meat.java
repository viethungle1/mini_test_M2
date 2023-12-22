import java.time.LocalDate;
public class Meat extends Material {
    public static final double RATE = 0.9;
    public static final double RATE_EX = 0.7;
    public static final int ZERO = 0;
    public static final int LV1 = 5;
    private double weight;

    public Meat () {
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return getCost()*getAmount();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getmanufacturingDate().plusDays(7);
    }

    @Override
    public String toString() {
        return super.toString()+ " weight=" + weight +" "+"\n";
    }

    @Override
    public double getRealMoney() {
        LocalDate day = LocalDate.now();
        double realCost = ZERO;
        double rate = RATE;
        double rateEX = RATE_EX;
        if (day.isBefore(getmanufacturingDate())) {
            realCost = getCost()+1;
        }else if (day.isAfter(getExpiryDate())) {
            realCost = ZERO;
        } else if ((getExpiryDate().minusDays(LV1)).isAfter(day)) {
            realCost = getCost()* RATE;
        } else {
            realCost = getCost()* RATE_EX;
        }
        return realCost;

    }
}
