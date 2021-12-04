Trata-se de uma aplicação que armazena, em uma tabela hash de tamanho = 10, objetos do tipo produto que têm os seguintes atributos:

- Código do produto – String (padrão GTIN-13); 
- Descrição do produto – String; 
- Preço – double.

Além do mais, foram implementadas as as operações de exclusão e busca de produtos.

A aplicação também possui a função de mostrar o nome do país, considerando os três primeiros digitos do código do produto.

Por fim, cumpre esclarecer:
- o código do produto é validado, devendo conter, obrigatóriamente 13 digitos no momento do cadastramento;
- a descrição não pode estar em branco;
- o preço deve ser maior que 0 
- a função hash é calculada levando-se em consideração apenas os três primeiros caracteres do produto, que indicam o país de origem. 
