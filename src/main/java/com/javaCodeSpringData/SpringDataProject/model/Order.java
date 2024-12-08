package com.javaCodeSpringData.SpringDataProject.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_user")
public class Order {
    public interface Views {
        interface OrderSummary {}
        interface OrderDetails extends OrderSummary {}
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonView(Views.OrderSummary.class)
    private String product;

    @JsonView(Views.OrderSummary.class)
    private Double amount;

    @JsonView(Views.OrderDetails.class)
    private String status;

}
