

## Exercício: Sistema de Gerenciamento de Biblioteca

Você deve criar um pequeno sistema para gerenciar livros em uma biblioteca. O objetivo é simular as operações básicas de adicionar livros, buscar livros e emprestar/devolver livros.

### Requisitos:

1.  **Classe `Livro`**:
    * Deve representar um livro com os seguintes **atributos**:
        * `titulo` (String)
        * `autor` (String)
        * `isbn` (String - um identificador único para o livro)
        * `anoPublicacao` (int)
        * `disponivel` (boolean - indica se o livro está disponível para empréstimo)
    * Crie um **construtor** para inicializar esses atributos (exceto `disponivel`, que deve começar como `true` por padrão).
    * Implemente **métodos *getters*** para todos os atributos.
    * Implemente **métodos *setters*** apenas para o atributo `disponivel`.
    * Sobrescreva o método `toString()` para que ele retorne uma representação legível do objeto `Livro` (ex: "Título: O Pequeno Príncipe, Autor: Antoine de Saint-Exupéry, ISBN: 978-85-359-0000-0, Disponível: Sim").

2.  **Classe `Biblioteca`**:
    * Deve gerenciar uma coleção de objetos `Livro`.
    * Use um **`ArrayList` de `Livro`** para armazenar os livros da biblioteca. Lembre-se dos **generics**!
    * Implemente os seguintes **métodos**:
        * `adicionarLivro(Livro livro)`: Adiciona um livro à coleção. Antes de adicionar, verifique se já existe um livro com o mesmo ISBN para evitar duplicatas. Se já existir, imprima uma mensagem informando que o livro já está cadastrado.
        * `buscarLivroPorTitulo(String titulo)`: Retorna um `List<Livro>` contendo todos os livros que possuem o título informado (pode haver mais de um). Se nenhum livro for encontrado, retorne uma lista vazia. A busca deve ser *case-insensitive* (não diferenciar maiúsculas de minúsculas).
        * `buscarLivroPorAutor(String autor)`: Retorna um `List<Livro>` contendo todos os livros que possuem o autor informado. Se nenhum livro for encontrado, retorne uma lista vazia. A busca deve ser *case-insensitive*.
        * `emprestarLivro(String isbn)`: Altera o status de `disponivel` de um livro para `false`, caso ele exista e esteja disponível. Retorna `true` se o empréstimo for bem-sucedido, `false` caso contrário (livro não encontrado ou já emprestado).
        * `devolverLivro(String isbn)`: Altera o status de `disponivel` de um livro para `true`, caso ele exista e esteja emprestado. Retorna `true` se a devolução for bem-sucedida, `false` caso contrário (livro não encontrado ou já disponível).
        * `listarTodosOsLivros()`: Imprime no console todos os livros cadastrados na biblioteca, utilizando o método `toString()` da classe `Livro`.

3.  **Classe Principal (`Main` ou `AplicacaoBiblioteca`)**:
    * Crie uma classe com o método `main` para **testar** as funcionalidades da sua `Biblioteca`.
    * Crie uma instância da `Biblioteca`.
    * Adicione pelo menos 3-5 livros à biblioteca (incluindo alguns do mesmo autor e um que já exista para testar a validação de ISBN).
    * Realize buscas por título e autor, imprimindo os resultados.
    * Tente emprestar e devolver alguns livros, testando os casos de sucesso e falha.
    * Liste todos os livros no final para ver o estado atual da biblioteca.

---

### Conceitos Java e POO a serem aplicados:

* **Classes e Objetos**: Criação de `Livro` e `Biblioteca`.
* **Encapsulamento**: Uso de `private` para atributos e `public` para *getters* e *setters*.
* **Construtores**: Inicialização de objetos.
* **Generics**: `ArrayList<Livro>`.
* **Tipagem Forte**: Declaração explícita de tipos.
* **Estruturas de Dados**: Uso de `ArrayList` e lógica para busca e manipulação.
* **Laços de Repetição (`for` ou `for-each`)**: Para iterar sobre a lista de livros.
* **Condicionais (`if`/`else`)**: Para lógica de validação e status.
* **Métodos (`toString()`, `equals()` (opcional, mas boa prática))**: Sobrescrever métodos para melhor representação e comparação.
* **Manipulação de String**: Uso de `toLowerCase()` e `equalsIgnoreCase()` para buscas *case-insensitive*.

---

Este exercício é um excelente ponto de partida para consolidar os conceitos fundamentais do Java e da POO. Sinta-se à vontade para me perguntar qualquer dúvida durante a implementação!