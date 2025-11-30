# Strategy

## 🦧 Intent

**Strategy** is a behavioral design pattern that lets you define a family of algorithms, put each of them into a
separate class, and make their objects interchangeable.

## 🙁 Problem

Imagine that you’re creating a navigation application. It can calculate routes for cars, public transport, or walking.

<img src="src/main/resources/problem.png" alt="Problem">
<center><i>Different ways to calculate a route.</i></center>

Initially, you implemented all of these algorithms inside a single `Navigator` class. However, as the application grew,
these algorithms started to become bloated with conditional statements that selected a proper algorithm depending on the
user's input. Changing one algorithm might affect others, leading to bugs and inconsistencies.

## 😀 Solution

The Strategy pattern suggests that you take a class that does something specific in many different ways and extract all
of these algorithms into separate classes called *strategies*.

<img src="src/main/resources/solution.png" alt="Solution">
<center><i>Separate algorithms into distinct classes.</i></center>

The original class, called the *context*, instead of implementing all versions of an algorithm, stores a reference to
one of the strategies. The context delegates the work to the linked strategy object instead of executing it itself.

This way, the context becomes independent of concrete strategies. The client code can provide the context with a
different strategy object when the program needs to perform the same task in a different way.

## Structure

<img src="src/main/resources/structure.png" alt="Structure">
<center><i>Structure of the Strategy pattern.</i></center>

1. The **Context** maintains a reference to one of the concrete strategies and communicates with this object only via
   the strategy interface.
2. The **Strategy** interface declares operations common to all supported versions of some algorithm. The context uses
   this interface to call the algorithm defined by the concrete strategies.
3. **Concrete Strategies** implement different variations of an algorithm that the context uses.
4. The **Client** creates a specific concrete strategy object and passes it to the context. The client can replace the
   strategy associated with the context at runtime.

## Pseudocode

This example illustrates how the *Strategy* pattern can be used for different order processing algorithms depending on
the payment method.

When processing an order, the application needs to apply different payment strategies (e.g., credit card, PayPal, etc.).
Each payment method has its own logic for handling transactions.

The `Order` class acts as the context, holding a reference to a `PaymentStrategy` object. When the `Order` needs to
process payment, it delegates the task to its current `PaymentStrategy`.

The `PaymentStrategy` interface defines a common method, `pay`, which all concrete payment strategies (e.g.,
`CreditCardPayment`, `PayPalPayment`) implement. Each concrete strategy encapsulates the logic for a specific payment
method.

This allows the application to switch payment methods at runtime without modifying the `Order` class. The client code
simply instantiates the appropriate `PaymentStrategy` and passes it to the `Order`.

```
// The strategy interface declares operations common to all
// supported versions of some algorithm. The context uses this
// interface to call the algorithm defined by the concrete
// strategies.
interface Strategy is
    method execute(a, b)

// Concrete strategies implement the algorithm while following
// the base strategy interface. The interface makes them
// interchangeable in the context.
class ConcreteStrategyAdd implements Strategy is
    method execute(a, b) is
        return a + b

class ConcreteStrategySubtract implements Strategy is
    method execute(a, b) is
        return a - b

class ConcreteStrategyMultiply implements Strategy is
    method execute(a, b) is
        return a * b

// The context defines the interface of interest to clients.
class Context is
    // The context maintains a reference to one of the strategy
    // objects. The context doesn't know the concrete class of a
    // strategy. It should work with all strategies via the
    // strategy interface.
    private strategy: Strategy

    // Usually the context accepts a strategy through the
    // constructor, and also provides a setter so that the
    // strategy can be switched at runtime.
    method setStrategy(Strategy strategy) is
        this.strategy = strategy

    // The context delegates some work to the strategy object
    // instead of implementing multiple versions of the
    // algorithm on its own.
    method executeStrategy(int a, int b) is
        return strategy.execute(a, b)


// The client code picks a concrete strategy and passes it to
// the context. The client should be aware of the differences
// between strategies in order to make the right choice.
class ExampleApplication is
    method main() is
        Create context object.

        Read first number.
        Read last number.
        Read the desired action from user input.

        if (action == addition) then
            context.setStrategy(new ConcreteStrategyAdd())

        if (action == subtraction) then
            context.setStrategy(new ConcreteStrategySubtract())

        if (action == multiplication) then
            context.setStrategy(new ConcreteStrategyMultiply())

        result = context.executeStrategy(First number, Second number)

        Print result.
```

## ✨ Application

**⚠️ Use the Strategy pattern when you have a family of related algorithms, and you want to be able to interchange them
at runtime.**

**🗲** The Strategy pattern allows you to define a set of algorithms, encapsulate each one as an object, and make them
interchangeable. This lets the algorithm vary independently from clients that use it.

**⚠️ Use the Strategy pattern when you want to avoid exposing complex, algorithm-specific data structures to the client
code.**

**🗲** Strategies can hide their implementation details from the context and the client, making the system more modular
and easier to understand.

## 📋 How to Implement

1. Identify a family of related algorithms or behaviors.
2. Define a common interface for all algorithms. This interface should declare a method that the context will use to
   execute the algorithm.
3. Create concrete strategy classes for each algorithm, implementing the common strategy interface.
4. In the context class, add a field for storing a reference to a strategy object. Provide a setter for this field so
   clients can replace the strategy at runtime.
5. The context should delegate the work to the linked strategy object instead of implementing all versions of the
   algorithm itself.
6. The client code should create a suitable concrete strategy object and pass it to the context.

## ⚖️ Pros and Cons

| ✅ **Pros**                                                                                                     | ❌ **Cons**                                                                                                                            |
|----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|
| You can swap algorithms used inside an object at runtime.                                                      | If you have only a couple of algorithms, and they rarely change, there's no real need to overcomplicate the program with new classes. |
| You can isolate the implementation details of algorithms from the client code.                                 | Clients must be aware of the differences between strategies to choose an appropriate one.                                             |
| **Open/Closed Principle**. You can introduce new strategies without changing the context.                      |                                                                                                                                       |
| **Single Responsibility Principle**. You can extract different versions of an algorithm into separate classes. |                                                                                                                                       |

## ↔️ Relations with Other Patterns

- **Bridge** and **Strategy** patterns have very similar structures. They are both based on composition, delegating work
  to other objects. However, they solve different problems.
    - *Bridge* is used to separate an abstraction from its implementation so that the two can vary independently.
    - *Strategy* is used to encapsulate interchangeable algorithms within a context object.
- **State** is a variation of Strategy.
- **Adapter** can be used with Strategy to make incompatible strategies work with a context.
- **Template Method** often uses Strategy to provide a different implementation for certain steps of an algorithm.
- **Decorator** can be used with Strategy to add new behaviors to strategies without changing their code.
- **Command** and **Strategy** are related in that both encapsulate an algorithm for later execution. However, Command
  is about *what* action to perform, while Strategy is about *how* to perform it.
- **Abstract Factory** can be used to create families of related strategies.
- **Composite** can be used with Strategy to apply the same strategy to a group of objects.
