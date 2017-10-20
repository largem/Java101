package net.largem.poc.strongtype;

public class OtherServiceMessage extends ServiceMessage {

  public OtherServiceMessage() {
    super(MessageOperation.FORWARD);
  }

  @Override
  Object getValue() {
    return null;
  }
}
