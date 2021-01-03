package currency_convert.model;

public class CurrencyRate {
    private int money;
    private int rate;

    public CurrencyRate() {
    }

    public CurrencyRate(int money, int rate) {
        this.money = money;
        this.rate = rate;
    }

    public int getMoney() {
        return money;
    }

    public int getRate() {
        return rate;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
