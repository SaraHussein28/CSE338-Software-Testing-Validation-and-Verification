import org.junit.jupiter.api.*;

public class ATMMachineTest {

    ATMMachine atmMachine;

    @BeforeEach
    public void init (){
        atmMachine = new ATMMachine();
    }


    @Test
    public void withdraw() {
        Assertions.assertEquals(true, atmMachine.withdraw(100));
        Assertions.assertEquals(1000-100, atmMachine.displayBalance());
    }

    @Test
    public void deposit() {
        Assertions.assertEquals(true, atmMachine.deposit(200));
        Assertions.assertEquals(1000+200, atmMachine.displayBalance());

    }

    @Test
    public void displayBalance() {
        Assertions.assertEquals(1000, atmMachine.displayBalance());
    }

}