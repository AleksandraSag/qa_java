import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatClassTests {
    @Mock
    Feline feline;
    private final String expectedSoundCat = "Мяу";
    private final List<String> expectedFoodCat = List.of("Животные", "Птицы", "Рыба");

    @Test
    public void getSoundCatTest() {
        Cat cat = new Cat(feline);
        assertEquals(expectedSoundCat, cat.getSound());
    }

    @Test
    public void getFoodCatTest() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(expectedFoodCat);
        assertEquals(expectedFoodCat, cat.getFood());
    }
}
