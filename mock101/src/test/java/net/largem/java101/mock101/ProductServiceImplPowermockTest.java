package net.largem.java101.mock101;

import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;

//  If the mocking can be done by Mockito as well, PowerMock can fully cover but no need to use
//+ PowerMockRunner.
public class ProductServiceImplPowermockTest {
    private static final String TEST_VALUE = "TEST_VALUE";

    @Test
    public void prodFunc_mockExternalService() {
        ExternalService externalService = PowerMockito.mock(ExternalService.class);

        ProductService productService = new ProductServiceImpl(externalService);
        PowerMockito.doReturn(TEST_VALUE).when(externalService).getValue(Mockito.anyString());

        assertEquals(TEST_VALUE, productService.prodFunc("abc"));
    }
}
