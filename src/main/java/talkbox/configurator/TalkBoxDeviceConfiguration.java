package talkbox.configurator;

import talkbox.gui.TalkButton;
import java.nio.file.Path;

public class TalkBoxDeviceConfiguration implements TalkBoxConfiguration {

    ButtonInventoryCatalog catalog;

    public TalkBoxDeviceConfiguration(ButtonInventoryCatalog catalog){
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
        for(String name: catalog.getKeys()){
            int j = 1;
            allAudioFileNames[i][j] = name;
            i++;
            for(TalkButton talkButton: catalog.getButtonInventory(name).getTalkButtons()){
                allAudioFileNames[i][j] = talkButton.getName();
            }
        }

        return allAudioFileNames;
    }
}
