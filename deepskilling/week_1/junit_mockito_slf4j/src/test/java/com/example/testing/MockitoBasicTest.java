package com.example.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MockitoBasicTest {
    @Mock
    private ExternalApi externalApi;

    @Test
    void testMockingAndStubbing() {
        when(externalApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(externalApi);

        assertEquals("Mock Data", service.fetchData());
        verify(externalApi).getData();
    }
}
