# 🎫 Modificadores de acceso

Tiene que ver con ir haciendo las cosas **públicas** o **privadas**.

> El profe va a combinar ciertas clases con la IA, que le de una tabla con tipo de modificadores que hay en JAVA, y que haga un ejemplo de una app de ejemplo.
> Usará [`claude`](https://claude.ai/) para el propósito :P Usa **Sonnet 4.6** como modelo!

* **Prompt**: En JAVA, necesito saber que modificadores de acceso existen, saber qué significa cada uno de ellos. Un pequeño ejemplo para cada uno de ellos. Y una tabla resumen.

1. `public`: Es el **más permisivo**. Es accesible desde cualquier lugar: misma clase, mismo paquete, subclases y otros paquetes
2. `private`: Es el **más restrictivo**. Solo es accesible dentro de la misma clase. ES el pilar de la encapsulación.
3. `protected`: Accesible dentro del **mismo paquete** y también por **subclases**, aunque estén en otro paquete, muy usado en herencia. Cuando marcas algo con protected implica que es menos que `public` pero más que `private`. Es accesible desde cualquier clase que esté **dentro del paquete** incluyendo **subclases** aunque estén en otro paquete!
4. `default`(sin modificador): No se escribe ningún modificador. El elemento es accesible **solo dentro del mismo paquete**, pero fuera no tiene acceso, ni las subclases ni nada.

| Modificador | Misma clase | Mismo paquete | Subclase (otro paquete) | Cualquier lugar |
| :--- | :---: | :---: | :---: | :---: |
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| (default) |  ✅ | ✅ |  ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

> **Regla de oro**: Como buena práctica en POO se recomienda usar **siempre** el modificador **más restrictivo**
> `private`-> `default` -> `protected` -> `public`
> Empieza por `private` y amplia solo cuando sea necesario, esto es la **base de la encapsulación**!
> Así, siendo las cosas privadas, nadie desde fuera la puede utilizar.