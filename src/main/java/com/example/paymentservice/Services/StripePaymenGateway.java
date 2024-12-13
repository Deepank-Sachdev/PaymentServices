package com.example.paymentservice.Services;


import com.example.paymentservice.models.Order;
import com.stripe.Stripe;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripePaymenGateway implements PaymentGateway {

    private String apiKey = "sk_test_51QU1oKHXC1Hjiiy7viMEzS47rBZ8xq3k4k4CL1UbMNyZevx87GvpD17GoiiQzyudJGffGP1aM5KoA5XsNwaA1LHO00Ccg5tQsj";

    @Override
    public String GeneratePaymentLink(Order order) {
        try{
            Stripe.apiKey = this.apiKey;
            Price price = getPrice(order);

            PaymentLinkCreateParams params =
                    PaymentLinkCreateParams.builder()
                            .addLineItem(
                                    PaymentLinkCreateParams.LineItem.builder()
                                            .setPrice(getPrice().getId())
                                            .setQuantity(1L)
                                            .build()
                            ).setAfterCompletion(PaymentLinkCreateParams.AfterCompletion.builder()
                                    .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                    .setRedirect(PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                            .setUrl("https://google.com?txn_id =" +"abc12").build()).build())
                            .build();
            PaymentLink paymentLink = PaymentLink.create(params);
            return paymentLink.getUrl();
        }
        catch(Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    private Price getPrice(Order order) {
        try {
            PriceCreateParams params =
                    PriceCreateParams.builder()
                            .setCurrency("inr")
                            .setUnitAmount(order.getAmount())
//                            .setRecurring(
//                                    PriceCreateParams.Recurring.builder()
//                                            .setInterval(PriceCreateParams
//                                            .Recurring.Interval.MONTH)
//                                            .build()
//                            )
                            .setProductData(
                                    PriceCreateParams
                                            .ProductData
                                            .builder()
                                            .setName(order.getOrderId())
                                            .build()
                            )
                            .build();

            Price price = Price.create(params);
            return price;
        }
        catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}
