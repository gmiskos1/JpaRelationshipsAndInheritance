package com.demo.demo1;

import com.demo.OneToOne.Address;
import com.demo.OneToOne.Home;

import javax.persistence.EntityManager;

public class HomeService {
    // ======================================
    // =             Attributes             =
    // ======================================

    private EntityManager em;

    // ======================================
    // =            Constructors            =
    // ======================================

    public HomeService(EntityManager em) {
        this.em = em;
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public Home createHome(Home home) {
        em.persist(home);
        return home;
    }

    public Home updateHome(Home home, Address newAddress) {
        Home homeToUpdate = em.merge(home);
        if (homeToUpdate != null)
            homeToUpdate.setAddress(newAddress);
        return homeToUpdate;
    }

    public void removeHome(Long id) {
        Home home = em.find(Home.class, id);
        if (home != null)
            em.remove(home);
    }

    public void removeHome(Home home) {
        Home homeToBeRemoved = em.merge(home);
        if (homeToBeRemoved != null)
            em.remove(homeToBeRemoved);
    }

    public Home findHome(Long id) {
        return em.find(Home.class, id);
    }
}
