package vn.codegym.service;

import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Override
    public List<Customer> findAll() throws Exception {
        /*TODO: Để giả lập việc showList() tung một exception, có thể thêm dòng lệnh sau vào thân method findAll(), chỉ để bật dự án lên và kiểm tra Spring AOP đã hoạt động tốt, (kiểm tra bằng cách xem log tại server xem có dòng log liên quan được viết ra hay không):*/
        throw new Exception("a dummy exception");
    }

    @Override
    public Customer findOne(Long id) throws Exception {
        /*TODO: - Chỉnh sửa triển khai của phương thức findOne() của service để xuất bản một exception khi có ngoại lệ:*/
        Customer customer = new Customer();
        if (customer.getName() == null) {
            throw new Exception("customer not found!");
        }
        return customer;
    }
}
