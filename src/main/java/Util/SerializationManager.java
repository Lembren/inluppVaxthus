package Util;

import Models.VäxthusData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationManager {


    public void SerializeList(List<VäxthusData> list, String filePath){
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);){

            objectOut.writeObject(list);
            System.out.printf("Värdena sparade i %s\n",filePath);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public List<VäxthusData> deSerializeList(String filePath){
        System.out.println("deSerializeList "+ filePath);
        List<VäxthusData>list = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn);){

            list = (List<VäxthusData>) in.readObject();
            System.out.println("deSerialize " + list.size()+" Värden");
            return list;
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Något gick fel");
        }
        catch (ClassNotFoundException e){
            System.out.println("Växthusdata okänd klass");
        }
        return list;
    }

}
