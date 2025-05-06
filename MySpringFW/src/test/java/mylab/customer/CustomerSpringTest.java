package mylab.customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;

public class CustomerSpringTest {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("spring-beans.xml");

        CustomerService service = context.getBean("customerServiceImpl", CustomerService.class);

        // 고객 등록
        CustomerVO customer = new CustomerVO();
        customer.setEmail("hong@naver.com");
        customer.setName("홍길동");
        customer.setAge(30);
        service.insertCustomer(customer);

        // 고객 조회
        CustomerVO result = service.getCustomerInfo(1);
        System.out.println("고객명: " + result.getName());
    }
}
