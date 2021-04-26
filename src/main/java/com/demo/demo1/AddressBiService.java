package com.demo.demo1;

import com.demo.OneToOneBidirectional.AddressBi;

import javax.persistence.EntityManager;

public class AddressBiService {
    // ======================================
    // =             Attributes             =
    // ======================================

    private EntityManager em;

    // ======================================
    // =            Constructors            =
    // ======================================

    public AddressBiService(EntityManager em) {
        this.em = em;
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public AddressBi createAddress(AddressBi address) {
        em.persist(address);
        return address;
    }

    public void removeAddress(Long id) {
        AddressBi address = em.find(AddressBi.class, id);
        if (address != null)
            em.remove(address);
    }

    public void removeAddress(AddressBi addressBi) {
        AddressBi addressToDelete = em.merge(addressBi);
        if (addressToDelete != null)
            em.remove(addressToDelete);
    }

    public AddressBi findAddress(Long id) {
        return em.find(AddressBi.class, id);
    }
}
