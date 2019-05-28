package pl.robwork;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Robert Burek
 */

//@Ignore("Pakietowo zignorowany zestaw testów!!!")
public class TwoAppTest {

    @Test
    public void addKwh_newMeter_properAddition1() {
        App electrisityMeter = new App();
        App twoElectrisityMeter = new App();
        electrisityMeter.addKwh(1);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 1);
    }

    @Test
    public void addKwh_newMeter2_properAddition2() {
        App electrisityMeter = new App();
        App twoElectrisityMeter = new App();
        electrisityMeter.addKwh(1);
        electrisityMeter.addKwh(4);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 5);
    }

    @Test
    public void addKwh_newMeter5_properAddition3() {
        App electrisityMeter = new App();
        App twoElectrisityMeter = new App();
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
        App twoElectrisityMeter = new App();
        for (int i = 1; i <= 12; i++)
            electrisityMeter.addKwh(i);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 78);
    }

    @Test
    public void kwhCounterIncreaseIfNew5() {
        App electrisityMeter = new App();
        App twoElectrisityMeter = new App();
        electrisityMeter.addKwh(5);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 5);
    }

    @Test
    public void kwhCounterIncreaseIfSecond6() {
        App electrisityMeter = new App();
        App twoElectrisityMeter = new App();
        electrisityMeter.addKwh(5);
        electrisityMeter.addKwh(4);
        Assert.assertTrue(electrisityMeter.getKwhNoTariff() == 9);
    }

    @Test(expected = ArithmeticException.class)
    public void getHowMoreExpensiveNormalIs9() {
        App electrisityMeter = new App();
        App twoElectrisityMeter = new App();
        electrisityMeter.setCentsForKwh(90);
        electrisityMeter.getHowMoreExpensiveNormalIs();
    }
}
