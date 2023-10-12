package seminars.second.hw;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 *Задание 1.
 Проект Vehicle. Написать следующие тесты с использованием JUnit5:
 */

class VehicleTest {
    @Test
    public void testCarIsInstanceOfVehicle() {
        Car car = new Car("Dodge", "Ram", 2010);
        assertTrue(car instanceof Vehicle);
    }

    /**
     *  * - Проверить, что объект Car создается с 4-мя колесами.
     */
    @Test
    public void testCarHasFourWheels() {
        Car car = new Car("Dodge", "Ram", 2010);
        assertThat(car.getNumWheels()).isEqualTo(4);
    }
    /**
     * * - Проверить, что объект Motorcycle создается с 2-мя колесами.
     */
    @Test
    public void testMotoHasTwoWheels() {
        Motorcycle motorcycle = new Motorcycle("Harvey", "Sport", 2010);
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    /**
     * * - Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя
     * метод testDrive()).
     *
     */
    @Test
    public void testCarTestDriveSpeed() {
        Car car = new Car("Dodge", "Ram", 2010);
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    /**
     * * - Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения
     * (используя метод testDrive()).
     *             *
     */
    @Test
    public void testMotoTestDriveSpeed() {
        Motorcycle motorcycle = new Motorcycle("Harvey", "Sport", 2010);
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }
/**
 * - Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения
 * транспорта) машина останавливается (speed = 0).
 *
 */
    @Test
    public void testCarParkSpeed() {
        Car car = new Car("Dodge", "Ram", 2010);
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }
    /**
     * * - Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0).
     *
     */

    @Test
    public void testMotoParkSpeed() {
        Motorcycle motorcycle = new Motorcycle("Harvey", "Sport", 2010);
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }


}