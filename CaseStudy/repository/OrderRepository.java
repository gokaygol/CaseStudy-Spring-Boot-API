package CaseStudy.CaseStudy.repository;

import CaseStudy.CaseStudy.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
