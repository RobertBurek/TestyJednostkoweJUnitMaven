package pl.robwork;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by Robert Burek
 */
public class TariffAppTest {

    App electricityMeter;
    App electricityMeterNew;
    TariffProvider tp;

    @Before
    public void setUp() {
        tp = Mockito.mock(TariffProvider.class);
        electricityMeterNew = new App(tp);
        electricityMeter = new App();
        electricityMeter = Mockito.spy(electricityMeter);
        electricityMeter.setTariffOn(true);
        electricityMeter.setElectricityTariffEndHour(12);
        electricityMeter.setElectricityTariffStartHour(14);
    }

    @Test
    public void GivenOnTariffWhenKwhAdditionThenCounterTariffIsIncreased() {
        //Given
        //TODO setTariff Time mock isTariffNow() !
        Mockito.when(electricityMeter.isTariffNow()).thenReturn(true);
        //When
        electricityMeter.addKwh(100);
        //Then
        //Assert.assertEquals(100, (int)electricityMeter.getKwhTariff());
        Assert.assertEquals(100, electricityMeter.getKwhTariff(), 0.01);
    }

    @Test
    public void GivenNotOnTariffWhenKwhAdditionThenCounterTariffIsIncreased() {
        //Given
        //TODO setTariff Time mock isTariffNow() NOT TARIFF!
        Mockito.when(electricityMeter.isTariffNow()).thenReturn(false);
        //When
        electricityMeter.addKwh(50);
        //Then
        Assert.assertEquals(50, (int) electricityMeter.getKwhNoTariff());
//        Assert.assertEquals(50, electricityMeter.getKwhNoTariff(),0.01);
    }

    @Test
    public void GivenOnTariffWhenKwhAdditionThenCounterTariffIsIncreasedNew() {
        //Given
        //TODO setTariff Time mock isTariffNow() !
        Mockito.when(tp.isTariffNow()).thenReturn(true);
        //When
        electricityMeterNew.addKwh(120);
        //Then
        //Assert.assertEquals(120, (int)electricityMeter.getKwhTariff());
        Assert.assertEquals(120, electricityMeterNew.getKwhTariff(), 0.01);
    }

    @Test
    public void GivenNotOnTariffWhenKwhAdditionThenCounterTariffIsIncreasedNew() {
        //Given
        //TODO setTariff Time mock isTariffNow() NOT TARIFF!
        Mockito.when(tp.isTariffNow()).thenReturn(false);
        //When
        electricityMeterNew.addKwh(70);
        //Then
        Assert.assertEquals(70, (int) electricityMeterNew.getKwhNoTariff());
//        Assert.assertEquals(50, electricityMeter.getKwhNoTariff(),0.01);
    }
}
