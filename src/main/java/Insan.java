public class Insan {
    private String name;
    private String surname;
    private short age;
    private Insan father;
    private Insan mother;

    public Insan() {
    }

    public Insan(String name, String surname, short age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Insan(String name, String surname, short age, Insan father, Insan mother) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.father = father;
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Insan getFather() {
        return father;
    }

    public void setFather(Insan father) {
        this.father = father;
    }

    public Insan getMother() {
        return mother;
    }

    public void setMother(Insan mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return
                name + ' ' + surname + ' ' + age;
    }
}
