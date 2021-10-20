# Prueba técnica: Solicitud Vehículo

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/4618d01af1e247eaa5e75b73b1dbdd51)](https://www.codacy.com/gh/MaQuiNa1995/EntrevistaTecnica_Vehiculos/dashboard?utm_source=github.com&utm_medium=referral&utm_content=MaQuiNa1995/EntrevistaTecnica_Vehiculos&utm_campaign=Badge_Coverage)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/4618d01af1e247eaa5e75b73b1dbdd51)](https://www.codacy.com/gh/MaQuiNa1995/EntrevistaTecnica_Vehiculos/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=MaQuiNa1995/EntrevistaTecnica_Vehiculos&amp;utm_campaign=Badge_Grade)

Modifica la funcionalidad existente del servicio de creación de pedido de coche:

## Modificar el código de respuesta
- [x] Devolver un 201 en la creación de la solicitud del coche (en caso de éxito)

## Integrar con el servicio de stock
Dado el comportamiento actual de la creación de solicitud de vehículo (Create Car)

- [x] ampliar el comportamiento para comprobar si existe stock para la combinación solicitada de modelo de coche y color
- [x] En caso de no existir stock denegar la petición (generar la respuesta REST que consideres mejor)

Para simular la llamada a dicho servicio usar la clase: CarAvailabilityRestConnector

## Integrar con el servicio de configurador
Dado el comportamiento actual de la creación de solicitud de vehículo (Create Car)

- [x] ampliar el comportamiento para que en caso de que la solicitud no indique un color, obtener el color predeterminado para el modelo de coche, Para simular la llamada a dicho servicio usar la clase: ColorPickerRestConnector

## Integrar con el servicio de seguros
Dado el comportamiento actual de la creación de solicitud de vehículo (Create Car)

- [x] ampliar el comportamiento para comprobar si el solicitante puede ser asegurado para el modelo coche que indica
- [x] En caso de no poder ser asegurado denegar la petición (genera una respuesta 400, si es posible utiliza un validador)

Para simular la llamada a dicho servicio usar la clase: InsuranceRestConnector

## Hacer end-point de consulta
Además del comportamiento actual de la creación de solicitud de vehículo (Create Car)

- [x] crear un nuevo comportamiento para consultar un vehículo con la información de solicitud
- [x] Mostrar el estado de la petición usando el servicio OrderStatusRestConnector

# Nota
Puedes modificar el código existente según sea necesario para organizar mejor la nueva funcionalidad (nuevas clases, refactor, enums, paqueteria ...)

# Valorable
- [ ] estructuración de código
- [ ] mantener los tests funcionando
- [ ] ampliar la suite de tests
- [ ] incluir nuevo end-point para añadir funcionalidad de filtrado por color de coche de los "cars" almacenados en base de datos
- [ ] cualquier otra mejora que consideres
