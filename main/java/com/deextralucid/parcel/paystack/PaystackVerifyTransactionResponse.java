// package com.deextralucid.parcel.paystack;

// import java.io.BufferedReader;
// import java.net.http.HttpClient;
// import java.net.http.HttpResponse;

// import com.fasterxml.jackson.databind.ObjectMapper;

// public class PaystackVerifyTransactionResponse {
    
//     public VerifyTransactionResponse verifyTransaction(String reference) throws Exception {
//         VerifyTransactionResponse paystackresponse = null;
//         try {
//             HttpClient client = HttpClientBuilder.create().build();
//             HttpGet request = new HttpGet("https://api.paystack.co/transaction/verify/" + reference);
//             request.addHeader("Content-type", "application/json");
//             request.addHeader("Authorization", "Bearer " + PAYSTACK_SECRET_KEY);
//             StringBuilder result = new StringBuilder();
//             HttpResponse response = client.execute(request);
//             if (response.getStatusLine().getStatusCode() == STATUS_CODE_OK) {
//                 BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
    
//                 String line;
//                 while ((line = rd.readLine()) != null) {
//                     result.append(line);
//                 }
    
//             } else {
//                 throw new Exception("Error Occured while connecting to paystack url");
//             }
//             ObjectMapper mapper = new ObjectMapper();
    
//             paystackresponse = mapper.readValue(result.toString(), PaystackVerifyTransactionResponse.class);
    
//             if (paystackresponse == null || paystackresponse.getStatus().equals("false")) {
//                 throw new Exception("An error occurred while  verifying payment");
//             } else if (paystackresponse.getData().getStatus().equals("success")) {
//                //PAYMENT IS SUCCESSFUL, APPLY VALUE TO THE TRANSACTION
//             }
    
//         } catch (Exception ex) {
//             ex.printStackTrace();
//             throw new Exception("Internal server error");
//         }
//         return paystackresponse;
//     }
// }
