public class PetBuilder {
    /**
     * Instancja do zapamiętywania zmian związanych z tworzeniem produktu
     */
    private Pet result;

    /**
     * Konstruktor
     */
    public PetBuilder(){
        result = new Pet();
    }

    /**
     * Metoda do ustawiania imienia
     * @param name imię
     * @return referencja w stylu fluent api
     */
    public PetBuilder setName(String name){
        result.setName(name);
        return this;
    }

    /**
     * Metoda do ustawiania wagi
     * @param weight waga
     * @return referencja w stylu fluent api
     */
    public PetBuilder setWeight(double weight){
        result.setWeight(weight);
        return this;
    }

    /**
     * Metoda do ustawiania wysokości
     * @param height wysokość
     * @return referencja w stylu fluent api
     */
    public PetBuilder setHeight(double height){
        result.setHeight(height);
        return this;
    }

    /**
     * Metoda do ustawiania warości wieku
     * @param age wiek
     * @return referencja w stylu fluent api
     */
    public PetBuilder setAge(int age){
        result.setAge(age);
        return this;
    }

    /**
     * Metoda do budowania produktu
     * @return produkt zwierzątko
     */
    public Pet build(){
        return result;
    }
}
