package dummy_nupay_service.smfg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NuPayResponse {

    private String mandateId;
    private String status;
    private String redirectUrl;
    private  String message;
    private  String  referenceId;


}
