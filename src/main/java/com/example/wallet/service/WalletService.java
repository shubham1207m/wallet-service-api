package com.example.wallet.service;

import com.example.wallet.dto.WalletRequest;
import com.example.wallet.entity.Wallet;
import com.example.wallet.repository.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository repository;

    @Transactional
    public void updateWallet(WalletRequest request) {

        Wallet wallet = repository.findById(request.getWalletId())
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        if ("DEPOSIT".equalsIgnoreCase(request.getOperationType())) {
            wallet.setBalance(wallet.getBalance() + request.getAmount());

        } else if ("WITHDRAW".equalsIgnoreCase(request.getOperationType())) {

            if (wallet.getBalance() < request.getAmount()) {
                throw new RuntimeException("Insufficient funds");
            }

            wallet.setBalance(wallet.getBalance() - request.getAmount());
        }

        repository.save(wallet);
    }

    public Long getBalance(UUID id) {
        Wallet wallet = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        return wallet.getBalance();
    }
}