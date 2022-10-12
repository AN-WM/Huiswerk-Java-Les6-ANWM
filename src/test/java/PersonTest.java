import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void addMother() {
        //Arrange
        Person child = new Person("Henk", "de Vries", 40, "male");
        Person mother = new Person("Johanna", "Catharina", "de Vries - Wouda", 60, "female");
        Person father = new Person("Hendrik", "de Vries", 65, "male");

        //Act
        child.addParents(mother, father);

        //Assert
        assertEquals(mother, child.getMother());
    }

    @Test
    void addFather() {
        //Arrange
        Person child = new Person("Henk", "de Vries", 40, "male");
        Person mother = new Person("Johanna", "Catharina", "de Vries - Wouda", 60, "female");
        Person father = new Person("Hendrik", "de Vries", 65, "male");

        //Act
        child.addParents(mother, father);

        //Assert
        assertEquals(father, child.getFather());
    }

    @Test
    void addOneChild() {
        //Arrange
        //Persoon en kind klaarzetten
        Person parent = new Person("Henk", "de Vries", 40, "male");
        Person child = new Person("Marie", "de Vries", 15, "female");
        //Vergelijk Array aanmaken
        List<Person> testChildren = new ArrayList<>();
        //Kinderen toevoegen aan vergelijk array
        testChildren.add(child);

        //Act
        //Test of het derde kind ook correct toegevoegd wordt
        parent.addChild(child);

        //Assert
        //Vergelijk array tegen het testresultaat aanzetten
        assertEquals(parent.getChildren(), testChildren);
    }

    @Test
    void addThreeChildren() {
        //Arrange
        //Persoon en kinderen klaarzetten (drie kinderen om zeker te weten dat ook bij meerdere kinderen, deze correct toegevoegd worden)
        Person parent = new Person("Henk", "de Vries", 40, "male");
        Person childOne = new Person("Marie", "de Vries", 15, "female");
        Person childTwo = new Person("Joep", "de Vries", 12, "male");
        Person childThree = new Person("Lisa", "de Vries", 8, "female");
        //Vergelijk Array aanmaken
        List<Person> testChildren = new ArrayList<>();
        //Kinderen toevoegen aan vergelijk array
        testChildren.add(childOne);
        testChildren.add(childTwo);
        testChildren.add(childThree);
        //Alvast twee kinderen aan de parent toevoegen
        parent.addChild(childOne);
        parent.addChild(childTwo);

        //Act
        //Test of het derde kind ook correct toegevoegd wordt
        parent.addChild(childThree);

        //Assert
        //Vergelijk array tegen het testresultaat aanzetten
        assertEquals(parent.getChildren(), testChildren);
    }

    @Test
    void addOnePet() {
        //Arrange
        Person owner = new Person("Henk", "de Vries", 40, "male");
        Pet pet = new Pet("Fikkie", 6, "Jack Russell");
        List<Pet> testPets = new ArrayList<>();
        testPets.add(pet);

        //Act
        owner.addPet(pet);

        //Assert
        assertEquals(testPets, owner.getPets());
    }

    @Test
    void addThreePets() {
        //Arrange
        Person owner = new Person("Henk", "de Vries", 40, "male");
        Pet petOne = new Pet("Fikkie", 6, "Jack Russell");
        Pet petTwo = new Pet("Minoes", 12, "Europese korthaar");
        Pet petThree = new Pet("Felix", 8, "Europese korthaar");
        List<Pet> testPets = new ArrayList<>();
        testPets.add(petOne);
        testPets.add(petTwo);
        testPets.add(petThree);
        owner.addPet(petOne);
        owner.addPet(petTwo);

        //Act
        owner.addPet(petThree);

        //Assert
        assertEquals(testPets, owner.getPets());
    }

    @Test
    void addOneSibling() {
        //Arrange
        Person person = new Person("Marie", "de Vries", 15, "female");
        Person siblingOne = new Person("Joep", "de Vries", 12, "male");
        List<Person> testSiblings = new ArrayList<>();
        testSiblings.add(siblingOne);

        //Act
        person.addSibling(siblingOne);

        //Assert
        assertEquals(testSiblings, person.getSiblings());
    }

    @Test
    void addThreeSiblings() {
        //Arrange
        Person person = new Person("Marie", "de Vries", 15, "female");
        Person siblingOne = new Person("Joep", "de Vries", 12, "male");
        Person siblingTwo = new Person("Lisa", "de Vries", 8, "female");
        Person siblingThree = new Person("Fien", "de Vries", 6, "female");
        List<Person> testSiblings = new ArrayList<>();
        testSiblings.add(siblingOne);
        testSiblings.add(siblingTwo);
        testSiblings.add(siblingThree);
        person.addSibling(siblingOne);
        person.addSibling(siblingTwo);

        //Act
        person.addSibling(siblingThree);

        //Assert
        assertEquals(testSiblings, person.getSiblings());
    }

    @Test
    void getGrandChildren() {
        //Arrange
        List<Person> resultGrandChildren;
        Person grandParent = new Person("Johanna", "Catharina", "de Vries - Wouda", 60, "female");
        Person parentOne = new Person("Henk", "de Vries", 40, "male");
        Person parentTwo = new Person("Joke", "Feenstra - de Vries", 38, "female");
        Person childOne = new Person("Marie", "de Vries", 15, "female");
        Person childTwo = new Person("Joep", "de Vries", 12, "male");
        Person childThree = new Person("Lisa", "Feenstra", 8, "female");

        grandParent.addChild(parentOne);
        grandParent.addChild(parentTwo);
        parentOne.addChild(childOne);
        parentOne.addChild(childTwo);
        parentTwo.addChild(childThree);

        List<Person> testGrandChildren = new ArrayList<>();
        testGrandChildren.add(childOne);
        testGrandChildren.add(childTwo);
        testGrandChildren.add(childThree);

        //Act
        resultGrandChildren = grandParent.getGrandChildren();

        //Assert
        assertEquals(testGrandChildren, resultGrandChildren);
    }

    //Getter tests voor 100% coverage
    @Test
    void getName() {
        Person person = new Person("Henk", "de Vries", 40, "male");
        String testResult = person.getName();
        assertEquals("Henk", testResult);
    }

    @Test
    void getMiddleName() {
        Person person = new Person("Henk", "Jan", "de Vries", 40, "male");
        String testResult = person.getMiddleName();
        assertEquals("Jan", testResult);
    }

    @Test
    void getLastName() {
        Person person = new Person("Henk", "de Vries", 40, "male");
        String testResult = person.getLastName();
        assertEquals("de Vries", testResult);
    }

    @Test
    void getSex() {
        Person person = new Person("Henk", "de Vries", 40, "male");
        String testResult = person.getSex();
        assertEquals("male", testResult);
    }

    @Test
    void getAge() {
        Person person = new Person("Henk", "de Vries", 40, "male");
        int testResult = person.getAge();
        assertEquals(40, testResult);
    }

    //Setter tests voor 100% coverage
    @Test
    void setName() {
        Person person = new Person("Henk", "de Vries", 40, "male");
        person.setName("Pieter");
        assertEquals("Pieter", person.getName());
    }

    @Test
    void setMiddleName() {
        Person person = new Person("Henk", "de Vries", 40, "male");
        person.setMiddleName("Jan");
        assertEquals("Jan", person.getMiddleName());
    }

    @Test
    void setLastName() {
        Person person = new Person("Henk", "de Vries", 40, "male");
        person.setLastName("de Boer");
        assertEquals("de Boer", person.getLastName());
    }

    @Test
    void setSex() {
        Person person = new Person("Henk", "de Vries", 40, "male");
        person.setSex("female");
        assertEquals("female", person.getSex());
    }

    @Test
    void setAge() {
        Person person = new Person("Henk", "de Vries", 40, "male");
        person.setAge(45);
        assertEquals(45, person.getAge());
    }
}