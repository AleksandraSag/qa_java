import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    private final int expectedKittenCount = 1;
    @Mock
    Feline feline;
    private final List<String> expectedFoodLion = List.of("Животные", "Птицы", "Рыба");

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        when(feline.getKittens()).thenReturn(1);
        assertEquals(expectedKittenCount, lion.getKittens());
    }

    @Test
    public void getFoodLionTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFoodLion);
        assertEquals(expectedFoodLion, lion.getFood());
    }
}
