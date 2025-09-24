# Máquina de Estados... de Café

## Diagrama

```mermaid
stateDiagram-v2
    [*] --> Idle
    Idle --> ServingCoffee: makeCoffee()
    ServingCoffee --> [*]: clean()
    Idle --> Idle: clean()
    ServingCoffee --> ServingCoffee: makeCoffee()
    Idle --> Error: error
    Error --> [*]: clean()