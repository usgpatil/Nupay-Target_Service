package dummy_nupay_service.smfg.controller;

import dummy_nupay_service.smfg.dto.NuPayRequest;
import dummy_nupay_service.smfg.dto.NuPayResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/nupay")
public class DummyNuPayController {


    @PostMapping("/mandates")
    public ResponseEntity<NuPayResponse> cerateMandate(@RequestBody NuPayRequest request){

        String mandateId = "NP-" + UUID.randomUUID();
        String referenceId = "NPR-" + UUID.randomUUID();

        String redirectUrl =
                "https://dummy-nupay.com/pay/" + mandateId;

        NuPayResponse response=new NuPayResponse(
                mandateId,
                "Success",
                redirectUrl,
                "Mandate created successfully",
                referenceId
        );

        return ResponseEntity.ok(response);
    }
}
