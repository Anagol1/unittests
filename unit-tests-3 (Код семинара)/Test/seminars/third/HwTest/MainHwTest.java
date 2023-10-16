package seminars.third.HwTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.hw.MainHW;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
public class MainHwTest {
    MainHW mainHW;
    @BeforeEach
    void setUp(){
        mainHW = new MainHW();
    }
    @Test
    void evenOddNumTrueTest(){
        assertTrue(mainHW.evenOddNum(4));
    }
    @Test
    void evenOddNumFalseTest(){
        assertFalse(mainHW.evenOddNum(5));
    }
    @Test
    void num25To100FalseTest(){
        assertFalse(mainHW.numIn25To100Interval(5));
    }

    @Test
    void num25To100TrueTest(){
        assertTrue(mainHW.numIn25To100Interval(30));
    }

}
