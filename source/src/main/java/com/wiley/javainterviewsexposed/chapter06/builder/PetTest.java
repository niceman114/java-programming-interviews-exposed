package com.wiley.javainterviewsexposed.chapter06.builder;

import org.junit.Test;

public class PetTest {

    @Test
    public void legalBuild() {
        final Pet.Builder builder = new Pet.Builder();
        final Pet pet = builder
                .withAnimal(Animal.CAT)
                .withPetName("Squidge")
                .withOwnerName("Simon Smith")
                .withAddress("123 High Street")
                .withTelephone("07777777770")
                .withEmailAddress("simon@email.com")
                .build();
        // test pass - no exception thrown
    }

    @Test(expected = IllegalStateException.class)
    public void illegalBuild() {
        final Pet.Builder builder = new Pet.Builder();
        final Pet pet = builder
                .withAnimal(Animal.DOG)
                .withPetName("Fido")
                .withOwnerName("Simon Smith")
                .build();
    }
}
