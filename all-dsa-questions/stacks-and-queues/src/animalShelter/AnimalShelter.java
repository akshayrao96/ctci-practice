package animalShelter;

import java.util.LinkedList;

public class AnimalShelter<T extends Animal> {

  private final LinkedList<Dog> dogs;
  private final LinkedList<Cat> cats;
  private int order;

  public AnimalShelter() {
    this.dogs = new LinkedList<>();
    this.cats = new LinkedList<>();
    order = 0;
  }

  public void enqueue(Animal a) {
    a.setOrder(order);
    this.order += 1;
    if (a instanceof Dog) {
      dogs.addLast((Dog) a);
    } else {
      cats.addLast((Cat) a);
    }
  }

  public Animal dequeueAny() {
    if (dogs.size() == 0) {
      return dequeueCat();
    }
    if (cats.size() == 0) {
      return dequeueDog();
    }
    Dog getDog = dogs.peek();
    Cat getCat = cats.peek();
    return getDog.isOlderThan(getCat) ? getDog : getCat;
  }

  public Cat dequeueCat() {
    return cats.poll();
  }

  public Dog dequeueDog() {
    return dogs.poll();
  }
}
