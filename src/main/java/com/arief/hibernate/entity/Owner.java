package com.arief.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name="t_owner")
public class Owner {

    @Id
    @Column(name="owner_id")
    private String ownerId;


    @Column(name="owner_name")
    private String ownerName;


    @Column(name="owner_address")
    private String ownerAddress;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "pet_id",unique = true)
    private Pet pet;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
