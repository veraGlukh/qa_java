package ru.yandex.practicum.animals;

import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Feline feline = new Feline();
    Cat cat = new Cat(feline);
    @Mock
    Animal animal = new Animal();

    @Test
    public void doesGetSoundReturnValidValue(){
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();

        assertEquals("Кошка издает сомнительные звуки:", expectedSound, actualSound);
    }

    @Test
    public void doesGetFoodReturnValidValue() throws Exception {
        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = cat.getFood();

        assertEquals("Кошка ест сомнительную еду:", animal.getFood("Хищник"), actualFood);
    }
}