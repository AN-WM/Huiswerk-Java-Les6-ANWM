import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String middleName;
    private String lastName;
    private String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings;
    private List<Person> children;
    private List<Pet> pets;

    public Person(String name, String lastName, int age, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, String middleName, String lastName, int age, String sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addParents(Person mother, Person father) {
        //Add parents to this person
        this.setMother(mother);
        this.setFather(father);

        //Add this person as child to mother
        mother.addChild(this);

        //Add this person as child to father
        father.addChild(this);
    }

    public void addChild(Person child) {
        List<Person> newChildList = new ArrayList();
        if (this.getChildren() != null){
            newChildList = this.getChildren();
            newChildList.add(child);
        } else {
            newChildList.add(child);
        }

        this.setChildren(newChildList);
    }

    public void addPet(Pet pet) {
        List<Pet> newPetList = new ArrayList<>();
        if (this.getPets() != null){
            newPetList = this.getPets();
            newPetList.add(pet);
        } else {
            newPetList.add(pet);
        }

        this.setPets(newPetList);
    }

    public void addSibling(Person sibling) {
        List<Person> newSiblingList = new ArrayList<>();
        if (this.getSiblings() != null) {
            newSiblingList = this.getSiblings();
            newSiblingList.add(sibling);
        } else {
            newSiblingList.add(sibling);
        }

        this.setSiblings(newSiblingList);
    }

    public List<Person> getGrandChildren () {
        List<Person> grandChildren = new ArrayList<>();

        if (this.children.size() != 0) {
            for (Person child: this.children) {
                if (child.children.size() != 0) {
                    for (Person grandChild : child.children) {
                        grandChildren.add(grandChild);
                    }
                }
            }
        }

        return grandChildren;
    }
}
