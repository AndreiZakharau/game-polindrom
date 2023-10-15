
Palindrom: a word or phrase that reads the same in both directions.
For example:
clomping
and the rose fell on Azor’s paw
Task:
You need to design and write a logical kernel (a set of interconnected
components) a game that would take the input word/phrase, checking whether is
this phrase/word palindrome and, if so, would give the user points in
depending on the length of the phrase/word (+1 for each symbol). The game should have
"Leader Board" with 5 users with the most users
points. The game should not test the word/phrase for literacy and existence
such words in reality. It is necessary to write only the core of such a game, do not need to think about the UI
or how words/phrases enter the system from the outside world and only the basic
The classes/interfaces that provide the described functionality.
Gras keeps his state in his memory.
The game lasts indefinitely and it does not have a queue, but the same user
should not get points for a phrase he’s already used.
When designing, you can consider a further extension, for example,
connection of some database.
Sample code should be written in Java SE (no lower than 8 or higher) without
use any frameworks (except maven and junit).