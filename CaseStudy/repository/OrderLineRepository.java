package CaseStudy.CaseStudy.repository;

import CaseStudy.CaseStudy.entity.OrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLineItems, Long> {
}
