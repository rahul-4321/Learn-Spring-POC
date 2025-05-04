package com.rahul;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private int sid;
    private String sName;
    private int marks;
    public int getsid() {
        return sid;
    }
    public void setsid(int sid) {
        this.sid = sid;
    }
    public String getsName() {
        return sName;
    }
    public void setsName(String sName) {
        this.sName = sName;
    }
    public int getmarks() {
        return marks;
    }
    public void setmarks(int marks) {
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "Student [sid=" + sid + ", sName=" + sName + ", marks=" + marks + "]";
    }
}
