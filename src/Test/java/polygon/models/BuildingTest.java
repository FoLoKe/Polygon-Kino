package polygon.models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingTest {

    @Test
    public void setType() {
        Building building = new Building();
        String expected = "Москва";
        String actual=building.getType();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setAddress() {
    }

    @Test
    public void setRooms() {
    }
}