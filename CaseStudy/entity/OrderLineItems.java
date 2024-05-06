package CaseStudy.CaseStudy.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Entity
@Table(name="t_order_line_items")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class OrderLineItems {

    @Getter
    @Setter
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private int quantity;

}
