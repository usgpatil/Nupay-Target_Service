package dummy_nupay_service.smfg.dto;

import lombok.Data;

@Data
public class NuPayRequest {

    private  String customerId;
    private double amount;
    private String frequency;

}
