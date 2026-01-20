package com.example.service;

import com.example.model.Order;
import com.example.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setup() {
        // executed before each test
    }

    @Test
    @DisplayName("Should calculate total successfully")
    void shouldCalculateTotalSuccessfully() {
        double result = orderService.calculateTotal(100, 2);
        assertEquals(200, result);
    }

    @Test
    @DisplayName("Should throw exception for invalid input")
    void shouldThrowExceptionForInvalidInput() {
        assertThrows(IllegalArgumentException.class,
                () -> orderService.calculateTotal(-10, 2));
    }

    @Test
    @DisplayName("Should place order successfully")
    void shouldPlaceOrderSuccessfully() {
        Order mockOrder = new Order(100, 2);

        when(orderRepository.save(any(Order.class)))
                .thenReturn(mockOrder);

        Order savedOrder = orderService.placeOrder(100, 2);

        assertNotNull(savedOrder);
        assertEquals(100, savedOrder.getPrice());
        assertEquals(2, savedOrder.getQuantity());

        verify(orderRepository, times(1))
                .save(any(Order.class));
    }

    @Test
    @DisplayName("Should not save order when input is invalid")
    void shouldNotSaveOrderWhenInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> orderService.placeOrder(0, 1));

        verify(orderRepository, never()).save(any());
    }
}
