package patterns_Builder;

public class PersonBuilder {

    private String name;
    private String lastName;
    private int age;
    private String city;

    public PersonBuilder() {
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (this.age < 0 || this.age > 130) throw new IllegalArgumentException("Возраст недопустимый");
        this.age = age;
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public Person build() throws IllegalArgumentException {

        if (name == null || lastName == null)
            throw new IllegalArgumentException("Не заполнены обязательные поля");

        if (age > 0) {
            Person person =  new Person(name, lastName, age);
            person.setCity(city);
            return person;
        } else {
            Person person = new Person(name, lastName);
            person.setCity(city);
            return person;
        }

    }

}
