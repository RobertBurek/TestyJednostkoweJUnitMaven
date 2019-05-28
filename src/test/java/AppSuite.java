import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.robwork.AppTest;
import pl.robwork.TwoAppTest;

/**
 * Created by Robert Burek
 */

//trub powiązanych testów
//np grupowanie ze względu na funkcjonalności

@RunWith(Suite.class)

@Suite.SuiteClasses({
        AppTest.class,
        TwoAppTest.class
})

public class AppSuite {
}
