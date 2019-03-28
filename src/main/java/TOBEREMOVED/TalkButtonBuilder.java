package TOBEREMOVED;

import java.io.File;

public class TalkButtonBuilder {
        public static class Builder{
            private String name;
            private File image;
            private File audio;



            public Builder withName(String name) {
                this.name = name;
                return this;
            }

            public Builder withImage(File image){
                //TODO IF FILE IS NOT OF TYPE AUDIO THROW ERROR
                this.image = image;
                return this;
            }

            public Builder withAudio(File audio){
                //TODO IF FILE IS NOT OF TYPE AUDIO THROW ERROR
                this.audio = audio;
                return this;
            }

        }


}
