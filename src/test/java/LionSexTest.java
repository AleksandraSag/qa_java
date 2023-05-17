import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionSexTest {
    Feline feline;
    private final String sex;
    private final boolean hasMane;
    public LionSexTest(String sex, boolean expectedResultMane) {
        this.sex = sex;
        this.hasMane = expectedResultMane;
    }

    @Parameters(name = "{index}: Тестовые данные: пол {0}, наличие гривы {1}")
    public static Object[][] checkHaveMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},

        };
    }

    @Test
    public void doesManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(hasMane, lion.doesHaveMane());
    }
}
