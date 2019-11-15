package interview.chapter1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列
 */
public class N4 {

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private int count;

    public N4() {
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, count++));
        }
    }

    public Pet pollAll() {
        if (!isCatQueueEmpty() && !isDogQueueEmpty()) {
            if (catQ.peek().getCount() < dogQ.peek().getCount()) {
                return pollCat();
            } else {
                return pollDog();
            }
        } else if (!isCatQueueEmpty()) {
            return pollCat();
        } else if (!isDogQueueEmpty()) {
            return pollDog();
        } else {
            throw new RuntimeException("queue is empty");
        }
    }

    public Dog pollDog() {
        return (Dog) this.dogQ.poll().getPet();
    }

    public Cat pollCat() {
        return (Cat) this.catQ.poll().getPet();
    }

    public boolean isEmpty() {
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.catQ.isEmpty();
    }
}

class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {

    public Cat() {
        super("cat");
    }
}

class PetEnterQueue {
    private Pet pet;
    private int count;

    public PetEnterQueue(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public int getCount() {
        return count;
    }

    public String getEnterPetType() {
        return this.pet.getType();
    }
}
