package beans.events;

import lombok.Value;

@Value
public class OrderConfirmedEvent {

    String orderId;

}
