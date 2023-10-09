

package seminars.first.model;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    public static double squareRootExtraction(double number) {
        if (number == 0) {
            throw new ArithmeticException("It is not possible to extract the root from 0");
        }
        if (number < 0) {
            throw new ArithmeticException("It is impossible to extract the root from negative numbers");
        }

        double t;
        double squareRoot = number / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        }
        while ((t - squareRoot) != 0);
        return squareRoot;

        // или просто return Math.sqrt(number);
    }
/**
 * Задание 1. ** В классе Calculator создайте метод calculateDiscount, который принимает сумму
 *  покупки и процент скидки и возвращает сумму с учетом скидки. Ваша задача - проверить этот
 *  метод с использованием библиотеки AssertJ. Если метод calculateDiscount получает недопустимые
 *  аргументы, он должен выбрасывать исключение ArithmeticException. Не забудьте написать тесты для
 *  проверки этого поведения.
 */
    /**
     * @param purchaseAmount сумма покупки
     * @param discountAmount размер скидки
     * @return возвращает сумму покупки с учетом скидки
     */
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        if (purchaseAmount > 0 && discountAmount > 0)
            return purchaseAmount - (purchaseAmount * ((double)discountAmount/100));
        else
            throw new ArithmeticException("Покупка или скидка отсутствуют");
    }
}