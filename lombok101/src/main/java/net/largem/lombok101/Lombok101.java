package net.largem.lombok101;

public class Lombok101 {

    public static void main(String[] args) {
        final DataPOJO dataPOJO = new DataPOJO(100L, "MyName");

        System.out.println(dataPOJO.getAnotherId());
        dataPOJO.setName(null);

        System.out.println(dataPOJO);
    }
}
