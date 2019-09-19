/*
 * Referência da API | Plataforma Digital
 * (doc 1.0.37 | 14/1/2019)  # Introdução Bem-vindo à Getnet!  Este é o manual para que você possa integrar sua empresa à Plataforma de Digital da Getnet e começar a usufruir das melhores soluções do mercado.  Para atendê-lo da melhor maneira, a Getnet oferece diferentes soluções seguras para captura de transações de E-Commerce. Estes serviços permitem aos estabelecimentos credenciados aceitar cartões de crédito, cartões de débito e boletos bancários como forma de pagamento em suas lojas virtuais através da implementação de processos simples.  Além dos serviços de pagamento, a Getnet oferece serviços de cofre, recorrência, antifraude, conciliador e outras facilidades para atender seu negócio com rapidez e segurança.  Sugerimos que este documento seja lido com atenção, e usado como guia de referência para quaisquer dúvidas não somente no momento da implementação da integração de sua plataforma de comércio eletrônico com a Rede de Adquirência da Getnet, mas para quaisquer mudanças nos sistemas.  O conteúdo deste Manual de Integração se destina a programadores e desenvolvedores de plataformas para comércio eletrônico que desejam realizar a captura e o processamento de suas transações diretamente com a Rede Adquirente da Getnet.  Neste documento o desenvolvedor/analista terá acesso a todos os passos e processos referentes à integração com o sistema de captura e autorização de transações financeiras da Getnet via as funcionalidades da API.  Sugerimos também que, periodicamente e sempre que for iniciar um desenvolvimento relacionado à captura de transações, utilize este portal para acompanhamento de mudanças e versionamento dos produtos de nossa plataforma.  # Soluções  Para atender a todas as demandas de nossos clientes, criamos uma Plataforma de E-Commerce que conta com um conjunto de soluções diversificadas para cada necessidade. Essas soluções estão agrupadas em 2 modelos, de acordo com a forma de captura das transações. São eles:  * E-Commerce WEB via Checkout Iframe  * E-Commerce WEB via API  Este manual cobre o modelo de E-Commerce WEB via API, que realiza a conexão com a Getnet utilizando protocolo HTTPS tendo sua chamada através de WebServices em REST. # Requisitos de Infraestrutura ### Protocolo TLS Prezado Cliente, conforme comunicações realizadas previamente por email, gostaríamos de reforçar que: De acordo com os requisitos da normativa do PCI DSS 3.2 que regulamentam os ambientes transacionais, desde de o dia 30/06/2018 às 22h00 nossos serviços de e-commerce somente trabalham no protocolo de criptografia TLS 1.1 e superiores. A versão antiga do TLS 1.0 e anteriores foram desativadas permanentemente.  Para evitar qualquer impacto em sua plataforma, é importante que você confira se seus sistemas estão aptos a trabalhar no protocolo TLS 1.1 e superiores, que são mais seguros e aceitos pelo PCI. Você não pode mais efetuar transações no protocolo TLS 1.0.  Maiores informações podem ser encontradas diretamente no site do PCI.  <a href=\"https://www.pcisecuritystandards.org/documents/Migrating_from_SSL_Early_TLS_Information%20Supplement_v1.pdf\">Migrating From SSL Early TLS InformationSupplement v1.pdf</a>  # Como começar A Plataforma Digital é um ecossistema completo criado para fornecer as mais diversas soluções para o mercado de pagamentos (eCommerce, mCommerce).  Temos disponíveis as seguintes funcionalidades transacionais: Crédito à Vista, Crédito Parcelado Lojista, Crédito com Pré-autorização, Crédito com Confirmação Tardia, Crédito Autenticado, Débito Autenticado, Verificação de Cartão e Boleto Registrado.  Mais informações: https://developers.getnet.com.br/api#section/Funcionalidades  Além dos seguintes módulos para enriquecer a experiência de pagamentos de sua loja e de seus clientes:  ### Checkout digital seguro  O checkout é a forma mais simples de realizar a integração com a Getnet. Com ele você não precisa se preocupar com segurança no envio dos dados. Basta realizar a implementação da nossa solução via API ou iFrame que nós cuidaremos de todo o resto.  ### Pagamento via boleto  Mais uma comodidade para negócios que possuem convênio com Santander. Através dele seu negócio terá mais oportunidades de vendas. Os boletos são gerados já com registro XML, adequados ao modelo FEBRABAN.  ### Antifraude  Tenha mais segurança nas transações através da análise de comportamento de compra do consumidor. Em casos de atitudes suspeitas a transação é bloqueada automaticamente, evitando risco para seu negócio e dando mais segurança aos clientes do seu e-commerce.  ### Cofre  Ofereça aos seus clientes a possibilidade de guardar as informações dos cartões utilizados para uso futuro, melhorando a experiência de consumo em uma compra futura. Tudo isso de maneira segura, através da certificação PCI.  ### Conciliador Financeiro  Tenha acesso a uma visão única e integrada do seu fluxo de caixa e aumente a eficiência das análises financeiras, consultas a transações e taxas.  ### Recorrência  Se seu e-commerce trabalha com mensalidades ou cobranças recorrentes, com a solução Getnet é possível realizar a gestão das cobranças que possuem periodicidade sem precisar reinserir os dados do cartão.  ### Consultoria Getnet  Conte com um time especializado em negócios digitais, prontos para oferecer uma consultoria completa em meios de pagamento. Desde a identificação das necessidades do seu negócio até a customização de soluções e acompanhamento do pós-implantação.  ## Criando a sua conta no Sandbox  O Sandbox da Plataforma Digital é a maneira mais ágil para você, desenvolvedor, experimentar nossos serviços de ecommerce.  Crie uma conta através do link a seguir, precisando somente de email e senha: https://developers.getnet.com.br/login ##  Obtenção de chaves de autenticação Suas chaves de autenticação para o ambiente do Sandbox são disponibilizadas na aba de Configurações, aqui: https://developers.getnet.com.br/dashboard#/api  ## Funcionalidades no Sandbox  O path de utilização do ambiente do sandbox via api é: api-sandbox.getnet.com.br  Atualmente, estão disponíveis no Sandbox os seguintes serviços da API: * Autenticação Oauth * Tokenização de cartão * Pagamento com cartão de crédito * Pagamento com cartão de débito * Pagamento com boleto * Cancelamento de pagamento com cartão  Também estão disponíveis no Sandbox os seguintes simuladores: * Tokenização de cartão * Pagamento com cartão de crédito * Pagamento com cartão de débito * Pagamento com boleto  Você pode acessar nosso simulador intuitivo através do seguinte link: https://developers.getnet.com.br/dashboard#/simulation  Você também pode conferir o histórico de utilização do ambiente de Sandbox através da aba Logs: https://developers.getnet.com.br/dashboard#/logs  ## Não sou desenvolvedor  Caso você tenha caído nesta seção e não seja um desenvolvedor, não entre em pânico! A Plataforma Digital também é o produto certo para você!  Nossa orientação é procurar nosso parceiro de plataforma de ecommerce, VTEX (http://www.vtex.com/).  O qual tem um leque de soluções para vendas online já desenvolvidas e prontas para contratação. Incluindo a integração com o ecommerce Getnet!  As seguintes funcionalidades estão disponíveis no plugin VTEX:  <br> <table class=\"table table-bordered\">   <tr>     <th>Funcionalidade</th>     <th>VTEX</th>   </tr>   <tr>     <th>Crédito à Vista</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i> (Somente no formato de Captura Tardia)</td>   </tr>   <tr>     <th>Crédito Parcelado Lojista (sem Juros)</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>   </tr>   <tr>     <th>Crédito Parcelado Emissor (com Juros)</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>   </tr>   <tr>     <th>Crédito Autenticado</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>   </tr>   <tr>     <th>Débito Autenticado</th>     <td></td>   </tr>   <tr>     <th>Pré-autorização</th>     <td></td>   </tr>   <tr>     <th>Verificação de Cartão</th>     <td></td>   </tr>   <tr>     <th>MCC Dinâmico</th>     <td></td>   </tr>   <tr>     <th>Soft Descriptor</th>     <td></td>   </tr>   <tr>     <th>Recorrência</th>     <td></td>   </tr> </table> <br>  ## Processo de Homologação  Para iniciar a homologação de sua integração com a Plataforma Digital da Getnet, utilizando nosso ambiente de testes você precisa ser credenciado na Getnet.  Caso já seja cliente nosso, procure seu contato comercial com a Getnet para que ele solicite a habilitação do produto Plataforma Digital para você.  Caso você não seja cliente, procure seu gerente de conta Santander e solicite mais informações sobre o Ecommerce Getnet.  Os cartões de teste aceitos neste ambiente são encontrados nesta documentação no tópico Cartões de Teste (https://developers.getnet.com.br/api#section/Cartoes-para-Teste)  ## Necessita ajuda  Quaisquer dúvidas técnicas, fique à vontade para contatar nosso time pela caixa atendimento_ecommerce@getnet.com.br.  # Funcionalidades  * Pagamentos: Crédito à Vista, Crédito Parcelado Lojista, Crédito com Pré-autorização, Crédito com Confirmação Tardia, Crédito Autenticado, Débito Autenticado, Verificação de Cartão e Boleto Registrado.  * Produtos: Antifraude, Cofre, Recorrência e Conciliação de Transações.  ## Funcionalidades por Bandeira  <table>   <tr>     <th>Funcionalidade</th>     <th>Mastercard</th>     <th>Visa</th>     <th>Amex</th>     <th>Elo</th>     <th>Hipercard</th>   </tr>   <tr>     <th>Crédito à Vista</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>   </tr>   <tr>     <th>Crédito Parcelado Lojista (sem Juros)</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>   </tr>   <tr>     <th>Crédito Parcelado Emissor (com Juros)</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>   </tr>   <tr>     <th>Crédito Autenticado</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td></td>     <td></td>     <td></td>   </tr>   <tr>     <th>Débito Autenticado</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td></td>     <td></td>     <td></td>   </tr>   <tr>     <th>Pré-autorização</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>   </tr>   <tr>     <th>Verificação de Cartão</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td></td>     <td></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>   </tr>   <tr>     <th>MCC Dinâmico</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>   </tr>   <tr>     <th>Soft Descriptor</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>   </tr>   <tr>     <th>Recorrência</th>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td><i class=\"fa fa-check fa-2x\" aria-hidden=\"true\"></i></td>     <td></td>     <td></td>     <td></td>   </tr> </table>  # Cartões para Teste  Para fim de teste podem ser utilizados os seguintes cartões:  <table>   <tr>     <th>Cartão</th>     <th>Tipo de Teste</th>     <th>Resultado do Teste</th>   </tr>   <tr>     <td><i class=\"fa fa-cc-mastercard fa-2x\" aria-hidden=\"true\"></i> 5155901222280001</td>     <td>Transação Autorizada</td>     <td><i class=\"fa fa-check-circle-o fa-1x\" aria-hidden=\"true\"></i> Transação Aprovada</td>   </tr>   <tr>     <td><i class=\"fa fa-cc-mastercard fa-2x\" aria-hidden=\"true\"></i> 5155901222270002</td>     <td>Transação Não Autorizada</td>     <td><i class=\"fa fa-times-circle-o fa-1x\" aria-hidden=\"true\"></i> Cartão Inválido</td>   </tr>   <tr>     <td><i class=\"fa fa-cc-mastercard fa-2x\" aria-hidden=\"true\"></i> 5155901222260003</td>     <td>Transação Não Autorizada</td>     <td><i class=\"fa fa-times-circle-o fa-1x\" aria-hidden=\"true\"></i> Cartão Vencido</td>   </tr>   <tr>     <td><i class=\"fa fa-cc-mastercard fa-2x\" aria-hidden=\"true\"></i> 5155901222250004</td>     <td>Transação Não Autorizada</td>     <td><i class=\"fa fa-times-circle-o fa-1x\" aria-hidden=\"true\"></i> Estabelecimento Inválido</td>   </tr>   <tr>     <td><i class=\"fa fa-cc-mastercard fa-2x\" aria-hidden=\"true\"></i> 5155901222240005</td>     <td>Transação Não Autorizada</td>     <td><i class=\"fa fa-times-circle-o fa-1x\" aria-hidden=\"true\"></i> Saldo Insuficiente</td>   </tr>   <tr>     <td><i class=\"fa fa-cc-mastercard fa-2x\" aria-hidden=\"true\"></i> 5155901222230006</td>     <td>Transação Não Autorizada</td>     <td><i class=\"fa fa-times-circle-o fa-1x\" aria-hidden=\"true\"></i> Autorização Recusada</td>   </tr>   <tr>     <td><i class=\"fa fa-cc-mastercard fa-2x\" aria-hidden=\"true\"></i> 5155901222220007</td>     <td>Transação Não Autorizada</td>     <td><i class=\"fa fa-times-circle-o fa-1x\" aria-hidden=\"true\"></i> Transacao Não Processada</td>   </tr>   <tr>     <td><i class=\"fa fa-cc-mastercard fa-2x\" aria-hidden=\"true\"></i> 5155901222210008</td>     <td>Transação Não Autorizada</td>     <td><i class=\"fa fa-times-circle-o fa-1x\" aria-hidden=\"true\"></i> Excede o Limite de Retiradas</td>   </tr>   <tr>     <td><i class=\"fa fa-cc-visa fa-2x\" aria-hidden=\"true\"></i> 4012001037141112</td>     <td>Transação Autorizada</td>     <td><i class=\"fa fa-check-circle-o fa-1x\" aria-hidden=\"true\"></i> Transação Aprovada</td>   </tr> </table>   Observação: Ao utilizar os cartões de teste, é necessário ter atenção em alguns pontos:  * Utilize uma data de vencimento válida, ou seja, posterior à data atual.  * O nome do portador não deve ter caracteres especiais, como acento e Ç.  * O valor do CVV pode ser qualquer valor numérico com três dígitos.  * Para <b>operações de tipo Débito</b>, deve-se utilizar somente o cartão Visa: 4012001037141112.  ### Como usar cartões de teste em compras com parcelamento Para testar compras com parcelamento em nosso ambiente de teste, você pode utilizar um dos cartões de teste Mastercard ou Visa disponibilizados. Porém, se optar por um cartão Mastercard, é necessário enviar valores específicos na transação, de acordo com a tabela abaixo:  <table>   <caption>Parcelado Lojista Mastercard <i class=\"fa fa-cc-mastercard fa-2x\" aria-hidden=\"true\"></i></caption>   <tr>     <th>transaction_type</th>     <th>number_installments</th>     <th>amount</th>   </tr>   <tr>     <td>INSTALL_NO_INTEREST</td>     <td>3</td>     <td>nnn0303</td>   </tr>   <tr>     <td>INSTALL_NO_INTEREST</td>     <td>4</td>     <td>nnn0404</td>   </tr>   <tr>     <td>INSTALL_NO_INTEREST</td>     <td>5</td>     <td>nnn0505</td>   </tr>   <tr>     <td>INSTALL_NO_INTEREST</td>     <td>6</td>     <td>nnn0606</td>   </tr>   <tr>     <td>INSTALL_WITH_INTEREST</td>     <td>3</td>     <td>nnn0303</td>   </tr>   <tr>     <td>INSTALL_WITH_INTEREST</td>     <td>4</td>     <td>nnn0404</td>   </tr>   <tr>     <td>INSTALL_WITH_INTEREST</td>     <td>5</td>     <td>nnn0505</td>   </tr>   <tr>     <td>INSTALL_WITH_INTEREST</td>     <td>6</td>     <td>nnn0606</td>   </tr>  </table> <br> <table>   <caption>Parcelado Lojista Visa <i class=\"fa fa-cc-visa fa-2x\" aria-hidden=\"true\"></i></caption>   <tr>     <th>transaction_type</th>     <th>number_installments</th>     <th>amount</th>   </tr>   <tr>     <td>INSTALL_NO_INTEREST</td>     <td>3</td>     <td>nnn0303</td>   </tr>   <tr>     <td>INSTALL_NO_INTEREST</td>     <td>4</td>     <td>nnn0404</td>   </tr>   <tr>     <td>INSTALL_NO_INTEREST</td>     <td>5</td>     <td>nnn0505</td>   </tr>   <tr>     <td>INSTALL_NO_INTEREST</td>     <td>6</td>     <td>nnn0606</td>   </tr>   <tr>     <td>INSTALL_WITH_INTEREST</td>     <td>2</td>     <td>20221</td>   </tr>   <tr>     <td>INSTALL_WITH_INTEREST</td>     <td>3</td>     <td>30221</td>   </tr>   <tr>     <td>INSTALL_WITH_INTEREST</td>     <td>4</td>     <td>40221</td>   </tr>   <tr>     <td>INSTALL_WITH_INTEREST</td>     <td>5</td>     <td>50221</td>   </tr> </table>  Sendo nnn qualquer valor. Essas regras são exclusivas para a bandeira Mastercard em nosso ambiente de teste e não se aplicam ao ambiente produtivo.  # Antifraude  O Antifraude lhe dá melhor visão do comportamento do seu cliente durante a compra, passando segurança ao comprador e a loja virtual em que a operação está acontecendo.  O Antifraude tem um papel importantíssimo para avaliar se as transações que passam pela loja virtual são seguras, além de entregar uma maior rentabilidade para o seu negócio através dos seguintes fatores: melhores vendas, melhor experiência de compra e mínimo de perdas.  Temos um grande diferencial que é a impressão digital de dispositivos (Device Fingerprint), monitoramento de velocidade, mudança de identidade dos dados, score antifraude específico para o segmento do seu negócio, modelos retroalimentados para evolução contínua, inteligência artificial, controle de qualidade e detecção de ataques.  Todas as transações são imediatamente submetidas à análise de fraude por uma infraestrutura robusta que está preparada para grandes volumes de transações e com altíssimo nível de segurança,  Detecte fraudes com facilidade em ambientes online ou no aplicativo e onde quer que seus negócios sejam oferecidos. Você pode melhorar a experiência de compra, fidelizar seu cliente e aumentar a taxa de conversão com facilidade. <div class=\"alert alert-warning show\" role=\"alert\">   <strong>Atenção:</strong> O Antifraude da Getnet é ativado por padrão para todos os nossos clientes, caso não seja interesse de você utilizar nossa ferramenta de prevenção a fraudes, favor enviar um email para suporte.edigital@getnet.com.br solicitando a desativação da mesma. </div>  ###  Integrando ao E-Commerce  A integração do FingerPrinting resume-se a duas etapas :  #### __1. Incluir a chamada__  ```javascript   <!-- HEAD -->   <head>   <script type=\"text/javascript\" src=\"https://h.online-metrix.net/fp/tags.js?org_id=1snn5n9w&session_id=123456789\"></script>   </head> ``` ou ```javascript   <!-- BODY -->     <body>     <noscript>     <iframe style=\"width: 100px; height: 100px; border: 0; position:absolute; top: -5000px;\" src=\"https://h.online-metrix.net/fp/tags?org_id=1snn5n9w &session_id=123456789\"></iframe>     </noscript>     </body> ``` Essas chamadas devem ser todas incluídas para darem suporte à diversos tipos de dispositivos que venham a utilizar o E-Commerce. A execução dessa chamada é responsável por gerar o <b>deviceFingerprintID</b> na CyberSource.  #### __2. Variáveis <i>\"org_id\" e \"session_id\"</i>__  Essas duas variáveis devem ser passadas de forma obrigatória para ser gerado o <b>FingerPrint</b>.  Onde:  <b>1snn5n9w</b> é o org_id. Este código do org_id é utilizado somente em ambiente de teste da CyberSource. Para o ambiente de produção o org_id utilizado é o <b>k8vif92e</b>.  <b>123456789</b> é o exemplo da session_id. A session_id deve ser composto por um identificador único (por um período de 48 horas) com até 80 caracteres. Como exemplo, pode-se utilizar o identificador do pedido ou tracknumber de seu E-Commerce.  Para o carregamento do script, recomenda-se colocar as <b> chamadas do item 1</b> entre a tag  <body> ou <head>.  Inclua apenas elementos HTML visíveis. Os segmentos de código devem ser carregados antes do cliente efetuar o checkout. Os códigos que você precisa colocar na sua página podem ser <b>http ou https</b>.  #### __3. Enviando <i>deviceFingerprintID no checkOut</i>__  No momento de checkOut, uma informação de campo da API (deviceFingerPrintId) deve ser incluída no Pedido para ser enviado para o CYBS (Gerenciador de Decisão da CyberSource).  Com isso um elemento de página deve ser populado com o identificador exclusivo e único para ser enviado.  O <b>deviceFingerprintID</b> é o session_id reprsentado por <b>123456789</b> no exemplo acima.  ```javascript   <input type=\"hidden\" name=\"deviceFingerprintID\" value=\"123456789\" />; ``` #### __4. Especificação do <i>\"session_id\"</i>__  * Tipo : String * Tamanho : Até 80 bytes * Dado : Caracteres permitidos [a-z], [A-Z], 0-9, _, -  Recomendamos um hash com no mínimo 12 e no máximo 30 caracteres alfanuméricos (suficiente para que não haja repetição).  ###  Dados para análise de Antifraude  #### Campos para análise  Para melhor assertividade na análise do Antifraude, além dos dados comuns da compra que devem ser enviados, é <b>mandatório</b> o preenchimento e envio das seguintes informações:  #### Dados do Dono do Cartão  <table>   <tr>     <th>Campo</th>     <th>Descrição</th>     <th>Exemplo</th>   </tr>   <tr>     <td>first_name</td>     <td>Primeiro nome do comprador.</td>     <td>Luciano</td>   </tr>   <tr>     <td>last_name</td>     <td>Último nome do comprador.</td>     <td>Santos</td>   </tr>   <tr>     <td>document_number</td>     <td>Número do documento do comprador sem pontuação. (sem máscara)</td>     <td>01234567890</td>   </tr>   <tr>     <td>email</td>     <td>Email do comprador.</td>     <td>email.do.portador@dominio.com.br</td>   </tr> </table>  #### Dados do Endereço de Cobrança do Dono do Cartão  <table>   <tr>     <th>Campo</th>     <th>Descrição</th>     <th>Exemplo</th>   </tr>   <tr>     <td>street</td>     <td>Logradouro.</td>     <td>Av. Paulista</td>   </tr>   <tr>     <td>number</td>     <td>Número do logradouro.</td>     <td>Santos</td>   </tr>   <tr>     <td>complement</td>     <td>Complemento do logradouro.</td>     <td>01234567890</td>   </tr>   <tr>     <td>city</td>     <td>Cidade.</td>     <td>São Paulo</td>   </tr>   <tr>     <td>state</td>     <td>Estado (UF).</td>     <td>São Paulo</td>   </tr>   <tr>     <td>country</td>     <td>País.</td>     <td>Brasil</td>   </tr>   <tr>     <td>postal_code</td>     <td>Código Postal, CEP no Brasil ou ZIP nos Estados Unidos. (sem máscara)</td>     <td>01311300</td>   </tr> </table>  #### Dados da compra  <table>   <tr>     <th>Campo</th>     <th>Descrição</th>     <th>Exemplo</th>   </tr>   <tr>     <td>amount</td>     <td>Valor da compra em centavos.</td>     <td>100</td>   </tr> </table>  # API  ## Introdução  O objetivo deste documento é descrever a interface das APIs de integração da Plataforma Digital da Getnet com o E-commerce. 
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package br.com.getnet.pagamento.api;

import br.com.getnet.pagamento.client.ApiCallback;
import br.com.getnet.pagamento.client.ApiClient;
import br.com.getnet.pagamento.client.ApiException;
import br.com.getnet.pagamento.client.ApiResponse;
import br.com.getnet.pagamento.client.Configuration;
import br.com.getnet.pagamento.client.Pair;
import br.com.getnet.pagamento.client.ProgressRequestBody;
import br.com.getnet.pagamento.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import java.math.BigDecimal;
import br.com.getnet.pagamento.model.ChargeFilterResponse;
import br.com.getnet.pagamento.model.Error;
import br.com.getnet.pagamento.model.Subscription;
import br.com.getnet.pagamento.model.SubscriptionCancel;
import br.com.getnet.pagamento.model.SubscriptionConfirm;
import br.com.getnet.pagamento.model.SubscriptionFilterResponse;
import br.com.getnet.pagamento.model.SubscriptionPaymentDate;
import br.com.getnet.pagamento.model.SubscriptionProjectionResponse;
import br.com.getnet.pagamento.model.SubscriptionResponse;
import br.com.getnet.pagamento.model.SubscriptionUpdatePaymentType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssinaturasApi {
    private ApiClient apiClient;

    public AssinaturasApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AssinaturasApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for v1ChargesGet
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param page Número da página em que inicia a paginação. (required)
     * @param limit Limite de resultados por página. (required)
     * @param chargeId Identificador da cobrança. (optional)
     * @param sellerId2 Código de identificação do e-commerce. (optional)
     * @param subscriptionId Identificador da assinatura de recorrência. (optional)
     * @param status Status da cobrança. (optional)
     * @param startDate Data de início. (optional)
     * @param endDate Data final. (optional)
     * @param scheduledDate Data de agendamento. (optional)
     * @param retries Número de retentativas. (optional)
     * @param sort Campo para realizar a ordenação. (optional, default to create_date)
     * @param sortType Tipo de ordenação. Ascendente ou Descendente. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1ChargesGetCall(String authorization, String sellerId, BigDecimal page, BigDecimal limit, String chargeId, String sellerId2, String subscriptionId, String status, String startDate, String endDate, String scheduledDate, BigDecimal retries, String sort, String sortType, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/charges";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (chargeId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("charge_id", chargeId));
        if (sellerId2 != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("seller_id", sellerId2));
        if (subscriptionId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("subscription_id", subscriptionId));
        if (status != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("status", status));
        if (startDate != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("start_date", startDate));
        if (endDate != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("end_date", endDate));
        if (scheduledDate != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("scheduled_date", scheduledDate));
        if (retries != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("retries", retries));
        if (sort != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sort", sort));
        if (sortType != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sort_type", sortType));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));
        if (sellerId != null)
        localVarHeaderParams.put("seller_id", apiClient.parameterToString(sellerId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call v1ChargesGetValidateBeforeCall(String authorization, String sellerId, BigDecimal page, BigDecimal limit, String chargeId, String sellerId2, String subscriptionId, String status, String startDate, String endDate, String scheduledDate, BigDecimal retries, String sort, String sortType, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1ChargesGet(Async)");
        }
        
        // verify the required parameter 'sellerId' is set
        if (sellerId == null) {
            throw new ApiException("Missing the required parameter 'sellerId' when calling v1ChargesGet(Async)");
        }
        
        // verify the required parameter 'page' is set
        if (page == null) {
            throw new ApiException("Missing the required parameter 'page' when calling v1ChargesGet(Async)");
        }
        
        // verify the required parameter 'limit' is set
        if (limit == null) {
            throw new ApiException("Missing the required parameter 'limit' when calling v1ChargesGet(Async)");
        }
        

        com.squareup.okhttp.Call call = v1ChargesGetCall(authorization, sellerId, page, limit, chargeId, sellerId2, subscriptionId, status, startDate, endDate, scheduledDate, retries, sort, sortType, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Lista de cobranças
     * Retorna uma lista de cobranças cadastradas com base nos filtros escolhidos.
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param page Número da página em que inicia a paginação. (required)
     * @param limit Limite de resultados por página. (required)
     * @param chargeId Identificador da cobrança. (optional)
     * @param sellerId2 Código de identificação do e-commerce. (optional)
     * @param subscriptionId Identificador da assinatura de recorrência. (optional)
     * @param status Status da cobrança. (optional)
     * @param startDate Data de início. (optional)
     * @param endDate Data final. (optional)
     * @param scheduledDate Data de agendamento. (optional)
     * @param retries Número de retentativas. (optional)
     * @param sort Campo para realizar a ordenação. (optional, default to create_date)
     * @param sortType Tipo de ordenação. Ascendente ou Descendente. (optional)
     * @return ChargeFilterResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ChargeFilterResponse v1ChargesGet(String authorization, String sellerId, BigDecimal page, BigDecimal limit, String chargeId, String sellerId2, String subscriptionId, String status, String startDate, String endDate, String scheduledDate, BigDecimal retries, String sort, String sortType) throws ApiException {
        ApiResponse<ChargeFilterResponse> resp = v1ChargesGetWithHttpInfo(authorization, sellerId, page, limit, chargeId, sellerId2, subscriptionId, status, startDate, endDate, scheduledDate, retries, sort, sortType);
        return resp.getData();
    }

    /**
     * Lista de cobranças
     * Retorna uma lista de cobranças cadastradas com base nos filtros escolhidos.
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param page Número da página em que inicia a paginação. (required)
     * @param limit Limite de resultados por página. (required)
     * @param chargeId Identificador da cobrança. (optional)
     * @param sellerId2 Código de identificação do e-commerce. (optional)
     * @param subscriptionId Identificador da assinatura de recorrência. (optional)
     * @param status Status da cobrança. (optional)
     * @param startDate Data de início. (optional)
     * @param endDate Data final. (optional)
     * @param scheduledDate Data de agendamento. (optional)
     * @param retries Número de retentativas. (optional)
     * @param sort Campo para realizar a ordenação. (optional, default to create_date)
     * @param sortType Tipo de ordenação. Ascendente ou Descendente. (optional)
     * @return ApiResponse&lt;ChargeFilterResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ChargeFilterResponse> v1ChargesGetWithHttpInfo(String authorization, String sellerId, BigDecimal page, BigDecimal limit, String chargeId, String sellerId2, String subscriptionId, String status, String startDate, String endDate, String scheduledDate, BigDecimal retries, String sort, String sortType) throws ApiException {
        com.squareup.okhttp.Call call = v1ChargesGetValidateBeforeCall(authorization, sellerId, page, limit, chargeId, sellerId2, subscriptionId, status, startDate, endDate, scheduledDate, retries, sort, sortType, null, null);
        Type localVarReturnType = new TypeToken<ChargeFilterResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Lista de cobranças (asynchronously)
     * Retorna uma lista de cobranças cadastradas com base nos filtros escolhidos.
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param page Número da página em que inicia a paginação. (required)
     * @param limit Limite de resultados por página. (required)
     * @param chargeId Identificador da cobrança. (optional)
     * @param sellerId2 Código de identificação do e-commerce. (optional)
     * @param subscriptionId Identificador da assinatura de recorrência. (optional)
     * @param status Status da cobrança. (optional)
     * @param startDate Data de início. (optional)
     * @param endDate Data final. (optional)
     * @param scheduledDate Data de agendamento. (optional)
     * @param retries Número de retentativas. (optional)
     * @param sort Campo para realizar a ordenação. (optional, default to create_date)
     * @param sortType Tipo de ordenação. Ascendente ou Descendente. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1ChargesGetAsync(String authorization, String sellerId, BigDecimal page, BigDecimal limit, String chargeId, String sellerId2, String subscriptionId, String status, String startDate, String endDate, String scheduledDate, BigDecimal retries, String sort, String sortType, final ApiCallback<ChargeFilterResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = v1ChargesGetValidateBeforeCall(authorization, sellerId, page, limit, chargeId, sellerId2, subscriptionId, status, startDate, endDate, scheduledDate, retries, sort, sortType, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ChargeFilterResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1SubscriptionsGet
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param page Número da página em que inicia a paginação. (required)
     * @param limit Limite de resultados por página. (required)
     * @param customerId Identificador do comprador. (optional)
     * @param planId Identificador do plano de recorrência. (optional)
     * @param subscriptionId Identificador da assinatura de recorrência. (optional)
     * @param nextScheduledDateStart Data inicial do próximo agendamento. (optional)
     * @param nextScheduledDateEnd Data final do próximo agendamento. (optional)
     * @param createDateStart Data inicial de criação da assinatura. (optional)
     * @param createDateEnd Data final de criação da assinatura. (optional)
     * @param endDateStart Data inicial da assinatura. (optional)
     * @param endDateEnd Data final da assinatura. (optional)
     * @param sort Campo para realizar a ordenação. (optional, default to create_date)
     * @param sortType Tipo de ordenação. Ascendente ou Descendente. (optional, default to asc)
     * @param status Status da assinatura. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsGetCall(String authorization, String sellerId, BigDecimal page, BigDecimal limit, String customerId, String planId, String subscriptionId, String nextScheduledDateStart, String nextScheduledDateEnd, String createDateStart, String createDateEnd, String endDateStart, String endDateEnd, String sort, String sortType, String status, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/subscriptions";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (customerId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("customer_id", customerId));
        if (planId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("plan_id", planId));
        if (subscriptionId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("subscription_id", subscriptionId));
        if (nextScheduledDateStart != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("next_scheduled_date[start]", nextScheduledDateStart));
        if (nextScheduledDateEnd != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("next_scheduled_date[end]", nextScheduledDateEnd));
        if (createDateStart != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("create_date[start]", createDateStart));
        if (createDateEnd != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("create_date[end]", createDateEnd));
        if (endDateStart != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("end_date[start]", endDateStart));
        if (endDateEnd != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("end_date[end]", endDateEnd));
        if (sort != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sort", sort));
        if (sortType != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sort_type", sortType));
        if (status != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("status", status));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));
        if (sellerId != null)
        localVarHeaderParams.put("seller_id", apiClient.parameterToString(sellerId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call v1SubscriptionsGetValidateBeforeCall(String authorization, String sellerId, BigDecimal page, BigDecimal limit, String customerId, String planId, String subscriptionId, String nextScheduledDateStart, String nextScheduledDateEnd, String createDateStart, String createDateEnd, String endDateStart, String endDateEnd, String sort, String sortType, String status, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1SubscriptionsGet(Async)");
        }
        
        // verify the required parameter 'sellerId' is set
        if (sellerId == null) {
            throw new ApiException("Missing the required parameter 'sellerId' when calling v1SubscriptionsGet(Async)");
        }
        
        // verify the required parameter 'page' is set
        if (page == null) {
            throw new ApiException("Missing the required parameter 'page' when calling v1SubscriptionsGet(Async)");
        }
        
        // verify the required parameter 'limit' is set
        if (limit == null) {
            throw new ApiException("Missing the required parameter 'limit' when calling v1SubscriptionsGet(Async)");
        }
        

        com.squareup.okhttp.Call call = v1SubscriptionsGetCall(authorization, sellerId, page, limit, customerId, planId, subscriptionId, nextScheduledDateStart, nextScheduledDateEnd, createDateStart, createDateEnd, endDateStart, endDateEnd, sort, sortType, status, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Lista de assinaturas
     * Retorna a lista de assinaturas de recorrência cadastradas com base nos filtros escolhidos.
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param page Número da página em que inicia a paginação. (required)
     * @param limit Limite de resultados por página. (required)
     * @param customerId Identificador do comprador. (optional)
     * @param planId Identificador do plano de recorrência. (optional)
     * @param subscriptionId Identificador da assinatura de recorrência. (optional)
     * @param nextScheduledDateStart Data inicial do próximo agendamento. (optional)
     * @param nextScheduledDateEnd Data final do próximo agendamento. (optional)
     * @param createDateStart Data inicial de criação da assinatura. (optional)
     * @param createDateEnd Data final de criação da assinatura. (optional)
     * @param endDateStart Data inicial da assinatura. (optional)
     * @param endDateEnd Data final da assinatura. (optional)
     * @param sort Campo para realizar a ordenação. (optional, default to create_date)
     * @param sortType Tipo de ordenação. Ascendente ou Descendente. (optional, default to asc)
     * @param status Status da assinatura. (optional)
     * @return SubscriptionFilterResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SubscriptionFilterResponse v1SubscriptionsGet(String authorization, String sellerId, BigDecimal page, BigDecimal limit, String customerId, String planId, String subscriptionId, String nextScheduledDateStart, String nextScheduledDateEnd, String createDateStart, String createDateEnd, String endDateStart, String endDateEnd, String sort, String sortType, String status) throws ApiException {
        ApiResponse<SubscriptionFilterResponse> resp = v1SubscriptionsGetWithHttpInfo(authorization, sellerId, page, limit, customerId, planId, subscriptionId, nextScheduledDateStart, nextScheduledDateEnd, createDateStart, createDateEnd, endDateStart, endDateEnd, sort, sortType, status);
        return resp.getData();
    }

    /**
     * Lista de assinaturas
     * Retorna a lista de assinaturas de recorrência cadastradas com base nos filtros escolhidos.
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param page Número da página em que inicia a paginação. (required)
     * @param limit Limite de resultados por página. (required)
     * @param customerId Identificador do comprador. (optional)
     * @param planId Identificador do plano de recorrência. (optional)
     * @param subscriptionId Identificador da assinatura de recorrência. (optional)
     * @param nextScheduledDateStart Data inicial do próximo agendamento. (optional)
     * @param nextScheduledDateEnd Data final do próximo agendamento. (optional)
     * @param createDateStart Data inicial de criação da assinatura. (optional)
     * @param createDateEnd Data final de criação da assinatura. (optional)
     * @param endDateStart Data inicial da assinatura. (optional)
     * @param endDateEnd Data final da assinatura. (optional)
     * @param sort Campo para realizar a ordenação. (optional, default to create_date)
     * @param sortType Tipo de ordenação. Ascendente ou Descendente. (optional, default to asc)
     * @param status Status da assinatura. (optional)
     * @return ApiResponse&lt;SubscriptionFilterResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SubscriptionFilterResponse> v1SubscriptionsGetWithHttpInfo(String authorization, String sellerId, BigDecimal page, BigDecimal limit, String customerId, String planId, String subscriptionId, String nextScheduledDateStart, String nextScheduledDateEnd, String createDateStart, String createDateEnd, String endDateStart, String endDateEnd, String sort, String sortType, String status) throws ApiException {
        com.squareup.okhttp.Call call = v1SubscriptionsGetValidateBeforeCall(authorization, sellerId, page, limit, customerId, planId, subscriptionId, nextScheduledDateStart, nextScheduledDateEnd, createDateStart, createDateEnd, endDateStart, endDateEnd, sort, sortType, status, null, null);
        Type localVarReturnType = new TypeToken<SubscriptionFilterResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Lista de assinaturas (asynchronously)
     * Retorna a lista de assinaturas de recorrência cadastradas com base nos filtros escolhidos.
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param page Número da página em que inicia a paginação. (required)
     * @param limit Limite de resultados por página. (required)
     * @param customerId Identificador do comprador. (optional)
     * @param planId Identificador do plano de recorrência. (optional)
     * @param subscriptionId Identificador da assinatura de recorrência. (optional)
     * @param nextScheduledDateStart Data inicial do próximo agendamento. (optional)
     * @param nextScheduledDateEnd Data final do próximo agendamento. (optional)
     * @param createDateStart Data inicial de criação da assinatura. (optional)
     * @param createDateEnd Data final de criação da assinatura. (optional)
     * @param endDateStart Data inicial da assinatura. (optional)
     * @param endDateEnd Data final da assinatura. (optional)
     * @param sort Campo para realizar a ordenação. (optional, default to create_date)
     * @param sortType Tipo de ordenação. Ascendente ou Descendente. (optional, default to asc)
     * @param status Status da assinatura. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsGetAsync(String authorization, String sellerId, BigDecimal page, BigDecimal limit, String customerId, String planId, String subscriptionId, String nextScheduledDateStart, String nextScheduledDateEnd, String createDateStart, String createDateEnd, String endDateStart, String endDateEnd, String sort, String sortType, String status, final ApiCallback<SubscriptionFilterResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = v1SubscriptionsGetValidateBeforeCall(authorization, sellerId, page, limit, customerId, planId, subscriptionId, nextScheduledDateStart, nextScheduledDateEnd, createDateStart, createDateEnd, endDateStart, endDateEnd, sort, sortType, status, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubscriptionFilterResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1SubscriptionsPost
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Requisição contendo os dados para cadastro de uma nova assinatura. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsPostCall(String contentType, String authorization, String sellerId, String username, Subscription body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/v1/subscriptions";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));
        if (sellerId != null)
        localVarHeaderParams.put("seller_id", apiClient.parameterToString(sellerId));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call v1SubscriptionsPostValidateBeforeCall(String contentType, String authorization, String sellerId, String username, Subscription body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1SubscriptionsPost(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1SubscriptionsPost(Async)");
        }
        
        // verify the required parameter 'sellerId' is set
        if (sellerId == null) {
            throw new ApiException("Missing the required parameter 'sellerId' when calling v1SubscriptionsPost(Async)");
        }
        

        com.squareup.okhttp.Call call = v1SubscriptionsPostCall(contentType, authorization, sellerId, username, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Cadastra uma nova assinatura
     * Cadastra uma nova assinatura de recorrência.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Requisição contendo os dados para cadastro de uma nova assinatura. (optional)
     * @return SubscriptionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SubscriptionResponse v1SubscriptionsPost(String contentType, String authorization, String sellerId, String username, Subscription body) throws ApiException {
        ApiResponse<SubscriptionResponse> resp = v1SubscriptionsPostWithHttpInfo(contentType, authorization, sellerId, username, body);
        return resp.getData();
    }

    /**
     * Cadastra uma nova assinatura
     * Cadastra uma nova assinatura de recorrência.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Requisição contendo os dados para cadastro de uma nova assinatura. (optional)
     * @return ApiResponse&lt;SubscriptionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SubscriptionResponse> v1SubscriptionsPostWithHttpInfo(String contentType, String authorization, String sellerId, String username, Subscription body) throws ApiException {
        com.squareup.okhttp.Call call = v1SubscriptionsPostValidateBeforeCall(contentType, authorization, sellerId, username, body, null, null);
        Type localVarReturnType = new TypeToken<SubscriptionResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Cadastra uma nova assinatura (asynchronously)
     * Cadastra uma nova assinatura de recorrência.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Requisição contendo os dados para cadastro de uma nova assinatura. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsPostAsync(String contentType, String authorization, String sellerId, String username, Subscription body, final ApiCallback<SubscriptionResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = v1SubscriptionsPostValidateBeforeCall(contentType, authorization, sellerId, username, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubscriptionResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1SubscriptionsSubscriptionIdCancelPost
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Conjundo de dados adicionais para cancelamento. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdCancelPostCall(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionCancel body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/{subscription_id}/cancel"
            .replaceAll("\\{" + "subscription_id" + "\\}", apiClient.escapeString(subscriptionId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));
        if (sellerId != null)
        localVarHeaderParams.put("seller_id", apiClient.parameterToString(sellerId));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdCancelPostValidateBeforeCall(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionCancel body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1SubscriptionsSubscriptionIdCancelPost(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1SubscriptionsSubscriptionIdCancelPost(Async)");
        }
        
        // verify the required parameter 'sellerId' is set
        if (sellerId == null) {
            throw new ApiException("Missing the required parameter 'sellerId' when calling v1SubscriptionsSubscriptionIdCancelPost(Async)");
        }
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new ApiException("Missing the required parameter 'subscriptionId' when calling v1SubscriptionsSubscriptionIdCancelPost(Async)");
        }
        

        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdCancelPostCall(contentType, authorization, sellerId, subscriptionId, username, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Cancela uma assinatura de recorrência
     * Cancela uma assinatura de recorrência com base no seu identificador.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Conjundo de dados adicionais para cancelamento. (optional)
     * @return SubscriptionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SubscriptionResponse v1SubscriptionsSubscriptionIdCancelPost(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionCancel body) throws ApiException {
        ApiResponse<SubscriptionResponse> resp = v1SubscriptionsSubscriptionIdCancelPostWithHttpInfo(contentType, authorization, sellerId, subscriptionId, username, body);
        return resp.getData();
    }

    /**
     * Cancela uma assinatura de recorrência
     * Cancela uma assinatura de recorrência com base no seu identificador.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Conjundo de dados adicionais para cancelamento. (optional)
     * @return ApiResponse&lt;SubscriptionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SubscriptionResponse> v1SubscriptionsSubscriptionIdCancelPostWithHttpInfo(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionCancel body) throws ApiException {
        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdCancelPostValidateBeforeCall(contentType, authorization, sellerId, subscriptionId, username, body, null, null);
        Type localVarReturnType = new TypeToken<SubscriptionResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Cancela uma assinatura de recorrência (asynchronously)
     * Cancela uma assinatura de recorrência com base no seu identificador.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Conjundo de dados adicionais para cancelamento. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdCancelPostAsync(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionCancel body, final ApiCallback<SubscriptionResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdCancelPostValidateBeforeCall(contentType, authorization, sellerId, subscriptionId, username, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubscriptionResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1SubscriptionsSubscriptionIdChargesProjectionGet
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param limit Número de registros a serem retornados. (optional, default to 3)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdChargesProjectionGetCall(String authorization, String sellerId, String subscriptionId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/{subscription_id}/charges/projection"
            .replaceAll("\\{" + "subscription_id" + "\\}", apiClient.escapeString(subscriptionId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));
        if (sellerId != null)
        localVarHeaderParams.put("seller_id", apiClient.parameterToString(sellerId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdChargesProjectionGetValidateBeforeCall(String authorization, String sellerId, String subscriptionId, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1SubscriptionsSubscriptionIdChargesProjectionGet(Async)");
        }
        
        // verify the required parameter 'sellerId' is set
        if (sellerId == null) {
            throw new ApiException("Missing the required parameter 'sellerId' when calling v1SubscriptionsSubscriptionIdChargesProjectionGet(Async)");
        }
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new ApiException("Missing the required parameter 'subscriptionId' when calling v1SubscriptionsSubscriptionIdChargesProjectionGet(Async)");
        }
        

        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdChargesProjectionGetCall(authorization, sellerId, subscriptionId, limit, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Demonstra a projeção de cobranças
     * Demonstra a projeção de cobranças programadas para a assiantura de recorrência.
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param limit Número de registros a serem retornados. (optional, default to 3)
     * @return SubscriptionProjectionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SubscriptionProjectionResponse v1SubscriptionsSubscriptionIdChargesProjectionGet(String authorization, String sellerId, String subscriptionId, Integer limit) throws ApiException {
        ApiResponse<SubscriptionProjectionResponse> resp = v1SubscriptionsSubscriptionIdChargesProjectionGetWithHttpInfo(authorization, sellerId, subscriptionId, limit);
        return resp.getData();
    }

    /**
     * Demonstra a projeção de cobranças
     * Demonstra a projeção de cobranças programadas para a assiantura de recorrência.
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param limit Número de registros a serem retornados. (optional, default to 3)
     * @return ApiResponse&lt;SubscriptionProjectionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SubscriptionProjectionResponse> v1SubscriptionsSubscriptionIdChargesProjectionGetWithHttpInfo(String authorization, String sellerId, String subscriptionId, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdChargesProjectionGetValidateBeforeCall(authorization, sellerId, subscriptionId, limit, null, null);
        Type localVarReturnType = new TypeToken<SubscriptionProjectionResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Demonstra a projeção de cobranças (asynchronously)
     * Demonstra a projeção de cobranças programadas para a assiantura de recorrência.
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param limit Número de registros a serem retornados. (optional, default to 3)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdChargesProjectionGetAsync(String authorization, String sellerId, String subscriptionId, Integer limit, final ApiCallback<SubscriptionProjectionResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdChargesProjectionGetValidateBeforeCall(authorization, sellerId, subscriptionId, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubscriptionProjectionResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1SubscriptionsSubscriptionIdConfirmPaymentPost
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Conjunto de informações para confirmação de pagamento de assinatura. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdConfirmPaymentPostCall(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionConfirm body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/{subscription_id}/confirmPayment"
            .replaceAll("\\{" + "subscription_id" + "\\}", apiClient.escapeString(subscriptionId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));
        if (sellerId != null)
        localVarHeaderParams.put("seller_id", apiClient.parameterToString(sellerId));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdConfirmPaymentPostValidateBeforeCall(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionConfirm body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1SubscriptionsSubscriptionIdConfirmPaymentPost(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1SubscriptionsSubscriptionIdConfirmPaymentPost(Async)");
        }
        
        // verify the required parameter 'sellerId' is set
        if (sellerId == null) {
            throw new ApiException("Missing the required parameter 'sellerId' when calling v1SubscriptionsSubscriptionIdConfirmPaymentPost(Async)");
        }
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new ApiException("Missing the required parameter 'subscriptionId' when calling v1SubscriptionsSubscriptionIdConfirmPaymentPost(Async)");
        }
        

        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdConfirmPaymentPostCall(contentType, authorization, sellerId, subscriptionId, username, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Confirma o pagamento da assinatura
     * Confirma o pagamento da assinatura de recorrência.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Conjunto de informações para confirmação de pagamento de assinatura. (optional)
     * @return SubscriptionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SubscriptionResponse v1SubscriptionsSubscriptionIdConfirmPaymentPost(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionConfirm body) throws ApiException {
        ApiResponse<SubscriptionResponse> resp = v1SubscriptionsSubscriptionIdConfirmPaymentPostWithHttpInfo(contentType, authorization, sellerId, subscriptionId, username, body);
        return resp.getData();
    }

    /**
     * Confirma o pagamento da assinatura
     * Confirma o pagamento da assinatura de recorrência.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Conjunto de informações para confirmação de pagamento de assinatura. (optional)
     * @return ApiResponse&lt;SubscriptionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SubscriptionResponse> v1SubscriptionsSubscriptionIdConfirmPaymentPostWithHttpInfo(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionConfirm body) throws ApiException {
        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdConfirmPaymentPostValidateBeforeCall(contentType, authorization, sellerId, subscriptionId, username, body, null, null);
        Type localVarReturnType = new TypeToken<SubscriptionResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Confirma o pagamento da assinatura (asynchronously)
     * Confirma o pagamento da assinatura de recorrência.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Conjunto de informações para confirmação de pagamento de assinatura. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdConfirmPaymentPostAsync(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionConfirm body, final ApiCallback<SubscriptionResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdConfirmPaymentPostValidateBeforeCall(contentType, authorization, sellerId, subscriptionId, username, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubscriptionResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1SubscriptionsSubscriptionIdGet
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdGetCall(String authorization, String sellerId, String subscriptionId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/{subscription_id}"
            .replaceAll("\\{" + "subscription_id" + "\\}", apiClient.escapeString(subscriptionId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));
        if (sellerId != null)
        localVarHeaderParams.put("seller_id", apiClient.parameterToString(sellerId));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdGetValidateBeforeCall(String authorization, String sellerId, String subscriptionId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1SubscriptionsSubscriptionIdGet(Async)");
        }
        
        // verify the required parameter 'sellerId' is set
        if (sellerId == null) {
            throw new ApiException("Missing the required parameter 'sellerId' when calling v1SubscriptionsSubscriptionIdGet(Async)");
        }
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new ApiException("Missing the required parameter 'subscriptionId' when calling v1SubscriptionsSubscriptionIdGet(Async)");
        }
        

        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdGetCall(authorization, sellerId, subscriptionId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Assinatura de recorrência
     * Retorna os dados de assinatura de recorrência com base no seu identificador.
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @return SubscriptionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SubscriptionResponse v1SubscriptionsSubscriptionIdGet(String authorization, String sellerId, String subscriptionId) throws ApiException {
        ApiResponse<SubscriptionResponse> resp = v1SubscriptionsSubscriptionIdGetWithHttpInfo(authorization, sellerId, subscriptionId);
        return resp.getData();
    }

    /**
     * Assinatura de recorrência
     * Retorna os dados de assinatura de recorrência com base no seu identificador.
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @return ApiResponse&lt;SubscriptionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SubscriptionResponse> v1SubscriptionsSubscriptionIdGetWithHttpInfo(String authorization, String sellerId, String subscriptionId) throws ApiException {
        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdGetValidateBeforeCall(authorization, sellerId, subscriptionId, null, null);
        Type localVarReturnType = new TypeToken<SubscriptionResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Assinatura de recorrência (asynchronously)
     * Retorna os dados de assinatura de recorrência com base no seu identificador.
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdGetAsync(String authorization, String sellerId, String subscriptionId, final ApiCallback<SubscriptionResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdGetValidateBeforeCall(authorization, sellerId, subscriptionId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubscriptionResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1SubscriptionsSubscriptionIdPaymentDatePatch
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Conjunto de dados para atualização de data de pagamento. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdPaymentDatePatchCall(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionPaymentDate body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/{subscription_id}/paymentDate"
            .replaceAll("\\{" + "subscription_id" + "\\}", apiClient.escapeString(subscriptionId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));
        if (sellerId != null)
        localVarHeaderParams.put("seller_id", apiClient.parameterToString(sellerId));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdPaymentDatePatchValidateBeforeCall(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionPaymentDate body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1SubscriptionsSubscriptionIdPaymentDatePatch(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1SubscriptionsSubscriptionIdPaymentDatePatch(Async)");
        }
        
        // verify the required parameter 'sellerId' is set
        if (sellerId == null) {
            throw new ApiException("Missing the required parameter 'sellerId' when calling v1SubscriptionsSubscriptionIdPaymentDatePatch(Async)");
        }
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new ApiException("Missing the required parameter 'subscriptionId' when calling v1SubscriptionsSubscriptionIdPaymentDatePatch(Async)");
        }
        

        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdPaymentDatePatchCall(contentType, authorization, sellerId, subscriptionId, username, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Atualiza data da cobrança
     * Atualiza a data de pagamento da cobrança de uma assinatura de recorrência.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Conjunto de dados para atualização de data de pagamento. (optional)
     * @return SubscriptionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SubscriptionResponse v1SubscriptionsSubscriptionIdPaymentDatePatch(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionPaymentDate body) throws ApiException {
        ApiResponse<SubscriptionResponse> resp = v1SubscriptionsSubscriptionIdPaymentDatePatchWithHttpInfo(contentType, authorization, sellerId, subscriptionId, username, body);
        return resp.getData();
    }

    /**
     * Atualiza data da cobrança
     * Atualiza a data de pagamento da cobrança de uma assinatura de recorrência.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Conjunto de dados para atualização de data de pagamento. (optional)
     * @return ApiResponse&lt;SubscriptionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SubscriptionResponse> v1SubscriptionsSubscriptionIdPaymentDatePatchWithHttpInfo(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionPaymentDate body) throws ApiException {
        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdPaymentDatePatchValidateBeforeCall(contentType, authorization, sellerId, subscriptionId, username, body, null, null);
        Type localVarReturnType = new TypeToken<SubscriptionResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Atualiza data da cobrança (asynchronously)
     * Atualiza a data de pagamento da cobrança de uma assinatura de recorrência.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param body Conjunto de dados para atualização de data de pagamento. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdPaymentDatePatchAsync(String contentType, String authorization, String sellerId, String subscriptionId, String username, SubscriptionPaymentDate body, final ApiCallback<SubscriptionResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdPaymentDatePatchValidateBeforeCall(contentType, authorization, sellerId, subscriptionId, username, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubscriptionResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatch
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param body Conjunto de dados para troca de tipo de pagamento. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatchCall(String contentType, String authorization, String sellerId, String subscriptionId, SubscriptionUpdatePaymentType body, String username, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/v1/subscriptions/{subscription_id}/paymentType/credit/card"
            .replaceAll("\\{" + "subscription_id" + "\\}", apiClient.escapeString(subscriptionId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-Type", apiClient.parameterToString(contentType));
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));
        if (sellerId != null)
        localVarHeaderParams.put("seller_id", apiClient.parameterToString(sellerId));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatchValidateBeforeCall(String contentType, String authorization, String sellerId, String subscriptionId, SubscriptionUpdatePaymentType body, String username, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatch(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatch(Async)");
        }
        
        // verify the required parameter 'sellerId' is set
        if (sellerId == null) {
            throw new ApiException("Missing the required parameter 'sellerId' when calling v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatch(Async)");
        }
        
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new ApiException("Missing the required parameter 'subscriptionId' when calling v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatch(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatch(Async)");
        }
        

        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatchCall(contentType, authorization, sellerId, subscriptionId, body, username, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Atualiza os dados de pagamento
     * Atualiza os dados de pagamento de uma assinatura.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param body Conjunto de dados para troca de tipo de pagamento. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @return SubscriptionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SubscriptionResponse v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatch(String contentType, String authorization, String sellerId, String subscriptionId, SubscriptionUpdatePaymentType body, String username) throws ApiException {
        ApiResponse<SubscriptionResponse> resp = v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatchWithHttpInfo(contentType, authorization, sellerId, subscriptionId, body, username);
        return resp.getData();
    }

    /**
     * Atualiza os dados de pagamento
     * Atualiza os dados de pagamento de uma assinatura.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param body Conjunto de dados para troca de tipo de pagamento. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @return ApiResponse&lt;SubscriptionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SubscriptionResponse> v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatchWithHttpInfo(String contentType, String authorization, String sellerId, String subscriptionId, SubscriptionUpdatePaymentType body, String username) throws ApiException {
        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatchValidateBeforeCall(contentType, authorization, sellerId, subscriptionId, body, username, null, null);
        Type localVarReturnType = new TypeToken<SubscriptionResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Atualiza os dados de pagamento (asynchronously)
     * Atualiza os dados de pagamento de uma assinatura.
     * @param contentType Tipo do conteúdo application/json. (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param sellerId Código de identificação do e-commerce. (required)
     * @param subscriptionId Identificador da assinatura de recorrência. (required)
     * @param body Conjunto de dados para troca de tipo de pagamento. (required)
     * @param username Usuário que está realizando o cadastro. Esta informação pode ser utilizada para fins de auditoria. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatchAsync(String contentType, String authorization, String sellerId, String subscriptionId, SubscriptionUpdatePaymentType body, String username, final ApiCallback<SubscriptionResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = v1SubscriptionsSubscriptionIdPaymentTypeCreditCardPatchValidateBeforeCall(contentType, authorization, sellerId, subscriptionId, body, username, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SubscriptionResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
