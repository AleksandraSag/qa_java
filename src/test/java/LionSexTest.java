import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionSexTest {
    private final String sex;
    private final boolean hasMane;

    public LionSexTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Parameterized.Parameters(name = "{index}: sex={0}, hasMane={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самей", true},
                {"самка", false},
                {"Гермафродит", false},
                {"", false},
                {"777", false}
        });
    }
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testDoesHaveManeException() throws Exception {
        Lion lion = new Lion(sex);
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самей или самка");
    }
}
