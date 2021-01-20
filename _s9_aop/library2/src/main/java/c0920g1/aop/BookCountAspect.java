package c0920g1.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookCountAspect {

    @Pointcut("execution(* c0920g1.controller.BorrowBillController.saveBookAndBorrowCodeBill(..))")
    public void billControllerMethodBorrow(){}

    @Before("billControllerMethodBorrow()")
    public void logBookDown(){
        System.out.println("***** Quantity book is DOWN *****");
    }

    @Pointcut("execution(* c0920g1.controller.BorrowBillController.returnBookAndDeleteBorrowCode(..))")
    public void billControllerMethodReturn(){}

    @Before("billControllerMethodReturn()")
    public void logBookUp(){
        System.out.println("_____ Quantity book is UP _____");
    }





}
