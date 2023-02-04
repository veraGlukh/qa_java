package ru.yandex.practicum.animals;

import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FelineTest {

    Feline feline = new Feline();
    @Mock
    Animal animal = new Animal();

    @Test
    public void doesEatMeatReturnValidValue() throws Exception {
        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = feline.eatMeat();

        assertEquals("Кошачьи кушают сомнительную еду:", animal.getFood("Хищник"), actualFood);
    }

    @Test
    public void doesGetFamilyReturnValidValue(){
        String expectedFamily = "Кошачьи";
        String actualFamily =  feline.getFamily();

        assertEquals("Ошибка в семействе кошачьих:", expectedFamily, actualFamily);
    }

    @Test
    public void doesGetKittensWithoutArgReturnValidValue(){
        int actualKittensCount = feline.getKittens();
        Mockito.when(Mockito.mock(Feline.class).getKittens(1)).thenReturn(1);

        assertEquals("Ошибка в количестве котят:", feline.getKittens(1), actualKittensCount);
    }

    @Test
    public void doesGetKittensWithArgReturnValidValue(){
        int expectedKittensCount = 2;
        int actualKittensCount =  feline.getKittens(2);

        assertEquals("Ошибка в количестве котят:", expectedKittensCount, actualKittensCount);
    }
}