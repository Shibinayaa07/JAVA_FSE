package com.example.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MockitoAdvancedTest {
    @Mock
    private ExternalApi externalApi;

    @Test
    void testVerifyInteractionCount() {
        MyService service = new MyService(externalApi);

        service.fetchData();
        service.fetchData();

        verify(externalApi, times(2)).getData();
        verify(externalApi, never()).saveData("test");
    }

    @Test
    void testArgumentCaptor() {
        MyService service = new MyService(externalApi);

        service.processAndSave("  hello  ");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(externalApi).saveData(captor.capture());
        assertEquals("HELLO", captor.getValue());
    }

    @Test
    void testArgumentMatcher() {
        MyService service = new MyService(externalApi);
        service.processAndSave("done");

        verify(externalApi).saveData(eq("DONE"));
    }
}
