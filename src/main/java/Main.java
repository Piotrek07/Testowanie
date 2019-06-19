/**
 * Klasa główna
 */
public class Main {
    /**
     * @param args Argumnety które są dostarczane z wywołania konsoli
     */
    public static void main(String[] args) {

        PetBuilder petBuilder = new PetBuilder();
        Pet Reksio = petBuilder.setName("Reksio").setAge(10).setWeight(10).setHeight(50).build();

    }
}