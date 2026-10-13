package repository;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;


public class PokeData {
    public static final ArrayList<Pokemon> pokeDataSeed() {
        ArrayList<Pokemon> pokeDataSeed = new ArrayList<>();
        //😺🦊🐸🐋🐹🐮
        Pokemon pikachu = new Pokemon("\uD83D\uDE3A Pikachu", Type.ELECTRIC, 140, 140);
        pikachu.addAttack(new DamageAttack("Thunderbolt", 60, 80, Type.ELECTRIC));
        pikachu.addAttack(new DamageAttack("Quick attack", 40, 90, Type.NORMAL));

        Pokemon charmander = new Pokemon("\uD83E\uDD8A Charmander", Type.FIRE, 140, 140);
        charmander.addAttack(new DamageAttack("Ember", 60, 90, Type.FIRE));
        charmander.addAttack(new DamageAttack("Tail whip", 50, 85, Type.NORMAL));

        Pokemon squirtle = new Pokemon("\uD83D\uDC0B Squirtle", Type.WATER, 140, 140);
        squirtle.addAttack(new DamageAttack("Water gun", 60, 90, Type.WATER));
        squirtle.addAttack(new DamageAttack("Tackle", 45, 90, Type.NORMAL));

        Pokemon bulbasaur = new Pokemon("\uD83D\uDC38 Bulbasaur", Type.GRASS, 140, 140);
        bulbasaur.addAttack(new DamageAttack("Vine whip", 65, 90, Type.GRASS));
        bulbasaur.addAttack(new DamageAttack("Tackle", 45, 90, Type.NORMAL));

        Pokemon eevee = new Pokemon("\uD83D\uDC39 Eevee", Type.NORMAL, 150, 150);
        eevee.addAttack(new DamageAttack("Tackle", 40, 90, Type.NORMAL));
        eevee.addAttack(new DamageAttack("Quick attack", 40, 90, Type.NORMAL));

        Pokemon snorlax = new Pokemon("\uD83D\uDC2E Snorlax", Type.NORMAL, 200, 200);
        snorlax.addAttack(new DamageAttack("Body slam", 85, 75, Type.NORMAL));
        snorlax.addAttack(new DamageAttack("Tackle", 45, 90, Type.NORMAL));


        pokeDataSeed.addAll(Arrays.asList(pikachu, charmander, squirtle, bulbasaur, eevee, snorlax));
        return pokeDataSeed;
    }

    public static final ArrayList<Pokemon> wildPokeData() {
        ArrayList<Pokemon> wildPokeList = new ArrayList<>();
        //🐭🐺🌱🪿🐯
        Pokemon rattata = new Pokemon("\uD83D\uDC2D Rattata", Type.NORMAL, 130, 130);
        rattata.addAttack(new DamageAttack("Bite", 45, 80, Type.NORMAL));
        rattata.addAttack(new DamageAttack("Tail whip", 35, 80, Type.NORMAL));

        Pokemon wulpix = new Pokemon("\uD83D\uDC3A Wulpix", Type.FIRE, 140, 140);
        wulpix.addAttack(new DamageAttack("Fire burst", 60, 75, Type.FIRE));
        wulpix.addAttack(new DamageAttack("Slash", 45, 85, Type.NORMAL));

        Pokemon oddish = new Pokemon("\uD83C\uDF31 Oddish", Type.GRASS, 130, 130);
        oddish.addAttack(new DamageAttack("Vine whip", 50, 75, Type.GRASS));
        oddish.addAttack(new DamageAttack("Slam", 40, 80, Type.NORMAL));

        Pokemon psyduck = new Pokemon("\uD83E\uDEBF Psyduck", Type.WATER, 140, 140);
        psyduck.addAttack(new DamageAttack("Water beam", 50, 80, Type.WATER));
        psyduck.addAttack(new DamageAttack("Bite", 40, 80, Type.NORMAL));

        Pokemon electabuzz = new Pokemon("\uD83D\uDC2F Electabuzz", Type.ELECTRIC, 160, 160);
        electabuzz.addAttack(new DamageAttack("Thunder strike", 60, 85, Type.ELECTRIC));
        electabuzz.addAttack(new DamageAttack("Slash", 40, 90, Type.NORMAL));

        wildPokeList.addAll(Arrays.asList(rattata, wulpix, oddish, psyduck, electabuzz));
        return wildPokeList;
    }
}

