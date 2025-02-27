package Util;

import Models.VäxthusData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CreateSerializedFile {
    LocalDateTime ldt = LocalDateTime.now();
    SerializationManager sm = new SerializationManager();
    List<VäxthusData> växthusDataList = new ArrayList<>();

    CreateSerializedFile(){

        VäxthusData dag1 = new VäxthusData(1, 50, 20, 100, 2045,"2020-5-1,15:30");
        VäxthusData dag2 = new VäxthusData(2, 48, 20, 100, 1000,"2020-5-2,15:30");
        VäxthusData dag3 = new VäxthusData(3, 49, 23, 150, 1252,"2020-5-3,15:00");
        VäxthusData dag4 = new VäxthusData(4, 48, 22, 147, 6326,"2020-5-4,20:30");
        VäxthusData dag5 = new VäxthusData(5, 48, 24, 150, 2512,"2020-5-5,20:45");
        VäxthusData dag6 = new VäxthusData(6, 47, 30, 200, 2521,"2020-5-6 20:30");
        VäxthusData dag7 = new VäxthusData(7, 47, 29, 190, 5251,"2020-5-7 20:14");
        VäxthusData dag8 = new VäxthusData(8, 50, 25, 170, 6321,"2020-5-8 20:10");


        växthusDataList.add(dag1);
        växthusDataList.add(dag2);
        växthusDataList.add(dag3);
        växthusDataList.add(dag4);
        växthusDataList.add(dag5);
        växthusDataList.add(dag6);
        växthusDataList.add(dag7);
        växthusDataList.add(dag8);

        sm.SerializeList(växthusDataList, "C:\\Users\\Lembr\\Downloads\\Inlämningsuppgiftväxthus\\src\\main\\java\\Repositories/växthusdata.ser");

    }

    public static void main(String[] args) {
        CreateSerializedFile c = new CreateSerializedFile();
    }

}
