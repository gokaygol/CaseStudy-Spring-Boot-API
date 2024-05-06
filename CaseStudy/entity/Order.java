package CaseStudy.CaseStudy.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_order")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Order {

    @Getter
    @Setter
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List <OrderLineItems> orderLineItemsList = new ArrayList<>();

}
