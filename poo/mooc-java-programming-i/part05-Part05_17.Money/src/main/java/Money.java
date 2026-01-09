
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public Money plus(Money addition) {
        int euros = this.euros + addition.euros;
        int cents = this.cents + addition.cents;

        Money newMoney = new Money(euros, cents);
        
        return newMoney;
    }

    public boolean lessThan(Money compared){
        if(this.euros < compared.euros){
            return true;
        }else if(this.euros > compared.euros){
            return false;
        }else{
            if(this.cents < compared.euros){
                return true;
            }else{
                return false;
            }
        }
    }

    public Money minus(Money decreaser){
        Money addition;
        if(this.euros < decreaser.euros){
            addition = new Money(0, 0);

        }else if(this.cents < decreaser.cents){
            int euro = this.euros - 1 - (decreaser.euros);
            int cents = this.cents + 100 - (decreaser.cents);

            addition = new Money(euro, cents);

        }else{
            addition = new Money(-decreaser.euros, -decreaser.cents);

            addition = plus(addition);
        }

        return addition;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

}