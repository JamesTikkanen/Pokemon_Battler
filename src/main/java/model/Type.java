package model;
//🔥💧🥬✊⚡
public enum Type {
    FIRE("Fire \uD83D\uDD25"),
    WATER("Water \uD83D\uDCA7"),
    GRASS("Grass \uD83E\uDD6C"),
    ELECTRIC("Electric ⚡"),
    NORMAL("Normal ✊");

    private final String label;

    Type(String label){
        this.label = label;
    }
    public String getLable(){
        return label;
    }
}
