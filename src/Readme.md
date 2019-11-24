Requisitos do trabalho:

    Protóripo para gerenciamento de memória para uso de paginação

    - Vai ter uma área de memória
    -- A memória vai ter um tamanho e um tamanho de quadros, cada quadro vai ser um x, e o numero de espaços nesse quadro vai ser o resultado de (memória / quadros). (Sempre multiplos de 2, lançar erro caso não seja)
    --- Cada espaçozinho vai ter 256 bytes;

    Gerenciador vai ter:
    - Informações sobre as páginas livres; (LinkedList)
    - Cada novo processo vai ter uma tabela de páginas;
    - Cada tabela têm uma tamanho máximo; (cada processo têm um tamanho máximo) **Configurável
    - "Alocar" memória para novos processos; (a partir da memória livre dar para a tabela do processo baseado no tamanho do mesmo)
    - NÃO PRECISA DE SUBSTITUIÇÃO DE PÁGINAS;

    Informações extras:
    - A tabela de páginas é uma lista onde cada posição indica o indice de um quadro na memória;

    Interface com o usuário:
    - Visualizar memoria():
    -- Exibe cada bagulhinho da memória e o número de bytes alocados em cada um;
    -- Inicialmente todas estão vazias (a vá)

    - Cria processo(ProcId, Tamanho)
    -- Recebe o tamanho do processo em Bytes na sua criação;
    -- Cria uma tabela de páginas para o processo
    --- Todas as posições da tabela apontam para (-0)
    - O gerenciador de processos mantém as tabelas dos processos (map)

    - Visualizar tabela de memória (proc ID)
    -- Exibe a tabela de páginas do processo;
    -- Exibe o tamanho do processo (o indicado na criação do processo);

    - O simulador deve ser configurável
    -- Tamanho de memória, tamanho de quadros/páginas, tamanho máximo de um processo;

    Mostrar exceções:
    - Criar processo maior doq o tamanho máximo;
    - Criar um processo quando a memória já está cheia (tente mais tarde);
    - Criar um processo com tamanho maior que a memória;
    Outros;

Planejamento:
    MODELO:
        Memória:
        - Vai ter dentro uma linkedList; (ou arrayList)
        -- Cada posição é 256 bytes;
        - Vai ter um tamanho de quadros e funções para retornar um quadro inteiro;
        -- Vai ter uma função para retornar o número de bytes em cada quadro;
        - Vai manter informações sobre quadros usados e quadros vazios;
        -- Get próximo quadro vazio;
        -- ToString() que devolve a memória (o array bonitinho)
        - Vai ter uma função que devolve um quadro, baseado no seu "index"; (calculo on the fly)

        Página:
        - Indica o número do quadro que corresponde ao espaço de memória utilizado;
        
        Tabela de páginas:
        - Contém uma lista de páginas, e o id de um processo (usar o id para acessar o tamanho máximo)

        Processo:
        - ProcID; (definido pelo usuário)
        - Tamanho.

        Configuração:
        - Mantém informações configuradas no inicio do programa;

    CONTROLE
        MMU
        - Gerencia as outras classes para realizar as operações (Controller)
        -- Como criar e manter uma tabela, tratar das validações necessárias;
        --- Considerar o tamanho do processo e tamanhos disponíveis e tudo;

    VISÃO
        Mostrar interações com usuário;


Esse projeto foi desenvolvido pelos colaboradores atráves do liveshare