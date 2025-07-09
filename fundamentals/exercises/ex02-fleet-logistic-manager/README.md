# **Sistema de Gerenciamento de Frota Logística (SGF-Log)**

## **Contexto da Empresa**

A "LogiCore Solutions" é uma startup em crescimento que está desenvolvendo uma plataforma para otimizar operações logísticas. O seu primeiro grande desafio é criar o módulo central do sistema: o **Sistema de Gerenciamento de Frota (SGF-Log)**. Este módulo será responsável por cadastrar, gerenciar e operar uma frota diversificada de veículos para realizar entregas.

## **O Problema**

A frota da LogiCore não é homogênea. Ela é composta por diferentes tipos de veículos, cada um com suas próprias especificidades, custos operacionais e capacidades. O sistema precisa ser robusto e flexível para acomodar novos tipos de veículos no futuro com o mínimo de retrabalho.

Sua tarefa é projetar e implementar a estrutura de software fundamental para este sistema.

---

## **Requisitos do Desafio**

### **1. O Conceito de Veículo**

* O sistema deve ser capaz de representar o conceito de "Veículo".
* Todos os veículos compartilham os seguintes atributos:
    * `placa` (String)
    * `marca` (String)
    * `modelo` (String)
    * `anoFabricacao` (int)
    * `capacidadeCargaKg` (double) - Peso máximo que pode transportar.
    * `cargaAtualKg` (double) - Peso que está transportando no momento.
* É importante notar que um "veículo" genérico não pode existir concretamente no sistema; apenas seus tipos específicos (como caminhões, vans, etc.) podem ser criados e operados.
* Todos os veículos devem responder às seguintes ações:
    * Ser carregado com um determinado peso. A operação deve falhar se o peso exceder a capacidade.
    * Ser descarregado de um determinado peso.
    * Calcular o custo de uma viagem baseada em uma distância em quilômetros. A fórmula para este cálculo é totalmente diferente para cada tipo de veículo e não existe uma fórmula "padrão".

### **2. Tipos de Veículos na Frota**

O sistema deve, inicialmente, suportar três tipos de veículos:

* **`Caminhao`**:
    * Possui um atributo adicional: `numeroDeEixos` (int).
    * Fórmula de custo de viagem: `(distanciaKm * 1.85) + (numeroDeEixos * 25.50)`. Um acréscimo de 10% sobre o custo total é aplicado se a carga atual for superior a 5000 kg.

* **`Van`**:
    * Possui um atributo adicional: `possuiSeguro` (boolean).
    * Fórmula de custo de viagem: `distanciaKm * 1.30`. Se possuir seguro, há um custo fixo adicional de `R$ 150,00` na viagem.

* **`Drone`**:
    * Possui um atributo adicional: `tipoBateria` (String).
    * Fórmula de custo de viagem: `(distanciaKm * 0.75) + (autonomiaRestanteBateriaEmHoras * 5.0)`. Você pode tratar a `autonomiaRestanteBateriaEmHoras` como um valor fixo ou um atributo.

### **3. Capacidades Operacionais Adicionais**

* Certos veículos, como `Caminhao` e `Van`, requerem manutenção periódica. O sistema deve permitir que uma ação de `realizarManutencao` seja executada nesses veículos. A ação deve simplesmente indicar qual veículo está em manutenção.
* Apenas os caminhões estão habilitados para transportar cargas especiais. Para eles, o sistema deve ser capaz de `emitirLicencaTransporte`, que gera um código de licença simulado.

### **4. Flexibilidade no Carregamento**

O sistema precisa de duas formas de registrar o carregamento de um veículo. A primeira é simplesmente pelo peso (um número `double`). A segunda é por um objeto de `Carga`, que contém uma `descricao` (String) e o seu `pesoKg` (double). O sistema deve ser capaz de lidar com ambas as chamadas.

### **5. Gerenciamento Central da Frota**

* Deve haver uma entidade no sistema capaz de agrupar e gerenciar todos os veículos existentes.
* Esta entidade deve permitir:
    * Adicionar um novo veículo à frota.
    * Remover um veículo da frota pela sua placa.
    * Listar os detalhes de todos os veículos cadastrados.
    * Gerar um relatório de custos. Este relatório deve receber uma distância como parâmetro e exibir o custo da viagem para **cada um** dos veículos na frota, de acordo com suas próprias fórmulas de cálculo.

### **6. O Desafio de Otimização**

O gerenciador da frota precisa de uma funcionalidade inteligente:

* Crie uma operação chamada `designarVeiculoParaEntrega` que recebe uma `Carga` e uma `distanciaKm`.
* Esta operação deve varrer a frota e determinar qual veículo disponível é a opção **mais barata** para realizar essa entrega específica.
* **Regras para seleção:**
    1.  O veículo deve ter capacidade para transportar o peso da carga.
    2.  O espaço disponível no veículo (`capacidade - cargaAtual`) deve ser suficiente para a nova carga.
* A operação deve retornar o veículo escolhido. Se nenhum veículo for adequado, deve sinalizar essa impossibilidade (seja retornando `null`, uma `Optional` vazia ou lançando uma exceção – a escolha de design é sua).

---

## **O que você deve entregar:**

1.  O código-fonte completo em Java que implementa a solução para os requisitos acima.
2.  Uma classe `Main` (ou de teste) que demonstre o funcionamento do sistema:
    * Crie o gerenciador da frota.
    * Adicione pelo menos um `Caminhao`, uma `Van` e um `Drone`.
    * Demonstre as diferentes formas de carregar um veículo.
    * Execute a geração do relatório de custos.
    * Invoque as capacidades especiais de manutenção e emissão de licença nos veículos aplicáveis.
    * Demonstre a funcionalidade de `designarVeiculoParaEntrega` para encontrar a opção mais econômica para uma entrega.

### **Critérios de Avaliação:**

* **Lógica de Negócio:** O programa resolve os problemas descritos, especialmente o cálculo de custos e a lógica de designação do veículo?
* **Estrutura e Design de Software:** A solução é bem estruturada, flexível e extensível? A forma como você modelou as entidades e suas relações será o ponto principal da avaliação.
* **Aplicação de Paradigmas:** Sua solução demonstra um bom domínio dos conceitos fundamentais da Programação Orientada a Objetos? (ex: Abstração, Encapsulamento, Herança, Polimorfismo).
* **Qualidade do Código:** Legibilidade, organização e boas práticas de programação em Java.
* **Tratamento de Casos de Borda:** A solução é robusta a situações como tentar carregar peso excessivo ou não encontrar um veículo disponível?