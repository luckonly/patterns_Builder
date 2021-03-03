package patterns_Builder;

public class Person {

    private static String name;
    private static String lastName;
    private int age;
    private String city;
    private boolean hasAge = false; // По умолчанию записываем в переменную false, а при вызове setAge меняем на true

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.hasAge = true;
    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public boolean hasAge() {
        return this.hasAge;
    }

    public void happyBirthday() {
        this.age++;
        this.hasAge = true;
    }

    public boolean hasCity() {
        return this.getCity().isEmpty();
    }

    public void setAge(int age) {
        if (this.hasAge == false) {
            this.age = age;
            this.hasAge = true;
        } else {
            System.out.println("Возраст можно изменить только через метод happyBirthday");
        }
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PersonBuilder newChildBuilder() {

        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setAge(0);
        personBuilder.setLastName(this.getLastName());
        personBuilder.setCity(this.getCity());

        return personBuilder;

    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getLastName() + ", возраст: " + this.getAge() + (this.hasCity() ? ", город: " + this.getCity() : "");
    }
}
