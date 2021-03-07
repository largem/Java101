package net.largem.java101.mock101;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

//Need PowerMockRunner to run test with special mock (such as static mock, private mock,etc)
//Also need PrepareForTest
@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "net.largem.java101.mock101.*")
public class ProductServiceImplTest {

    private static final String TEST_VALUE = "TEST_VALUE";

    @Test
    public void prodFunc_mockExternalService() {
        //This test does not require PowerMock, so use either Mockito or PowerMock will work
        ExternalService externalService = Mockito.mock(ExternalService.class);

        ProductService productService = new ProductServiceImpl(externalService);
        Mockito.doReturn(TEST_VALUE).when(externalService).getValue(Mockito.anyString());

        assertEquals(TEST_VALUE, productService.prodFunc("abc"));
    }

    @Test
    public void prodFunc_mockPrivateMethod() throws Exception {
        ExternalService externalService = Mockito.mock(ExternalService.class);
        //The following mock is also work.
        //ExternalService externalService = PowerMockito.mock(ExternalService.class);

        //The following mock must use PowerMock.
        ProductService productService = PowerMockito.spy(new ProductServiceImpl(externalService));
        PowerMockito.doReturn(TEST_VALUE).when(productService, "supportFunc", Mockito.anyString());

        assertEquals(TEST_VALUE, productService.prodFunc("abc"));
    }
}