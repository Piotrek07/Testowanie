import org.junit.*;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PetTest {

    private static Pet pet;

    // zbudowanie atrapy dla obu testow *BeforeClass* setName_mockedPet_callVerification(), setAge_mockedPet_callVerification()
    @BeforeClass
    public static void setup(){
        pet = mock(Pet.class);
        System.out.println("Before Class");
    }

    @Before
    public void setUpTest(){
        System.out.println("Before");
    }

    @After
    public void cleanUpTest(){
        System.out.println("After clean up");
    }

    @AfterClass
    public static void cleanup(){
        pet = null;
        System.out.println("After Class clean up");
    }



    // Testowanie za pomoca atrapy metody getName
    @Test
    public void getName_mockedPet_callVerification(){
        Pet mockedPet = mock(Pet.class);
        mockedPet.getName();
        verify(mockedPet).getName();
    }

    // Testowanie za pomoca atrapy metody getAge
    @Test
    public void getAge_mockedPet_callVerification(){
        pet.getAge();
        verify(pet).getAge();
    }

    // Testowanie za pomoca atrapy metody getAge z parametrem
    @Test
    public void setName_mockedPet_callVerification(){
        pet.setName("Reksio");
        verify(pet).setName("Reksio");
    }


    @Test
    public void getName_mockedPetWhichReturnsFafikNane_Fafik(){
        String expected = "Fafik";
        when(pet.getName()).thenReturn("Fafik");

        String actual = pet.getName();

        assertThat(expected).isEqualTo(actual);
    }

}