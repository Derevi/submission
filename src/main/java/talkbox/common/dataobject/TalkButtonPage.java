package talkbox.common.dataobject;

import java.util.ArrayList;

public class TalkButtonPage {
    private ArrayList<ArrayList<TalkButton>> page;
    private int buttonSize;
    private String pageName;

    public TalkButtonPage(String pageName, int buttonSize){
        this(pageName);
        this.buttonSize = buttonSize;
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

    public void setbuttonSize(int buttonSize){
        if(buttonSize>150 || buttonSize<10){
            //TODO throw error for above max size
            //TODO throw error for min size
        }
        this.buttonSize = buttonSize;
    }

    public void add(ArrayList<TalkButton> row){
        page.add(row);
    }

    public ArrayList<ArrayList<TalkButton>> getPage(){
        return page;
    }
}
