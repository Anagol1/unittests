package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Array;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    SomeService service;
    @BeforeEach
    void setUp() {
        service = new SomeService();

    }
   // 3.1.

    /**
     * 3.1. Метод возвращает Fizz для чисел кратных 3, Buzz для кратных 5, и FizzBuzz для кратных 3 и 5 одновременно
     */
    @Test
    void multipleThreeNotFiveReturnsFizz() {
//        SomeService service = new SomeService();
        assertEquals(service.fizzBuzz(12), "Fizz");
        // assertEquals...
    }

    @Test
    void multipleFiveNotThreeReturnsBuzz() {
//        SomeService service = new SomeService();
        assertEquals(service.fizzBuzz(10), "Buzz");
        // assertEquals...
    }
    @Test
    void multipleFiveAndThreeReturnsFizzBuzz() {
//        SomeService service = new SomeService();
        assertEquals(service.fizzBuzz(15), "FizzBuzz");
        // assertEquals...
    }
    @Test
    void multipleNotFiveNotThreeReturnsString() {
//        SomeService service = new SomeService();
        assertEquals(service.fizzBuzz(14), "14");
        // assertEquals...
    }

    /**
     * 3.2.
     */
    @Test
    void first6Test() {
//        SomeService service = new SomeService();
        int[] nums= {6,4,8,2,3,1};
        assertTrue(service.firstLast6(nums));
    }
    @Test
    void last6Test() {
//        SomeService service = new SomeService();
        int[] nums= {1,4,8,2,3,6};
        assertTrue(service.firstLast6(nums));
    }
    @Test
    void lastFirstNo6Test() {
//        SomeService service = new SomeService();
        int[] nums= {1,4,8,2,3};
        assertFalse(service.firstLast6(nums));
    }

    /**
     * 3.3.
     */
    /**
     * @apiNote процент скидки меньше 0% или больше 100
     * @param discount
     */
    @ParameterizedTest
    @ValueSource(ints = {101,-1})
    void insufficientDiscountAmountTest(int discount) {
        assertThatThrownBy(() ->
                service.calculatingDiscount(2000.0, discount))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    /**
     * @apiNote обычная скидка
     * @param discount
     * @param result
     */
    @ParameterizedTest
    @CsvSource({"50, 1000", "100, 0", "0, 2000"})

    void correctDiscountCalculatingTest(int discount, int result) {
        assertThat(service.calculatingDiscount(2000.0, discount))
                .isEqualTo(result); // обычная скидка
    }

    /**
     * 3.4 Разработайте метод luckySum и напишите для него тесты.
     */
    @Test
    void luckySumA13Test() {
        assertEquals(service.luckySum(13,2,3), 5);
    }

    @Test
    void luckySumB13Test() {
        assertEquals(service.luckySum(5,13,3), 8);
    }

    @Test
    void luckySumC13Test() {
        assertEquals(service.luckySum(5,4,13), 9);
    }
    @Test
    void luckySumWithout13Test() {
        assertEquals(service.luckySum(5,4,3), 12);
    }
}