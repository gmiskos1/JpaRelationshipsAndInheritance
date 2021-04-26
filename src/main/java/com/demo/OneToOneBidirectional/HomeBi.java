package com.demo.OneToOneBidirectional;

import javax.persistence.*;

@Entity
public class HomeBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200)
    private String name;

    // we are saving a home together with a newly created address. CascadeType.PERSIST
    // and when deleting home, we are deleting the corresponding address. CascadeType.REMOVE
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private AddressBi addressBi;

    public HomeBi() {

    }

    public HomeBi(String name) {
        this.name = name;
    }

    public HomeBi(String name, AddressBi addressBi) {
        this.name = name;
        this.addressBi = addressBi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressBi getAddress() {
        return addressBi;
    }

    public void setAddress(AddressBi addressBi) {
        this.addressBi = addressBi;
    }
}
