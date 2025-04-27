package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class OrderSpringTest {

    @Test
    void testShoppingCart() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mylab-order-di.xml");
        
        ShoppingCart cart = context.getBean("shoppingCart", ShoppingCart.class);
        assertNotNull(cart);
        
        System.out.println("ShoppingCart: " + cart);
        System.out.println("Total Price: " + cart.getTotalPrice());
        
        // 추가: 가격 체크
        assertEquals(4.5, cart.getTotalPrice(), 0.01);
    }

    @Test
    void testOrderService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mylab-order-di.xml");
        
        OrderService orderService = context.getBean("orderService", OrderService.class);
        assertNotNull(orderService);
        
        System.out.println("OrderService: " + orderService);
        System.out.println("Order Total: " + orderService.calculateOrderTotal());
        
        // 추가: 가격 체크
        assertEquals(4.5, orderService.calculateOrderTotal(), 0.01);
    }
}
