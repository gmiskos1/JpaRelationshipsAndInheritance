package com.demo.demo1;

import com.demo.OneToOne.Address;

import javax.persistence.EntityManager;

public class AddressService {
    // ======================================
    // =             Attributes             =
    // ======================================

    private EntityManager em;

    // ======================================
    // =            Constructors            =
    // ======================================

    public AddressService(EntityManager em) {
        this.em = em;
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public Address createAddress(Address address) {
        em.persist(address);
        return address;
    }

    public void removeAddress(Long id) {
        Address address = em.find(Address.class, id);
        if (address != null)
            em.remove(address);
    }

    public Address findAddress(Long id) {
        return em.find(Address.class, id);
    }
}
