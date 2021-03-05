package net.largem.java101.mock101;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "net.largem.java101.mock101.*")
public class ProductServiceImplMockitoTest {

    private static final String TEST_VALUE = "TEST_VALUE";

    @Test
    public void prodFunc_mockExternalService() {
        ExternalService externalService = Mockito.mock(ExternalService.class);

        ProductService productService = new ProductServiceImpl(externalService);
        Mockito.doReturn(TEST_VALUE).when(externalService).getValue(anyString());

        assertEquals(TEST_VALUE, productService.prodFunc("abc"));
    }

    @Test
    public void prodFunc_mockPrivateMethod() throws Exception {
        ExternalService externalService = PowerMockito.mock(ExternalService.class);

        ProductService productService = PowerMockito.spy(new ProductServiceImpl(externalService));
        PowerMockito.doReturn(TEST_VALUE).when(productService, "supportFunc", anyString());

        assertEquals(TEST_VALUE, productService.prodFunc("abc"));
    }
}