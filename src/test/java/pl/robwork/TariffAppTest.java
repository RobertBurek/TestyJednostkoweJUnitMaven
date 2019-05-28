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

    @Before
    public void setUp(){
        electricityMeter=new App();
        electricityMeter=Mockito.spy(electricityMeter);
        electricityMeter.setTariffOn(true);
        electricityMeter.setElectricityTariffEndHour(12);
        electricityMeter.setElectricityTariffStartHour(14);
    }

    @Test
    public void GivenOnTariffWhenKwhAdditionThenCounterTariffIsIncreased(){
        //Given
        //TODO setTariff Time mock isTariffNow() !
        Mockito.when(electricityMeter.isTariffNow()).thenReturn(true);
        //When
        electricityMeter.addKwh(100);
        //Then
        //Assert.assertEquals(100, (int)electricityMeter.getKwhTariff());
        Assert.assertEquals(100, electricityMeter.getKwhTariff(),0.01);
    }

    @Test
    public void GivenNotOnTariffWhenKwhAdditionThenCounterTariffIsIncreased(){
        //Given
        //TODO setTariff Time mock isTariffNow() NOT TARIFF!
        Mockito.when(electricityMeter.isTariffNow()).thenReturn(false);
        //When
        electricityMeter.addKwh(50);
        //Then
        Assert.assertEquals(50, (int)electricityMeter.getKwhNoTariff());
//        Assert.assertEquals(50, electricityMeter.getKwhNoTariff(),0.01);
    }
}
