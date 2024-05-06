package CaseStudy.CaseStudy.service;

import CaseStudy.CaseStudy.dto.InventoryResponse;
import CaseStudy.CaseStudy.dto.OrderLineItemsDto;
import CaseStudy.CaseStudy.dto.OrderRequest;
import CaseStudy.CaseStudy.entity.Order;
import CaseStudy.CaseStudy.entity.OrderLineItems;
import CaseStudy.CaseStudy.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public void placeOrder(OrderRequest orderRequest) {


        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .toList()
                .stream()
                .map(this::mapToOrderDto).toList();

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItemsList(orderLineItemsList);

        List <String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode).toList();

        InventoryResponse[]inventoryResponses = new InventoryResponse[skuCodes.size()];

        assert inventoryResponses != null;
        boolean allProductsInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);

        if(allProductsInStock){
            orderRepository.save(order);}
        else {
            throw new IllegalArgumentException("Product not in stock, check back later");
        }
    }
    private OrderLineItems mapToOrderDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItem = new OrderLineItems();
        orderLineItem.setPrice(orderLineItemsDto.getPrice());
        orderLineItem.setSkuCode(orderLineItem.getSkuCode());
        orderLineItem.setQuantity(orderLineItemsDto.getQuantity());

        return orderLineItem;
    }
}
