package talkbox.toberemoved;

import talkbox.common.service.TalkBoxConfiguration;

import java.nio.file.Path;

public class TalkBoxDeviceConfiguration {
/*
    TalkButtonCatalog catalog;

    public TalkBoxDeviceConfiguration(TalkButtonCatalog catalog){
        this.catalog = catalog;
    }

    @Override
    public int getNumberOfAudioButtons() {
        return catalog.totalAudioButtons();
    }

    @Override
    public int getNumberOfAudioSets() {
        return  catalog.size();
    }

    @Override
    public int getTotalNumberOfButtons() {
        return catalog.totalButtons();
    }

    @Override
    public Path getRelativePathToAudioFiles() {
        return null;
    }

    @Override
    public String[][] getAudioFileNames() {
        int i= 0;
        String[][] allAudioFileNames = new String[getNumberOfAudioSets()][getNumberOfAudioButtons()+1];
        for(String name: catalog.getTalkButtonCatalogKeys()){
            int j = 1;
            allAudioFileNames[i][j] = name;
            i++;
            for(TalkButton talkButton: catalog.getTalkButtonInventory(name).getTalkButtons()){
                allAudioFileNames[i][j] = talkButton.getName();
            }
        }

        return allAudioFileNames;
    }
    */
}
