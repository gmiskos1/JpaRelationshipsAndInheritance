package com.demo.demo1;

import com.demo.OneToOneBidirectional.AddressBi;
import com.demo.OneToOneBidirectional.HomeBi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainBi {
    public static void main(String args[]){
        System.out.println("\n\n>>> Executing : " + MainBi.class.toString() + " <<<\n");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        HomeBiService homeBiServiceService = new HomeBiService(em);
        AddressBiService addressBiServiceService = new AddressBiService(em);

        //create and persist home.
        tx.begin();
        HomeBi home = homeBiServiceService.createHome(new HomeBi("Exohico", new AddressBi("Evzwnwn 2")));
        tx.commit();
        System.out.println("Home with address persisted : " + home);

        //create a new address
        AddressBi otherAddress = new AddressBi("Karamanli 123");
        //update address of home.
        tx.begin();
        home = homeBiServiceService.updateHome(home, otherAddress);
        tx.commit();
        //until now we saved two addresses without calling AddressService

        //now lets remove the home....address is also removed.
        tx.begin();
        homeBiServiceService.removeHome(home);
        tx.commit();

        System.out.println("\n========================================================");

        //create and persist address.
        tx.begin();
        AddressBi addressBi = addressBiServiceService.createAddress(new AddressBi("Skatoulidi 42"));
        tx.commit();
        System.out.println("new address persisted : " + addressBi);

        //create and persist otherHome.
        tx.begin();
        HomeBi otherHome = homeBiServiceService.createHome(new HomeBi("diamerisma"));
        tx.commit();
        System.out.println("new other home persisted : " + otherHome);

        //create and persist address with home together
        tx.begin();
        AddressBi anotherAddressBi = addressBiServiceService.createAddress(new AddressBi("Skatoulidi 42" , new HomeBi("kalyva")));
        tx.commit();

        //update address of home.
        tx.begin();
        HomeBi justCreatedHome = anotherAddressBi.getHomeBi();
        justCreatedHome = homeBiServiceService.updateHome(justCreatedHome, anotherAddressBi);
        tx.commit();

        //now lets remove the home....address is also removed.
        tx.begin();
        addressBiServiceService.removeAddress(anotherAddressBi);
        tx.commit();

        em.close();
        emf.close();
    }
}
