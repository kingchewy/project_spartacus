// Distance to next Lvl: previous Distance *1.5 & round up
//      let distance = 150
//      let borders = 150
//      for (let i=0; i < 10; i++) {
//          distance = Math.round(distance*1.5)
//          borders = borders+distance
//          console.log(distance,borders,"\n")
//      }
// Lvl0: Distance=150 Border=150
// Lvl1: Distance=225 Border=375
// Lvl2: Distance=338 Border=713
// Lvl3: Distance=507 Border=1220
// Lvl4: Distance=761 Border=1981
// Lvl5: Distance=1142 Border=3123
// Lvl6: Distance=1713 Border=4836
// Lvl7: Distance=2570 Border=7406
// Lvl8: Distance=3855 Border=11261
// Lvl9: Distance=5783 Border=17044
// Lvl10: Distance=8675 Border=25719

export const Lvl = {
    0: {
        fromXp: 0,
        toXp: 150
    },
    1: {
        fromXp: 150,
        toXp: 375
    },
    2: {
        fromXp: 375,
        toXp: 713
    },
    3: {
        fromXp: 713,
        toXp: 1220
    },
    4: {
        fromXp: 1220,
        toXp: 1981
    },
    5: {
        fromXp: 1981,
        toXp: 3123
    },
    6: {
        fromXp: 3123,
        toXp: 4836
    },
    7: {
        fromXp: 4836,
        toXp: 7406
    },
    8: {
        fromXp: 7406,
        toXp: 11261
    },
    9: {
        fromXp: 11261,
        toXp: 17044
    },
    10: {
        fromXp: 17044,
        toXp: 25719
    }
}