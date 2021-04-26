package com.demo.demo1;

import com.demo.OneToOne.Address;
import com.demo.OneToOne.Home;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String args[]){
        System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        HomeService homeService = new HomeService(em);
        //create and persist home.
        tx.begin();
        Home home = homeService.createHome(new Home("Exohico", new Address("Evzwnwn 2")));
        tx.commit();
        System.out.println("Home with address persisted : " + home);

        //create a new address
        Address otherAddress = new Address("Karamanli 123");
        //update address of home.
        tx.begin();
        home = homeService.updateHome(home, otherAddress);
        tx.commit();
        //until now we saved two addresses without calling AddressService

        //now lets remove the address.
        tx.begin();
        homeService.removeHome(home);
        tx.commit();

        em.close();
        emf.close();
    }
}
