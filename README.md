# Sistema de Prioridades Hospitalarias

Sistema de triage para una sala de emergencias usando una **cola de prioridad (Min-Heap binario)** implementada a mano sobre un arreglo, para el curso de **Estructuras de Datos**. El paciente más crítico (prioridad numérica más baja) siempre se atiende primero, sin importar el orden de llegada.

> Nota: el material del curso no cubre heaps explícitamente (menciona colas de prioridad al hablar de Dijkstra) — esta implementación construye el heap desde cero (inserción/extracción en O(log n) con "subir"/"bajar" nodo) siguiendo buenas prácticas generales de la estructura.

## Estructura

```
src/
├── Paciente.java       → POJO (nombre, prioridad 1-5)
├── ColaPrioridad.java  → Min-Heap sobre arreglo: insertar, atenderSiguiente, verSiguiente
└── Main.java             → menú de consola
```

## Cómo ejecutarlo

```bash
javac -d bin src/*.java
java -cp bin Main
```

> Compilado y verificado con `javac` sin errores.

## Capturas

_Pendiente: agregar capturas en `capturas/`._

## Licencia

MIT — ver [LICENSE](LICENSE).
