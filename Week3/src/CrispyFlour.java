import java.time.LocalDate;

public class CrispyFlour extends Material {
    public static final int ZERO = 0;
    public static final double RATE_EX_2 = 0.8;
    public static final double RATE_EX_4 = 0.6;
    public static final double RATE = 0.95;
    public static final int LV1 = 2;
    public static final int LV2 = 4;
    private double quantily;

    public CrispyFlour() {
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantily) {
        super(id, name, manufacturingDate, cost);
        this.quantily = quantily;
    }

    public double getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    @Override
    public double getAmount() {
        return this.quantily * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {

        return getmanufacturingDate().plusYears(1);
    }

    @Override
    public String toString() {
        return super.toString()+ " quantily=" + quantily +" "+"\n";
    }

    @Override
    public double getRealMoney() {
        LocalDate day = LocalDate.now();
        double realCost = ZERO;
        double rate = RATE;
//        0.95
        double rateEx2 = RATE_EX_2;
//        0.8
        double rateEx4 = RATE_EX_4;
//        0.6
        if (day.isBefore(getmanufacturingDate())) {
            realCost = getAmount()+1;
        } else if (day.isAfter(getExpiryDate())) {
            realCost = ZERO;
        } else if ((getExpiryDate().minusMonths(LV1)).isBefore(day)) {
            realCost = getAmount()* RATE_EX_4;
        } else if ((getExpiryDate().minusMonths(LV2)).isBefore(day)) {
            realCost = getAmount()* RATE_EX_2;
        } else {
            realCost = getAmount()* RATE;
        }
        return realCost;
    }
}
