package pl.coderslab.equipmentrentalbootapp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime created;

    private int rentalDays;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    public Rental() {
    }

    public Rental(Item item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", item=" + item +
                ", user=" + user +
                ", created=" + created +
                ", rentalDays=" + rentalDays +
                '}';
    }
}
