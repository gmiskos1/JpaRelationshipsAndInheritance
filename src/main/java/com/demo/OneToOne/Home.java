package com.demo.OneToOne;

import javax.persistence.*;

@Entity
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200)
    private String name;

    // we are saving a home together with a newly created address. CascadeType.PERSIST
    // and when deleting home, we are deleting the corresponding address. CascadeType.REMOVE
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Address address;

    public Home() {

    }
    public Home(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
