import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
    void setName() {
        Pet pet = new Pet("Fikkie", 8, "Rottweiler");
        pet.setName("Bello");
        assertEquals("Bello", pet.getName());
    }

    @Test
    void setAge() {
        Pet pet = new Pet("Fikkie", 8, "Rottweiler");
        pet.setAge(9);
        assertEquals(9, pet.getAge());
    }

    @Test
    void setSpecies() {
        Pet pet = new Pet("Fikkie", 8, "Rottweiler");
        pet.setSpecies("Labrador");
        assertEquals("Labrador", pet.getSpecies());
    }

    @Test
    void addOwner() {
        Pet pet = new Pet("Fikkie", 8, "Rottweiler");
        Person owner = new Person("Henk", "de Vries", 40, "male");
        pet.addOwner(owner);
        assertEquals(owner, pet.getOwner());
    }
}