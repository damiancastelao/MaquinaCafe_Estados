//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

// punto de partida de la app
fun main() {
    println("--- Encendiendo la máquina ---")
    CoffeeMachine.makeCoffee()

    println("\n--- Intentando hacer café de nuevo ---")
    CoffeeMachine.makeCoffee()

    println("\n--- Limpiando la máquina ---")
    CoffeeMachine.clean()

    println("\n--- Y ahora, otro café ---")
    CoffeeMachine.makeCoffee()
}