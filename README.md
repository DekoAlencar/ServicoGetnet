# ServicoGetnet
Serviço de comunicação com a api de pagamento da GetNet Santander

## Observação
O projeto ainda está sendo melhorado. Falta ainda incluir callback de retorno com a getnet.
Caso queira começar um projeto tirando esse como base aproveite, fique a vontade ;).

### Tem mais
Estou fazendo um app somente para estudo em angular para fazer o acompanhamento das transações.
[Download do app caso queira baixar](https://github.com/DekoAlencar/GetnetApp)

## Instalação
Os arquivos de application.properties esta divido em dois sendo um para produção e outro para desenvolvimento.
Lá é onde se coloca as suas configurações das chaves da api getnet.
````
app.url = "https://api-homologacao.getnet.com.br"
app.sellerId = "Seu_SellerID"
app.clientId = "SeuClientId"
app.clientSecret = "SeuClientSecret"
````
