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


package br.com.getnet.pagamento.client;

import com.squareup.okhttp.*;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.squareup.okhttp.logging.HttpLoggingInterceptor.Level;
import okio.BufferedSink;
import okio.Okio;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import javax.net.ssl.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.getnet.pagamento.client.auth.Authentication;
import br.com.getnet.pagamento.client.auth.HttpBasicAuth;
import br.com.getnet.pagamento.client.auth.ApiKeyAuth;
import br.com.getnet.pagamento.client.auth.OAuth;
import org.springframework.beans.factory.annotation.Value;

public class ApiClient {
    
    @Value("${app.url}")
    private String basePath;
//    private String basePath = "https://api-homologacao.getnet.com.br";
    private boolean debugging = false;
    private Map<String, String> defaultHeaderMap = new HashMap<String, String>();
    private String tempFolderPath = null;

    private Map<String, Authentication> authentications;

    private DateFormat dateFormat;
    private DateFormat datetimeFormat;
    private boolean lenientDatetimeFormat;
    private int dateLength;

    private InputStream sslCaCert;
    private boolean verifyingSsl;
    private KeyManager[] keyManagers;

    private OkHttpClient httpClient;
    private JSON json;

    private HttpLoggingInterceptor loggingInterceptor;

    /*
     * Constructor for ApiClient
     */
    public ApiClient() {
        httpClient = new OkHttpClient();


        verifyingSsl = true;

        json = new JSON();

        // Set default User-Agent.
        setUserAgent("Swagger-Codegen/1.0.0/java");

        // Setup authentications (key: authentication name, value: authentication).
        authentications = new HashMap<String, Authentication>();
        // Prevent the authentications from being modified.
        authentications = Collections.unmodifiableMap(authentications);
    }

    /**
     * Get base path
     *
     * @return Baes path
     */
    public String getBasePath() {
        return basePath;
    }

    /**
     * Set base path
     *
     * @param basePath Base path of the URL (e.g https://api-homologacao.getnet.com.br
     * @return An instance of OkHttpClient
     */
    public ApiClient setBasePath(String basePath) {
        this.basePath = basePath;
        return this;
    }

    /**
     * Get HTTP client
     *
     * @return An instance of OkHttpClient
     */
    public OkHttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * Set HTTP client
     *
     * @param httpClient An instance of OkHttpClient
     * @return Api Client
     */
    public ApiClient setHttpClient(OkHttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    /**
     * Get JSON
     *
     * @return JSON object
     */
    public JSON getJSON() {
        return json;
    }

    /**
     * Set JSON
     *
     * @param json JSON object
     * @return Api client
     */
    public ApiClient setJSON(JSON json) {
        this.json = json;
        return this;
    }

    /**
     * True if isVerifyingSsl flag is on
     *
     * @return True if isVerifySsl flag is on
     */
    public boolean isVerifyingSsl() {
        return verifyingSsl;
    }

    /**
     * Configure whether to verify certificate and hostname when making https requests.
     * Default to true.
     * NOTE: Do NOT set to false in production code, otherwise you would face multiple types of cryptographic attacks.
     *
     * @param verifyingSsl True to verify TLS/SSL connection
     * @return ApiClient
     */
    public ApiClient setVerifyingSsl(boolean verifyingSsl) {
        this.verifyingSsl = verifyingSsl;
        applySslSettings();
        return this;
    }

    /**
     * Get SSL CA cert.
     *
     * @return Input stream to the SSL CA cert
     */
    public InputStream getSslCaCert() {
        return sslCaCert;
    }

    /**
     * Configure the CA certificate to be trusted when making https requests.
     * Use null to reset to default.
     *
     * @param sslCaCert input stream for SSL CA cert
     * @return ApiClient
     */
    public ApiClient setSslCaCert(InputStream sslCaCert) {
        this.sslCaCert = sslCaCert;
        applySslSettings();
        return this;
    }

    public KeyManager[] getKeyManagers() {
        return keyManagers;
    }

    /**
     * Configure client keys to use for authorization in an SSL session.
     * Use null to reset to default.
     *
     * @param managers The KeyManagers to use
     * @return ApiClient
     */
    public ApiClient setKeyManagers(KeyManager[] managers) {
        this.keyManagers = managers;
        applySslSettings();
        return this;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public ApiClient setDateFormat(DateFormat dateFormat) {
        this.json.setDateFormat(dateFormat);
        return this;
    }

    public ApiClient setSqlDateFormat(DateFormat dateFormat) {
        this.json.setSqlDateFormat(dateFormat);
        return this;
    }

    public ApiClient setOffsetDateTimeFormat(DateTimeFormatter dateFormat) {
        this.json.setOffsetDateTimeFormat(dateFormat);
        return this;
    }

    public ApiClient setLocalDateFormat(DateTimeFormatter dateFormat) {
        this.json.setLocalDateFormat(dateFormat);
        return this;
    }

    public ApiClient setLenientOnJson(boolean lenientOnJson) {
        this.json.setLenientOnJson(lenientOnJson);
        return this;
    }

    /**
     * Get authentications (key: authentication name, value: authentication).
     *
     * @return Map of authentication objects
     */
    public Map<String, Authentication> getAuthentications() {
        return authentications;
    }

    /**
     * Get authentication for the given name.
     *
     * @param authName The authentication name
     * @return The authentication, null if not found
     */
    public Authentication getAuthentication(String authName) {
        return authentications.get(authName);
    }

    /**
     * Helper method to set username for the first HTTP basic authentication.
     *
     * @param username Username
     */
    public void setUsername(String username) {
        for (Authentication auth : authentications.values()) {
            if (auth instanceof HttpBasicAuth) {
                ((HttpBasicAuth) auth).setUsername(username);
                return;
            }
        }
        throw new RuntimeException("No HTTP basic authentication configured!");
    }

    /**
     * Helper method to set password for the first HTTP basic authentication.
     *
     * @param password Password
     */
    public void setPassword(String password) {
        for (Authentication auth : authentications.values()) {
            if (auth instanceof HttpBasicAuth) {
                ((HttpBasicAuth) auth).setPassword(password);
                return;
            }
        }
        throw new RuntimeException("No HTTP basic authentication configured!");
    }

    /**
     * Helper method to set API key value for the first API key authentication.
     *
     * @param apiKey API key
     */
    public void setApiKey(String apiKey) {
        for (Authentication auth : authentications.values()) {
            if (auth instanceof ApiKeyAuth) {
                ((ApiKeyAuth) auth).setApiKey(apiKey);
                return;
            }
        }
        throw new RuntimeException("No API key authentication configured!");
    }

    /**
     * Helper method to set API key prefix for the first API key authentication.
     *
     * @param apiKeyPrefix API key prefix
     */
    public void setApiKeyPrefix(String apiKeyPrefix) {
        for (Authentication auth : authentications.values()) {
            if (auth instanceof ApiKeyAuth) {
                ((ApiKeyAuth) auth).setApiKeyPrefix(apiKeyPrefix);
                return;
            }
        }
        throw new RuntimeException("No API key authentication configured!");
    }

    /**
     * Helper method to set access token for the first OAuth2 authentication.
     *
     * @param accessToken Access token
     */
    public void setAccessToken(String accessToken) {
        for (Authentication auth : authentications.values()) {
            if (auth instanceof OAuth) {
                ((OAuth) auth).setAccessToken(accessToken);
                return;
            }
        }
        throw new RuntimeException("No OAuth2 authentication configured!");
    }

    /**
     * Set the User-Agent header's value (by adding to the default header map).
     *
     * @param userAgent HTTP request's user agent
     * @return ApiClient
     */
    public ApiClient setUserAgent(String userAgent) {
        addDefaultHeader("User-Agent", userAgent);
        return this;
    }

    /**
     * Add a default header.
     *
     * @param key The header's key
     * @param value The header's value
     * @return ApiClient
     */
    public ApiClient addDefaultHeader(String key, String value) {
        defaultHeaderMap.put(key, value);
        return this;
    }

    /**
     * Check that whether debugging is enabled for this API client.
     *
     * @return True if debugging is enabled, false otherwise.
     */
    public boolean isDebugging() {
        return debugging;
    }

    /**
     * Enable/disable debugging for this API client.
     *
     * @param debugging To enable (true) or disable (false) debugging
     * @return ApiClient
     */
    public ApiClient setDebugging(boolean debugging) {
        if (debugging != this.debugging) {
            if (debugging) {
                loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(Level.BODY);
                httpClient.interceptors().add(loggingInterceptor);
            } else {
                httpClient.interceptors().remove(loggingInterceptor);
                loggingInterceptor = null;
            }
        }
        this.debugging = debugging;
        return this;
    }

    /**
     * The path of temporary folder used to store downloaded files from endpoints
     * with file response. The default value is <code>null</code>, i.e. using
     * the system's default tempopary folder.
     *
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/io/File.html#createTempFile">createTempFile</a>
     * @return Temporary folder path
     */
    public String getTempFolderPath() {
        return tempFolderPath;
    }

    /**
     * Set the temporary folder path (for downloading files)
     *
     * @param tempFolderPath Temporary folder path
     * @return ApiClient
     */
    public ApiClient setTempFolderPath(String tempFolderPath) {
        this.tempFolderPath = tempFolderPath;
        return this;
    }

    /**
     * Get connection timeout (in milliseconds).
     *
     * @return Timeout in milliseconds
     */
    public int getConnectTimeout() {
        return httpClient.getConnectTimeout();
    }

    /**
     * Sets the connect timeout (in milliseconds).
     * A value of 0 means no timeout, otherwise values must be between 1 and
     * {@link Integer#MAX_VALUE}.
     *
     * @param connectionTimeout connection timeout in milliseconds
     * @return Api client
     */
    public ApiClient setConnectTimeout(int connectionTimeout) {
        httpClient.setConnectTimeout(connectionTimeout, TimeUnit.MILLISECONDS);
        return this;
    }

    /**
     * Get read timeout (in milliseconds).
     *
     * @return Timeout in milliseconds
     */
    public int getReadTimeout() {
        return httpClient.getReadTimeout();
    }

    /**
     * Sets the read timeout (in milliseconds).
     * A value of 0 means no timeout, otherwise values must be between 1 and
     * {@link Integer#MAX_VALUE}.
     *
     * @param readTimeout read timeout in milliseconds
     * @return Api client
     */
    public ApiClient setReadTimeout(int readTimeout) {
        httpClient.setReadTimeout(readTimeout, TimeUnit.MILLISECONDS);
        return this;
    }

    /**
     * Get write timeout (in milliseconds).
     *
     * @return Timeout in milliseconds
     */
    public int getWriteTimeout() {
        return httpClient.getWriteTimeout();
    }

    /**
     * Sets the write timeout (in milliseconds).
     * A value of 0 means no timeout, otherwise values must be between 1 and
     * {@link Integer#MAX_VALUE}.
     *
     * @param writeTimeout connection timeout in milliseconds
     * @return Api client
     */
    public ApiClient setWriteTimeout(int writeTimeout) {
        httpClient.setWriteTimeout(writeTimeout, TimeUnit.MILLISECONDS);
        return this;
    }

    /**
     * Format the given parameter object into string.
     *
     * @param param Parameter
     * @return String representation of the parameter
     */
    public String parameterToString(Object param) {
        if (param == null) {
            return "";
        } else if (param instanceof Date || param instanceof OffsetDateTime || param instanceof LocalDate) {
            //Serialize to json string and remove the " enclosing characters
            String jsonStr = json.serialize(param);
            return jsonStr.substring(1, jsonStr.length() - 1);
        } else if (param instanceof Collection) {
            StringBuilder b = new StringBuilder();
            for (Object o : (Collection)param) {
                if (b.length() > 0) {
                    b.append(",");
                }
                b.append(String.valueOf(o));
            }
            return b.toString();
        } else {
            return String.valueOf(param);
        }
    }

    /**
     * Formats the specified query parameter to a list containing a single {@code Pair} object.
     *
     * Note that {@code value} must not be a collection.
     *
     * @param name The name of the parameter.
     * @param value The value of the parameter.
     * @return A list containing a single {@code Pair} object.
     */
    public List<Pair> parameterToPair(String name, Object value) {
        List<Pair> params = new ArrayList<Pair>();

        // preconditions
        if (name == null || name.isEmpty() || value == null || value instanceof Collection) return params;

        params.add(new Pair(name, parameterToString(value)));
        return params;
    }

    /**
     * Formats the specified collection query parameters to a list of {@code Pair} objects.
     *
     * Note that the values of each of the returned Pair objects are percent-encoded.
     *
     * @param collectionFormat The collection format of the parameter.
     * @param name The name of the parameter.
     * @param value The value of the parameter.
     * @return A list of {@code Pair} objects.
     */
    public List<Pair> parameterToPairs(String collectionFormat, String name, Collection value) {
        List<Pair> params = new ArrayList<Pair>();

        // preconditions
        if (name == null || name.isEmpty() || value == null || value.isEmpty()) {
            return params;
        }

        // create the params based on the collection format
        if ("multi".equals(collectionFormat)) {
            for (Object item : value) {
                params.add(new Pair(name, escapeString(parameterToString(item))));
            }
            return params;
        }

        // collectionFormat is assumed to be "csv" by default
        String delimiter = ",";

        // escape all delimiters except commas, which are URI reserved
        // characters
        if ("ssv".equals(collectionFormat)) {
            delimiter = escapeString(" ");
        } else if ("tsv".equals(collectionFormat)) {
            delimiter = escapeString("\t");
        } else if ("pipes".equals(collectionFormat)) {
            delimiter = escapeString("|");
        }

        StringBuilder sb = new StringBuilder() ;
        for (Object item : value) {
            sb.append(delimiter);
            sb.append(escapeString(parameterToString(item)));
        }

        params.add(new Pair(name, sb.substring(delimiter.length())));

        return params;
    }

    /**
     * Sanitize filename by removing path.
     * e.g. ../../sun.gif becomes sun.gif
     *
     * @param filename The filename to be sanitized
     * @return The sanitized filename
     */
    public String sanitizeFilename(String filename) {
        return filename.replaceAll(".*[/\\\\]", "");
    }

    /**
     * Check if the given MIME is a JSON MIME.
     * JSON MIME examples:
     *   application/json
     *   application/json; charset=UTF8
     *   APPLICATION/JSON
     *   application/vnd.company+json
     * "* / *" is also default to JSON
     * @param mime MIME (Multipurpose Internet Mail Extensions)
     * @return True if the given MIME is JSON, false otherwise.
     */
    public boolean isJsonMime(String mime) {
      String jsonMime = "(?i)^(application/json|[^;/ \t]+/[^;/ \t]+[+]json)[ \t]*(;.*)?$";
      return mime != null && (mime.matches(jsonMime) || mime.equals("*/*"));
    }

    /**
     * Select the Accept header's value from the given accepts array:
     *   if JSON exists in the given array, use it;
     *   otherwise use all of them (joining into a string)
     *
     * @param accepts The accepts array to select from
     * @return The Accept header to use. If the given array is empty,
     *   null will be returned (not to set the Accept header explicitly).
     */
    public String selectHeaderAccept(String[] accepts) {
        if (accepts.length == 0) {
            return null;
        }
        for (String accept : accepts) {
            if (isJsonMime(accept)) {
                return accept;
            }
        }
        return StringUtil.join(accepts, ",");
    }

    /**
     * Select the Content-Type header's value from the given array:
     *   if JSON exists in the given array, use it;
     *   otherwise use the first one of the array.
     *
     * @param contentTypes The Content-Type array to select from
     * @return The Content-Type header to use. If the given array is empty,
     *   or matches "any", JSON will be used.
     */
    public String selectHeaderContentType(String[] contentTypes) {
        if (contentTypes.length == 0 || contentTypes[0].equals("*/*")) {
             return "application/json";
        }
        for (String contentType : contentTypes) {
            if (isJsonMime(contentType)) {
                return contentType;
            }
        }
        return contentTypes[0];
    }

    /**
     * Escape the given string to be used as URL query value.
     *
     * @param str String to be escaped
     * @return Escaped string
     */
    public String escapeString(String str) {
        try {
            return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    /**
     * Deserialize response body to Java object, according to the return type and
     * the Content-Type response header.
     *
     * @param <T> Type
     * @param response HTTP response
     * @param returnType The type of the Java object
     * @return The deserialized Java object
     * @throws ApiException If fail to deserialize response body, i.e. cannot read response body
     *   or the Content-Type of the response is not supported.
     */
    @SuppressWarnings("unchecked")
    public <T> T deserialize(Response response, Type returnType) throws ApiException {
        if (response == null || returnType == null) {
            return null;
        }

        if ("byte[]".equals(returnType.toString())) {
            // Handle binary response (byte array).
            try {
                return (T) response.body().bytes();
            } catch (IOException e) {
                throw new ApiException(e);
            }
        } else if (returnType.equals(File.class)) {
            // Handle file downloading.
            return (T) downloadFileFromResponse(response);
        }

        String respBody;
        try {
            if (response.body() != null)
                respBody = response.body().string();
            else
                respBody = null;
        } catch (IOException e) {
            throw new ApiException(e);
        }

        if (respBody == null || "".equals(respBody)) {
            return null;
        }

        String contentType = response.headers().get("Content-Type");
        if (contentType == null) {
            // ensuring a default content type
            contentType = "application/json";
        }
        if (isJsonMime(contentType)) {
            return json.deserialize(respBody, returnType);
        } else if (returnType.equals(String.class)) {
            // Expecting string, return the raw response body.
            return (T) respBody;
        } else {
            throw new ApiException(
                    "Content type \"" + contentType + "\" is not supported for type: " + returnType,
                    response.code(),
                    response.headers().toMultimap(),
                    respBody);
        }
    }

    /**
     * Serialize the given Java object into request body according to the object's
     * class and the request Content-Type.
     *
     * @param obj The Java object
     * @param contentType The request Content-Type
     * @return The serialized request body
     * @throws ApiException If fail to serialize the given object
     */
    public RequestBody serialize(Object obj, String contentType) throws ApiException {
        if (obj instanceof byte[]) {
            // Binary (byte array) body parameter support.
            return RequestBody.create(MediaType.parse(contentType), (byte[]) obj);
        } else if (obj instanceof File) {
            // File body parameter support.
            return RequestBody.create(MediaType.parse(contentType), (File) obj);
        } else if (isJsonMime(contentType)) {
            String content;
            if (obj != null) {
                content = json.serialize(obj);
            } else {
                content = null;
            }
            return RequestBody.create(MediaType.parse(contentType), content);
        } else {
            throw new ApiException("Content type \"" + contentType + "\" is not supported");
        }
    }

    /**
     * Download file from the given response.
     *
     * @param response An instance of the Response object
     * @throws ApiException If fail to read file content from response and write to disk
     * @return Downloaded file
     */
    public File downloadFileFromResponse(Response response) throws ApiException {
        try {
            File file = prepareDownloadFile(response);
            BufferedSink sink = Okio.buffer(Okio.sink(file));
            sink.writeAll(response.body().source());
            sink.close();
            return file;
        } catch (IOException e) {
            throw new ApiException(e);
        }
    }

    /**
     * Prepare file for download
     *
     * @param response An instance of the Response object
     * @throws IOException If fail to prepare file for download
     * @return Prepared file for the download
     */
    public File prepareDownloadFile(Response response) throws IOException {
        String filename = null;
        String contentDisposition = response.header("Content-Disposition");
        if (contentDisposition != null && !"".equals(contentDisposition)) {
            // Get filename from the Content-Disposition header.
            Pattern pattern = Pattern.compile("filename=['\"]?([^'\"\\s]+)['\"]?");
            Matcher matcher = pattern.matcher(contentDisposition);
            if (matcher.find()) {
                filename = sanitizeFilename(matcher.group(1));
            }
        }

        String prefix = null;
        String suffix = null;
        if (filename == null) {
            prefix = "download-";
            suffix = "";
        } else {
            int pos = filename.lastIndexOf(".");
            if (pos == -1) {
                prefix = filename + "-";
            } else {
                prefix = filename.substring(0, pos) + "-";
                suffix = filename.substring(pos);
            }
            // File.createTempFile requires the prefix to be at least three characters long
            if (prefix.length() < 3)
                prefix = "download-";
        }

        if (tempFolderPath == null)
            return File.createTempFile(prefix, suffix);
        else
            return File.createTempFile(prefix, suffix, new File(tempFolderPath));
    }

    /**
     * {@link #execute(Call, Type)}
     *
     * @param <T> Type
     * @param call An instance of the Call object
     * @throws ApiException If fail to execute the call
     * @return ApiResponse&lt;T&gt;
     */
    public <T> ApiResponse<T> execute(Call call) throws ApiException {
        return execute(call, null);
    }

    /**
     * Execute HTTP call and deserialize the HTTP response body into the given return type.
     *
     * @param returnType The return type used to deserialize HTTP response body
     * @param <T> The return type corresponding to (same with) returnType
     * @param call Call
     * @return ApiResponse object containing response status, headers and
     *   data, which is a Java object deserialized from response body and would be null
     *   when returnType is null.
     * @throws ApiException If fail to execute the call
     */
    public <T> ApiResponse<T> execute(Call call, Type returnType) throws ApiException {
        try {
            Response response = call.execute();
            T data = handleResponse(response, returnType);
            return new ApiResponse<T>(response.code(), response.headers().toMultimap(), data);
        } catch (IOException e) {
            throw new ApiException(e);
        }
    }

    /**
     * {@link #executeAsync(Call, Type, ApiCallback)}
     *
     * @param <T> Type
     * @param call An instance of the Call object
     * @param callback ApiCallback&lt;T&gt;
     */
    public <T> void executeAsync(Call call, ApiCallback<T> callback) {
        executeAsync(call, null, callback);
    }

    /**
     * Execute HTTP call asynchronously.
     *
     * @see #execute(Call, Type)
     * @param <T> Type
     * @param call The callback to be executed when the API call finishes
     * @param returnType Return type
     * @param callback ApiCallback
     */
    @SuppressWarnings("unchecked")
    public <T> void executeAsync(Call call, final Type returnType, final ApiCallback<T> callback) {
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onFailure(new ApiException(e), 0, null);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                T result;
                try {
                    result = (T) handleResponse(response, returnType);
                } catch (ApiException e) {
                    callback.onFailure(e, response.code(), response.headers().toMultimap());
                    return;
                }
                callback.onSuccess(result, response.code(), response.headers().toMultimap());
            }
        });
    }

    /**
     * Handle the given response, return the deserialized object when the response is successful.
     *
     * @param <T> Type
     * @param response Response
     * @param returnType Return type
     * @throws ApiException If the response has a unsuccessful status code or
     *   fail to deserialize the response body
     * @return Type
     */
    public <T> T handleResponse(Response response, Type returnType) throws ApiException {
        if (response.isSuccessful()) {
            if (returnType == null || response.code() == 204) {
                // returning null if the returnType is not defined,
                // or the status code is 204 (No Content)
                if (response.body() != null) {
                    try {
                        response.body().close();
                    } catch (IOException e) {
                        throw new ApiException(response.message(), e, response.code(), response.headers().toMultimap());
                    }
                }
                return null;
            } else {
                return deserialize(response, returnType);
            }
        } else {
            String respBody = null;
            if (response.body() != null) {
                try {
                    respBody = response.body().string();
                } catch (IOException e) {
                    throw new ApiException(response.message(), e, response.code(), response.headers().toMultimap());
                }
            }
            throw new ApiException(response.message(), response.code(), response.headers().toMultimap(), respBody);
        }
    }

    /**
     * Build HTTP call with the given options.
     *
     * @param path The sub-path of the HTTP URL
     * @param method The request method, one of "GET", "HEAD", "OPTIONS", "POST", "PUT", "PATCH" and "DELETE"
     * @param queryParams The query parameters
     * @param collectionQueryParams The collection query parameters
     * @param body The request body object
     * @param headerParams The header parameters
     * @param formParams The form parameters
     * @param authNames The authentications to apply
     * @param progressRequestListener Progress request listener
     * @return The HTTP call
     * @throws ApiException If fail to serialize the request body object
     */
    public Call buildCall(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams, Map<String, Object> formParams, String[] authNames, ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Request request = buildRequest(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, progressRequestListener);

        return httpClient.newCall(request);
    }

    /**
     * Build an HTTP request with the given options.
     *
     * @param path The sub-path of the HTTP URL
     * @param method The request method, one of "GET", "HEAD", "OPTIONS", "POST", "PUT", "PATCH" and "DELETE"
     * @param queryParams The query parameters
     * @param collectionQueryParams The collection query parameters
     * @param body The request body object
     * @param headerParams The header parameters
     * @param formParams The form parameters
     * @param authNames The authentications to apply
     * @param progressRequestListener Progress request listener
     * @return The HTTP request 
     * @throws ApiException If fail to serialize the request body object
     */
    public Request buildRequest(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams, Map<String, Object> formParams, String[] authNames, ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        updateParamsForAuth(authNames, queryParams, headerParams);

        final String url = buildUrl(path, queryParams, collectionQueryParams);
        final Request.Builder reqBuilder = new Request.Builder().url(url);
        processHeaderParams(headerParams, reqBuilder);

        String contentType = (String) headerParams.get("Content-Type");
        // ensuring a default content type
        if (contentType == null) {
            contentType = "application/json";
        }

        RequestBody reqBody;
        if (!HttpMethod.permitsRequestBody(method)) {
            reqBody = null;
        } else if ("application/x-www-form-urlencoded".equals(contentType)) {
            reqBody = buildRequestBodyFormEncoding(formParams);
        } else if ("multipart/form-data".equals(contentType)) {
            reqBody = buildRequestBodyMultipart(formParams);
        } else if (body == null) {
            if ("DELETE".equals(method)) {
                // allow calling DELETE without sending a request body
                reqBody = null;
            } else {
                // use an empty request body (for POST, PUT and PATCH)
                reqBody = RequestBody.create(MediaType.parse(contentType), "");
            }
        } else {
            reqBody = serialize(body, contentType);
        }

        Request request = null;

        if(progressRequestListener != null && reqBody != null) {
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(reqBody, progressRequestListener);
            request = reqBuilder.method(method, progressRequestBody).build();
        } else {
            request = reqBuilder.method(method, reqBody).build();
        }

        return request;
    }

    /**
     * Build full URL by concatenating base path, the given sub path and query parameters.
     *
     * @param path The sub path
     * @param queryParams The query parameters
     * @param collectionQueryParams The collection query parameters
     * @return The full URL
     */
    public String buildUrl(String path, List<Pair> queryParams, List<Pair> collectionQueryParams) {
        final StringBuilder url = new StringBuilder();
        url.append(basePath).append(path);

        if (queryParams != null && !queryParams.isEmpty()) {
            // support (constant) query string in `path`, e.g. "/posts?draft=1"
            String prefix = path.contains("?") ? "&" : "?";
            for (Pair param : queryParams) {
                if (param.getValue() != null) {
                    if (prefix != null) {
                        url.append(prefix);
                        prefix = null;
                    } else {
                        url.append("&");
                    }
                    String value = parameterToString(param.getValue());
                    url.append(escapeString(param.getName())).append("=").append(escapeString(value));
                }
            }
        }

        if (collectionQueryParams != null && !collectionQueryParams.isEmpty()) {
            String prefix = url.toString().contains("?") ? "&" : "?";
            for (Pair param : collectionQueryParams) {
                if (param.getValue() != null) {
                    if (prefix != null) {
                        url.append(prefix);
                        prefix = null;
                    } else {
                        url.append("&");
                    }
                    String value = parameterToString(param.getValue());
                    // collection query parameter value already escaped as part of parameterToPairs
                    url.append(escapeString(param.getName())).append("=").append(value);
                }
            }
        }

        return url.toString();
    }

    /**
     * Set header parameters to the request builder, including default headers.
     *
     * @param headerParams Header parameters in the ofrm of Map
     * @param reqBuilder Reqeust.Builder
     */
    public void processHeaderParams(Map<String, String> headerParams, Request.Builder reqBuilder) {
        for (Entry<String, String> param : headerParams.entrySet()) {
            reqBuilder.header(param.getKey(), parameterToString(param.getValue()));
        }
        for (Entry<String, String> header : defaultHeaderMap.entrySet()) {
            if (!headerParams.containsKey(header.getKey())) {
                reqBuilder.header(header.getKey(), parameterToString(header.getValue()));
            }
        }
    }

    /**
     * Update query and header parameters based on authentication settings.
     *
     * @param authNames The authentications to apply
     * @param queryParams  List of query parameters
     * @param headerParams  Map of header parameters
     */
    public void updateParamsForAuth(String[] authNames, List<Pair> queryParams, Map<String, String> headerParams) {
        for (String authName : authNames) {
            Authentication auth = authentications.get(authName);
            if (auth == null) throw new RuntimeException("Authentication undefined: " + authName);
            auth.applyToParams(queryParams, headerParams);
        }
    }

    /**
     * Build a form-encoding request body with the given form parameters.
     *
     * @param formParams Form parameters in the form of Map
     * @return RequestBody
     */
    public RequestBody buildRequestBodyFormEncoding(Map<String, Object> formParams) {
        FormEncodingBuilder formBuilder  = new FormEncodingBuilder();
        for (Entry<String, Object> param : formParams.entrySet()) {
            formBuilder.add(param.getKey(), parameterToString(param.getValue()));
        }
        return formBuilder.build();
    }

    /**
     * Build a multipart (file uploading) request body with the given form parameters,
     * which could contain text fields and file fields.
     *
     * @param formParams Form parameters in the form of Map
     * @return RequestBody
     */
    public RequestBody buildRequestBodyMultipart(Map<String, Object> formParams) {
        MultipartBuilder mpBuilder = new MultipartBuilder().type(MultipartBuilder.FORM);
        for (Entry<String, Object> param : formParams.entrySet()) {
            if (param.getValue() instanceof File) {
                File file = (File) param.getValue();
                Headers partHeaders = Headers.of("Content-Disposition", "form-data; name=\"" + param.getKey() + "\"; filename=\"" + file.getName() + "\"");
                MediaType mediaType = MediaType.parse(guessContentTypeFromFile(file));
                mpBuilder.addPart(partHeaders, RequestBody.create(mediaType, file));
            } else {
                Headers partHeaders = Headers.of("Content-Disposition", "form-data; name=\"" + param.getKey() + "\"");
                mpBuilder.addPart(partHeaders, RequestBody.create(null, parameterToString(param.getValue())));
            }
        }
        return mpBuilder.build();
    }

    /**
     * Guess Content-Type header from the given file (defaults to "application/octet-stream").
     *
     * @param file The given file
     * @return The guessed Content-Type
     */
    public String guessContentTypeFromFile(File file) {
        String contentType = URLConnection.guessContentTypeFromName(file.getName());
        if (contentType == null) {
            return "application/octet-stream";
        } else {
            return contentType;
        }
    }

    /**
     * Apply SSL related settings to httpClient according to the current values of
     * verifyingSsl and sslCaCert.
     */
    private void applySslSettings() {
        try {
            TrustManager[] trustManagers = null;
            HostnameVerifier hostnameVerifier = null;
            if (!verifyingSsl) {
                TrustManager trustAll = new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
                    @Override
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                };
                SSLContext sslContext = SSLContext.getInstance("TLS");
                trustManagers = new TrustManager[]{ trustAll };
                hostnameVerifier = new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) { return true; }
                };
            } else if (sslCaCert != null) {
                char[] password = null; // Any password will work.
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                Collection<? extends Certificate> certificates = certificateFactory.generateCertificates(sslCaCert);
                if (certificates.isEmpty()) {
                    throw new IllegalArgumentException("expected non-empty set of trusted certificates");
                }
                KeyStore caKeyStore = newEmptyKeyStore(password);
                int index = 0;
                for (Certificate certificate : certificates) {
                    String certificateAlias = "ca" + Integer.toString(index++);
                    caKeyStore.setCertificateEntry(certificateAlias, certificate);
                }
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(caKeyStore);
                trustManagers = trustManagerFactory.getTrustManagers();
            }

            if (keyManagers != null || trustManagers != null) {
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(keyManagers, trustManagers, new SecureRandom());
                httpClient.setSslSocketFactory(sslContext.getSocketFactory());
            } else {
                httpClient.setSslSocketFactory(null);
            }
            httpClient.setHostnameVerifier(hostnameVerifier);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    private KeyStore newEmptyKeyStore(char[] password) throws GeneralSecurityException {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, password);
            return keyStore;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
