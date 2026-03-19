package com.example.wallet.controller;

import com.example.wallet.dto.WalletRequest;
import com.example.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService service;

    @PostMapping("/wallet")
    public void updateWallet(@RequestBody WalletRequest request) {
        service.updateWallet(request);
    }

    @GetMapping("/wallets/{id}")
    public Long getBalance(@PathVariable UUID id) {
        return service.getBalance(id);
    }
}