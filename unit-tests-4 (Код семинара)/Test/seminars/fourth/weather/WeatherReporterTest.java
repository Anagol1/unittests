package seminars.fourth.weather;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
//**
// 4.3. Предположим, у вас есть класс WeatherService, который имеет метод getCurrentTemperature(),
// обращающийся к внешнему API для получения информации о текущей температуре.
// Вам нужно протестировать другой класс, WeatherReporter, который использует WeatherService.
// Создайте мок-объект для WeatherService с использованием Mockito.
// *

class WeatherReporterTest {
    @Test
    void WeatherReporterTest (){
        //Act
        WeatherService weatherServiceMock = mock(WeatherService.class);
        WeatherReporter reporter = new WeatherReporter(weatherServiceMock);
        when(weatherServiceMock.getCurrentTemperature()).thenReturn(15);
        String res = reporter.generateReport();

        //Assert
        assertEquals("Текущая температура: 15 градусов.",res);
        verify(weatherServiceMock,times(1)).getCurrentTemperature();
    }

}