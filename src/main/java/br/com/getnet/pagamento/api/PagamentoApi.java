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


import br.com.getnet.pagamento.model.CreditConfirm;
import br.com.getnet.pagamento.model.CreditDelayedCancel;
import br.com.getnet.pagamento.model.CreditDelayedConfirm;
import br.com.getnet.pagamento.model.CreditPreauthorizedAdjustment;
import br.com.getnet.pagamento.model.CreditPreauthorizedAdjustmentResponse;
import br.com.getnet.pagamento.model.Error;
import br.com.getnet.pagamento.model.InlineResponse2001;
import br.com.getnet.pagamento.model.PaymentAuthenticatedResponse;
import br.com.getnet.pagamento.model.PaymentBoleto;
import br.com.getnet.pagamento.model.PaymentBoletoResponse;
import br.com.getnet.pagamento.model.PaymentCredit;
import br.com.getnet.pagamento.model.PaymentCreditFinalize;
import br.com.getnet.pagamento.model.PaymentCreditFinalizeResponse;
import br.com.getnet.pagamento.model.PaymentCreditPreResponse;
import br.com.getnet.pagamento.model.PaymentCreditResponse;
import br.com.getnet.pagamento.model.PaymentDebit;
import br.com.getnet.pagamento.model.PaymentDebitConfirm;
import br.com.getnet.pagamento.model.PaymentDebitConfirmResponse;
import br.com.getnet.pagamento.model.VerificationCardBody;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagamentoApi {
    private ApiClient apiClient;

    public PagamentoApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PagamentoApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for v1CardsVerificationPost
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param verificationCardBody Requisição contendo os dados de cartão para verificação. (required)
     * @param sellerId Authorization: Código de identificação do e-commerce. Obrigatório quando o cliente for tratado como Plataforma.  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1CardsVerificationPostCall(String contentType, String authorization, VerificationCardBody verificationCardBody, String sellerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = verificationCardBody;

        // create path and map variables
        String localVarPath = "/v1/cards/verification";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-type", apiClient.parameterToString(contentType));
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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call v1CardsVerificationPostValidateBeforeCall(String contentType, String authorization, VerificationCardBody verificationCardBody, String sellerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1CardsVerificationPost(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1CardsVerificationPost(Async)");
        }
        
        // verify the required parameter 'verificationCardBody' is set
        if (verificationCardBody == null) {
            throw new ApiException("Missing the required parameter 'verificationCardBody' when calling v1CardsVerificationPost(Async)");
        }
        

        com.squareup.okhttp.Call call = v1CardsVerificationPostCall(contentType, authorization, verificationCardBody, sellerId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Verificação de cartão
     * O objetivo da transação de verificação de cartão de crédito é verificar se o cartão de crédito informado pelo portador é um cartão válido. Entende-se como um cartão crédito válido um cartão que não está cancelado, bloqueado ou com restrições. A verificação de cartão está disponível somente para as bandeiras Mastercard e Visa.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param verificationCardBody Requisição contendo os dados de cartão para verificação. (required)
     * @param sellerId Authorization: Código de identificação do e-commerce. Obrigatório quando o cliente for tratado como Plataforma.  (optional)
     * @return InlineResponse2001
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse2001 v1CardsVerificationPost(String contentType, String authorization, VerificationCardBody verificationCardBody, String sellerId) throws ApiException {
        ApiResponse<InlineResponse2001> resp = v1CardsVerificationPostWithHttpInfo(contentType, authorization, verificationCardBody, sellerId);
        return resp.getData();
    }

    /**
     * Verificação de cartão
     * O objetivo da transação de verificação de cartão de crédito é verificar se o cartão de crédito informado pelo portador é um cartão válido. Entende-se como um cartão crédito válido um cartão que não está cancelado, bloqueado ou com restrições. A verificação de cartão está disponível somente para as bandeiras Mastercard e Visa.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param verificationCardBody Requisição contendo os dados de cartão para verificação. (required)
     * @param sellerId Authorization: Código de identificação do e-commerce. Obrigatório quando o cliente for tratado como Plataforma.  (optional)
     * @return ApiResponse&lt;InlineResponse2001&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse2001> v1CardsVerificationPostWithHttpInfo(String contentType, String authorization, VerificationCardBody verificationCardBody, String sellerId) throws ApiException {
        com.squareup.okhttp.Call call = v1CardsVerificationPostValidateBeforeCall(contentType, authorization, verificationCardBody, sellerId, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse2001>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Verificação de cartão (asynchronously)
     * O objetivo da transação de verificação de cartão de crédito é verificar se o cartão de crédito informado pelo portador é um cartão válido. Entende-se como um cartão crédito válido um cartão que não está cancelado, bloqueado ou com restrições. A verificação de cartão está disponível somente para as bandeiras Mastercard e Visa.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param verificationCardBody Requisição contendo os dados de cartão para verificação. (required)
     * @param sellerId Authorization: Código de identificação do e-commerce. Obrigatório quando o cliente for tratado como Plataforma.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1CardsVerificationPostAsync(String contentType, String authorization, VerificationCardBody verificationCardBody, String sellerId, final ApiCallback<InlineResponse2001> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = v1CardsVerificationPostValidateBeforeCall(contentType, authorization, verificationCardBody, sellerId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse2001>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1PaymentsBoletoPaymentIdHtmlGet
     * @param paymentId Hash identificador do boleto. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsBoletoPaymentIdHtmlGetCall(String paymentId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/payments/boleto/{payment_id}/html"
            .replaceAll("\\{" + "payment_id" + "\\}", apiClient.escapeString(paymentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

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
    private com.squareup.okhttp.Call v1PaymentsBoletoPaymentIdHtmlGetValidateBeforeCall(String paymentId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'paymentId' is set
        if (paymentId == null) {
            throw new ApiException("Missing the required parameter 'paymentId' when calling v1PaymentsBoletoPaymentIdHtmlGet(Async)");
        }
        

        com.squareup.okhttp.Call call = v1PaymentsBoletoPaymentIdHtmlGetCall(paymentId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Download html do boleto
     * Nesse endpoint o usuário consegue realizar o download html do boleto para o ID informado no path.
     * @param paymentId Hash identificador do boleto. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void v1PaymentsBoletoPaymentIdHtmlGet(String paymentId) throws ApiException {
        v1PaymentsBoletoPaymentIdHtmlGetWithHttpInfo(paymentId);
    }

    /**
     * Download html do boleto
     * Nesse endpoint o usuário consegue realizar o download html do boleto para o ID informado no path.
     * @param paymentId Hash identificador do boleto. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> v1PaymentsBoletoPaymentIdHtmlGetWithHttpInfo(String paymentId) throws ApiException {
        com.squareup.okhttp.Call call = v1PaymentsBoletoPaymentIdHtmlGetValidateBeforeCall(paymentId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Download html do boleto (asynchronously)
     * Nesse endpoint o usuário consegue realizar o download html do boleto para o ID informado no path.
     * @param paymentId Hash identificador do boleto. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsBoletoPaymentIdHtmlGetAsync(String paymentId, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = v1PaymentsBoletoPaymentIdHtmlGetValidateBeforeCall(paymentId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for v1PaymentsBoletoPaymentIdPdfGet
     * @param paymentId Hash identificador do boleto. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsBoletoPaymentIdPdfGetCall(String paymentId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/payments/boleto/{payment_id}/pdf"
            .replaceAll("\\{" + "payment_id" + "\\}", apiClient.escapeString(paymentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

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
    private com.squareup.okhttp.Call v1PaymentsBoletoPaymentIdPdfGetValidateBeforeCall(String paymentId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'paymentId' is set
        if (paymentId == null) {
            throw new ApiException("Missing the required parameter 'paymentId' when calling v1PaymentsBoletoPaymentIdPdfGet(Async)");
        }
        

        com.squareup.okhttp.Call call = v1PaymentsBoletoPaymentIdPdfGetCall(paymentId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Download pdf do boleto
     * Nesse endpoint o usuário consegue realizar o download PDF do boleto para o ID informado no path.
     * @param paymentId Hash identificador do boleto. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void v1PaymentsBoletoPaymentIdPdfGet(String paymentId) throws ApiException {
        v1PaymentsBoletoPaymentIdPdfGetWithHttpInfo(paymentId);
    }

    /**
     * Download pdf do boleto
     * Nesse endpoint o usuário consegue realizar o download PDF do boleto para o ID informado no path.
     * @param paymentId Hash identificador do boleto. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> v1PaymentsBoletoPaymentIdPdfGetWithHttpInfo(String paymentId) throws ApiException {
        com.squareup.okhttp.Call call = v1PaymentsBoletoPaymentIdPdfGetValidateBeforeCall(paymentId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Download pdf do boleto (asynchronously)
     * Nesse endpoint o usuário consegue realizar o download PDF do boleto para o ID informado no path.
     * @param paymentId Hash identificador do boleto. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsBoletoPaymentIdPdfGetAsync(String paymentId, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = v1PaymentsBoletoPaymentIdPdfGetValidateBeforeCall(paymentId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for v1PaymentsBoletoPost
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param boletoBody Requisição contendo os dados para pagamento com boleto. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsBoletoPostCall(String contentType, String authorization, PaymentBoleto boletoBody, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = boletoBody;

        // create path and map variables
        String localVarPath = "/v1/payments/boleto";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-type", apiClient.parameterToString(contentType));
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

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
    private com.squareup.okhttp.Call v1PaymentsBoletoPostValidateBeforeCall(String contentType, String authorization, PaymentBoleto boletoBody, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1PaymentsBoletoPost(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1PaymentsBoletoPost(Async)");
        }
        
        // verify the required parameter 'boletoBody' is set
        if (boletoBody == null) {
            throw new ApiException("Missing the required parameter 'boletoBody' when calling v1PaymentsBoletoPost(Async)");
        }
        

        com.squareup.okhttp.Call call = v1PaymentsBoletoPostCall(contentType, authorization, boletoBody, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Registro para pagamento com boleto
     * Nesse endpoint serão recebidos os dados do novo boleto, que será registrado no Banco Santander. &lt;br&gt; &lt;br&gt; &lt;b&gt;Como imprimir a segunda via de um boleto?&lt;/b&gt; &lt;br&gt;&lt;br&gt; Pegando o payment_id do response do &lt;a href&#x3D;\&quot;https://developers.getnet.com.br/api#tag/Pagamento%2Fpaths%2F~1v1~1payments~1boleto%2Fpost\&quot;&gt;Registro de boleto&lt;/a&gt; ou do callback de registro do boleto &lt;a href&#x3D;\&quot;https://developers.getnet.com.br/faq\&quot;&gt;FAQ \&quot;Como receber status das transações via callback?\&quot;&lt;/a&gt;, você pode montar as URLs  e fazer o download da segunda via conforme descrito na documentação abaixo: &lt;br&gt; &lt;br&gt; Ver exemplo PDF: \&quot;https://developers.getnet.com.br/api#tag/Pagamento%2Fpaths%2F~1v1~1payments~1boleto~1%7Bpayment_id%7D~1pdf%2Fget\&quot; &lt;br&gt; Ver exemplo HTML: \&quot;https://developers.getnet.com.br/api#tag/Pagamento%2Fpaths%2F~1v1~1payments~1boleto~1%7Bpayment_id%7D~1html%2Fget\&quot;
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param boletoBody Requisição contendo os dados para pagamento com boleto. (required)
     * @return PaymentBoletoResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PaymentBoletoResponse v1PaymentsBoletoPost(String contentType, String authorization, PaymentBoleto boletoBody) throws ApiException {
        ApiResponse<PaymentBoletoResponse> resp = v1PaymentsBoletoPostWithHttpInfo(contentType, authorization, boletoBody);
        return resp.getData();
    }

    /**
     * Registro para pagamento com boleto
     * Nesse endpoint serão recebidos os dados do novo boleto, que será registrado no Banco Santander. &lt;br&gt; &lt;br&gt; &lt;b&gt;Como imprimir a segunda via de um boleto?&lt;/b&gt; &lt;br&gt;&lt;br&gt; Pegando o payment_id do response do &lt;a href&#x3D;\&quot;https://developers.getnet.com.br/api#tag/Pagamento%2Fpaths%2F~1v1~1payments~1boleto%2Fpost\&quot;&gt;Registro de boleto&lt;/a&gt; ou do callback de registro do boleto &lt;a href&#x3D;\&quot;https://developers.getnet.com.br/faq\&quot;&gt;FAQ \&quot;Como receber status das transações via callback?\&quot;&lt;/a&gt;, você pode montar as URLs  e fazer o download da segunda via conforme descrito na documentação abaixo: &lt;br&gt; &lt;br&gt; Ver exemplo PDF: \&quot;https://developers.getnet.com.br/api#tag/Pagamento%2Fpaths%2F~1v1~1payments~1boleto~1%7Bpayment_id%7D~1pdf%2Fget\&quot; &lt;br&gt; Ver exemplo HTML: \&quot;https://developers.getnet.com.br/api#tag/Pagamento%2Fpaths%2F~1v1~1payments~1boleto~1%7Bpayment_id%7D~1html%2Fget\&quot;
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param boletoBody Requisição contendo os dados para pagamento com boleto. (required)
     * @return ApiResponse&lt;PaymentBoletoResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PaymentBoletoResponse> v1PaymentsBoletoPostWithHttpInfo(String contentType, String authorization, PaymentBoleto boletoBody) throws ApiException {
        com.squareup.okhttp.Call call = v1PaymentsBoletoPostValidateBeforeCall(contentType, authorization, boletoBody, null, null);
        Type localVarReturnType = new TypeToken<PaymentBoletoResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Registro para pagamento com boleto (asynchronously)
     * Nesse endpoint serão recebidos os dados do novo boleto, que será registrado no Banco Santander. &lt;br&gt; &lt;br&gt; &lt;b&gt;Como imprimir a segunda via de um boleto?&lt;/b&gt; &lt;br&gt;&lt;br&gt; Pegando o payment_id do response do &lt;a href&#x3D;\&quot;https://developers.getnet.com.br/api#tag/Pagamento%2Fpaths%2F~1v1~1payments~1boleto%2Fpost\&quot;&gt;Registro de boleto&lt;/a&gt; ou do callback de registro do boleto &lt;a href&#x3D;\&quot;https://developers.getnet.com.br/faq\&quot;&gt;FAQ \&quot;Como receber status das transações via callback?\&quot;&lt;/a&gt;, você pode montar as URLs  e fazer o download da segunda via conforme descrito na documentação abaixo: &lt;br&gt; &lt;br&gt; Ver exemplo PDF: \&quot;https://developers.getnet.com.br/api#tag/Pagamento%2Fpaths%2F~1v1~1payments~1boleto~1%7Bpayment_id%7D~1pdf%2Fget\&quot; &lt;br&gt; Ver exemplo HTML: \&quot;https://developers.getnet.com.br/api#tag/Pagamento%2Fpaths%2F~1v1~1payments~1boleto~1%7Bpayment_id%7D~1html%2Fget\&quot;
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param boletoBody Requisição contendo os dados para pagamento com boleto. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsBoletoPostAsync(String contentType, String authorization, PaymentBoleto boletoBody, final ApiCallback<PaymentBoletoResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = v1PaymentsBoletoPostValidateBeforeCall(contentType, authorization, boletoBody, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PaymentBoletoResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1PaymentsCreditPaymentIdAdjustmentPost
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param body Requisição contendo os dados para uma solicitação de ajuste de valor de uma Pré-Autorização. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsCreditPaymentIdAdjustmentPostCall(String contentType, String authorization, String paymentId, CreditPreauthorizedAdjustment body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/v1/payments/credit/{payment_id}/adjustment"
            .replaceAll("\\{" + "payment_id" + "\\}", apiClient.escapeString(paymentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-type", apiClient.parameterToString(contentType));
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

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
    private com.squareup.okhttp.Call v1PaymentsCreditPaymentIdAdjustmentPostValidateBeforeCall(String contentType, String authorization, String paymentId, CreditPreauthorizedAdjustment body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1PaymentsCreditPaymentIdAdjustmentPost(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1PaymentsCreditPaymentIdAdjustmentPost(Async)");
        }
        
        // verify the required parameter 'paymentId' is set
        if (paymentId == null) {
            throw new ApiException("Missing the required parameter 'paymentId' when calling v1PaymentsCreditPaymentIdAdjustmentPost(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling v1PaymentsCreditPaymentIdAdjustmentPost(Async)");
        }
        

        com.squareup.okhttp.Call call = v1PaymentsCreditPaymentIdAdjustmentPostCall(contentType, authorization, paymentId, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Ajustar valor de uma transação de pré autorização
     * Executa um ajuste (Incremento/Decremento) no valor previamente reservado no saldo do Portador por uma Transação de Pré-Autorização. O valor da Transação de Ajuste de Pré-Autorização pode ser maior ou menor que o valor original. Na chamada do processo de ajuste sempre deve ser enviado o valor final desejado no campo de amount.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param body Requisição contendo os dados para uma solicitação de ajuste de valor de uma Pré-Autorização. (required)
     * @return CreditPreauthorizedAdjustmentResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CreditPreauthorizedAdjustmentResponse v1PaymentsCreditPaymentIdAdjustmentPost(String contentType, String authorization, String paymentId, CreditPreauthorizedAdjustment body) throws ApiException {
        ApiResponse<CreditPreauthorizedAdjustmentResponse> resp = v1PaymentsCreditPaymentIdAdjustmentPostWithHttpInfo(contentType, authorization, paymentId, body);
        return resp.getData();
    }

    /**
     * Ajustar valor de uma transação de pré autorização
     * Executa um ajuste (Incremento/Decremento) no valor previamente reservado no saldo do Portador por uma Transação de Pré-Autorização. O valor da Transação de Ajuste de Pré-Autorização pode ser maior ou menor que o valor original. Na chamada do processo de ajuste sempre deve ser enviado o valor final desejado no campo de amount.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param body Requisição contendo os dados para uma solicitação de ajuste de valor de uma Pré-Autorização. (required)
     * @return ApiResponse&lt;CreditPreauthorizedAdjustmentResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CreditPreauthorizedAdjustmentResponse> v1PaymentsCreditPaymentIdAdjustmentPostWithHttpInfo(String contentType, String authorization, String paymentId, CreditPreauthorizedAdjustment body) throws ApiException {
        com.squareup.okhttp.Call call = v1PaymentsCreditPaymentIdAdjustmentPostValidateBeforeCall(contentType, authorization, paymentId, body, null, null);
        Type localVarReturnType = new TypeToken<CreditPreauthorizedAdjustmentResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Ajustar valor de uma transação de pré autorização (asynchronously)
     * Executa um ajuste (Incremento/Decremento) no valor previamente reservado no saldo do Portador por uma Transação de Pré-Autorização. O valor da Transação de Ajuste de Pré-Autorização pode ser maior ou menor que o valor original. Na chamada do processo de ajuste sempre deve ser enviado o valor final desejado no campo de amount.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param body Requisição contendo os dados para uma solicitação de ajuste de valor de uma Pré-Autorização. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsCreditPaymentIdAdjustmentPostAsync(String contentType, String authorization, String paymentId, CreditPreauthorizedAdjustment body, final ApiCallback<CreditPreauthorizedAdjustmentResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = v1PaymentsCreditPaymentIdAdjustmentPostValidateBeforeCall(contentType, authorization, paymentId, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CreditPreauthorizedAdjustmentResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1PaymentsCreditPaymentIdAuthenticatedFinalizePost
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param creditFinalizeBody Requisição contendo os dados para finalização de pagamento com cartão de crédito autenticado. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsCreditPaymentIdAuthenticatedFinalizePostCall(String contentType, String authorization, String paymentId, PaymentCreditFinalize creditFinalizeBody, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = creditFinalizeBody;

        // create path and map variables
        String localVarPath = "/v1/payments/credit/{payment_id}/authenticated/finalize"
            .replaceAll("\\{" + "payment_id" + "\\}", apiClient.escapeString(paymentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-type", apiClient.parameterToString(contentType));
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

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
    private com.squareup.okhttp.Call v1PaymentsCreditPaymentIdAuthenticatedFinalizePostValidateBeforeCall(String contentType, String authorization, String paymentId, PaymentCreditFinalize creditFinalizeBody, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1PaymentsCreditPaymentIdAuthenticatedFinalizePost(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1PaymentsCreditPaymentIdAuthenticatedFinalizePost(Async)");
        }
        
        // verify the required parameter 'paymentId' is set
        if (paymentId == null) {
            throw new ApiException("Missing the required parameter 'paymentId' when calling v1PaymentsCreditPaymentIdAuthenticatedFinalizePost(Async)");
        }
        
        // verify the required parameter 'creditFinalizeBody' is set
        if (creditFinalizeBody == null) {
            throw new ApiException("Missing the required parameter 'creditFinalizeBody' when calling v1PaymentsCreditPaymentIdAuthenticatedFinalizePost(Async)");
        }
        

        com.squareup.okhttp.Call call = v1PaymentsCreditPaymentIdAuthenticatedFinalizePostCall(contentType, authorization, paymentId, creditFinalizeBody, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Finalização de pagamento autenticado com cartão de crédito
     * Finaliza a transação de crédito autenticado.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param creditFinalizeBody Requisição contendo os dados para finalização de pagamento com cartão de crédito autenticado. (required)
     * @return PaymentCreditFinalizeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PaymentCreditFinalizeResponse v1PaymentsCreditPaymentIdAuthenticatedFinalizePost(String contentType, String authorization, String paymentId, PaymentCreditFinalize creditFinalizeBody) throws ApiException {
        ApiResponse<PaymentCreditFinalizeResponse> resp = v1PaymentsCreditPaymentIdAuthenticatedFinalizePostWithHttpInfo(contentType, authorization, paymentId, creditFinalizeBody);
        return resp.getData();
    }

    /**
     * Finalização de pagamento autenticado com cartão de crédito
     * Finaliza a transação de crédito autenticado.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param creditFinalizeBody Requisição contendo os dados para finalização de pagamento com cartão de crédito autenticado. (required)
     * @return ApiResponse&lt;PaymentCreditFinalizeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PaymentCreditFinalizeResponse> v1PaymentsCreditPaymentIdAuthenticatedFinalizePostWithHttpInfo(String contentType, String authorization, String paymentId, PaymentCreditFinalize creditFinalizeBody) throws ApiException {
        com.squareup.okhttp.Call call = v1PaymentsCreditPaymentIdAuthenticatedFinalizePostValidateBeforeCall(contentType, authorization, paymentId, creditFinalizeBody, null, null);
        Type localVarReturnType = new TypeToken<PaymentCreditFinalizeResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Finalização de pagamento autenticado com cartão de crédito (asynchronously)
     * Finaliza a transação de crédito autenticado.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param creditFinalizeBody Requisição contendo os dados para finalização de pagamento com cartão de crédito autenticado. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsCreditPaymentIdAuthenticatedFinalizePostAsync(String contentType, String authorization, String paymentId, PaymentCreditFinalize creditFinalizeBody, final ApiCallback<PaymentCreditFinalizeResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = v1PaymentsCreditPaymentIdAuthenticatedFinalizePostValidateBeforeCall(contentType, authorization, paymentId, creditFinalizeBody, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PaymentCreditFinalizeResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1PaymentsCreditPaymentIdCancelPost
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsCreditPaymentIdCancelPostCall(String contentType, String authorization, String paymentId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/payments/credit/{payment_id}/cancel"
            .replaceAll("\\{" + "payment_id" + "\\}", apiClient.escapeString(paymentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-type", apiClient.parameterToString(contentType));
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

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
    private com.squareup.okhttp.Call v1PaymentsCreditPaymentIdCancelPostValidateBeforeCall(String contentType, String authorization, String paymentId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1PaymentsCreditPaymentIdCancelPost(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1PaymentsCreditPaymentIdCancelPost(Async)");
        }
        
        // verify the required parameter 'paymentId' is set
        if (paymentId == null) {
            throw new ApiException("Missing the required parameter 'paymentId' when calling v1PaymentsCreditPaymentIdCancelPost(Async)");
        }
        

        com.squareup.okhttp.Call call = v1PaymentsCreditPaymentIdCancelPostCall(contentType, authorization, paymentId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Cancelar pagamento no cartão de crédito
     * Cancelar uma transação de crédito completa ou transação de crédito tardia ou transação de pré autorização.  * Estorna ou desfaz transações feitas no mesmo dia (D0).
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @return CreditDelayedCancel
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CreditDelayedCancel v1PaymentsCreditPaymentIdCancelPost(String contentType, String authorization, String paymentId) throws ApiException {
        ApiResponse<CreditDelayedCancel> resp = v1PaymentsCreditPaymentIdCancelPostWithHttpInfo(contentType, authorization, paymentId);
        return resp.getData();
    }

    /**
     * Cancelar pagamento no cartão de crédito
     * Cancelar uma transação de crédito completa ou transação de crédito tardia ou transação de pré autorização.  * Estorna ou desfaz transações feitas no mesmo dia (D0).
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @return ApiResponse&lt;CreditDelayedCancel&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CreditDelayedCancel> v1PaymentsCreditPaymentIdCancelPostWithHttpInfo(String contentType, String authorization, String paymentId) throws ApiException {
        com.squareup.okhttp.Call call = v1PaymentsCreditPaymentIdCancelPostValidateBeforeCall(contentType, authorization, paymentId, null, null);
        Type localVarReturnType = new TypeToken<CreditDelayedCancel>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Cancelar pagamento no cartão de crédito (asynchronously)
     * Cancelar uma transação de crédito completa ou transação de crédito tardia ou transação de pré autorização.  * Estorna ou desfaz transações feitas no mesmo dia (D0).
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsCreditPaymentIdCancelPostAsync(String contentType, String authorization, String paymentId, final ApiCallback<CreditDelayedCancel> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = v1PaymentsCreditPaymentIdCancelPostValidateBeforeCall(contentType, authorization, paymentId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CreditDelayedCancel>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1PaymentsCreditPaymentIdConfirmPost
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param body Requisição contendo os dados para uma solicitação de confirmação de crédito tardio ou pré autorizado. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsCreditPaymentIdConfirmPostCall(String contentType, String authorization, String paymentId, CreditConfirm body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/v1/payments/credit/{payment_id}/confirm"
            .replaceAll("\\{" + "payment_id" + "\\}", apiClient.escapeString(paymentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-type", apiClient.parameterToString(contentType));
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

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
    private com.squareup.okhttp.Call v1PaymentsCreditPaymentIdConfirmPostValidateBeforeCall(String contentType, String authorization, String paymentId, CreditConfirm body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1PaymentsCreditPaymentIdConfirmPost(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1PaymentsCreditPaymentIdConfirmPost(Async)");
        }
        
        // verify the required parameter 'paymentId' is set
        if (paymentId == null) {
            throw new ApiException("Missing the required parameter 'paymentId' when calling v1PaymentsCreditPaymentIdConfirmPost(Async)");
        }
        

        com.squareup.okhttp.Call call = v1PaymentsCreditPaymentIdConfirmPostCall(contentType, authorization, paymentId, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Confirmação tardia de pagamento ou confirmação de pré autorização com cartão de crédito
     * Quando uma transação de crédito é feita com a opção delayed &#x3D; true ou pre_authorization &#x3D; true, confirmação tardia ou pré autorização, respectivamente, ela pode ser posteriormente confirmada, este endpoint é responsável pela confirmação.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param body Requisição contendo os dados para uma solicitação de confirmação de crédito tardio ou pré autorizado. (optional)
     * @return CreditDelayedConfirm
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CreditDelayedConfirm v1PaymentsCreditPaymentIdConfirmPost(String contentType, String authorization, String paymentId, CreditConfirm body) throws ApiException {
        ApiResponse<CreditDelayedConfirm> resp = v1PaymentsCreditPaymentIdConfirmPostWithHttpInfo(contentType, authorization, paymentId, body);
        return resp.getData();
    }

    /**
     * Confirmação tardia de pagamento ou confirmação de pré autorização com cartão de crédito
     * Quando uma transação de crédito é feita com a opção delayed &#x3D; true ou pre_authorization &#x3D; true, confirmação tardia ou pré autorização, respectivamente, ela pode ser posteriormente confirmada, este endpoint é responsável pela confirmação.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param body Requisição contendo os dados para uma solicitação de confirmação de crédito tardio ou pré autorizado. (optional)
     * @return ApiResponse&lt;CreditDelayedConfirm&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CreditDelayedConfirm> v1PaymentsCreditPaymentIdConfirmPostWithHttpInfo(String contentType, String authorization, String paymentId, CreditConfirm body) throws ApiException {
        com.squareup.okhttp.Call call = v1PaymentsCreditPaymentIdConfirmPostValidateBeforeCall(contentType, authorization, paymentId, body, null, null);
        Type localVarReturnType = new TypeToken<CreditDelayedConfirm>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Confirmação tardia de pagamento ou confirmação de pré autorização com cartão de crédito (asynchronously)
     * Quando uma transação de crédito é feita com a opção delayed &#x3D; true ou pre_authorization &#x3D; true, confirmação tardia ou pré autorização, respectivamente, ela pode ser posteriormente confirmada, este endpoint é responsável pela confirmação.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param body Requisição contendo os dados para uma solicitação de confirmação de crédito tardio ou pré autorizado. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsCreditPaymentIdConfirmPostAsync(String contentType, String authorization, String paymentId, CreditConfirm body, final ApiCallback<CreditDelayedConfirm> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = v1PaymentsCreditPaymentIdConfirmPostValidateBeforeCall(contentType, authorization, paymentId, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CreditDelayedConfirm>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1PaymentsCreditPost
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param creditBody Requisição contendo os dados para pagamento com cartão de crédito e análise de fraude. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsCreditPostCall(String contentType, String authorization, PaymentCredit creditBody, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = creditBody;

        // create path and map variables
        String localVarPath = "/v1/payments/credit";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-type", apiClient.parameterToString(contentType));
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

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
    private com.squareup.okhttp.Call v1PaymentsCreditPostValidateBeforeCall(String contentType, String authorization, PaymentCredit creditBody, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1PaymentsCreditPost(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1PaymentsCreditPost(Async)");
        }
        
        // verify the required parameter 'creditBody' is set
        if (creditBody == null) {
            throw new ApiException("Missing the required parameter 'creditBody' when calling v1PaymentsCreditPost(Async)");
        }
        

        com.squareup.okhttp.Call call = v1PaymentsCreditPostCall(contentType, authorization, creditBody, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Pagamento com cartão de crédito
     * Nesse endpoint serão recebidos dados para pagamento com cartão de crédito. &lt;/br&gt; &lt;/br&gt; Para o os campos delayed, authenticated e pre_authorization, somente um deles podem estar com valor true, indicando assim somente um serviço de crédito a ser processado.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param creditBody Requisição contendo os dados para pagamento com cartão de crédito e análise de fraude. (required)
     * @return PaymentCreditResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PaymentCreditResponse v1PaymentsCreditPost(String contentType, String authorization, PaymentCredit creditBody) throws ApiException {
        ApiResponse<PaymentCreditResponse> resp = v1PaymentsCreditPostWithHttpInfo(contentType, authorization, creditBody);
        return resp.getData();
    }

    /**
     * Pagamento com cartão de crédito
     * Nesse endpoint serão recebidos dados para pagamento com cartão de crédito. &lt;/br&gt; &lt;/br&gt; Para o os campos delayed, authenticated e pre_authorization, somente um deles podem estar com valor true, indicando assim somente um serviço de crédito a ser processado.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param creditBody Requisição contendo os dados para pagamento com cartão de crédito e análise de fraude. (required)
     * @return ApiResponse&lt;PaymentCreditResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PaymentCreditResponse> v1PaymentsCreditPostWithHttpInfo(String contentType, String authorization, PaymentCredit creditBody) throws ApiException {
        com.squareup.okhttp.Call call = v1PaymentsCreditPostValidateBeforeCall(contentType, authorization, creditBody, null, null);
        Type localVarReturnType = new TypeToken<PaymentCreditResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Pagamento com cartão de crédito (asynchronously)
     * Nesse endpoint serão recebidos dados para pagamento com cartão de crédito. &lt;/br&gt; &lt;/br&gt; Para o os campos delayed, authenticated e pre_authorization, somente um deles podem estar com valor true, indicando assim somente um serviço de crédito a ser processado.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param creditBody Requisição contendo os dados para pagamento com cartão de crédito e análise de fraude. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsCreditPostAsync(String contentType, String authorization, PaymentCredit creditBody, final ApiCallback<PaymentCreditResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = v1PaymentsCreditPostValidateBeforeCall(contentType, authorization, creditBody, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PaymentCreditResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1PaymentsDebitPaymentIdAuthenticatedFinalizePost
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param debitConfirmBody Requisição contendo os dados para confirmação de pagamento com cartão de débito. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsDebitPaymentIdAuthenticatedFinalizePostCall(String contentType, String authorization, String paymentId, PaymentDebitConfirm debitConfirmBody, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = debitConfirmBody;

        // create path and map variables
        String localVarPath = "/v1/payments/debit/{payment_id}/authenticated/finalize"
            .replaceAll("\\{" + "payment_id" + "\\}", apiClient.escapeString(paymentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-type", apiClient.parameterToString(contentType));
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

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
    private com.squareup.okhttp.Call v1PaymentsDebitPaymentIdAuthenticatedFinalizePostValidateBeforeCall(String contentType, String authorization, String paymentId, PaymentDebitConfirm debitConfirmBody, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1PaymentsDebitPaymentIdAuthenticatedFinalizePost(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1PaymentsDebitPaymentIdAuthenticatedFinalizePost(Async)");
        }
        
        // verify the required parameter 'paymentId' is set
        if (paymentId == null) {
            throw new ApiException("Missing the required parameter 'paymentId' when calling v1PaymentsDebitPaymentIdAuthenticatedFinalizePost(Async)");
        }
        
        // verify the required parameter 'debitConfirmBody' is set
        if (debitConfirmBody == null) {
            throw new ApiException("Missing the required parameter 'debitConfirmBody' when calling v1PaymentsDebitPaymentIdAuthenticatedFinalizePost(Async)");
        }
        

        com.squareup.okhttp.Call call = v1PaymentsDebitPaymentIdAuthenticatedFinalizePostCall(contentType, authorization, paymentId, debitConfirmBody, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Finalização de pagamento autenticado com cartão de débito
     * Finaliza a transação de débito autenticado.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param debitConfirmBody Requisição contendo os dados para confirmação de pagamento com cartão de débito. (required)
     * @return PaymentDebitConfirmResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PaymentDebitConfirmResponse v1PaymentsDebitPaymentIdAuthenticatedFinalizePost(String contentType, String authorization, String paymentId, PaymentDebitConfirm debitConfirmBody) throws ApiException {
        ApiResponse<PaymentDebitConfirmResponse> resp = v1PaymentsDebitPaymentIdAuthenticatedFinalizePostWithHttpInfo(contentType, authorization, paymentId, debitConfirmBody);
        return resp.getData();
    }

    /**
     * Finalização de pagamento autenticado com cartão de débito
     * Finaliza a transação de débito autenticado.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param debitConfirmBody Requisição contendo os dados para confirmação de pagamento com cartão de débito. (required)
     * @return ApiResponse&lt;PaymentDebitConfirmResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PaymentDebitConfirmResponse> v1PaymentsDebitPaymentIdAuthenticatedFinalizePostWithHttpInfo(String contentType, String authorization, String paymentId, PaymentDebitConfirm debitConfirmBody) throws ApiException {
        com.squareup.okhttp.Call call = v1PaymentsDebitPaymentIdAuthenticatedFinalizePostValidateBeforeCall(contentType, authorization, paymentId, debitConfirmBody, null, null);
        Type localVarReturnType = new TypeToken<PaymentDebitConfirmResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Finalização de pagamento autenticado com cartão de débito (asynchronously)
     * Finaliza a transação de débito autenticado.
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param paymentId Identificador do pagamento previamente recebido e aceito. (required)
     * @param debitConfirmBody Requisição contendo os dados para confirmação de pagamento com cartão de débito. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsDebitPaymentIdAuthenticatedFinalizePostAsync(String contentType, String authorization, String paymentId, PaymentDebitConfirm debitConfirmBody, final ApiCallback<PaymentDebitConfirmResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = v1PaymentsDebitPaymentIdAuthenticatedFinalizePostValidateBeforeCall(contentType, authorization, paymentId, debitConfirmBody, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PaymentDebitConfirmResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for v1PaymentsDebitPost
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param debitBody Requisição contendo os dados para pagamento com cartão de débito e análise de fraude. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsDebitPostCall(String contentType, String authorization, PaymentDebit debitBody, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = debitBody;

        // create path and map variables
        String localVarPath = "/v1/payments/debit";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (contentType != null)
        localVarHeaderParams.put("Content-type", apiClient.parameterToString(contentType));
        if (authorization != null)
        localVarHeaderParams.put("Authorization", apiClient.parameterToString(authorization));

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
    private com.squareup.okhttp.Call v1PaymentsDebitPostValidateBeforeCall(String contentType, String authorization, PaymentDebit debitBody, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new ApiException("Missing the required parameter 'contentType' when calling v1PaymentsDebitPost(Async)");
        }
        
        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new ApiException("Missing the required parameter 'authorization' when calling v1PaymentsDebitPost(Async)");
        }
        
        // verify the required parameter 'debitBody' is set
        if (debitBody == null) {
            throw new ApiException("Missing the required parameter 'debitBody' when calling v1PaymentsDebitPost(Async)");
        }
        

        com.squareup.okhttp.Call call = v1PaymentsDebitPostCall(contentType, authorization, debitBody, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Pagamento com cartão de débito
     * Nesse endpoint serão recebidos dados para pagamento com cartão de débito.  ### Fluxo Transação de Débito Autenticado &lt;br&gt; ![Fluxo Transação Débito Autenticado](/img/fluxodebitoautenticado.png) &lt;br&gt; &lt;br&gt; &lt;br&gt; &lt;ol type&#x3D;\&quot;1\&quot;&gt; &lt;li&gt;Pagamento com cartão de débito (Requisição da transação de débito autenticado).&lt;/li&gt; &lt;li&gt;Enviar requisição da transação de débito para a Plataforma Digital Getnet – Verificação 3D Secure&lt;/li&gt; &lt;li&gt;Resposta da transação de débito – Verificação 3D Secure, neste passo são retornados alguns atributos:&lt;/li&gt; &lt;ol type&#x3D;\&quot;a\&quot;&gt;  &lt;li&gt;&lt;b&gt;payment_id&lt;/b&gt;: identificador único do pagamento gerado pela Plataforma Digital Getnet, será utilizando no passo 9 da transação.&lt;/li&gt;  &lt;li&gt;&lt;b&gt;redirect_url&lt;/b&gt;: URL gerada pelo emissor, deve ser chamada no passo 5 da transação&lt;/li&gt;  &lt;li&gt;&lt;b&gt;post_data.issuer_payment_id&lt;/b&gt;: identificador do pagamento gerado pelo emissor, será enviado no passo 5 da transação&lt;/li&gt;  &lt;li&gt;&lt;b&gt;post_data.payer_authentication_request&lt;/b&gt;: dado referente a transação, gerado no formato Base64-encoded pelo emissor, será enviado no passo 5 da transação&lt;/li&gt; &lt;/ol&gt; &lt;li&gt;Resposta da transação para o device do consumidor&lt;/li&gt; &lt;li&gt;Executar um redirecionamento, enviando uma requisição HTTP POST para a URL do atributo &lt;b&gt;redirect_url&lt;/b&gt; retornado no passo 3 da transação. Para o request, você deve enviar as seguintes informações no header e no body da requisição:&lt;/li&gt; &lt;ol type&#x3D;\&quot;a\&quot;&gt; &lt;li&gt;&lt;b&gt;No Header&lt;/b&gt;&lt;/li&gt; &lt;ol type&#x3D;\&quot;i\&quot;&gt; &lt;li&gt;&lt;b&gt;Content-Type&lt;/b&gt;: application/x-www-form-urlencoded&lt;/li&gt; &lt;/ol&gt; &lt;li&gt;&lt;b&gt;No Body&lt;/b&gt;&lt;/li&gt; &lt;ol type&#x3D;\&quot;i\&quot;&gt; &lt;li&gt;&lt;b&gt;MD&lt;/b&gt;: referente ao atributo &lt;b&gt;post_data.issuer_payment_id&lt;/b&gt; retornado no passo 3 da transação.&lt;/li&gt; &lt;li&gt;&lt;b&gt;PaReq&lt;/b&gt;: referente ao atributo &lt;b&gt;post_data.payer_authentication_request&lt;/b&gt; retornado no passo 3 da transação.&lt;/li&gt; &lt;li&gt;&lt;b&gt;TermUrl&lt;/b&gt;: Sua URL, responsável por receber o PaRes por parte do emissor, conforme descrito no passo 8 da transação&lt;/li&gt; &lt;/ol&gt; &lt;/ol&gt; &lt;li&gt;Emissor responde a requisição enviando um formulário para autenticação do portador&lt;/li&gt; &lt;li&gt;Portador preenche o formulário com as informações solicitadas e envia para a validação do emissor&lt;/li&gt; &lt;li&gt;Emissor responde enviando um POST HTTP para a URL informada no atributo TermUrl do passo 5 da transação. Nesta requisição, o emissor enviará dois atributos:&lt;/li&gt; &lt;ol type&#x3D;\&quot;a\&quot;&gt; &lt;li&gt;&lt;b&gt;MD&lt;/b&gt;: retorno do atributo MD enviado no passo 5 da transação&lt;/li&gt; &lt;li&gt;&lt;b&gt;PaRes&lt;/b&gt;: autorização de pagamento retornada pelo emissor, será utilizado no passo 9 da transação&lt;/li&gt; &lt;/ol&gt; &lt;li&gt;A aplicação recebe a requisição do emissor e envia uma solicitação de finalização da transação de débito (&lt;a href&#x3D;\&quot;/api#tag/Pagamento%2Fpaths%2F~1v1~1payments~1debit~1%7Bpayment_id%7D~1authenticated~1finalize%2Fpost\&quot;&gt;Finalização de pagamento autenticado com cartão de débito&lt;/a&gt;)&lt;/li&gt; &lt;/ol&gt;
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param debitBody Requisição contendo os dados para pagamento com cartão de débito e análise de fraude. (required)
     * @return PaymentAuthenticatedResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PaymentAuthenticatedResponse v1PaymentsDebitPost(String contentType, String authorization, PaymentDebit debitBody) throws ApiException {
        ApiResponse<PaymentAuthenticatedResponse> resp = v1PaymentsDebitPostWithHttpInfo(contentType, authorization, debitBody);
        return resp.getData();
    }

    /**
     * Pagamento com cartão de débito
     * Nesse endpoint serão recebidos dados para pagamento com cartão de débito.  ### Fluxo Transação de Débito Autenticado &lt;br&gt; ![Fluxo Transação Débito Autenticado](/img/fluxodebitoautenticado.png) &lt;br&gt; &lt;br&gt; &lt;br&gt; &lt;ol type&#x3D;\&quot;1\&quot;&gt; &lt;li&gt;Pagamento com cartão de débito (Requisição da transação de débito autenticado).&lt;/li&gt; &lt;li&gt;Enviar requisição da transação de débito para a Plataforma Digital Getnet – Verificação 3D Secure&lt;/li&gt; &lt;li&gt;Resposta da transação de débito – Verificação 3D Secure, neste passo são retornados alguns atributos:&lt;/li&gt; &lt;ol type&#x3D;\&quot;a\&quot;&gt;  &lt;li&gt;&lt;b&gt;payment_id&lt;/b&gt;: identificador único do pagamento gerado pela Plataforma Digital Getnet, será utilizando no passo 9 da transação.&lt;/li&gt;  &lt;li&gt;&lt;b&gt;redirect_url&lt;/b&gt;: URL gerada pelo emissor, deve ser chamada no passo 5 da transação&lt;/li&gt;  &lt;li&gt;&lt;b&gt;post_data.issuer_payment_id&lt;/b&gt;: identificador do pagamento gerado pelo emissor, será enviado no passo 5 da transação&lt;/li&gt;  &lt;li&gt;&lt;b&gt;post_data.payer_authentication_request&lt;/b&gt;: dado referente a transação, gerado no formato Base64-encoded pelo emissor, será enviado no passo 5 da transação&lt;/li&gt; &lt;/ol&gt; &lt;li&gt;Resposta da transação para o device do consumidor&lt;/li&gt; &lt;li&gt;Executar um redirecionamento, enviando uma requisição HTTP POST para a URL do atributo &lt;b&gt;redirect_url&lt;/b&gt; retornado no passo 3 da transação. Para o request, você deve enviar as seguintes informações no header e no body da requisição:&lt;/li&gt; &lt;ol type&#x3D;\&quot;a\&quot;&gt; &lt;li&gt;&lt;b&gt;No Header&lt;/b&gt;&lt;/li&gt; &lt;ol type&#x3D;\&quot;i\&quot;&gt; &lt;li&gt;&lt;b&gt;Content-Type&lt;/b&gt;: application/x-www-form-urlencoded&lt;/li&gt; &lt;/ol&gt; &lt;li&gt;&lt;b&gt;No Body&lt;/b&gt;&lt;/li&gt; &lt;ol type&#x3D;\&quot;i\&quot;&gt; &lt;li&gt;&lt;b&gt;MD&lt;/b&gt;: referente ao atributo &lt;b&gt;post_data.issuer_payment_id&lt;/b&gt; retornado no passo 3 da transação.&lt;/li&gt; &lt;li&gt;&lt;b&gt;PaReq&lt;/b&gt;: referente ao atributo &lt;b&gt;post_data.payer_authentication_request&lt;/b&gt; retornado no passo 3 da transação.&lt;/li&gt; &lt;li&gt;&lt;b&gt;TermUrl&lt;/b&gt;: Sua URL, responsável por receber o PaRes por parte do emissor, conforme descrito no passo 8 da transação&lt;/li&gt; &lt;/ol&gt; &lt;/ol&gt; &lt;li&gt;Emissor responde a requisição enviando um formulário para autenticação do portador&lt;/li&gt; &lt;li&gt;Portador preenche o formulário com as informações solicitadas e envia para a validação do emissor&lt;/li&gt; &lt;li&gt;Emissor responde enviando um POST HTTP para a URL informada no atributo TermUrl do passo 5 da transação. Nesta requisição, o emissor enviará dois atributos:&lt;/li&gt; &lt;ol type&#x3D;\&quot;a\&quot;&gt; &lt;li&gt;&lt;b&gt;MD&lt;/b&gt;: retorno do atributo MD enviado no passo 5 da transação&lt;/li&gt; &lt;li&gt;&lt;b&gt;PaRes&lt;/b&gt;: autorização de pagamento retornada pelo emissor, será utilizado no passo 9 da transação&lt;/li&gt; &lt;/ol&gt; &lt;li&gt;A aplicação recebe a requisição do emissor e envia uma solicitação de finalização da transação de débito (&lt;a href&#x3D;\&quot;/api#tag/Pagamento%2Fpaths%2F~1v1~1payments~1debit~1%7Bpayment_id%7D~1authenticated~1finalize%2Fpost\&quot;&gt;Finalização de pagamento autenticado com cartão de débito&lt;/a&gt;)&lt;/li&gt; &lt;/ol&gt;
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param debitBody Requisição contendo os dados para pagamento com cartão de débito e análise de fraude. (required)
     * @return ApiResponse&lt;PaymentAuthenticatedResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PaymentAuthenticatedResponse> v1PaymentsDebitPostWithHttpInfo(String contentType, String authorization, PaymentDebit debitBody) throws ApiException {
        com.squareup.okhttp.Call call = v1PaymentsDebitPostValidateBeforeCall(contentType, authorization, debitBody, null, null);
        Type localVarReturnType = new TypeToken<PaymentAuthenticatedResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Pagamento com cartão de débito (asynchronously)
     * Nesse endpoint serão recebidos dados para pagamento com cartão de débito.  ### Fluxo Transação de Débito Autenticado &lt;br&gt; ![Fluxo Transação Débito Autenticado](/img/fluxodebitoautenticado.png) &lt;br&gt; &lt;br&gt; &lt;br&gt; &lt;ol type&#x3D;\&quot;1\&quot;&gt; &lt;li&gt;Pagamento com cartão de débito (Requisição da transação de débito autenticado).&lt;/li&gt; &lt;li&gt;Enviar requisição da transação de débito para a Plataforma Digital Getnet – Verificação 3D Secure&lt;/li&gt; &lt;li&gt;Resposta da transação de débito – Verificação 3D Secure, neste passo são retornados alguns atributos:&lt;/li&gt; &lt;ol type&#x3D;\&quot;a\&quot;&gt;  &lt;li&gt;&lt;b&gt;payment_id&lt;/b&gt;: identificador único do pagamento gerado pela Plataforma Digital Getnet, será utilizando no passo 9 da transação.&lt;/li&gt;  &lt;li&gt;&lt;b&gt;redirect_url&lt;/b&gt;: URL gerada pelo emissor, deve ser chamada no passo 5 da transação&lt;/li&gt;  &lt;li&gt;&lt;b&gt;post_data.issuer_payment_id&lt;/b&gt;: identificador do pagamento gerado pelo emissor, será enviado no passo 5 da transação&lt;/li&gt;  &lt;li&gt;&lt;b&gt;post_data.payer_authentication_request&lt;/b&gt;: dado referente a transação, gerado no formato Base64-encoded pelo emissor, será enviado no passo 5 da transação&lt;/li&gt; &lt;/ol&gt; &lt;li&gt;Resposta da transação para o device do consumidor&lt;/li&gt; &lt;li&gt;Executar um redirecionamento, enviando uma requisição HTTP POST para a URL do atributo &lt;b&gt;redirect_url&lt;/b&gt; retornado no passo 3 da transação. Para o request, você deve enviar as seguintes informações no header e no body da requisição:&lt;/li&gt; &lt;ol type&#x3D;\&quot;a\&quot;&gt; &lt;li&gt;&lt;b&gt;No Header&lt;/b&gt;&lt;/li&gt; &lt;ol type&#x3D;\&quot;i\&quot;&gt; &lt;li&gt;&lt;b&gt;Content-Type&lt;/b&gt;: application/x-www-form-urlencoded&lt;/li&gt; &lt;/ol&gt; &lt;li&gt;&lt;b&gt;No Body&lt;/b&gt;&lt;/li&gt; &lt;ol type&#x3D;\&quot;i\&quot;&gt; &lt;li&gt;&lt;b&gt;MD&lt;/b&gt;: referente ao atributo &lt;b&gt;post_data.issuer_payment_id&lt;/b&gt; retornado no passo 3 da transação.&lt;/li&gt; &lt;li&gt;&lt;b&gt;PaReq&lt;/b&gt;: referente ao atributo &lt;b&gt;post_data.payer_authentication_request&lt;/b&gt; retornado no passo 3 da transação.&lt;/li&gt; &lt;li&gt;&lt;b&gt;TermUrl&lt;/b&gt;: Sua URL, responsável por receber o PaRes por parte do emissor, conforme descrito no passo 8 da transação&lt;/li&gt; &lt;/ol&gt; &lt;/ol&gt; &lt;li&gt;Emissor responde a requisição enviando um formulário para autenticação do portador&lt;/li&gt; &lt;li&gt;Portador preenche o formulário com as informações solicitadas e envia para a validação do emissor&lt;/li&gt; &lt;li&gt;Emissor responde enviando um POST HTTP para a URL informada no atributo TermUrl do passo 5 da transação. Nesta requisição, o emissor enviará dois atributos:&lt;/li&gt; &lt;ol type&#x3D;\&quot;a\&quot;&gt; &lt;li&gt;&lt;b&gt;MD&lt;/b&gt;: retorno do atributo MD enviado no passo 5 da transação&lt;/li&gt; &lt;li&gt;&lt;b&gt;PaRes&lt;/b&gt;: autorização de pagamento retornada pelo emissor, será utilizado no passo 9 da transação&lt;/li&gt; &lt;/ol&gt; &lt;li&gt;A aplicação recebe a requisição do emissor e envia uma solicitação de finalização da transação de débito (&lt;a href&#x3D;\&quot;/api#tag/Pagamento%2Fpaths%2F~1v1~1payments~1debit~1%7Bpayment_id%7D~1authenticated~1finalize%2Fpost\&quot;&gt;Finalização de pagamento autenticado com cartão de débito&lt;/a&gt;)&lt;/li&gt; &lt;/ol&gt;
     * @param contentType Tipo do conteúdo application/json.  (required)
     * @param authorization Authorization: Bearer *AuthString* &lt;/br&gt; Onde *AuthString* é token de acesso obtido no endpoint de autenticação.  (required)
     * @param debitBody Requisição contendo os dados para pagamento com cartão de débito e análise de fraude. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1PaymentsDebitPostAsync(String contentType, String authorization, PaymentDebit debitBody, final ApiCallback<PaymentAuthenticatedResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = v1PaymentsDebitPostValidateBeforeCall(contentType, authorization, debitBody, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PaymentAuthenticatedResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
