package net.largem.poc.strongtype;

public final class ServiceRequest extends ServiceMessage {

  private final String request;

  public ServiceRequest(String request) {
    super(MessageOperation.FORWARD);
    this.request = request;
  }

  @Override
  Object getValue() {
    return request;
  }
}
