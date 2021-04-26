package com.demo.OneToOneBidirectional;

import javax.persistence.*;

@Entity
public class AddressBi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String address;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private HomeBi homeBi;

    public AddressBi(){

    }

    public AddressBi(String address) {
        this.address = address;
    }

    public AddressBi(String address, HomeBi homeBi) {
        this.address = address;
        this.homeBi = homeBi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HomeBi getHomeBi() {
        return homeBi;
    }

    public void setHomeBi(HomeBi homeBi) {
        this.homeBi = homeBi;
    }
}
