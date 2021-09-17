Estrutura de diretórios:

`controller` -> onde ficam as classes dos endpoints

<br>

Em `ClienteController`

```java
// para informar que essa é uma classe controller
@RestController

// vai mapear os endpoints para receber requisições iniciadas em /clientes
@RequestMapping("/clientes") 

// No método
// para informar que ao chegar no endpoint deve executar esse método
@GetMapping
```

