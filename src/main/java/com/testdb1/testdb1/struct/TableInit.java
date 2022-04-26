package com.testdb1.testdb1.struct;

import java.sql.Date;

public class TableInit {
    public int ID;
    public Date dob;
    public String email;

    public TableInit(int ID, Date dob, String email) {
        this.ID = ID;
        this.dob = dob;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
