============================== Project 4 Readme ==============================

My primary goal for this project was to achieve a degree of interactivity so
that the code written so far could constitute a "game" with a win state, lose 
state, and replay value. My main inspirations going forward from Project 3 were
minimalist ASCII rougelike RPGs like Nethack and Dwarf Fortress. This is one of
the reasons why the "Random" class shows up so frequently in my code, as those
games predicate their replay-ability on randomly generated environments and
enemies. 

The first thing I did was reuse the Sword, Bow, and Staff objects to create 
three distinct enemies: the Goblin, Troll, and Lich. From there I made
RandomNaming.java so that random enemy objects could have random names, I used
a World of Warcraft name generator to make a static list from which names could
be picked randomly. I got this idea from a video I watched about the DOOM
(1993) source code; in order to reduce the processing overhead of generating
random values on the slower 486 CPUs of the day, ID Software simply employed a
static list of randomized integer values to be iterated through over the
course of a game whenever one was needed. 

With my Enemy subclasses and RandomNaming complete, I created the 
EnemyRandomizer class to use a RandomNaming object in conjunction with its own
Random object and associated logic for encounter rate in order to create random
enemy objects. I made some changes to Map, giving it a static field for the
coordinates of the player character, a method to move the player, and a default 
constructor to generate 8x8 Maps with obstacles placed at random. I wanted these 
obstacles to trigger enemy encounters, so I created the Damage class to handle 
battle proceedings. I wanted there to be a clear "weapon triangle" relationship 
between the weapons when designing how damage would be calculated; I made the 
Bow the most reliable weapon (as a call to hitProb with it is always true, it 
never misses), with the Staff as the riskier high-damage option, and the Sword 
as a reliable in-between. I felt the combat in the game was simple enough, so I 
just made it automatic, playing out in a single call to the Battle method. Both 
Hero and Enemy now extend the HitPoints class (illustrated by my UML diagram), 
which provides a field and methods used for representing health values in 
combat. From there it was just a matter of making a driver to create and manage 
the player's character, prompting for a movement direction and deferring to 
Damage as a helper class for battle events.

I tested my game a number of times outside of my GeneralTester class, working
through a number of small issues pertaining to the player's position on the
map amongst other things, until I was pretty confident everything worked as
intended. Admittedly, a few features from the Project 3 code haven't been 
carried over into gameplay (including the Halfling's hunger mechanic, the Bow's 
arrow mechanic, and the Elf's magic stat) in the interest of keeping things as 
simple as possible.

It's also worth noting that names.txt needs to be in the same directory as the
.jar executable in order for the program to work properly.

Ethan Hopkins
Prof. Givens
Software Development
5/17/2020
