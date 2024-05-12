package dev.kei.controller;

import dev.kei.dto.FraudCreateRequest;
import dev.kei.dto.FraudResponse;
import dev.kei.entity.LoanStatus;
import dev.kei.service.FraudService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/frauds")
public class FraudController {
    private final FraudService fraudService;

    public FraudController(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody FraudCreateRequest fraudCreateRequest) {
        return fraudService.save(fraudCreateRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FraudResponse> findAllFraud() {
        return fraudService.findAllFraud();
    }

    @GetMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    public LoanStatus checkFraudByCustomerId(@RequestParam Integer customerId) {
        return fraudService.checkFraudByCustomerId(customerId);
    }
}
