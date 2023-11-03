package pl.coderslab.equipmentrentalbootapp.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 7, max = 19)
    private String voivodeship;
    @Size(min = 2)
    private String city;
    @Pattern(regexp = "[0-9][0-9]-[0-9][0-9][0-9]")
    private String postalCode;
    @Pattern(regexp = "^[A-Z]+[a-z-]+")
    @Size(min = 2)
    private String street;
    @Pattern(regexp = "\\d+[a-z]?")
    private String streetNumber;
    @Pattern(regexp = "\\d+[a-z]?")
    private String apartmentNumber;
    @OneToMany(mappedBy = "address", orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<User> userList = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", voivodeship='" + voivodeship + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
