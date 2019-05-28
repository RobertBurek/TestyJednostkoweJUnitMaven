import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.robwork.ExistAppTest;
import pl.robwork.NewAppTest;
import pl.robwork.TwoAppTest;

/**
 * Created by Robert Burek
 */

//trub powiązanych testów
//np grupowanie ze względu na funkcjonalności

@RunWith(Suite.class)

@Suite.SuiteClasses({
        NewAppTest.class,
        ExistAppTest.class,
//        AppTest.class,     gdy mamy @BeforeClass i init() robimy testy na tej samej intencji (bazie danych)
        TwoAppTest.class
})

public class AppSuite {
}
