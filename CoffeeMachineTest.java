import org.junit.jupiter.api.*;

public class CoffeeMachineTest {
    CoffeeMachine coffeeMachine;
    @BeforeEach
    public void init (){
        coffeeMachine = new CoffeeMachine();
    }

    @Nested
    public class basic_functions{
        @Test
        public void fillIngredientTest(){
            coffeeMachine.fillsIngredient();
            Assertions.assertEquals(500, coffeeMachine.getCoffee_powder());
            Assertions.assertEquals(2, coffeeMachine.getWater());
            Assertions.assertEquals(1, coffeeMachine.getMilk());
        }

        @Test
        public void takeCoffeeTest1(){
            Assertions.assertEquals(false, coffeeMachine.takeCoffeePowder(10));
        }

        @Test
        public void takeCoffeeTest2(){
            coffeeMachine.fillsIngredient();
            double takenAmount = 10;
            double originalAmount = coffeeMachine.getCoffee_powder();
            Assertions.assertEquals(true, coffeeMachine.takeCoffeePowder(takenAmount));
            Assertions.assertEquals(originalAmount-takenAmount, coffeeMachine.getCoffee_powder());

        }

        @Test
        public void takeMilk1(){
            Assertions.assertEquals(false, coffeeMachine.takeMilk(1));
        }

        @Test
        public void takeMilkTest2(){
            coffeeMachine.fillsIngredient();
            double takenAmount = 1;
            double originalAmount = coffeeMachine.getMilk();
            Assertions.assertEquals(true, coffeeMachine.takeMilk(takenAmount));
            Assertions.assertEquals(originalAmount-takenAmount, coffeeMachine.getMilk());

        }


        @Test
        public void takeWater1(){
            Assertions.assertEquals(false, coffeeMachine.takeWater(1));
        }

        @Test
        public void takeWaterTest2(){
            coffeeMachine.fillsIngredient();
            double takenAmount = 1;
            double originalAmount = coffeeMachine.getWater();
            Assertions.assertEquals(true, coffeeMachine.takeWater(takenAmount));
            Assertions.assertEquals(originalAmount-takenAmount, coffeeMachine.getWater());
        }
    }

    @Nested
    public class BlackCoffee{
        @Test
        public void orderBlackCoffeeTest1(){
            Assertions.assertEquals(false, coffeeMachine.orderBlackCoffee());
        }

        @Test
        public void orderBlackCoffeeTest2(){
            coffeeMachine.fillsIngredient();
            Assertions.assertEquals(true, coffeeMachine.orderBlackCoffee());
        }
    }


    @Nested
    public class MilkCoffee{
        @Test
        public void orderMilkCoffeeTest1(){
            Assertions.assertEquals(false, coffeeMachine.orderMilkCoffee());
        }

        @Test
        public void orderMilkCoffeeTest2(){
            coffeeMachine.fillsIngredient();
            Assertions.assertEquals(true, coffeeMachine.orderMilkCoffee());
        }
    }

}