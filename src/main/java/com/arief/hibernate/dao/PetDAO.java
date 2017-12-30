package com.arief.hibernate.dao;

import com.arief.hibernate.entity.Pet;

import java.util.List;

public interface PetDAO {
    public void save(Pet p);
    public List<Pet> getPets() throws Exception;
    public void delete(Pet p);
    public Pet getOne(int petId);
    public void update(Pet p);
}
