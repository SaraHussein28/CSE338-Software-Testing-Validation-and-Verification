import org.junit.jupiter.api.*;

import static org.junit.Assert.*;

public class DigitalWatchIntegrationTesting {

    DigitalWatch digitalWatch;

    @BeforeEach
    public void init (){
        digitalWatch = new DigitalWatch();
    }

        @Nested
        public class BasicFunctions{
            @Test
            public void setNormalTest(){
            digitalWatch.setNormal();
            Assertions.assertEquals("NORMAL-TIME", digitalWatch.displayCurrentState());
            Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
            Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }

            @Test
            public void setUpdateTest(){
                digitalWatch.setUpdate();
                Assertions.assertEquals("UPDATE-MIN", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }

            @Test
            public void setAlarmTest(){
                digitalWatch.setAlarm();
                Assertions.assertEquals("ALARM-ALARM", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }
            @AfterEach
             public void clear() {
            digitalWatch = null;
            }

         }


        @Nested
        public class NormalMode{
            @Test
            public void tesCase1() {    // NORMAL-TIME to NORMAL-DATE
                digitalWatch.pressButton('a');
                Assertions.assertEquals("NORMAL-DATE", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }

            @Test
            public void tesCase2() {// NORMAL-DATE to NORMAL-TIME
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                Assertions.assertEquals("NORMAL-TIME", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }

            @Test
            public void tesCase3() { // NORMAL-TIME to ALARM-ALARM
                digitalWatch.pressButton('b');
                Assertions.assertEquals("ALARM-ALARM", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }


            @Test
            public void tesCase4() { // NORMAL-TIME to UPDATE-MIN
                digitalWatch.pressButton('c');
                Assertions.assertEquals("UPDATE-MIN", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }

            @AfterEach
            public void clear() {
                digitalWatch = null;
            }

        }


        @Nested
        public class AlarmMode{
            @Test
            public void tesCase1() {    // NORMAL-TIME to NORMAL-DATE
                digitalWatch.pressButton('b');
                digitalWatch.pressButton('a');
                Assertions.assertEquals("ALARM-CHIME", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }

            @Test
            public void tesCase2() {// NORMAL-DATE to NORMAL-TIME
                digitalWatch.pressButton('b');
                digitalWatch.pressButton('d');
                Assertions.assertEquals("NORMAL-TIME", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }

            @AfterEach
            public void clear() {
                digitalWatch = null;
            }

        }


        @Nested
        public class UpdateMode{
            @Test
            public void tesCase1() {    // UPDATE-MIN to UPDATE-HOUR
                digitalWatch.pressButton('c');
                digitalWatch.pressButton('a');

                Assertions.assertEquals("UPDATE-HOUR", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }

            @Test
            public void tesCase2() { // UPDATE-HOUR to UPDATE-DAY
                digitalWatch.pressButton('c');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                Assertions.assertEquals("UPDATE-DAY", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }

            @Test
            public void tesCase3() { // UPDATE-DAY to UPDATE-MONTH
                digitalWatch.pressButton('c');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                Assertions.assertEquals("UPDATE-MONTH", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }


            @Test
            public void tesCase4() {// UPDATE-MONTH to UPDATE-YEAR
                digitalWatch.pressButton('c');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                Assertions.assertEquals("UPDATE-YEAR", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }


            @Test
            public void tesCase5() { // UPDATE-YEAR to NORMAL-DATE
                digitalWatch.pressButton('c');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                Assertions.assertEquals("NORMAL-TIME", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }

            @Test
            public void tesCase6() {    // UPDATE to NORMAL-DATE
                digitalWatch.pressButton('c');
                digitalWatch.pressButton('d');
                Assertions.assertEquals("NORMAL-TIME", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }

            @Test
            public void tesCase7() {    // UPDATE-MIN
                digitalWatch.pressButton('c');
                digitalWatch.pressButton('b');
                Assertions.assertEquals("UPDATE-MIN", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:1", digitalWatch.displayTime());
            }

            @Test
            public void tesCase8() { // UPDATE-HOUR
                digitalWatch.pressButton('c');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('b');
                Assertions.assertEquals("UPDATE-HOUR", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("1:0", digitalWatch.displayTime());
            }

            @Test
            public void tesCase9() { // UPDATE-DAY
                digitalWatch.pressButton('c');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('b');
                Assertions.assertEquals("UPDATE-DAY", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-1-2", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }


            @Test
            public void tesCase10() {// UPDATE-MONTH
                digitalWatch.pressButton('c');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('b');
                Assertions.assertEquals("UPDATE-MONTH", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2000-2-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }


            @Test
            public void tesCase11() { // UPDATE-YEAR
                digitalWatch.pressButton('c');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('a');
                digitalWatch.pressButton('b');
                Assertions.assertEquals("UPDATE-YEAR", digitalWatch.displayCurrentState());
                Assertions.assertEquals("2001-1-1", digitalWatch.displayDate());
                Assertions.assertEquals("0:0", digitalWatch.displayTime());
            }

            @AfterEach
            public void clear() {
                digitalWatch = null;
            }

        }


    @AfterEach
    public void clear(){
        digitalWatch = null;
    }





}