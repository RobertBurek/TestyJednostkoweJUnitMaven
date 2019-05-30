package pl.robwork;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

/**
 * Created by Robert Burek
 */
class AppTestJUnit5 {

    static App electricityMeter;
    static TariffProvider tp;

//    @BeforeAll odpowiednik @BeforeClass w JUnit4
//    @BeforeEach odpowiednik @Before w JUnit4

    @BeforeAll
    public static void setUp() {
        tp = Mockito.mock(TariffProvider.class);
        electricityMeter = new App(tp);
        electricityMeter.setTariffOn(true);
    }

//    @AfterAll odpowiednik @AfterClass w JUnit4
//    @AfterEach odpowiednik @After w JUnit4

    @Disabled("Bo tak ma być!!!")
    @Test
    public void givenTariffOnWhenAdditionThenKwhIncreased() {
        //Given
        //TODO setTariff Time mock isTariffNow()!
        Mockito.when(tp.isTariffNow()).thenReturn(false);
        electricityMeter = new App(tp);
        electricityMeter.setTariffOn(true);
        //When
        electricityMeter.addKwh(50);
        //Then
        Assumptions.assumeTrue(tp.isTariffNow());
        Assertions.assertEquals(50, electricityMeter.getKwhTariff());
    }

    @Disabled
    @Test
    public void getHowMoreExpensiveNormalIs() {
//        pełny zapis Executable
//        Assertions.assertThrows(ArithmeticException.class, ()-> {
//                App electricityMeter = new App();
//                electricityMeter.setCentsForKwh(90);
//                electricityMeter.getHowMoreExpensiveNormalIs();
//            });

        //zapis Executable przez lambdę
        // oczekiwany wyjątek ArithmeticException inny nie będzie obsłużony np IOException
        Throwable exception = Assertions.assertThrows(ArithmeticException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                App electricityMeter = new App(tp);
                electricityMeter.setCentsForKwh(90);
                electricityMeter.getHowMoreExpensiveNormalIs();
            }
        });
        Assertions.assertEquals("/ by zero", exception.getMessage());
    }

    @RepeatedTest(85)
    public void givenMuchAdditionsWhenAdditionThenTariffChange(RepetitionInfo repetitionInfo) {
        //Given
        Mockito.when(tp.isTariffNow()).thenReturn(false);
        //When
        electricityMeter.addKwh(50);
        System.out.println("Przebieg nr: " + repetitionInfo.getCurrentRepetition()
                + " wartość licznika = "
                + repetitionInfo.getCurrentRepetition() * 50 + " kwh");
        //Then
        Assertions.assertEquals(repetitionInfo.getCurrentRepetition() * 50,
                electricityMeter.getKwhNoTariff(),
                "Wartość licznika: " + repetitionInfo.getCurrentRepetition() * 50 + " kwh");
    }

    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Test wielokrotny z kilkoma assercjami")
    public void givenMuchAdditionsWhenAdditionThenTariffChangeAllAsserts(RepetitionInfo repetitionInfo) {
        //Given
        Mockito.when(tp.isTariffNow()).thenReturn(false);
        //When
        electricityMeter.addKwh(50);
        //Then
        Assertions.assertAll("Testing Tariff",
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        Assertions.assertTrue(electricityMeter.getKwhNoTariff() % 50 == 0);
                    }
                },
//        () -> Assertions.assertEquals(electricityMeter.getKwhTariff(), 0),
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        Assertions.assertTrue(electricityMeter.getKwhNoTariff() % 50 == 0);
                    }
                },
//        () -> Assertions.assertTrue(electricityMeter.getKwhNoTariff() % 50 == 0),
                //inny sposób zapisu, bez lambdy
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        Assertions.assertFalse(tp.isTariffNow());
                    }
                },
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        Assertions.assertTrue(!tp.isTariffNow());
                    }
                }
        );
    }

}