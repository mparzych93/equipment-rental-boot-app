package pl.coderslab.equipmentrentalbootapp.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 5, max = 30)
    private String name;
    @Min(value = 1)
    private int minimumRentalPeriodInDays;
    @Min(value = 1)
    private int rentalCostPerDay;
    @Min(value = 1)
    private int refundableDeposit;
    @Min(value = 1)
    private int amountForDelay;
    @Size(min = 10, max = 200)
    private String description;
    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> rentals = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinimumRentalPeriodInDays() {
        return minimumRentalPeriodInDays;
    }

    public void setMinimumRentalPeriodInDays(int minimumRentalPeriodInDays) {
        this.minimumRentalPeriodInDays = minimumRentalPeriodInDays;
    }

    public int getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public void setRentalCostPerDay(int rentalCostPerDay) {
        this.rentalCostPerDay = rentalCostPerDay;
    }

    public int getRefundableDeposit() {
        return refundableDeposit;
    }

    public void setRefundableDeposit(int refundableDeposit) {
        this.refundableDeposit = refundableDeposit;
    }

    public int getAmountForDelay() {
        return amountForDelay;
    }

    public void setAmountForDelay(int amountForDelay) {
        this.amountForDelay = amountForDelay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rentals=" + rentals +
                ", user=" + user +
                '}';
    }
}
