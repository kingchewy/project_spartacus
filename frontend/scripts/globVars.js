GlobVars = {
    Dialog: {
        greenqueen: [
            ["N", "<h1>Who the hell are YOU?</h1> Don't try to play me, I can tell, you are not from around 'Concrete Street'. No scars, no bruises, no smeares, no limping … just beauty at ease, and a child's naivity. You stick out like a glass of milk in the bar. So what's your name, darling?"],
            ["Y", "<input class='dialog-input' placeholder='Name your fighter!' for='enter-name' stat='name'>"
             + "<button class='dialog-btn' onclick= \"Dialog.setCharData(this, 'name')\" name='enter-name'>That's my name!</button>"],
            ["N", "*Name*? Well I've heard more frightening names. And what is it, that led you to this nasty place? You do know, where you are, right? You are in 'Concrete Street'. A bad place. An unsafe place. Especially for someone as pretty as you. You should turn on your toes, and sneak away, my little mouse, before someone not quite as friendly as me spots you."],
            ["Y", "I can look after myself, don’t worry. And you’ll feel it firsthand if you make fun of my name one more time."],
            ["N", "Ah yeah, you are a clone, right? I thought as much. I heard, that your people are quite touchy with names and stuff like that."],
            ["Y", "So why do you play with fire then?"],
            ["N", "Alright sorry! You’ve got quite the temper … So can you tell me now, what you are here for? I thought clones are created for military uses?"],
            ["Y", "Pha! You don’t honestly think I would accept someone else’s control of myself? I left with a bang, and am an outlaw now. So what better place to go than this?"],
            ["N", "That’s true. Well, now that you’re here, what’s next?"],
            ["Y", "Well what do you think? I was born to kill. I came to fight in the night. I came to rock the block. I’ll enter the ring, and leave with gold and fame, and I won’t leave before everyone knows my name: „The one and only! The green queen! *Name*.“"],
            ["N", "Oh really? Well what’s so spezial about you? There are other clones as well in „Concrete Street“, that fight for fame."],
            ["Y", "Never compare me to anyone, especially to a sibling. Don’t you dare. I’m unique, never question it."],
            ["Y", " I’ll tell you what I can cause!<br>"
             + "<input class='dialog-input' type='number' min='100' max='9000' step='50' value='100' for='enter-stats' stat='hp' placeholder='HP'>"
             + "<label>HP: </label><br>"
             + "<input class='dialog-input' type='number' min='1' max='9' step='0.2' value='1' for='enter-stats' stat='armor' placeholder='Armor'>"
             + "<label>Armor: </label><br>"
             + "<input class='dialog-input' type='number' min='1' max='9' step='0.2' value='1' for='enter-stats' stat='strength' placeholder='Strength'>"
             + "<label>Strength: </label><br>"
             + "<input class='dialog-input' type='number' min='1' max='10' step='0.2' value='1' for='enter-stats' stat='accuracy' placeholder='Accuracy'>"
             + "<label>Accuracy: </label><br>"
             + "<input class='dialog-input' type='number' min='0' max='10' step='0.2' value='0' for='enter-stats' stat='critChance' placeholder='Crit. Chance'>"
             + "<label>Critical Hit Chance: </label><br>"
             + "<input class='dialog-input' type='number' min='0' max='10' step='0.2' value='0' for='enter-stats' stat='agility' placeholder='Agility'>"
             + "<label>Agility: </label><br>"
            + "<button class='dialog-btn' onclick= \"Dialog.setCharData(this, 'hp armor strength accuracy critChance agility')\" name='enter-stats'>Done</button>"]],
        distroyerx:[
            ["N", "Turn back NOW! The Robot is not jet implementet!"]],
        rot:[
            ["N", "<h1>What the hell are YOU?</h1> My gosh, I've seen my share of ugly beasts here in 'Concrete Street', but I have to say, you do still stick out! What are you?"],
            ["Y", "HUNGRY…!"],
            ["N", "Ugh … I meant, what kind of a being you are. Are you really as dumb as you look?"],
            ["Y", "…?"],
            ["N", "… Well … How about a name? Do you at least know THAT?"],
            ["Y", "<input class='dialog-input' placeholder='Name your fighter!' for='enter-name' stat='name'>"
             + "<button class='dialog-btn' onclick= \"Dialog.setCharData(this, 'name')\" name='enter-name'>That's my name!</button>"]
        ]
    },
    Character: {
    },
    RaceColors: {
        human: {
            primary: "200,255,0",
            secondary: "0,80,0"
        },
        robot: {
            primary: "0,200,255",
            secondary: "0,20,80"
        },
        monster: {
            primary: "255,200,0",
            secondary: "80,20,0"
        }
    }
}