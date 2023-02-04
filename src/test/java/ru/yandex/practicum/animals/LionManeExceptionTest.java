package ru.yandex.practicum.animals;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LionManeExceptionTest {

    @Test
    public void isHaveManeExceptionTextCorrect() throws Exception {
        String expectedException = "Используйте допустимые значения пола животного - самей или самка";

        Exception actualException = Assert.assertThrows("Проверка текста исключения", Exception.class, () -> new Lion("Котик", new Feline()).notify());
        assertEquals("Некорректный текст исключения:", expectedException, actualException.getMessage());
    }
}
