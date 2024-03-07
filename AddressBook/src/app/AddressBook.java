/* CSIS312 - Assignment 4: Address Book Program
** By Ben Turner & Jack Skywalker (Baijun Jiang)
** Resources: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableView.html
*/

package app;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.FileOutputStream;
import java.io.IOException;

public class AddressBook {

    String firstName;
    String lastName;
    String birthday;
    String address;
    String city;
    String state;
    int zip;

    public AddressBook(String firstName, String lastName, String birthday, String address, String city, String state, int zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }
}
