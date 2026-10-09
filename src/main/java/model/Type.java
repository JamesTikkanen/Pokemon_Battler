package model;
//🔥💧🥬✊⚡
public enum Type {
    FIRE("Fire \uD83D\uDD25,", true),
    WATER("Water \uD83D\uDCA7", true),
    GRASS("Grass \uD83E\uDD6C", true),
    ELECTRIC("Electric ⚡",true),
    NORMAL("Normal ✊",false);

    private final String lable;
    private final Boolean normal;

    Type(String lable, boolean normal){
        this.lable = lable;
        this.normal = normal;

    }

    public String getLable(){
        return lable;
    }

    public Boolean getNormal(){return normal;}

}
