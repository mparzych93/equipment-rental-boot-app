package pl.coderslab.equipmentrentalbootapp.dto;

import pl.coderslab.equipmentrentalbootapp.entity.Address;

import javax.validation.Valid;

@Valid
public class UserToEditDataDto {
    private String firstName;
    private String lastName;
    private Address address;

    public UserToEditDataDto() {
    }

    public UserToEditDataDto(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
