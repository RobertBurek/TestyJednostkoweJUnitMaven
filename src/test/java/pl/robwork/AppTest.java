package pl.robwork;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Robert Burek
 */

@Ignore("Pakietowo zignorowany zestaw testów!!!")
public class AppTest {

    @Test
    public void addKwh_newMeter_properAddition1() {
        App electrisityMeter = new App();
        electrisityMeter.addKwh(1);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 1);
    }

    @Test
    public void addKwh_newMeter2_properAddition2() {
        App electrisityMeter = new App();
        electrisityMeter.addKwh(1);
        electrisityMeter.addKwh(4);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 5);
    }

    @Test
    public void addKwh_newMeter5_properAddition3() {
        App electrisityMeter = new App();
        electrisityMeter.addKwh(1);
        electrisityMeter.addKwh(4);
        electrisityMeter.addKwh(4);
        electrisityMeter.addKwh(3);
        electrisityMeter.addKwh(2);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 14);
    }

    @Test
    public void addKwh_newMeter12_properAddition4() {
        App electrisityMeter = new App();
        for (int i = 1; i <= 12; i++)
            electrisityMeter.addKwh(i);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 78);
    }

    @Test
    public void kwhCounterIncreaseIfNew5() {
        App electrisityMeter = new App();
        electrisityMeter.addKwh(5);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 5);
    }

    @Test
    public void kwhCounterIncreaseIfSecond6() {
        App electrisityMeter = new App();
        electrisityMeter.addKwh(5);
        electrisityMeter.addKwh(4);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 9);
    }

    @Test
    public void givenNewMeterWhenFirstAdditionThenProperCounter7() {
        App electrisityMeter = new App();
        electrisityMeter.addKwh(5);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 5);
    }

    @Ignore("Chwilowo nas to nie interesuje") //todo assure is proper
    @Test
    public void givenNewMeterWhenFirstAdditionThenProperCounterTwoAssert8() {
        App electrisityMeter = new App();
        electrisityMeter.addKwh(5);
        Assert.assertFalse("Dodano 5 kwh a czekiwano 7 kwh", electrisityMeter.getKwhNoTariff() == 7);
        // gdy pierwsza nie przejdzie nie mamy informacji o drugiej
        Assert.assertTrue("Dodano 5 kwh i oczekiwano 5 kwh", electrisityMeter.getKwhNoTariff() == 5);
    }

    @Test(expected = ArithmeticException.class)
    public void getHowMoreExpensiveNormalIs9() {
        App electrisityMeter = new App();
        electrisityMeter.setCentsForKwh(90);
        electrisityMeter.getHowMoreExpensiveNormalIs();
    }
}
