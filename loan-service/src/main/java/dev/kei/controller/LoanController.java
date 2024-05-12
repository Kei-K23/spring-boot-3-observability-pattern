package dev.kei.controller;

import dev.kei.dto.LoanCreateRequest;
import dev.kei.dto.LoanResponse;
import dev.kei.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public String save(@RequestBody LoanCreateRequest loanCreateRequest) {
        return loanService.save(loanCreateRequest);
    }

    @GetMapping
    public List<LoanResponse> findAllLoan() {
        return loanService.findAllLoan();
    }
}
