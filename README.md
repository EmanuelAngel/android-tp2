# BroadcastReceiver e Intents Implícitos

## Descripción de la aplicación

Cuando la aplicación está en ejecución y el usuario bloquea y posteriormente desbloquea la pantalla del dispositivo, el sistema desencadena las siguientes acciones:

1. **Notificación Visual (Toast):** Muestra un mensaje emergente en pantalla con el texto *"Screen Unlocked!"*.
2. **Registro de Depuración (Logcat):** Imprime un mensaje en la consola de Android Studio bajo la etiqueta `UNLOCK RECEIVER` indicando que el evento fue capturado exitosamente.
3. **Intent Implícito (Llamada):** Abre la aplicación de marcador telefónico por defecto del sistema (Dialer) con el número `2664553747` pre-cargado, listo para llamar.

## Integrantes

Esta actividad se realizó de manera individual.

- **Apellido**: Angel.
- **Nombre**: Emanuel.
- **Número de Documento**: 44600506.

## Detalles Técnicos y Arquitectura

- **Gestión del Ciclo de Vida:** El registro (`registerReceiver`) del `UnlockScreenReceiver` se realiza en el método `onCreate()` y su respectivo desregistro (`unregisterReceiver`) en el método `onDestroy()` del `MainActivity`. Esta decisión arquitectónica garantiza que la aplicación siga escuchando el evento de desbloqueo incluso cuando la Activity pasa por `onStop()` al apagarse la pantalla.
- **Flags de Intent:** Para abrir la aplicación de llamadas desde un `BroadcastReceiver` (el cual carece de una interfaz gráfica o pila de Activities propia), se añadió la bandera `Intent.FLAG_ACTIVITY_NEW_TASK` al Intent implícito, evitando excepciones de ejecución y asegurando que el Dialer se abra en una nueva tarea.
- **Acción Segura:** Se utilizó `Intent.ACTION_DIAL` en lugar de `ACTION_CALL` para no requerir permisos invasivos al usuario, permitiéndole confirmar la llamada manualmente (además de porque la actividad menciona a `ACTION_DIAL`).

*Proyecto académico desarrollado para la Universidad de La Punta (ULP).*