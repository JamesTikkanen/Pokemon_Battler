Pokémon Battler Project

Detta program är ett simpelt strids program mellan pokémons.
Man kan skapa pokémons, ge dom attacker och sedan strida mot andra pokémons man har sparade i sin pokédex eller mot en slumvald vild pokémon.
Man kan spara sin pokédex till en 'Pokedex.json' fil samt återställa den om man vill gå tillbaka till original listan.
Programmet är uppbyggt i två meny val. Den första är pokédex där man kan se, spara, skapa, ta bort pokémons.
Den andra är själva battlern där man strider med sina egna mot antingen en annan av sin egen eller mot en vild pokémon.
Man kan även läka alla sina pokémons in denna menyval.

---Pokédex Menu--- 

0 - Pokémon Battler

    - En egen meny för strider.

    0.1 - Wild Pokémon Battle 

        - Strid mot en slumpad vald pokémon från en lista av 6 unika varelser.

    0.2 - Pokédex Battle

        - Strid mellan två pokémons i sin egna pokédex so man själv väljer.

    0.3 - Heal All Pokèmon

        - Läker alla pokémons till full hälsa.

    0.4 - Exit Battler Menu

        - Återgår till pokédex menyval

    (Extra info)

    - Strider mellan pokémons slumpas i början av varje strid med ett 'Coin Toss' så det är en 50/50 chans vem det är som startar striden.

    - När en pokémon som man strider med tar skada i en strid återstår samma hälsa till nästa match om man inte läker sig i Battle Meny.

    - Efter varje strid sparas vinst och förlust för sina pokémons i en 'Stats.json' fil.

    - Man kan ej strida med en pokémon med noll hälsa eller noll attacker.

    - I strider är det en 2 sekunder vänta mellan varje attack för att det ska vara lättare att följa med stridens gång.

    - När man väljer att läka så läks alla pokémons inte en enskild.


1 - Show Pokémon

    - Visar alla pokémons i sin pokédex.

        (index plats i listan)

        (namn, typ, nuvarande hälsa / max hälsa)

        (vinster, förluster)

        (Attacker)

        (namn, typ, skada, träffsäkerhet)

    (extra info)

    - Lägger man till mer än fyra attacker i sin 'Pokedex.json' fil så visas endast dom fyra första.

    - Sparar man så försvinner dom attacker som inte visades.


2 - Add Pokémon 

    - Lägger till en pokémon och en attack i pokédex.

        (Pokémon)

        Namn - max 20 karaktärer och kan ej vara tom.

        Typ - eld, vatten, gräs, el, normal.

        Hälsa - mellan 1-200

        (Attack)

        Namn - max 20 karaktärer och kan ej vara tom.

        Typ - eld, vatten, gräs, el, normal.

        Skada - mellan 1-100.

        Träffsäkerhet - mellan 1-100.

    - Läggs sedan in i pokédex för strid men ej sparad i fil.

    (extra info)

    - Namn gräns på 20 karaktärer för att namn ej kan vara fär långa.

    - Skriver man fel i något så får man skriva igen så det ej blir inkorrekta pokémons.



3 - Add Attack

    - Lägg till en attack till en befintlig pokémon i pokédex.

    - Maxgräns för attacker är fyra, kan ej skapa flera efter det.

    (extra info)

    - Namn gräns på 20 karaktärer för att namn ej kan vara fär långa.

    - Skriver man fel i något så får man skriva igen så det ej blir inkorrekta pokémons.


4 - Search Pokemon

    - Sök efter en pokémon med ett namn för att finna ett lika i pokédex.

    (extra info)

    - Har man två pokémons med samma namn finner den endast den första i listan då det är en linjär sökning.


5 - Remove Pokémon

    - Välj en pokémon att ta bart från pokédex.

    (extra info)

    - Den pokémon man raderar kommer ha kvar sina stats

    - Skapar man en ny med samma namn eller återställer till original så finns vinster och förluster kvar.


6 - Save To File

    - Sparar pokédex till en 'Pokedex.json' fil.

    - Bra att använda om man stänger av spelet inkorrekt.

    (extra info)

    - Spara även om pokédex är tom.

    - Vinster och förluster sparas ej med detta val för att den gör det automatiskt efter varje strid.


7 - Load From File

    - Laddar fil från 'Pokedex.json' fil om det finns.

    (extra info)

    - Lite meningslös då i början av programstart laddas det redan fil om det finns.

    - Om fil ej finns så ladda 'Seed Data' i pokédex.


8 - Reset To Seed

    - Återställer pokédex till originala sex pokémons.

    (extra info)

    - Har man skapat pokékoms så försvinner dom om man återställer.

    - Sparas ej till fil, det måste göras manuellt.


9 - Exit Program

    - Avslutar program och sparar pokédex till fil.

    (extra info)

    - Vinster och förluster sparas separat i sin egna fil 'Stats.json'.


-------------------------------------------------------------------------


Jag har använt OOP, arv, polymorfism, json.


-Mappen 'inputcheck' 

Har jag lagt mina Exceptions klasser som jag också använde i förra uppgiften
och en klass Inputchecker för att säkra alla inputs i programmet.


-Mappen 'model' 

Har jag mina klasser Attack(samlar o ger data) som även är en basklass 
med DamageAttack(ansvarar för skada) som en subklass, Pokemon(samlar data, ger data, egna metoder), 
Stats(spara vinster och förluster), Type(fasta types).


-Mappen 'repository' 

Har klasser för data hantering till json fil. Klasserna AttackData och PokemonData 
skapades för att göra en funktionerande metod att ladda en json fil.

PokemonSeedData är för att ladda om pokédex till original och där har jag även vilda pokémons data.

StatsFile är för att spara och ladda vinster och förluster till specifika pokémons.

FileHandler är för att spara pokémons till en json fil och ladda från. Använder sig utav klasserna AttackData och PokemonData
för att spara då det inte gick med dom klasserna i model.


-Mappen 'ui'

Här finns menyvalen battleMenu och Main som går vidare till andra metoder och klasser


-Mappen 'utilities'

BattleEngine har det mesta stridslogiken samt cointoss som avgör vem som startar striden
Utilities har det mesta som att söka, skapa, ta bort pokemons som 'Main' menyn använder sig mycket utav.


VG-Krav

-Typ Effektivitet skapades med övningsuppgiften vi gjorde. 

Skada blir antingen 2x 1x eller 0.5x i effektivitet beroende på typ mot typ.


-JSON har jag använt för att spara och ladda filer och jag delade upp Stats.json(vinst/förlust + namn) från Pokedex.json(pokedex)
Dom sparas även lite annorlunda. Stats.json sparas direkt efter varje strid till ett namn och pokédex sparas om man själv 
väljer spara eller om man avslutar via menyn.


-Arv har jag använt med DamageAttack som ärver från Attack. För att attack har den samlade info om attacken medans DamageAttack 
ansvarar för hur skadan sker/utförs.


-Polymorfism användes när DamageAttack '@Override' metoden execute() som finns i Attack för att utföra sin egna metod.


(Han ej göra 'Critical hit' pga tidsbrist. Blev verkligen klar sista dagen och måste göra en annan inlämning för 
självledarskap som också lämnas in idag(fredag) som jag glömde bort. 
JUnit 5 tester och interface missades också men kanske testar göra det senare.

Jag kommer att förbättra koden efter inlämningen för att förbättra mina kunskaper men det kommer göras i en annan branch 
än mastern, om det går bra uppdaterar jag min master i framtiden.)

Tack o hej!