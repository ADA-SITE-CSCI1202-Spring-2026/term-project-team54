package com.team54.airportdispatchtycoonteam54.core.SaveLoad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class SaveDataManager {

    
    public static void save(SaveData saveResources) throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.dat"));
        out.writeObject(saveResources);
        out.close();

    }


    public static SaveData load() throws IOException, ClassNotFoundException{
        // ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.dat"));

        if((new File("save.dat")).exists())return null;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("save.dat"));
        SaveData save = (SaveData) in.readObject();
        in.close();
        return save;

    }
}
