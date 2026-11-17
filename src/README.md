# Adopt a Quetie

CS 2114 — Project 3: Designing for Change  
Team 28  
Deliverable 4 — Second Prototype + Tests

## Project Description

Adopt a Quetie is a pet adoption queue system. Users can view animals available for adoption and join a waiting line to meet an animal. Each animal has its own queue. The system uses first-in, first-out (FIFO) order, so the person who joins first gets to meet the animal first.

Users can view animals, join queues, check how many people are waiting, see who is next, finish meetings, and skip absent adopters.

For Deliverable 4, we added an estimated waiting time feature. Each adopter can check their estimated wait based on their position in the queue. Each meeting is estimated to take 30 minutes.

## How to Run

### Program

1. Open the project in Eclipse.
2. Make sure the CS3-Supp library is added.
3. Open AdoptionApp.java.
4. Run the file as a Java Application.
5. Follow the menu to use the adoption system.

The program includes six pre-written animals.

### Tests

1. Open the project in Eclipse.
2. Make sure the required JUnit library is added.
3. Open a test file, such as AdoptionQueueTest.java.
4. Run the file as a JUnit test.
5. Check that the tests pass.

The model tests can run without the view or controller.

## Reflection

### How Did Our Design Handle the Change?

For Deliverable 4, we added an estimated waiting time feature. This was the feature we planned in Deliverable 3.

We changed three main classes:

- AdoptionQueue.java — Added a method to calculate estimated waiting time based on queue position.
- AdoptionController.java — Added a method to request the estimated wait time from the queue.
- AdoptionView.java — Added a menu option to display the estimated waiting time.

We also updated AdoptionQueueTest.java to test the new feature.

This matched our prediction from Deliverable 3. We expected these three classes to change. We did not need to change `Adopter.java` because it only stores adopter information.

### Did the Change Cross the Model/View Line?

The new feature uses the model, controller, and view, but each class has its own responsibility.

The queue calculates the waiting time. The controller gets the information from the queue, and the view displays it.

The view does not calculate the waiting time or store a separate copy of the queue. This keeps the model separate from the view.

### What Changed From Our D3 Plan?

We followed our original plan to add estimated waiting time.

Instead of creating a live countdown timer, we calculate the waiting time based on queue position.

Each person ahead adds 30 minutes. When someone finishes a meeting or is skipped, the estimated waiting time changes based on the updated queue.

We also added more JUnit tests to check the new feature and queue behavior.

### What Does Not Work Yet?

All of our planned MVP features have been implemented.

The estimated waiting time is not a live countdown timer. It does not track the actual time remaining during a meeting.

The program does not automatically remove absent adopters or save queue information after closing.

We still need to finish checking all tests and bad-input cases before the final build.

### What Would Make Future Changes Easier?

One improvement would be to move more animal and queue management into AdoptionQuetie.java instead of handling it directly in the controller.

This would keep more logic in the model and make future features easier to add.

## Next Steps

### What Is Left for the Final Build?

1. Run all JUnit tests and fix any failures.
2. Test invalid names, nonexistent animals, and empty queues.
3. Make sure estimated waiting times update correctly.
4. Fix any remaining problems in the program.
5. Complete final testing and prepare the demonstration.

### Stretch Goals

**Completed:**
- Estimated waiting time for adopters.
- Separate queues for multiple animals.

**Not currently planned:**
- Automatically removing adopters who do not arrive.
- Saving and loading queue data.
- A live 30-minute countdown timer.

We want to focus on making our current features work correctly before adding more features.

### Three-Minute Demo Plan

**0:00–0:30 — View Animals**

Start the program and display the six available animals.

**0:30–1:00 — Join a Queue**

Select an animal and add three adopters to its queue.

**1:00–1:30 — Estimated Waiting Time**

Show that the first adopter has 0 minutes, the second has 30 minutes, and the third has 60 minutes.

**1:30–2:00 — Finish a Meeting**

Finish the first adopter's meeting and show how the waiting time changes.

**2:00–2:30 — Skip an Adopter**

Skip the next adopter and show the updated queue.

**2:30–3:00 — Bad Input and Tests**

Enter an invalid animal name and briefly show the JUnit tests.

### Team Responsibilities

| Person | Responsibilities |
|---|---|
| Daphne | Queue logic, waiting time feature, JUnit tests, README updates, and final testing |
| Sofia | Review Animal and Adopter classes and tests |
| Ujay | Review controller, view, and integration |
| Everyone | Final debugging and demonstration preparation |

## Attribution

| File | Contributor | Contribution |
|---|---|---|
| AdoptionQueue.java | Daphne | Implemented queue methods and added estimated waiting time with GenAI assistance |
| AdoptionQueueTest.java | Daphne | Wrote queue tests and added GenAI-assisted tests |
| Animal.java | Daphne and Sofia | Implemented animal information |
| Adopter.java | Daphne and Sofia | Implemented adopter information |
| AnimalTest.java | Daphne and Sofia | Wrote tests for Animal |
| AdopterTest.java | Daphne and Sofia | Wrote tests for Adopter |
| AdoptionController.java | Ujay and Daphne | Original controller by Ujay; waiting time integration with GenAI assistance by Daphne |
| AdoptionView.java | Ujay and Daphne | Original view by Ujay; waiting time menu and display updates with GenAI assistance by Daphne |
| ModelDriver.java | Ujay | Created the model driver |
| AdoptionApp.java | Daphne | Created six pre-written animals and the main method |
| AdoptionQuetie.java | Ujay | Adoption system model |
| AdoptionQuetieTest.java | Sofia | Adoption system tests |
| AdoptionControllerTest.java | Daphne | Controller tests |

## GenAI Statement

For Deliverable 3, we used GenAI to help distribute work among team members.
As well as generate data for the animals.
