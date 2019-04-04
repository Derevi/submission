package talkbox.common.dataobject;
import talkbox.common.service.TalkBoxConfiguration;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

public class TalkButtonCatalog implements Serializable, TalkBoxConfiguration {

    private LinkedHashMap<String, TalkButtonPage> catalog;
    private static final long serialVersionUID = 1L;

    public TalkButtonCatalog() {
        this.catalog = new LinkedHashMap<>();

    }

    public TalkButtonCatalog(LinkedHashMap<String, TalkButtonPage> catalog) {
        this.catalog = catalog;
    }

    public void addPage(String pageName, TalkButtonPage page){
        //TODO add max limit for page
        catalog.put(pageName,page);
    }

    public TalkButtonPage getPage(String pageName){
        return this.getCatalog().get(pageName);
    }

    public void addPage(String pageName, int buttonSize){
        //TODO add max limit for page
        catalog.put(pageName,new TalkButtonPage(pageName,buttonSize));
    }


    public void addPage(String pageName){
        //TODO add max limit for page
        catalog.put(pageName,new TalkButtonPage(pageName));
    }
    public void addPage(TalkButtonPage talkButtonPage){
        //TODO add max limit for page
        catalog.put(talkButtonPage.getPageName(),talkButtonPage);
    }

    public TalkButtonPage getTalkButtonPage(String pageName){
        return catalog.get(pageName);
    }

    public LinkedHashMap<String, TalkButtonPage> getCatalog(){
        return  ( LinkedHashMap<String, TalkButtonPage>) catalog.clone();
    }

    public void setTalkButtonPageButtonSize(String pageName, int size){
        this.catalog.get(pageName).setButtonSizeForPage(size);
    }

    public void setPageImageRootDirectory(String pageName, File imageDirectory){
        //TODO set directory from where images are pulled
    }

    public void setPageAudioFileRootDirectory(String pageName, File audioFileDirectory){
        //TODO set directory from where audio are pulled
    }

    @Override
    public int getNumberOfAudioButtons() {
        int count = 0;
        for(String s: getCatalog().keySet()){
           count = count + getCatalog().entrySet().size();
        }

        return count;

    }

    @Override
    public int getNumberOfAudioSets() {
        return getNumberOfAudioButtons() + getCatalog().keySet().size();
    }

    @Override
    public int getTotalNumberOfButtons() {
        return 0;
    }

    @Override
    public Path getRelativePathToAudioFiles() {
        return Paths.get("audio");
    }

    @Override
    public String[][] getAudioFileNames() {
        File audioFileParent = new File("audio");
        String audioFiles[][] = new String[0][audioFileParent.list().length];
        audioFiles[0] = audioFileParent.list();
        return audioFiles;
    }
}

