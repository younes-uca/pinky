package ma.zs.univ.integration.core.fonctionnaire.fonctionnaire;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class FonctionnaireIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("FonctionnaireHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
