package vn.codegym.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {
    /*TODO: Tạo class Logger đại diện cho một mối quan tâm về việc ghi log các sự kiện quan trong khi app vận hành. Định nghĩ một hành vi ghi log với tên là error, dùng khi trong hệ thống có những exception được phát sinh. Thông thường các lỗi phát sinh bên dưới được giấu khỏi view hiển thị của người dùng, và việc đó gây khó khăn cho nhà phát triển khi debug những lỗi xảy ra khi app vận hành trên môi trường production, vì thế ghi log là rất quan trọng. Sử dụng các annotation phù hợp để định nghĩa các vai trò trong AOP.*/

    /*TODO: - Bổ sung tham số cho khai báo advice, để lấy thông tin về exception:*/
    @AfterThrowing(pointcut = "execution(public * vn.codegym.service.CustomerService.findAll(..))", throwing = "e")
    public void logMethod(Exception e) {
        System.out.println("[CMS] co loi xay ra: " + e.getMessage());
    }

    /*TODO: Point cut được viết ở trên mô tả rằng phương thức log được thực thi khi phương thức triển khai findAll từ interface ICustomerService tung ra ngoại lệ thực thi. Dấu ... ngụ ý rằng poincut này áp dụng cho mọi bộ tham số của findAll().*/

    @AfterThrowing(pointcut = "execution(public * vn.codegym.service.CustomerService.*(..))", throwing = "e")
    /*TODO:  Mở rộng phạm vi của pointcut để áp dụng cho tất cả các phương thức của tất cả các class trong package service. Sử dụng đối tượng joinPoint để lấy thông tin về class, method, và bộ tham số nhằm debug dễ hơn:*/
    public void logClass(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("[CMS] co loi xay ra: %s.%s%s: %s%n", className, method, args, e.getMessage());
    }

}
