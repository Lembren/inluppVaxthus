package MainFolder.Controllers;

import Models.Response;
import Repositories.IVäxhusdataDAO;
import Repositories.VäxthusDataSerPersist;
import Models.VäxthusData;
import Repositories.VäxthusdataDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VäxthusController {
    IVäxhusdataDAO VD = new VäxthusDataSerPersist();
    VäxthusdataDAO vd = new VäxthusdataDAO();
    List<VäxthusData> växthusDataList = vd.getAllData();


    @RequestMapping("/")
    public String index() {
        return "Välkommen till mitt Växthus!";
    }

    @RequestMapping("/luftfuktighet/senaste")
    public float senasteLuftfuktighet() {
        return växthusDataList.get(växthusDataList.size() - 1).getLuftfuktighet();
    }

    @RequestMapping("/temperatur/senaste")
    public float senasteTemperature() {
        return växthusDataList.get(växthusDataList.size() - 1).getTemperatur();
    }

    @RequestMapping("/belysning/senaste")
    public float senasteBelysning() {
        return växthusDataList.get(växthusDataList.size() - 1).getBelysning();
    }

    @RequestMapping("/el/dygn")
    public float senasteElförbrukning() {
        return växthusDataList.get(växthusDataList.size() - 1).getElförbrukning();

    }

    @RequestMapping("vhus/data")
    public String allData() {
        String res = "";
        for (VäxthusData VD : växthusDataList) {
            res += "Id: " + VD.getId() + "\n" +
                    "Temperatur: " + VD.getTemperatur() + "\n" +
                    "Luftfuktighet: " + VD.getLuftfuktighet() + "\n" +
                    "Ljusstyrka: " + VD.getBelysning() + "\n" +
                    "Elkostnad: " + VD.getElförbrukning() + "\n" +
                    "Tid: " + VD.getTimeStamp()+"\n";
        }
        return res;
    }

    @RequestMapping("vhus/data/senaste")
    public String allDataSenaste() {
        String res = "";
        res += "Id: " + växthusDataList.get(växthusDataList.size() - 1).getId() + "\n" +
                "Temperatur: " + växthusDataList.get(växthusDataList.size() - 1).getTemperatur() + "\n" +
                "Luftfuktighet: " + växthusDataList.get(växthusDataList.size() - 1).getLuftfuktighet() + "\n" +
                "Ljusstyrka: " + växthusDataList.get(växthusDataList.size() - 1).getBelysning() + "\n" +
                "Elkostnad: " + växthusDataList.get(växthusDataList.size() - 1).getElförbrukning() + "\n" +
                "Tid: " + växthusDataList.get(växthusDataList.size()-1).getTimeStamp()+"\n";
        return res;
    }

    @RequestMapping("rapport/luftfuktighet")
    public String rapportLuftfuktighet () {
        String res = "Senaste veckans avläsningar utav luftfuktighet: \n";
        double total = 0;
        for(int i = 1; i < 8; i++){
            VäxthusData VD = växthusDataList.get(växthusDataList.size() - i);
            total += VD.getLuftfuktighet();
            res += "Id: " + VD.getId() + ", ljusstyrka vid avläsning: " + VD.getLuftfuktighet() +" datum: " + VD.getTimeStamp() + "\n";
        }
        String average = String.format("%.00f", (total/7));

        res += "\nSnittet för veckans luftfuktighet har varit: " + average;
        return res;
    }

    @RequestMapping("rapport/temperatur")
    public String rapportTemperatur() {
        String res = "Senaste veckans avläsningar utav temperatur: \n";
        double total = 0;
        for(int i = 1; i < 8; i++){
            VäxthusData VD = växthusDataList.get(växthusDataList.size() - i);
            total += VD.getTemperatur();
            res += "Id: " + VD.getId() + ", temperatur vid avläsning: " + VD.getTemperatur() +" datum: " + VD.getTimeStamp() + "\n";
        }
        String average = String.format("%.00f", (total/7));

        res += "\nSnittet för veckans temperatur har varit: " + average;
        return res;
    }

    @RequestMapping("rapport/belysning")
    public String rapportBelysning() {
        String res = "Senaste veckans avläsningar utav belysning: \n";
        double total = 0;
        for(int i = 1; i < 8; i++){
            VäxthusData VD = växthusDataList.get(växthusDataList.size() - i);
            total += VD.getBelysning();
            res += "Id: " + VD.getId() + ", belysning vid avläsning: " + VD.getBelysning() +" datum: " + VD.getTimeStamp() + "\n";
        }
        String average = String.format("%.00f", (total/7));
        res += "\nSnittet för veckans belysning har varit: " + average;
        return res;
    }
    @RequestMapping("elkostnad")
    public String elKostnad(@RequestParam int kostnad) {
        VäxthusData VD = new VäxthusData();
        int sum = 0;
        for(int i=1;i<8;i++){
            VD = växthusDataList.get(växthusDataList.size()-i);
            sum += VD.getElförbrukning();
        }
        int kost = (sum / 7)* kostnad;
        String s = String.valueOf(kost);
        return s;
    }

    @PostMapping("/vaxthus/add")
    public Response växthusAdd(@RequestBody VäxthusData v){
        System.out.println(v.getId()+" "+v.getLuftfuktighet()+" "+v.getTemperatur()+" "+v.getBelysning()+" "+v.getElförbrukning()+" "+v.getTimeStamp());
        Response res = new Response("Ny dags data tillagd", Boolean.FALSE);
       växthusDataList.add(v);

       res.setStatus(Boolean.TRUE);
       VD.persistVäxthusData(växthusDataList);
       return res;
   }



}






