package io.github.ital023.SmartStock.service;

import io.github.ital023.SmartStock.domain.CsvStockItem;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SmartStockService {

    private final ReportService reportService;

    public SmartStockService(ReportService reportService) {
        this.reportService = reportService;
    }

    public void start(String reportPath) {
        try {
            var items = reportService.readStockReport(reportPath);

            items.forEach(item -> {
                if(item.getQuantity() < item.getReorderThreshold()) {
                    var reorderQuantity = calculateReorderQuantity(item);
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Integer calculateReorderQuantity(CsvStockItem item) {
        return item.getReorderThreshold() + ((int) Math.ceil(item.getReorderThreshold() * 0.2));
    }

}
