package seminars.fourth.hotel;
//         Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
//        Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId),
//        который обычно проверяет, доступен ли номер в отеле.
//        Вам необходимо проверить правильность работы класса BookingService, который
//        использует HotelService для бронирования номера, если он доступен.

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingServiceTest {
    @Test
    void BookingServiceTest(){
        HotelService hotelServiceMock = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelServiceMock);
        when(hotelServiceMock.isRoomAvailable(2)).thenReturn(true);
        when(hotelServiceMock.isRoomAvailable(3)).thenReturn(false);

    assertTrue(bookingService.bookRoom(2));

    verify(hotelServiceMock, times(1)).isRoomAvailable(2);
    }


}