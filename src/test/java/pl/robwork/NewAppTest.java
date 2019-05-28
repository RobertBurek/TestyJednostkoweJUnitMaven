package pl.robwork;

import org.junit.*;

/**
 * Created by Robert Burek
 */

//@Ignore("Pakietowo zignorowany zestaw testów!!!")
public class NewAppTest {

    public static App electrisityMeter;

    @BeforeClass
    public static void init() {   //metoda wykonywana przed całą klasą AppTest, może mieć dowolną nazwę
        //złożone obliczenia, ładowanie bazy, coś co ma być wykonane raz na początku zestawu testów
        NewAppTest.electrisityMeter = new App();
        //AppTest robimy gdy chcemy wykonać tez zestaw testów na tej samej intencji klasy
    }

    @Before
    public void setUp() {    //metoda wykonywana przed każdym testem klasy AppTest, może mieć dowolną nazwę
        //determinuje inicjowane pola i klasy, wykonywane przed każdym testem w zestawie
        electrisityMeter.reset();
    }

    @AfterClass
    public static void release(){
        //czyścimy wszystko co było w @BeforeClass, wykonuje się po wykonaniu klasy
        //zwalniamy zasoby
    }

    @After
    public void tearDown(){
        //wykonuje się po każdej metodzie, tescie
    }

    @Test
    public void addKwh_newMeter_properAddition1() {
        electrisityMeter.addKwh(1);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 1);
    }

    @Test
    public void addKwh_newMeter2_properAddition2() {
        electrisityMeter.addKwh(1);
        electrisityMeter.addKwh(4);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 5);
    }

    @Test
    public void addKwh_newMeter5_properAddition3() {
        electrisityMeter.addKwh(1);
        electrisityMeter.addKwh(4);
        electrisityMeter.addKwh(4);
        electrisityMeter.addKwh(3);
        electrisityMeter.addKwh(2);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 14);
    }

    @Test
    public void addKwh_newMeter12_properAddition4() {
        for (int i = 1; i <= 12; i++)
            electrisityMeter.addKwh(i);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 78);
    }

    @Test
    public void kwhCounterIncreaseIfNew5() {
        electrisityMeter.addKwh(5);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 5);
    }

    @Test
    public void kwhCounterIncreaseIfSecond6() {
        electrisityMeter.addKwh(5);
        electrisityMeter.addKwh(4);
        Assert.assertTrue("Dodano 9kwh a oczekiwano 19kwh - celowy błąd.", electrisityMeter.getKwhNoTariff() == 19);
    }

    //Given When Then - GWT   lub  Arrange-przygotuj, Act-zachowaj się, Assert-sprawdź,
    @Test
    public void givenNewMeterWhenFirstAdditionThenProperCounter7() {
        //Geven - sekcja założeń początkowych
        //App electrisityMeter = new App();
        //When - wykonujemy te akcje które są potrzebne aby nastał stan dla nas potrzebny
        electrisityMeter.addKwh(5);
        //Then - sprawdzany zgodność z oczekiwaniami
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 5);
    }

    @Ignore("Chwilowo nas to nie interesuje") //todo assure is proper
    @Test
    public void givenNewMeterWhenFirstAdditionThenProperCounterTwoAssert8() {
        electrisityMeter.addKwh(5);
        Assert.assertFalse("Dodano 5 kwh a czekiwano 7 kwh", electrisityMeter.getKwhNoTariff() == 7);
        // gdy pierwsza nie przejdzie nie mamy informacji o drugiej
        Assert.assertTrue("Dodano 5 kwh i oczekiwano 5 kwh", electrisityMeter.getKwhNoTariff() == 5);
    }

    @Test(expected = ArithmeticException.class)
    public void getHowMoreExpensiveNormalIs9() {
        electrisityMeter.setCentsForKwh(90);
        electrisityMeter.getHowMoreExpensiveNormalIs();
    }
}
