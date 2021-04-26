package com.demo.demo1;

import com.demo.OneToOneBidirectional.AddressBi;
import com.demo.OneToOneBidirectional.HomeBi;

import javax.persistence.EntityManager;

public class HomeBiService {
    // ======================================
    // =             Attributes             =
    // ======================================

    private EntityManager em;

    // ======================================
    // =            Constructors            =
    // ======================================

    public HomeBiService(EntityManager em) {
        this.em = em;
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public HomeBi createHome(HomeBi home) {
        em.persist(home);
        return home;
    }

    public HomeBi updateHome(HomeBi home, AddressBi newAddress) {
        HomeBi homeToUpdate = em.merge(home);
        if (homeToUpdate != null)
            homeToUpdate.setAddress(newAddress);
        return homeToUpdate;
    }

    public void removeHome(Long id) {
        HomeBi home = em.find(HomeBi.class, id);
        if (home != null)
            em.remove(home);
    }

    public void removeHome(HomeBi home) {
        HomeBi homeToBeRemoved = em.merge(home);
        if (homeToBeRemoved != null)
            em.remove(homeToBeRemoved);
    }

    public HomeBi findHome(Long id) {
        return em.find(HomeBi.class, id);
    }
}
