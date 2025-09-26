import CoffeeMachineState.Idle.timestamp

interface ICoffeeMachineState {
    fun onEnter(stateMachine: StateMachine)
}

sealed class CoffeeMachineState: ICoffeeMachineState {
    object Idle : CoffeeMachineState() {
        val timestamp: Long = System.currentTimeMillis()
        override fun onEnter(stateMachine: StateMachine) {
            println("[Idle] Entrando en estado Idle a las $timestamp")
            println("[Idle] La máquina está lista para hacer café.")
        }

        init{
            println("[Idle] ejecutando init")
        }
    }

    object MakingCoffee : CoffeeMachineState() {
        override fun onEnter(stateMachine: StateMachine) {
            println("[MakingCoffee] Preparando el café...")
            // Simula el tiempo que tarda en hacer el café
            Thread.sleep(1000)
            println("[MakingCoffee] Café listo. Cambiando a estado ServingCoffee.")
            stateMachine.setState(ServingCoffee)
        }
    }

    object ServingCoffee : CoffeeMachineState() {
        override fun onEnter(stateMachine: StateMachine) {
            println("[ServingCoffee] Sirviendo el café...")
            // Simula el tiempo que tarda en servir el café
            Thread.sleep(2000)
            println("[ServingCoffee] Café servido. Volviendo a estado Idle.")
            stateMachine.setState(Idle)
        }
    }

    data class Error(val message: String) : CoffeeMachineState() {
        override fun onEnter(stateMachine: StateMachine) {
            TODO("Not yet implemented")
        }
    }
}