package io.github.ital023.SmartStock.service;

import io.github.ital023.SmartStock.domain.CsvStockItem;
import org.springframework.stereotype.Service;

@Service
public class PurchaseSectorService {

    private final AuthService authService;

    public PurchaseSectorService(AuthService authService) {
        this.authService = authService;
    }

    public boolean sendPurchaseRequest(CsvStockItem item,
                                       Integer purchaseQuantity) {

        var token = authService.getToken();



        return false;
    }

}
