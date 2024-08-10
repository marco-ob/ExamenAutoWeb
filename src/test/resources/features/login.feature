  @testfeature
  Feature: : Comprar productos
  Yo, como usuario
  Quiero, tener la opción de navegar por categorías y realizar compras
  Para agregar productos al carrito y validar la compra

  @test
  Scenario Outline: : Compra de productos desde la tienda


    Given estoy en la página de la tienda
    And me logueo con mi usuario "<usuario>" y clave "<clave>"
    When navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    And agrego "<cantidad>" unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

    Examples: :
      | usuario        | clave         | categoria | subcategoria | cantidad |
      | marcoobregong@gmail.com  | QAAutomationWeb  | CLOTHES   | MEN          | 2        |
      | marcoobreg@gmail.com   | passwordmal  | Clothes   | Men          | 2        |
      | marcoobregong@gmail.com  | QAAutomationWeb  | Inexistente   | Men          | 2        |