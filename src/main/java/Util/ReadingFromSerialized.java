package Util;

import Models.VäxthusData;

import java.util.ArrayList;
import java.util.List;

public class ReadingFromSerialized {


    public static void main(String[] args) {
        SerializationManager sm  = new SerializationManager();
        List<VäxthusData> växthusDataList = new ArrayList<>();
        växthusDataList = (List<VäxthusData>)sm.deSerializeList("C:\\Users\\Lembr\\Downloads\\Inlämningsuppgiftväxthus\\src\\main\\java\\Repositories/växthusdata.ser");
        växthusDataList.forEach(b-> System.out.println("Id: "+b.getId()+"\nLuftfuktighet: "+ b.getLuftfuktighet()+"\nBelysning: " +b.getBelysning()+"\nTemperatur "+b.getTemperatur()+" tid: "+b.getTimeStamp()));
    }

}
