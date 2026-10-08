package model;

public enum Type {
    FIRE("Fire", true),
    WATER("Water", true),
    GRASS("Grass", true),
    ELECTRIC("Electric",true),
    NORMAL("Normal",false);

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
