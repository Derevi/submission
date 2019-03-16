package talkbox.common.dataobject;

import javafx.scene.control.Button;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;

//Sets all parameters of of button
public class TalkButtonPage {
    private ArrayList<ArrayList<TalkButton>> page;
    private int buttonSize;
    private String pageName;
    private String audioFilePath;


    public TalkButtonPage(String pageName, int buttonSize){
        this(pageName);
        this.buttonSize = buttonSize;
    }


    public TalkButtonPage(String pageName){
        this.page = new ArrayList<>();
        this.pageName = pageName;
    }

    public String getPageName(){
        if(pageName.isEmpty()){
            //TODO throw error for null
        }
        String clone = new String(this.pageName);
        return clone;
    }

    public void setPageName(String pageName){
        if(pageName.isEmpty()){
            //TODO throw error for null
        }
        this.pageName = pageName;
    }

    public void setButtonSizeForPage(int buttonSize){
        if(buttonSize>150 || buttonSize<10){
            //TODO throw error for above max size
            //TODO throw error for min size
        }
        this.buttonSize = buttonSize;
        for( ArrayList<TalkButton> talkButtonRow : page){
              for(TalkButton talkButton: talkButtonRow){
                  talkButton.setButtonSize(buttonSize);
              }
        }
    }

    public void addRow(ArrayList<TalkButton> row){
        page.add(row);
    }

    public void addRow(){
        page.add(new ArrayList<>());
    }



    public ArrayList<TalkButton> getButtonRow(int row){

        ArrayList<TalkButton> clone = (ArrayList<TalkButton>)page.get(row).clone();
        return clone;
        /*
        return (ArrayList<TalkButton>) page.get(row).stream()
                .map(TalkButton::new)
                .collect(Collectors.toList());
*/
    }





    public ArrayList<ArrayList<TalkButton>> getPage(){
        ArrayList<ArrayList<TalkButton>> clone = (ArrayList<ArrayList<TalkButton>>)page.clone();
        return clone;

        /*
        return (ArrayList<ArrayList<TalkButton>>)this.page.stream()
                .map(t -> t.stream()
                        .map(TalkButton::new)
                        .collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toList());
                */
    }

    public void addButtonToRow(int row, String talkButtonName){
       page.get(row).add(new TalkButton(talkButtonName,buttonSize));
    }

    public void deleteButton(int row, int column){
        page.get(row).remove(column);
    }


    public void setPageImageRootDirectory(File imageDirectory){
        //TODO set directory from where images are pulled
    }

    public void setPageAudioFileRootDirectory(File audioFileDirectory){
        //TODO set directory from where audio are pulled
    }


}
