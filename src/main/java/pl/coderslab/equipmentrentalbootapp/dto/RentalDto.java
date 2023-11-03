package pl.coderslab.equipmentrentalbootapp.dto;

import javax.validation.Valid;

@Valid
public class RentalDto {
    private Long rentalId;
    private int rentalDays;
    private int daysOnLoan;
    private int finalCost;

    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public int getDaysOnLoan() {
        return daysOnLoan;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public void setDaysOnLoan(int daysOnLoan) {
        this.daysOnLoan = daysOnLoan;
    }

    public int getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(int finalCost) {
        this.finalCost = finalCost;
    }
}
