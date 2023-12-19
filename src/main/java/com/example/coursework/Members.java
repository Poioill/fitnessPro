package com.example.coursework;

import java.util.Date;

public class Members {
    int id_member;
    String name;
    String contact;
    String group_member;
    String membership;
    String trainer;
    Date start_ab;
    Date end_ab;

    public Members(int id_member, String name, String contact, String group_member, String membership, String trainer, Date start_ab, Date end_ab) {
        this.id_member = id_member;
        this.name = name;
        this.contact = contact;
        this.group_member = group_member;
        this.membership = membership;
        this.trainer = trainer;
        this.start_ab = start_ab;
        this.end_ab = end_ab;
    }

    public int getId_member() {
        return id_member;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGroup_member() {
        return group_member;
    }

    public void setGroup_member(String group_member) {
        this.group_member = group_member;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public Date getStart_ab() {
        return start_ab;
    }

    public void setStart_ab(Date start_ab) {
        this.start_ab = start_ab;
    }

    public Date getEnd_ab() {
        return end_ab;
    }

    public void setEnd_ab(Date end_ab) {
        this.end_ab = end_ab;
    }
}
