package Repositories;

import Models.VäxthusData;
import Util.SerializationManager;

import java.util.ArrayList;
import java.util.List;

public class VäxthusDataSerPersist implements IVäxhusdataDAO {

        SerializationManager sm = new SerializationManager();
        List<VäxthusData> växthusDataList = new ArrayList<>();
        String VäxthusDataPath = "C:\\Users\\Lembr\\Downloads\\Inlämningsuppgiftväxthus\\src\\main\\java\\Repositories/växthusdata.ser";


    public List<VäxthusData> getAllData() {
        return  (List<VäxthusData>)sm.deSerializeList(VäxthusDataPath);
    }

    public void persistVäxthusData(List<VäxthusData> växthusDataList) {
        sm.SerializeList(växthusDataList, VäxthusDataPath);

    }
}
