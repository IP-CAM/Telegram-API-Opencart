package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.Instant;
import java.util.Objects;

import static org.hibernate.annotations.CascadeType.ALL;

@Entity
public class Customer implements Identified {
    @Id
    private long id;

    @Column(name = "is_bot")
    private boolean isBot;

    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "language_code")
    private String languageCode;

    @OneToOne
    @Cascade(ALL)
    private Cart cart = new Cart();

    private Instant registerDate;

    public Customer() {
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isBot() {
        return isBot;
    }

    public void setBot(boolean bot) {
        isBot = bot;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Instant getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Instant registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                isBot == customer.isBot &&
                Objects.equals(username, customer.username) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(languageCode, customer.languageCode) &&
                Objects.equals(cart, customer.cart) &&
                Objects.equals(registerDate, customer.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isBot, username, firstName, lastName, languageCode, cart, registerDate);
    }
}
