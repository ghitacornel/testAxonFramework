package beans.queries;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@EqualsAndHashCode
@ToString
public class Order {

    private final String orderId;
    private final Map<String, Integer> products = new HashMap<>();
    private OrderStatus orderStatus = OrderStatus.CREATED;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public void addProduct(String productId) {
        products.putIfAbsent(productId, 1);
    }

    public void incrementProductInstance(String productId) {
        products.computeIfPresent(productId, (id, count) -> ++count);
    }

    public void decrementProductInstance(String productId) {
        products.computeIfPresent(productId, (id, count) -> --count);
    }

    public void removeProduct(String productId) {
        products.remove(productId);
    }

    public void setOrderConfirmed() {
        this.orderStatus = OrderStatus.CONFIRMED;
    }

    public void setOrderShipped() {
        this.orderStatus = OrderStatus.SHIPPED;
    }

}