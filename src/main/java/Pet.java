/**
 * Zwierzątko
 */
public class Pet {
    /**
     * Imię
     */
    private String name;

    /**
     * Waga
     */
    private double weight;

    /**
     * Wysokość
     */
    private double height;

    /**
     * Wiek
     */
    private int age;

    /**
     * @return Wiek zwierzątka
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age Ustawia wiek zwierzątka
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return Wysokość zwierzątka
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height Ustawai wysokość zwierzątka
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return Waga zwierzątka
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight Ustawia wagę zwierzątka
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return Imię zwierzątka
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Ustawia imię zwierzątka
     */
    public void setName(String name) {
        this.name = name;
    }
}
