package com.deextralucid.parcel.paystack;

import com.deextralucid.parcel.paystack.orderpaymentcrud.OrderItemRepo;
import com.deextralucid.parcel.paystack.orderpaymentcrud.OrderRepo;
import com.deextralucid.parcel.paystack.orderpaymentcrud.PaymentRepo;
import com.deextralucid.parcel.paystack.orderpaymentcrud.ProductRepo;
import com.deextralucid.parcel.paystack.ordersandpayments.Order;
import com.deextralucid.parcel.paystack.ordersandpayments.Payment;
import com.deextralucid.parcel.paystack.ordersandpayments.Product;
import com.deextralucid.parcel.paystack.ordersandpayments.OrderItem;
import com.deextralucid.parcel.paystack.verifypaystack.VerificationResponseDTO;
import com.deextralucid.parcel.paystack.verifypaystack.VerificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/v1")
public class InitializeTransactionController {

    @Autowired
    private InitializeTransactionService initializeTransactionService;

    @Autowired
    private VerificationService verificationService;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Autowired
    private ProductRepo productRepo;

    @RequestMapping(path = "/initializetransaction", method = RequestMethod.POST)
    public InitializeTransactionResponseDTO initializeTransaction(
            @RequestBody InitializeTransactionRequestDTO initializeTransactionRequestDTO) {
        InitializeTransactionResponseDTO initializeTransaction = initializeTransactionService
                .initializeTransaction(initializeTransactionRequestDTO);
        return initializeTransaction;
    }

    @RequestMapping(path = "/verifypayment/{paymentRef}", method = RequestMethod.GET)
    public boolean verifyMyPayment(@PathVariable("paymentRef") String paymentRef) {
        VerificationResponseDTO myResponse = verificationService.getPaymentWithCustomHeaders(paymentRef);
        System.out.println(myResponse.getMessage());
        String paymentStatus = myResponse.getData().getStatus();

        if (paymentStatus.equals("success")) {
            System.out.println(paymentStatus);
            Payment currPayment = paymentRepo.findByReference(paymentRef);
            currPayment.setStatus("Successful");
            paymentRepo.save(currPayment);

            int currOrderId = currPayment.getOrder_id();

            Order currOrder = orderRepo.findById(currOrderId);
            currOrder.setIs_completed(true);
            orderRepo.save(currOrder);

            OrderItem[] orderItems = orderItemRepo.findByOrderId(currOrderId);

            for (int i = 0; i < orderItems.length; i++) {
                orderItems[i].setIs_completed(true);
                Product product = productRepo.findById(orderItems[i].getProduct_id());
                int purchasedQty = orderItems[i].getQuantity();
                int stockQty = product.getProd_qty();
                int stockBalance = stockQty - purchasedQty;
                product.setProd_qty(stockBalance);
                productRepo.save(product);
                orderItemRepo.save(orderItems[i]);

            }

            return true;
        } else {
            System.out.println(paymentStatus);
            Payment currPayment = paymentRepo.findByReference(paymentRef);
            currPayment.setStatus(myResponse.getData().getGateway_response());
            paymentRepo.save(currPayment);
            return false;
        }
    }

    @RequestMapping(path = "/verifypaydetail/{paymentRef}", method = RequestMethod.GET)
    public VerificationResponseDTO verifyMyPaymentWithDetail(@PathVariable("paymentRef") String paymentRef) {
        VerificationResponseDTO myResponse = verificationService.getPaymentWithCustomHeaders(paymentRef);

        return myResponse;
    }

}
