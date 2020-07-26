# java-zippedlist
Java does unfortunately not have a "zip" function in the Streams API... Let's try some alternative ways to zip two lists...

### Background

Assume we have two list; one with first names and one with family names
```
List<String> firstNames = Arrays.asList("Arnold", "Sylvester", "Jean-Claude");
List<String> lastNames = Arrays.asList("Schwarzenegger", "Stallone", "Van Damme");
```        
and we want to "zip" these two list to get the following result:

```
[Arnold Schwarzenegger, Sylvester Stallone, Jean-Claude Van Damme]
```
If one of the lists are shorter than the other, the result should have the same length as the shorter list.

There are a few libraries that contains helper methods for zipping lists, such as Google Guava https://github.com/google/guava
or Protonpack https://github.com/poetix/protonpack, but what other options are there ?

#### A simple for-loop

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
                                          
#### Iterators

```
List<String> people = new ArrayList<>();
Iterator f = firstNames.iterator();
Iterator l = lastNames.iterator();
while (f.hasNext() && l.hasNext() ) {
  people.add(f.next() + " " + l.next() );
}
```
Pros:
* No need to check if the two lists are the same size

Cons:
* The iterators have too large scope (outside of the while-loop)
* The mutable collection is still needed

#### Java stream

```
List<String> people = IntStream.range(0, Math.min(firstNames.size(), lastNames.size()))
                               .mapToObj(i -> firstNames.get(i) + " " + lastNames.get(i))
                               .collect(Collectors.toList());
```
Pros:
* No need for a mutable collection
* Declarative
* The resulting list is immutable

Cons:
* It's still a for loop, though it looks more or less like a hack

#### Custom class that implements the Iterable interface, and encapsulate the input lists.

```
ZippedIterable zip = new ZippedIterable(firstNames, lastNames);
List<String> people = zip.toList();
```
The class can be iterated with extended for-loop, forEach() or via the iterator
```
for (String s : zip) { ... }
 
zip.forEach(...);

Iterator<String> zi = zip.iterator();
while (zi.hasNext()) { ... }

```
Pros:
* Object oriented solution
* Declarative 

Cons:
* It's not a list. If we need a list we have to manually convert it (or add a .toList()-method)

#### Create a real List and encapsulate the input Lists

Create a real list, by extending the AbstractList-class. Encapsulate the input lists, and concatenate the result in the .get()-method.
Note that the example is made generic, so any type of lists should be possible to zip.
```
ZippedList<String, String, String> people = new ZippedList<>(firstNames, lastNames, (t, u) ->  t + " " + u);
people.stream()...
people.forEach(...);
```
Pros:
* Object oriented solution
* Declarative 
* A real list, and therefore streams and other ways of iterating and manipulating it work automatically

Cons:
* An extra class has to be created






