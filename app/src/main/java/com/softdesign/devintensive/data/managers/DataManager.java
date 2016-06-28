package com.softdesign.devintensive.data.managers;


public class DataManager {
    private static DataManager INSTANSE = null;
    private PreferencesManager mPreferencesManager;

    public static DataManager getInstance(){
        if(INSTANSE == null){
            INSTANSE = new DataManager();
        }
        return INSTANSE;
    }
}
