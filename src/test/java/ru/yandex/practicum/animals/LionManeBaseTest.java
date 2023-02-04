package ru.yandex.practicum.animals;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionManeBaseTest {

    final String lionSex;
    final boolean expectedHasMane;

    public LionManeBaseTest(String lionSex, boolean expectedHasMane) {
        this.lionSex = lionSex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] lionSexTestData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeReturnValidValue() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(lionSex, feline);

        boolean actualHasMane = lion.doesHaveMane();

        assertEquals("Ошибка в наличии гривы:", expectedHasMane, actualHasMane);
    }
}
