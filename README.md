# java-zippedlist
Java does unfortunately not have a zip function in the Streams API... Let's try some alternative ways to zip two lists

Assume


#### a simple for-loop

```
List<String> people = new ArrayList<>();
for (int i=0; i< Math.min(firstNames.size(),lastNames.size()); i++) {
  people.add(firstNames.get(i) + " " + lastNames.get(i));
}
```
Pros:
  * easy to grasp
  * fast implementation
  * the counter has a short scope (just inside the for-loop)                                                                                  
                                                                                  
Cons:
  * imperative, not Object oriented at all
  * requires a mutable collection (people)
  * would reallt need an extra check to make sure the  
                                          
                                          
#### iterator

```
List<String> people = new ArrayList<>();
Iterator f = firstNames.iterator();
Iterator l = lastNames.iterator();
while (f.hasNext() && l.hasNext() ) {
  people.add(f.next() + " " + l.next() );
}
```
Pros:
* slightly more elgant than 
*
Cons:
*
*

####
