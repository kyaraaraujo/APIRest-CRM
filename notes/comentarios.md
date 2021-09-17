Estrutura de diretórios:

`controller` -> onde ficam as classes dos endpoints

`model` -> ficarão os modelos para banco de dados.

`repository` -> uma classe responsável por interagir com o banco de dados para uma determinada entidade.


## Anotações 

Em `ClienteController`

```java
// para informar que essa é uma classe controller

import org.springframework.web.bind.annotation.PostMapping;

@RestController

// vai mapear os endpoints para receber requisições iniciadas em /clientes
@RequestMapping("/clientes")

// No método
// para informar que ao chegar no endpoint deve executar esse método
@GetMapping
@PostMapping // usar @RequestBody no parâmetro para que converta o informado no body para objeto java.
```
---

JPA é uma especificação para que sejam usadas em ORM (mapeamento de bancos relacionais). Se usa Anotações(@) do pacote `javax.persistence`.

Nesse projeto é usado um banco de dados em memória: H2, em SQL. Segundo o instrutor com esse banco não precisa realizar configurações iniciais.


---
Em `Cliente` ficará o modelo do banco de dados.

```java
// para informar que a classe será uma entidade do banco
@Entity

// --- No atributo ---
// para informar ao banco que o atributo será a primary key
@Id

// para informar ao banco que deverá fazer o auto incremento do atributo (no caso, id).
@GeneratedValue(strategy = GenerationType.IDENTITY)

// caso queira colocar alguma configuração na coluna deve usar como exemplo:
@Column(nullable = false) // ou seja, coluna será NOT NULL
//também serve caso o nome da coluna no banco seja diferente do atributo em java
@Column(name = "cliente_nome")
//caso não possua configuração é desnecessário colocar @Column

```
### Lombok
Adicionou Lombok para evitar código "boilerplate" (códigos que não acrescentam muita coisa mas mesmo assim não podem ser omitidos). [Mais sobre boilerplate](https://pt.stackoverflow.com/questions/10575/o-que-%C3%A9-boilerplate-code)

```Java
// com essa anotação ele gera os getters e setters, além de equals e hashcode. (mas não fica no código da classe)
@Data 
```

### Interface - Repository
`repository` -> uma classe responsável por interagir com o banco de dados para uma determinada entidade.

A interface precisa herdar de `JpaRepository<T, ID>` sendo `T` o tipo (pode ser a classe, no caso foi Cliente) e `ID` o tipo do id do atributo (no caso o atributo id do cliente é do tipo Long).

Na interface precisa colocar a anotação `@Repository` para que o spring entenda como um componente repository.

---
```java
// para injetar uma instância do atributo declarado (ou seja, vai instanciar).
@Autowired
```

### Referência:
[Como criar uma REST API com Sping Boot](https://www.youtube.com/watch?v=9GWK9A79tEc)