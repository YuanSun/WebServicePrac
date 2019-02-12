import com.ryan.ws.SumWSImpl;

import net.sf.ehcache.search.aggregator.Sum;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMonthConversion {
    @Test
    public void testMonthConversionWithJoda() {
        String monthStr = "FEB";

        Month month = SumWSImpl.convertMonthWithJoda(monthStr);

        Assert.isTrue(month.equals(Month.FEBRUARY), "Month convert successfully");

        String badMonth = "FBI";
        assertThrows(IllegalArgumentException.class, () -> SumWSImpl.convertMonthWithJoda(badMonth));
    }

    @Test
    public void testMonthConvertionWithJavaTime() {
        String monthStr = "FEBRUARY";
        Month month = SumWSImpl.convertMonthWithJavaTime(monthStr);
        Assert.isTrue(month.equals(Month.FEBRUARY), "Month convert successfully");

        String badMonth = "FBI";
        assertThrows(IllegalArgumentException.class, () -> SumWSImpl.convertMonthWithJavaTime(badMonth));
    }

}
