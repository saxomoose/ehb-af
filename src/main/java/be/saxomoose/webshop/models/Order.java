package be.saxomoose.webshop.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collection;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    private ApplicationUser user;

    @OneToMany(targetEntity = OrderDetails.class, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Collection<OrderDetails> orderDetails;

    @NotNull
    @DecimalMin(value = "0.00", message = "Subtotal must be positive")
    private BigDecimal subtotal;

    @NotNull
    @DecimalMin(value = "0.00", message = "Subtotal must be positive")
    private BigDecimal total;

    @CreatedDate
    @Column(name = "created_at")
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}