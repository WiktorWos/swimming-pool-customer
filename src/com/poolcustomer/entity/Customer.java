package com.poolcustomer.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "box_number")
    @NotNull(message = "Insert the value")
    @Min(value = 1, message = "Box numbers starts from 1")
    @Max(value = 200, message = "The maximum number is 200")
    private Integer boxNumber;

    @Column(name = "ticket")
    private String ticket;

    @Column(name = "start")
    private Date start;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Integer boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", boxNumber=" + boxNumber +
                ", ticket='" + ticket + '\'' +
                ", start=" + start +
                '}';
    }
}
