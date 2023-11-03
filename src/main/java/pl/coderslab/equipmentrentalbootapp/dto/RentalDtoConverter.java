package pl.coderslab.equipmentrentalbootapp.dto;

import org.springframework.stereotype.Component;
import pl.coderslab.equipmentrentalbootapp.entity.Rental;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class RentalDtoConverter implements BaseConverter<Rental, RentalDto> {
    @Override
    public RentalDto convert(Rental from) {
        RentalDto rentalDto = new RentalDto();
        rentalDto.setRentalId(from.getId());
        rentalDto.setRentalDays(from.getRentalDays());
        rentalDto.setDaysOnLoan(countDaysOnLoan(from));
        rentalDto.setFinalCost(countFinalCost(from));
        return rentalDto;
    }

    private int countDaysOnLoan(Rental rental) {
        return (int) ChronoUnit.DAYS.between(rental.getCreated(), LocalDateTime.now());
    }
    private int countFinalCost(Rental rental) {
        int base = rental.getRentalDays() * rental.getItem().getRentalCostPerDay();
        int extraDays = countDaysOnLoan(rental) - rental.getRentalDays();
        int cashForDeley = extraDays * rental.getItem().getAmountForDelay();
        return base + cashForDeley;
    }
}
