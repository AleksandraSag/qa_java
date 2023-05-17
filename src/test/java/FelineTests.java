import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class FelineTests {
    Animal animal = new Animal();
    private final List<String> expectedFoodFeline = List.of("Животные", "Птицы", "Рыба");
    private final String expectedExceptionAboutFood = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    @Test
    public void eatMeatFelineTest() throws Exception {
        Feline feline = new Feline();
        assertEquals(expectedFoodFeline, feline.eatMeat());
    }
    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void getFoodInvalidAnimalKind() throws Exception {
        try {
            animal.getFood("Насекомое");
            Assert.fail("Expected Exception");
        } catch (Exception exception) {
            System.out.println(exception);
            assertEquals(expectedExceptionAboutFood, exception.getMessage());
        }
    }
}
