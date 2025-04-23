import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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


    //Optional way to test
    /*
    @Test
    void titleTestSuccess(){
        assertEquals("Mr",myPass.getTitle());
        Passenger myPass2 = new Passenger("Mrs","Mary","O'Leary");
        assertEquals("Mrs",myPass2.getTitle());
        Passenger myPass3 = new Passenger("Ms","Joan","Doyle");
        assertEquals("Ms",myPass3.getTitle());
    }
    */

    //cleaner way to test
    @ParameterizedTest
    @ValueSource(strings = {"Mr","Mrs","Ms"})
    void TestTitleSuccess2(String title){

        Passenger myPass4 = new Passenger(title, "John", "O'Leary");
    }


    @Test
    void TestTitleFail(){
        //Mr Mrs or Ms only
        assertThrows(IllegalArgumentException.class ,()-> {new Passenger("Fr","Todd","Umptious");});
        assertThrows(IllegalArgumentException.class, ()-> {new Passenger("","Todd","Umptious");});
        assertDoesNotThrow(()-> {myPass = new Passenger("Mr","Todd","Umptious");});
    }

    @Test
    void TestFnameFail(){

        assertThrows(IllegalArgumentException.class , ()-> {new Passenger("Mr","T","Umptious");});
        assertThrows(IllegalArgumentException.class, ()-> {new Passenger("Mr",null,"Umptious");});
        assertDoesNotThrow(()-> {myPass = new Passenger("Mr","Todd","Umptious");});



    }
    @Test
    void TestFnameSucc(){
        assertEquals("Todd",myPass.getFname());
    }

    @Test
    void TestLnameFail(){

        Exception ex=assertThrows(IllegalArgumentException.class, ()-> {new Passenger("Mr","Todd","U");});
        assertEquals("Invalid passenger Last Name",ex.getMessage());

        assertThrows(IllegalArgumentException.class, ()-> {new Passenger("Mr","Todd",null);});

        assertDoesNotThrow(()-> {myPass = new Passenger("Mr","Todd","Umptious");});


    }

    @Test
    void TestLnameSucc(){
        assertEquals("Umptious",myPass.getLname());
    }
}
