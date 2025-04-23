import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    Passenger myPass;

    @BeforeEach
   void setup(){

        myPass = new Passenger("Mr","Todd","Umptious");
    }
    @Test
    void ConstructorSuccess(){

        assertEquals("Mr",myPass.getTitle());
        assertEquals("Todd", myPass.getFname());
        assertEquals("Umptious", myPass.getLname());

    }


}
