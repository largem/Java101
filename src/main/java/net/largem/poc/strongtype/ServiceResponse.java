package net.largem.poc.strongtype;

public final class ServiceResponse extends ServiceMessage {

  private final Object response;

  public ServiceResponse(Object response) {
    super(MessageOperation.RETURN);
    this.response = response;
  }

  @Override
  Object getValue() {
    return response;
  }
}
