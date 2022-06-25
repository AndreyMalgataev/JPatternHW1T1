package classes;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;
    protected Person parentPerson;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age > 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException("Возраст недопустимый");
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder setParentPerson(Person parentPerson) {
        this.parentPerson = parentPerson;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (name != null && surname != null && age >= 0) {
            Person person = new Person(name, surname, age);
            if (address != null) person.setAddress(address);
            return person;
        } else {
            throw new IllegalStateException("Не хватает обязательных полей");
        }

    }
}
