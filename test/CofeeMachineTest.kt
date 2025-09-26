import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CoffeeMachineTest {

    @Test
    fun makeCoffee_whenIdle_shouldTransitionToServingCoffee() {
        StateMachine.clean() // Ensure the machine starts in Idle state
        StateMachine.makeCoffee()
        assertTrue(StateMachine.currentState is CoffeeMachineState.ServingCoffee)
    }

    @Test
    fun makeCoffee_whenMakingCoffee_shouldNotChangeState() {
        StateMachine.clean()
        StateMachine.makeCoffee() // Transition to ServingCoffee
        StateMachine.makeCoffee() // Attempt to make coffee again
        assertTrue(StateMachine.currentState is CoffeeMachineState.ServingCoffee)
    }

    @Test
    fun makeCoffee_whenServingCoffee_shouldNotChangeState() {
        StateMachine.clean()
        StateMachine.makeCoffee() // Transition to ServingCoffee
        StateMachine.makeCoffee() // Attempt to make coffee again
        assertTrue(StateMachine.currentState is CoffeeMachineState.ServingCoffee)
    }

    @Test
    fun clean_shouldResetStateToIdle() {
        StateMachine.makeCoffee() // Transition to ServingCoffee
        StateMachine.clean()
        assertTrue(StateMachine.currentState is CoffeeMachineState.Idle)
    }

    @Test
    fun makeCoffee_whenError_shouldNotChangeState() {
        StateMachine.currentState = CoffeeMachineState.Error("Test error")
        StateMachine.makeCoffee()
        assertTrue(StateMachine.currentState is CoffeeMachineState.Error)
    }
}