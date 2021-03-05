package net.largem.java101.mock101;

public class ProductServiceImpl implements ProductService {

    private final ExternalService externalService;

    public ProductServiceImpl(ExternalService externalService) {
        this.externalService = externalService;
    }

    @Override
    public String prodFunc(String arg) {
        return supportFunc(arg);
    }

    private String supportFunc(String arg) {
        return externalService.getValue(arg);
    }
}
