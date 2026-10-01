package model;

public enum Type {
    FIRE("Fire")
    ,WATER("Water"),
    GRASS("Grass"),
    ELECTRIC("Electric")
    ,NORMAL("Normal");

    private final String lable;

    Type(String lable){
        this.lable = lable;
    }
    public String getLable(){
        return lable;
    }

}
