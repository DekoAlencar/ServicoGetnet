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


package br.com.getnet.pagamento.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Conjunto de dados do cartão salvo.
 */
@ApiModel(description = "Conjunto de dados do cartão salvo.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-25T16:02:55.559Z")
public class VaultCardResponse {
  @SerializedName("card_id")
  private String cardId = null;

  @SerializedName("last_four_digits")
  private String lastFourDigits = null;

  @SerializedName("expiration_month")
  private String expirationMonth = null;

  @SerializedName("expiration_year")
  private String expirationYear = null;

  /**
   * Bandeira. (Utilizado também no antifraude).
   */
  @JsonAdapter(BrandEnum.Adapter.class)
  public enum BrandEnum {
    MASTERCARD("Mastercard"),
    
    VISA("Visa"),
    
    AMEX("Amex"),
    
    ELO("Elo"),
    
    HIPERCARD("Hipercard");

    private String value;

    BrandEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static BrandEnum fromValue(String text) {
      for (BrandEnum b : BrandEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<BrandEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final BrandEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public BrandEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return BrandEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("brand")
  private BrandEnum brand = null;

  @SerializedName("cardholder_name")
  private String cardholderName = null;

  @SerializedName("customer_id")
  private String customerId = null;

  @SerializedName("number_token")
  private String numberToken = null;

  @SerializedName("used_at")
  private String usedAt = null;

  @SerializedName("created_at")
  private String createdAt = null;

  @SerializedName("updated_at")
  private String updatedAt = null;

  /**
   * Status do cartão no cofre.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    ACTIVE("active"),
    
    BLOCKED("blocked"),
    
    CANCELED("canceled"),
    
    RENEWED("renewed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  public VaultCardResponse cardId(String cardId) {
    this.cardId = cardId;
    return this;
  }

   /**
   * Identificador do cartão salvo no cofre.
   * @return cardId
  **/
  @ApiModelProperty(example = "e8ad2ae4-9e3e-4532-998f-1a5a11e56e58", value = "Identificador do cartão salvo no cofre.")
  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  public VaultCardResponse lastFourDigits(String lastFourDigits) {
    this.lastFourDigits = lastFourDigits;
    return this;
  }

   /**
   * Últimos quatro dígitos do cartão.
   * @return lastFourDigits
  **/
  @ApiModelProperty(example = "1212", value = "Últimos quatro dígitos do cartão.")
  public String getLastFourDigits() {
    return lastFourDigits;
  }

  public void setLastFourDigits(String lastFourDigits) {
    this.lastFourDigits = lastFourDigits;
  }

  public VaultCardResponse expirationMonth(String expirationMonth) {
    this.expirationMonth = expirationMonth;
    return this;
  }

   /**
   * Mês de expiração do cartão com dois dígitos. 
   * @return expirationMonth
  **/
  @ApiModelProperty(example = "12", value = "Mês de expiração do cartão com dois dígitos. ")
  public String getExpirationMonth() {
    return expirationMonth;
  }

  public void setExpirationMonth(String expirationMonth) {
    this.expirationMonth = expirationMonth;
  }

  public VaultCardResponse expirationYear(String expirationYear) {
    this.expirationYear = expirationYear;
    return this;
  }

   /**
   * Ano de expiração do cartão com dois dígitos.
   * @return expirationYear
  **/
  @ApiModelProperty(example = "20", value = "Ano de expiração do cartão com dois dígitos.")
  public String getExpirationYear() {
    return expirationYear;
  }

  public void setExpirationYear(String expirationYear) {
    this.expirationYear = expirationYear;
  }

  public VaultCardResponse brand(BrandEnum brand) {
    this.brand = brand;
    return this;
  }

   /**
   * Bandeira. (Utilizado também no antifraude).
   * @return brand
  **/
  @ApiModelProperty(example = "Mastercard", value = "Bandeira. (Utilizado também no antifraude).")
  public BrandEnum getBrand() {
    return brand;
  }

  public void setBrand(BrandEnum brand) {
    this.brand = brand;
  }

  public VaultCardResponse cardholderName(String cardholderName) {
    this.cardholderName = cardholderName;
    return this;
  }

   /**
   * Nome do comprador impresso no cartão.
   * @return cardholderName
  **/
  @ApiModelProperty(example = "JOAO DA SILVA", value = "Nome do comprador impresso no cartão.")
  public String getCardholderName() {
    return cardholderName;
  }

  public void setCardholderName(String cardholderName) {
    this.cardholderName = cardholderName;
  }

  public VaultCardResponse customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * Identificador do comprador. Pode ser qualquer informação que identifique o seu consumidor, como documento de identificação, email ou até mesmo um id interno do seu sistema. 
   * @return customerId
  **/
  @ApiModelProperty(example = "customer_21081826", value = "Identificador do comprador. Pode ser qualquer informação que identifique o seu consumidor, como documento de identificação, email ou até mesmo um id interno do seu sistema. ")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public VaultCardResponse numberToken(String numberToken) {
    this.numberToken = numberToken;
    return this;
  }

   /**
   * Número do cartão tokenizado. Gerado por meio do endpoint /v1/tokens/card.
   * @return numberToken
  **/
  @ApiModelProperty(example = "dfe05208b105578c070f806c80abd3af09e246827d29b866cf4ce16c205849977c9496cbf0d0234f42339937f327747075f68763537b90b31389e01231d4d13c", value = "Número do cartão tokenizado. Gerado por meio do endpoint /v1/tokens/card.")
  public String getNumberToken() {
    return numberToken;
  }

  public void setNumberToken(String numberToken) {
    this.numberToken = numberToken;
  }

  public VaultCardResponse usedAt(String usedAt) {
    this.usedAt = usedAt;
    return this;
  }

   /**
   * Data da última utilização.
   * @return usedAt
  **/
  @ApiModelProperty(example = "2017-04-19T16:30:30Z", value = "Data da última utilização.")
  public String getUsedAt() {
    return usedAt;
  }

  public void setUsedAt(String usedAt) {
    this.usedAt = usedAt;
  }

  public VaultCardResponse createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Data de criação.
   * @return createdAt
  **/
  @ApiModelProperty(example = "2017-04-19T16:30:30Z", value = "Data de criação.")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public VaultCardResponse updatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Data de atualização.
   * @return updatedAt
  **/
  @ApiModelProperty(example = "2017-04-19T16:30:30Z", value = "Data de atualização.")
  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public VaultCardResponse status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Status do cartão no cofre.
   * @return status
  **/
  @ApiModelProperty(example = "active", value = "Status do cartão no cofre.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VaultCardResponse vaultCardResponse = (VaultCardResponse) o;
    return Objects.equals(this.cardId, vaultCardResponse.cardId) &&
        Objects.equals(this.lastFourDigits, vaultCardResponse.lastFourDigits) &&
        Objects.equals(this.expirationMonth, vaultCardResponse.expirationMonth) &&
        Objects.equals(this.expirationYear, vaultCardResponse.expirationYear) &&
        Objects.equals(this.brand, vaultCardResponse.brand) &&
        Objects.equals(this.cardholderName, vaultCardResponse.cardholderName) &&
        Objects.equals(this.customerId, vaultCardResponse.customerId) &&
        Objects.equals(this.numberToken, vaultCardResponse.numberToken) &&
        Objects.equals(this.usedAt, vaultCardResponse.usedAt) &&
        Objects.equals(this.createdAt, vaultCardResponse.createdAt) &&
        Objects.equals(this.updatedAt, vaultCardResponse.updatedAt) &&
        Objects.equals(this.status, vaultCardResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardId, lastFourDigits, expirationMonth, expirationYear, brand, cardholderName, customerId, numberToken, usedAt, createdAt, updatedAt, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VaultCardResponse {\n");
    
    sb.append("    cardId: ").append(toIndentedString(cardId)).append("\n");
    sb.append("    lastFourDigits: ").append(toIndentedString(lastFourDigits)).append("\n");
    sb.append("    expirationMonth: ").append(toIndentedString(expirationMonth)).append("\n");
    sb.append("    expirationYear: ").append(toIndentedString(expirationYear)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    cardholderName: ").append(toIndentedString(cardholderName)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    numberToken: ").append(toIndentedString(numberToken)).append("\n");
    sb.append("    usedAt: ").append(toIndentedString(usedAt)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

