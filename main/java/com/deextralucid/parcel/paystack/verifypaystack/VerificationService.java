package com.deextralucid.parcel.paystack.verifypaystack;

// import com.deextralucid.parcel.paystack.Data;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public interface VerificationService {
    public String getPayment();
    public VerificationResponseDTO getPaymentStatus(@PathVariable("paymentRef") String paymentRef);
    public VerificationResponseDTO getPaymentWithResponseHandling(@PathVariable("paymentRef") String paymentRef);
    public VerificationResponseDTO getPaymentWithCustomHeaders(@PathVariable("paymentRef") String paymentRef);    
}
