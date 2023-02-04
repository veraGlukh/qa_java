package ru.yandex.practicum.animals;

import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LionKittensFoodTest  {

    Feline feline = new Feline();
    Lion lion = new Lion("Самец", feline);
    @Mock
    Animal animal = new Animal();

    public LionKittensFoodTest() throws Exception {
    }

    @Test
    public void doesGetKittensReturnValidValue() throws Exception {

        int actualKittensCount = lion.getKittens();
        Mockito.when(Mockito.mock(Feline.class).getKittens(1)).thenReturn(1);

        assertEquals("Ошибка в количестве котят:", feline.getKittens(1), actualKittensCount);
    }

    @Test
    public void doesGetFoodReturnValidValue() throws Exception {
        Mockito.when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = lion.getFood();

        assertEquals("Лев ест сомнительную еду:", animal.getFood("Хищник"), actualFood);
    }
}