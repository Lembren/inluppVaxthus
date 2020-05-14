package Repositories;

import Models.VäxthusData;


import java.util.List;

public interface IVäxhusdataDAO {
        public List<VäxthusData> getAllData();
        public void persistVäxthusData(List<VäxthusData> växthusDataList);
}
