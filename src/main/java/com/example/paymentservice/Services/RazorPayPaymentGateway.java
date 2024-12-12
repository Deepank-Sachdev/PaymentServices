package com.example.paymentservice.Services;

import com.razorpay.PaymentLink;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

@Service
public class RazorPayPaymentGateway implements PaymentGateway {

    @Override
    public String GeneratePaymentLink() {
        try{
            RazorpayClient razorpay = new RazorpayClient("rzp_test_sg_PVg0keFyXnWqen", "mejLCFY56eQRa3WUvpjvLMyT");
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount",1000);
            paymentLinkRequest.put("currency","INR");
            paymentLinkRequest.put("accept_partial",true);
            paymentLinkRequest.put("first_min_partial_amount",100);
            paymentLinkRequest.put("expire_by",1733736637);
            paymentLinkRequest.put("reference_id","TS1989");
            paymentLinkRequest.put("description","Payment for policy no #23456");
            JSONObject customer = new JSONObject();
            customer.put("Deepank","+919000090000");
            customer.put("contact","Deepank");
            customer.put("email","dpanksachdev@example.com");
            paymentLinkRequest.put("customer",customer);
            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            paymentLinkRequest.put("notify",notify);
            paymentLinkRequest.put("reminder_enable",true);
            JSONObject notes = new JSONObject();
            notes.put("Product","iphone 16");
            paymentLinkRequest.put("notes",notes);
            paymentLinkRequest.put("callback_url","https://google.com?txn_id =" + "abc12");
            paymentLinkRequest.put("callback_method","get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
            return payment.toString();
        }
        catch(RazorpayException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
