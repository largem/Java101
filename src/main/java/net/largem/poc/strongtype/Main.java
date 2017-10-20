package net.largem.poc.strongtype;

import javax.print.attribute.standard.MediaSize.Other;

public class Main {

  public static void main(String[] args) {
    final ServiceMessage serviceMessage = handle_forward("request will be forwarded");

    assert (serviceMessage.getOperation() == MessageOperation.FORWARD);

    //This is safe
    String request = (String) serviceMessage.getValue();

    new OtherServiceMessage();
  }

  private static ServiceMessage handle_forward(String request)
  {
    return new ServiceRequest(request);
  }

  private static ServiceMessage handle_return(String request)
  {
    return new ServiceResponse(100);
  }
}
