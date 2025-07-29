package org.example.mobile;
import java.util.*;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public String getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(String myNumber) {
        this.myNumber = myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public void setMyContacts(ArrayList<Contact> myContacts) {
        this.myContacts = myContacts;
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = (ArrayList<Contact>) myContacts;
    }

    public MobilePhone(String myNumber)
    {
        this.setMyNumber(myNumber);
    }

    public boolean addNewContact(Contact contact)
    {
        if(this.myContacts.contains(contact)) return  false;
        this.myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact)
    {
        int idx = this.myContacts.indexOf(oldContact);
        if(idx == -1) return false;
        this.myContacts.get(idx).updateContact(newContact);
        return true;
    }

    public boolean removeContact(Contact contact)
    {
        int idx = this.myContacts.indexOf(contact);
        if(idx == -1) return false;
        this.myContacts.remove(idx);
        return true;
    }

    public int findContact(Contact contact)
    {
        return this.myContacts.indexOf(contact);
    }

    public int findContact(String name)
    {

        for (Contact contact : this.myContacts)
        {
            if (contact.getName() == name) return this.myContacts.indexOf(contact);
        }
        return -1;
    }

    public Contact queryContact(String name)
    {
        for (Contact contact : this.myContacts)
        {
            if (contact.getName() == name) return contact;
        }
        return null;
    }

    public void printContact()
    {
        System.out.println("Contact List:");
        int i = 1;
        for (Contact contact : this.myContacts)
        {
            System.out.println(i + "." + contact.getName() + " _> " + contact.getPhoneNumber());
            i++;
        }
    }


}
