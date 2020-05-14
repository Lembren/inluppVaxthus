import java.io.Serializable;
import java.time.LocalDateTime;

public class VäxthusData implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private float luftfuktighet;
    private float temperatur;
    private float belysning;
    private int elförbrukning;
    private String timeStamp;


    public VäxthusData(int id, float luftfuktighet, float temperatur, float belysning, int elförbrukning, String timeStamp) {
        this.id = id;
        this.luftfuktighet = luftfuktighet;
        this.temperatur = temperatur;
        this.belysning = belysning;
        this.elförbrukning = elförbrukning;
        this.timeStamp = timeStamp;
    }
//
//    public VäxthusData(int id, float luftfuktighet, float temperatur, float belysning, float elförbrukning) {
//        this.id=id;
//        this.luftfuktighet=luftfuktighet;
//        this.temperatur=temperatur;
//        this.belysning=belysning;
//        this.elförbrukning=elförbrukning;
//
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLuftfuktighet() {
        return luftfuktighet;
    }

    public void setLuftfuktighet(float luftfuktighet) {
        this.luftfuktighet = luftfuktighet;
    }

    public float getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(float temperatur) {
        this.temperatur = temperatur;
    }

    public float getBelysning() {
        return belysning;
    }

    public void setBelysning(float belysning) {
        this.belysning = belysning;
    }

    public int getElförbrukning() {
        return elförbrukning;
    }

    public void setElförbrukning(int elförbrukning) {
        this.elförbrukning = elförbrukning;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
