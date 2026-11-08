# Adopt a Quetie
CS 2114 — Project 3: Designing for Change  
Team 28  
Deliverable 3 — First Prototype

## Project Description

Adopt a Quetie is a pet adoption queue system. Users can view animals available for adoption and join a waiting line to meet an animal. Each animal has its own queue. The system uses first-in, first-out (FIFO) order, so the person who joins first gets to meet the animal first.

## How to Run

### Model

1. Open the project in Eclipse.
2. Make sure the CS3-Supp library is added.
3. Open `AdoptionQueueTest.java`.
4. Run the file as a JUnit test.
5. Check that the queue tests pass.

The queue can be tested without running the view or controller.

### View

The view and controller are being developed by Ujay.

Once connected, users will be able to view animals, select an animal, join its queue, and see how many people are waiting.

## Reflection

### What Changed From Our Specification?

Our specification separated the project into model, view, and controller classes.

For the prototype, we focused on building the queue logic before connecting it to the interface.

The `AdoptionQueue` class uses a singly linked queue with `firstNode` and `lastNode`. This allows adopters to be added and removed in O(1) time.

The queue also keeps track of its size so the system can show how many people are waiting.

The current implementation returns `null` when `peek()` or `dequeue()` is called on an empty queue. We also added validation to reject null adopters.

### Does the Model Stand Alone?

The `AdoptionQueue` class does not depend on the view or controller.

Its methods can be tested directly using JUnit. This allows us to check that the queue works before connecting it to the rest of the application.

### What Happened to Our Unknowns?

We figured out how to implement a FIFO queue using linked nodes and how to track the number of people waiting.

### What Does Not Work Yet?



## Next Steps

### Finish the MVP

1. Complete the Animal and Adopter classes.
2. Connect each animal to its own adoption queue.
3. Finish the controller and simple view.
4. Allow users to select an animal and join its queue.
5. Display the number of people waiting.
6. Add the ability to serve or skip the next adopter.
7. Test the complete application and fix any errors.

### Non-Trivial Change Feature

For Deliverable 4, we plan to add an estimated waiting time feature.

Each adopter will receive an estimated wait time based on their position in the queue. Each meeting will be estimated to take 30 minutes.

We predict this feature will require changes to:

- `AdoptionQueue.java` — Add a method to calculate estimated waiting time based on queue position.
- `AdoptionController.java` — Request the estimated wait time from the model.
- `AdoptionView.java` — Display the estimated wait time.

We predict `Adopter.java` will not need changes because it only stores adopter information.

### Stretch Goals

**Planned:**
- Estimated waiting time for adopters.
- Support for separate queues for multiple animals.

**Not currently planned:**
- Automatically removing adopters who do not arrive.
- Saving and loading queue data.
- A live 30-minute countdown timer.

### New Tests Needed

- Test that each animal has its own queue.
- Test joining a queue with valid information.
- Test rejecting empty or invalid names.
- Test removing or skipping the next adopter.
- Test queue behavior after all adopters are removed.
- Test estimated waiting times for different queue positions.
- Test that an empty queue has no waiting adopters.

### Team Responsibilities

| Person | Responsibilities |
|---|---|
| Daphne   | AdoptionQueue.java, AdoptionQueueTest.java, queue logic and tests |
| Sofia    | Animal.java, Adopter.java, AnimalTest.java, AdopterTest.java |
| Ujay     | AdoptionController.java, AdoptionView.java, ModelDriver.java, integration testing |
| Everyone | README, debugging, and final testing |

## Attribution

| File | Contributor | Contribution |
|---|---|---|
| AdoptionQueue.java | Daphne | Implemented queue methods |
| AdoptionQueueTest.java | Daphne | Wrote JUnit tests for queue operations |
| Animal.java | Person 2 | Implemented animal information |
| Adopter.java | Person 2 | Implemented adopter information |
| AnimalTest.java | Person 2 | Wrote tests for Animal |
| AdopterTest.java | Person 2 | Wrote tests for Adopter |
| AdoptionController.java | Person 3 | Implemented controller logic |
| AdoptionView.java | Person 3 | Created the basic view |
| ModelDriver.java | Person 3 | Created the model driver |

## GenAI Statement

