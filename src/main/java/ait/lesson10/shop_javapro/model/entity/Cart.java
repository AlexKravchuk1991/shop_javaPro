package ait.lesson10.shop_javapro.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;


    @Override
    public String toString() {
        return String.format("Cart: id - %d, custId - %d", id, customer.getId() );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id && Objects.equals(customer, cart.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
