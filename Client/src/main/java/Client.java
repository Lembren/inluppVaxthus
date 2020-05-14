import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Client {



    private static String getData(){
        final String url = "http://localhost:8080/vhus/data";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return result;
    }

    private static String senasteBelysning(){
        final String url = "http://localhost:8080/belysning/senaste.xml";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("Belysning: "+ result);
        return result;
    }

    private static String senasteTemperatur(){
        final String url = "http://localhost:8080/temperatur/senaste.xml";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("Temperatur: "+ result);
        return result;
    }

    private static String senasteLuftfuktigheten(){
        final String url = "http://localhost:8080/luftfuktighet/senaste.xml";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("Luftfuktighet: "+ result);
        return result;
    }

    private static String elFörbrukningDygn(){
        final String url = "http://localhost:8080/el/dygn.xml";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("Elförbrukning dygn: "+ result);
        return result;
    }

    private static String getDataSenaste(){
        final String url = "http://localhost:8080/vhus/data/senaste";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return result;
    }

    private static String rapportLuftfuktighet(){
        final String url = "http://localhost:8080/rapport/luftfuktighet";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return result;
    }

    private static String rapportTemperatur(){
        final String url = "http://localhost:8080/rapport/temperatur";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return result;
    }

    private static String rapportBelysning(){
        final String url = "http://localhost:8080/rapport/belysning";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return result;
    }
    public static void elKostnad(int kostnad) {
        final String uri = "http://localhost:8080/elkostnad?kostnad={kostnad}";
        Map<String, Integer> params = new HashMap<>();
        params.put("kostnad",kostnad);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class,params);
        System.out.println(result);
    }


    private static void createData(int id, float luftfuktighet, float temperatur, float belysning, int elförbrukning, String timeStamp)
    {
        final String uri = "http://localhost:8080/vaxthus/add";
        VäxthusData nyData = new VäxthusData(id,luftfuktighet,temperatur,belysning,elförbrukning,timeStamp);
        RestTemplate restTemplate = new RestTemplate();
        Response result = restTemplate.postForObject( uri, nyData, Response.class);
        System.out.println(result.getMessage());
    }




    public static void main(String[] args) {
 //       getData();
       senasteBelysning();
        senasteLuftfuktigheten();
        senasteTemperatur();
        elFörbrukningDygn();
        getDataSenaste();
        rapportLuftfuktighet();
        rapportTemperatur();
        rapportBelysning();
        createData(10,20,30,50,2000,"2020-5-9 20:45");
        getData();
        elKostnad(500);

    }
}
