package com.sorsix.interns.reservations.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "remark",length = 512)
    private String remark;

    @Column(name = "person_count", nullable = false)
    private int personCount;

    @Column(name = "for_date", nullable = false)
    private LocalDate forDate;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Company company;

    public Reservation() { }

    public Reservation(String remark, int personCount, LocalDate forDate, Company company) {
        this.remark = remark;
        this.personCount = personCount;
        this.forDate = forDate;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public LocalDate getForDate() {
        return forDate;
    }

    public void setForDate(LocalDate forDate) {
        this.forDate = forDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
