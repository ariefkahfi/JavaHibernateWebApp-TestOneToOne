package com.arief.hibernate.dao;

import com.arief.hibernate.entity.Owner;

import java.util.List;

public interface OwnerDAO {
    public void save(Owner o);
    public List<Owner> getOwners() throws Exception;
    public void delete(Owner o) ;
    public void update(Owner o);
    public Owner getOwner(String ownerId);
}
