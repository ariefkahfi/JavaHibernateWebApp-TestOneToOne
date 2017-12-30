package com.arief.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name="t_pet")
public class Pet {

    @Id
    @GeneratedValue
    @Column(name="pet_id")
    private int petId;

    @Column(name="pet_name")
    private String petName;

    @Column(name="pet_category")
    private String petCategory;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "pet")
    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetCategory() {
        return petCategory;
    }

    public void setPetCategory(String petCategory) {
        this.petCategory = petCategory;
    }
}
