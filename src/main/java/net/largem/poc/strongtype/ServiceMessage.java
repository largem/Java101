package net.largem.poc.strongtype;

public abstract class ServiceMessage {

  private final MessageOperation operation;

  protected ServiceMessage(MessageOperation operation) {
    final String className = this.getClass().getName();
    if (className.equals(ServiceRequest.class.getName()) || className
        .equals(ServiceResponse.class.getName())) {
      this.operation = operation;
    } else {
      throw new RuntimeException("Can't extend ServiceMessage to " + className);
    }
  }

  public MessageOperation getOperation() {
    return operation;
  }

  abstract Object getValue();
}
