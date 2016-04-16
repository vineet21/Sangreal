package com.vineet.sangreal;

/**
 * Created by vineet on 4/14/2016.
 */
public class Contact {
    int id,dob,phone,ephone;
    String name,password,email;
    public void setId (int id)
    {
        this.id=id;
    }
    public int getId()
    {
        return this.id ;
    }

    public void setDob (int dob)
    {
        this.dob=dob;
    }
    public int getDob()
    {
        return this.dob ;
    }

    public void setPhone (int phone)
    {
        this.phone=phone;
    }
    public int getPhone()
    {
        return this.phone;
    }

    public void setEphone (int ephone)
    {
        this.ephone=ephone;
    }
    public int getEphone()
    {
        return this.ephone;
    }

    public void setName (String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }

    public void setPassword (String password)
    {
        this.password=password;
    }
    public String getPassword()
    {
        return this.password;
    }

    public void setEmail (String email)
    {
        this.email=email;
    }
    public String getEmail()
    {
        return this.email;
    }
}
