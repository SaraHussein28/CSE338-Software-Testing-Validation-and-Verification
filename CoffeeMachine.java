import java.util.Scanner;
class CoffeeMachine{
    private double coffee_powder, milk, water;
    private static int coffee_count = 0;

    public CoffeeMachine(){
        setCoffee_powder(0);
        setMilk(0);
        setWater(0);
    }

    public double getCoffee_powder() {
        return coffee_powder;
    }

    public double getMilk() {
        return milk;
    }

    public double getWater() {
        return water;
    }

    public void setCoffee_powder(double coffee_powder) {
        this.coffee_powder = coffee_powder;
    }

    public void setMilk(double milk) {
        this.milk = milk;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public boolean takeCoffeePowder(double amount) {
        if (getCoffee_powder() >= amount) {
            setCoffee_powder(this.coffee_powder - amount);
            return true;
        }
        return false;
    }


    public boolean takeMilk(double amount) {
        if (getMilk() >= amount) {
            setMilk(this.milk - amount);
            return true;
        }
        return false;
    }


    public boolean takeWater(double amount) {
        if (getWater() >= amount) {
            setWater(this.water - amount);
            return true;
        }
        return false;
    }


    public void fillsIngredient(){
        setCoffee_powder(500);
        setWater(2);
        setMilk(1);
    }
    public void CleanMachine(){
        setCoffee_powder(0);
        setMilk(0);
        setWater(0);
    }
    public boolean orderBlackCoffee(){  // assume one black coffee needs 10 coffee powder and 0.2 gm of water
        if (takeCoffeePowder(10) && takeWater(0.2)) {
            this.coffee_count++;
            return true;
        }
        return false;
    }
    public boolean orderMilkCoffee(){ // assume one milk coffee needs 10 coffee powder, 0.4 gm of milk, and 0.2 gm of water
            if (takeCoffeePowder(10) && takeWater(0.2) && takeMilk(0.4)) {
                this.coffee_count++;
                return true;
            }
            return false;
        }

}
