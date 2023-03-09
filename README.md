# Gilded Rose Refactoring Kata

Esta Kata fue creada originalmente por Terry Hughes (https://github.com/NotMyself/GildedRose).
Y luego traducida a muchos lenguajes por Emily Bache (https://github.com/emilybache/GildedRose-Refactoring-Kata)
En este proyecto la tenemos en Java y con algunos test para centrarnos en la refactorización.

# Especificaciones de la Rosa Dorada (Gilded Rose)

Bienvenido al equipo de **Gilded Rose**.
Como quizá sabes, somos una pequeña posada ubicada estratégicamente en una prestigiosa ciudad, atendida por la amable **Allison**.
También compramos y vendemos mercadería de alta calidad.
Por desgracia, nuestra mercadería va bajando de calidad a medida que se aproxima la fecha de venta.

Tenemos un sistema instalado que actualiza automáticamente el `inventario`.
Este sistema fue desarrollado por un muchacho con poco sentido común llamado Leeroy, que ahora se dedica a nuevas aventuras.
Tu tarea es agregar una nueva característica al sistema para que podamos comenzar a vender una nueva categoría de items.

## Descripción preliminar

Pero primero, vamos a introducir el sistema:

* Todos los artículos (`Item`) tienen una propiedad `sellIn` que denota el número de días que tenemos para venderlo... hasta la `fecha de venta`
* Todos los artículos tienen una propiedad `quality` que denota cúan valioso es el artículo
* Al final de cada día, nuestro sistema decrementa ambos valores para cada artículo mediante el método `updateQuality`

Bastante simple, ¿no? Bueno, ahora es donde se pone interesante:

* Una vez que ha pasado la fecha recomendada de venta, la `quality` se degrada al doble de velocidad
* La `quality` de un artículo nunca es negativa
* El "Queso Brie envejecido" (`Aged brie`) incrementa su `quality` a medida que se pone viejo
  * Su `quality` aumenta en `1` unidad cada día
  * luego de la `fecha de venta` su `quality` aumenta `2` unidades por día
* La `quality` de un artículo nunca es mayor a `50`
* El artículo "Sulfuras" (`Sulfuras`), siendo un artículo legendario, no modifica su `fecha de venta` ni se degrada en `quality`
* Una "Entrada al Backstage", como el queso brie, incrementa su `quality` a medida que la `fecha de venta` se aproxima
  * si faltan 10 días o menos para el concierto, la `quality` se incrementa en `2` unidades
  * si faltan 5 días o menos, la `quality` se incrementa en `3` unidades
  * luego de la `fecha de venta` la `quality` cae a `0`

## El requerimiento

Hace poco contratamos a un proveedor de artículos *conjurados mágicamente* (`conjured`).
Esto requiere una actualización del sistema:

* Los artículos `conjured` degradan su `quality` al doble de velocidad que los normales

Siéntete libre de realizar cualquier cambio al mensaje `updateQuality` y agregar el código que sea necesario, mientras que todo siga funcionando correctamente. Sin embargo, **no alteres el objeto `Item` ni sus propiedades** ya que pertenecen al goblin que está en ese rincón, que en un ataque de ira te va a liquidar de un golpe porque no cree en la cultura de código compartido.

## Notas finales

Para aclarar: un artículo nunca puede tener una `quality` superior a `50`, sin embargo las Sulfuras siendo un artículo legendario posee una calidad inmutable de `80`.
