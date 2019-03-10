package talkbox.common.dataobject;

import javafx.scene.control.Button;

import java.util.ArrayList;
//Sets all parameters of of button
public class TalkButtonPage {
    private ArrayList<ArrayList<TalkButton>> page;
    private int buttonSize;
    private String pageName;
    private String audioFilePath;


    public TalkButtonPage(String pageName, int buttonSize){
        this(pageName);
        this.buttonSize = 130;
    }


    public TalkButtonPage(String pageName){
        this.page = new ArrayList<>();
        this.pageName = pageName;
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

    public ArrayList<TalkButton> getButtonRow(int row){
        ArrayList<TalkButton> clone = (ArrayList<TalkButton>)page.get(row).clone();
        return page.get(row);
    }

    public ArrayList<ArrayList<TalkButton>> getPage(){
        ArrayList<ArrayList<TalkButton>> clone = (ArrayList<ArrayList<TalkButton>>)page.clone();
        return clone;
    }

    public void addButtonToRow(int row, String talkButtonName){
       page.get(row).add(new TalkButton(talkButtonName,buttonSize));
    }

    public void deleteButton(int row, int column){
        page.get(row).remove(column);
    }

    public void setAudioFilePath(String audioFilePath){
        this.audioFilePath = audioFilePath;
    }


}
