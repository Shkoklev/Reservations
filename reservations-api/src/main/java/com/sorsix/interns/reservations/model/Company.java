package com.sorsix.interns.reservations.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "working_days_mask", nullable = false)
    private String workingDaysMask;

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @ManyToOne(optional = false)
    private Owner owner;

    @ManyToOne(optional = false)
    private Place place;

    @JoinTable
    @OneToMany
    private List<CompanyImage> images;

    @ManyToOne(optional = false)
    private CompanyType companyType;

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getWorkingDaysMask() {
        return workingDaysMask;
    }

    public void setWorkingDaysMask(String workingDaysMask) {
        this.workingDaysMask = workingDaysMask;
    }

    public Owner getOwner() {
        return owner;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public List<CompanyImage> getImages() {
        return images;
    }

    public void setImages(List<CompanyImage> images) {
        this.images = images;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }
}
