package pl.coderslab.equipmentrentalbootapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int minimumRentalPeriodInDays;
    private int rentalCostPerDay;
    private int refundableDeposit;
    private int amountForDelay;
    private String pickupAddress;
    private String returnAddress;
    private String description;
    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "item")
    private Rental rental;

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

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
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

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
