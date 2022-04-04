# DolarSi

El proyecto es una app desarrollada en Android Studio utilizando Volley (es una biblioteca HTTP que facilita y agiliza el uso de redes en apps para Android)
y que consume una la siguiente API (https://www.dolarsi.com/api/api.php?type=valoresprincipales).

La app devuelve informacion sobre la cotizacion del dolar en tiempo real. En este caso devuelve los valores elegidos dentro del segundo objeto y no todos los valores.

Valores devueltos:

- Nombre del dolar

- Valor de compra

- Valor de venta

- Numero de agencia


Para mostrar dicha informacion se utilizo una iteracion sobre el primer objeto y luego sobre el segundo, para finalmente elegir que elementos mostrar dentro del mismo.
