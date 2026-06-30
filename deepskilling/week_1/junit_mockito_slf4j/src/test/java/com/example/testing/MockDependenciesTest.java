package com.example.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MockDependenciesTest {
    @Mock
    private InventoryRepository inventoryRepository;

    @Mock
    private PaymentGateway paymentGateway;

    @InjectMocks
    private OrderService orderService;

    @Test
    void testPlaceOrderSuccess() {
        when(inventoryRepository.isAvailable("P100", 2)).thenReturn(true);
        when(paymentGateway.pay(500)).thenReturn(true);

        boolean result = orderService.placeOrder("P100", 2, 500);

        assertTrue(result);
        verify(inventoryRepository).reduceStock("P100", 2);
    }

    @Test
    void testPlaceOrderWhenStockNotAvailable() {
        when(inventoryRepository.isAvailable("P200", 5)).thenReturn(false);

        boolean result = orderService.placeOrder("P200", 5, 750);

        assertFalse(result);
        verify(paymentGateway, never()).pay(750);
        verify(inventoryRepository, never()).reduceStock("P200", 5);
    }
}
