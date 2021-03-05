package net.largem.java101.mock101;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "net.largem.java101.mock101.*")
public class ProductServiceImplPowermockTest {
    private static final String TEST_VALUE = "TEST_VALUE";

    @Test
    public void prodFunc_mockPrivateMethod() throws Exception {
        ExternalService externalService = mock(ExternalService.class);

        ProductService productService = spy(new ProductServiceImpl(externalService));
        doReturn(TEST_VALUE).when(productService, "supportFunc", anyString());

        assertEquals(TEST_VALUE, productService.prodFunc("abc"));
    }
}
