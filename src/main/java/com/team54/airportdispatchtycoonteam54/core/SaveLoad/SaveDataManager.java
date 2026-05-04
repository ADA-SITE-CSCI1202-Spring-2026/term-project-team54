package com.team54.airportdispatchtycoonteam54.core.SaveLoad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveDataManager {

    public static void save(SaveData saveData) throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.dat"));
        out.writeObject(saveData);
        out.close();
    }

    public static SaveData load() throws IOException, ClassNotFoundException{
        if(!(new File("save.dat")).exists()) return null;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("save.dat"));
        SaveData save = (SaveData) in.readObject();
        in.close();
        return save;
    }

    /**
     * Used when the 'start over' button is pressed
     */
    public static SaveData loadInitialState() throws IOException, ClassNotFoundException{
        if(!(new File("initial_state.dat")).exists()) return null;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("initial_state.dat"));
        SaveData save = (SaveData) in.readObject();
        in.close();
        return save;
    }
}
