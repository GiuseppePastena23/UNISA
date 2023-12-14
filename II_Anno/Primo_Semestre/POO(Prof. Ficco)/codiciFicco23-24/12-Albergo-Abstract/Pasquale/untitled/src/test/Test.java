package test;
import cliente.*;
import albergo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Cliente[] famiglia = new Cliente[3];
        famiglia[0] = new Adulto("Mario", "Rossi", "ABC123");
        famiglia[1] = new Ragazzo("Luigi", "Rossi", "XYZ321");
        famiglia[2] = new Bambino("Wario", "Rossi", 8, "Mario", "fghjkl");

        ExtraLusso ext = new ExtraLusso(707, 200.0f);
        ext.riempiCamera(famiglia);
        ext.printInfo();
        ext.pulisci();
        ext.accendiTV();
        ext.svuotaCamera();
/*
        List<Cliente> famiglia2 = new ArrayList<>();
        famiglia2.add(new Adulto("AAA", "BBB", "QWERTY"));
        famiglia2.add(new Ragazzo("CCC", "DDD", "POIUY"));
        famiglia2.add(new Bambino("EEE", "FFF", 8, "Mario", "fghjkl"));
        Cliente[] arr = (Cliente[]) famiglia2.toArray();
        ext.riempiCamera(arr);

 */

    }
}
